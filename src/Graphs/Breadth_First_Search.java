// https://youtu.be/-tgVpUgsQ5k
package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Breadth_First_Search 
{
	ArrayList<ArrayList<Integer>> adj;
	public Breadth_First_Search(int nodes) 
	{
		this.adj=new ArrayList<ArrayList<Integer>>(nodes);
		for(int i=0;i<nodes;i++)
			adj.add(new ArrayList<Integer>());
	}
	public void add(int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public void display()
	{
		for(int i=0;i<adj.size();i++)
			System.out.println(i+" : "+adj.get(i));
	}
	public void bfs(int node) // node means starting point for the Graph
	{
		boolean[] visited=new boolean[adj.size()];
		Queue<Integer> q=new LinkedList<Integer>();
		visited[node]=true;
		q.offer(node);
		
		while(!q.isEmpty())
		{
			int temp=q.poll();
			System.out.print(temp+" ");
			for(int i:adj.get(temp))
			{
				if(!visited[i])
				{
					visited[i]=true;
					q.offer(i);
				}
			}
		}
		
	}
	public static void main(String[] args) 
	{
		Breadth_First_Search b=new Breadth_First_Search(4);
		b.add(0,1); b.add(1,2); b.add(2, 3); b.add(3, 0);
		b.display();
		b.bfs(0);
	}
}
