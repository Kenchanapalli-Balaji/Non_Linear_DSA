// https://youtu.be/OsNklbh9gYI
package Graphs;

import java.util.ArrayList;

public class Adjacency_List 
{
	public static void main(String[] args) 
	{
		int n=3; int m=3;
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<=n;i++)
			adj.add(new ArrayList<Integer>());
		
		// edge 1--2
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(1).add(3);
		adj.get(3).add(1);
		
		// print all the edges
		for(int i=0;i<adj.size();i++)
		{
			System.out.println(i+" :"+adj.get(i));
		}
		
	}
}
