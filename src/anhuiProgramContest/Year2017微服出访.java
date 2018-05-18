package anhuiProgramContest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Year2017微服出访 {
	
	static StreamTokenizer cin = null;
	static{
		try {
			cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(new FileInputStream("lca.in"))));

		} catch (Exception e) {
			cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

		}
		
	}
	static class Edge{
		int to,next;
	}
	static int cnt, cnt2;
	static int[]head1,head2;
	static int[]fa,last,a;
	static HashSet <Integer>[]Q;
	static boolean[]vis;
	static Edge [] edges,edges2;
	public static void main(String[] args) throws IOException{
		cin.nextToken();
		int T = (int) cin.nval;
		int t = 1;
		while(T-->0){
			cin.nextToken();
			int n =  (int) cin.nval;
			cin.nextToken();
			int m = (int) cin.nval;
			cin.nextToken();
			int q = (int) cin.nval;
			cnt = cnt2 = 1;
			a = new int[n+1];
			vis = new boolean[n+1];
			edges = new Edge[n];
			edges2 = new Edge[q+1];
			fa = new int[n+1];
			last = new int[n+1];
			head1 = new int[n+1];
			head2 = new int[n+1];
			fa = new int[n+1];
			Q = new HashSet[q+1];
			for (int i = 1; i <=q; i++) {
				Q[i] = new HashSet<Integer>();
			}
			for (int i = 1; i <= n; i++) {
				fa[i] = i;
			}
			Arrays.fill(head1, -1);
			Arrays.fill(head2, -1);
			for (int i = 1; i <= n; i++) {
				cin.nextToken();
				a[i] = (int) cin.nval;
			}
			for (int i = 1; i < n; i++) {
				cin.nextToken();
				int u = (int) cin.nval;
				cin.nextToken();
				int v = (int) cin.nval;
				addEdge(u,v);
			}
			for (int i = 1; i <= q; i++){
				cin.nextToken();
				int u = (int) cin.nval;
				cin.nextToken();
				int v = (int) cin.nval;
				addEdge2(u,v);
			}
			/*for(int u = 1; u <= n; u++){
				for(int i = head1[u]; i != -1; i = edges[i].next){
					System.out.println("edges " + i + ": " + u + "-> " + edges[i].to );
				}
			}*/
			Tarjan(1);
			System.out.println(String.format("Case %d:",t++));
			for(int i = 1; i <= q; i++){
				Object[]list = Q[i].toArray();
				System.out.print(list[0]);
				for(int j = 1; j < list.length; j++){
					System.out.print(" " + list[j]);
				}
				System.out.println();
			}
		}
		
	}

	private static void Tarjan(int u) {
		last[u] = u;
		fa[u] = u;
		vis[u] = true; 
		for(int i = head1[u]; i !=-1; i = edges[i].next){
			int v = edges[i].to;
			if (!vis[v]) {
				last[v] = u;
				Tarjan(v);
				fa[v]= u; 
			} 
		}
		for (int i = head2[u]; i != -1; i = edges2[i].next) {
			int v = edges2[i].to;
			if (vis[v]) {
				Q[i].add(a[v]);
				while(fa[v]!= v ){
					Q[i].add(a[fa[v]]);
					v = fa[v];
				}
				Q[i].add(a[u]);
				while(last[u]!= u ){
					Q[i].add(a[last[u]]);u = last[u];
				}
			}
		}
	}
	static int GetF(int x){
		return fa[x]== x ? x : GetF(fa[x]); 
	}

	private static void addEdge2(int u, int v ) {
		edges2[cnt2] = new Edge();
		edges2[cnt2].to = v;
		edges2[cnt2].next = head2[u];
		head2[u] = cnt2++; 
	}

	private static void addEdge(int u, int v) {
		// TODO Auto-generated method stub
		edges[cnt] = new Edge();
		edges[cnt].to = v;
		edges[cnt].next = head1[u];
		head1[u] = cnt++; 
	}
}
