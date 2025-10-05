// https://youtu.be/Qzf1a--rhp8
package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Depth_First_Search 
{
	ArrayList<ArrayList<Integer>> adj;
	public Depth_First_Search(int nodes) 
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
	public void dfs(int node)
	{
		boolean visited[]=new boolean[adj.size()];
		Stack<Integer> stk=new Stack<Integer>();
		stk.push(node);
		while(!stk.isEmpty())
		{
			int temp=stk.pop();
			if(!visited[temp])
			{
				visited[temp]=true;
				System.out.print(temp+" ");
				for(int i:adj.get(temp))
				{
					if(!visited[i])
						stk.push(i);
				}
			}
		}
		
	}
	public static void main(String[] args) 
	{
		Depth_First_Search d=new Depth_First_Search(4);
		d.add(0,1);d.add(1,2); d.add(2, 3); d.add(3, 0);
		d.display();
		d.dfs(0);
	}
}
