// leetcode - 547
// https://youtu.be/ACzkVtewUYA
/*
 There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
 and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and 
the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
 */
package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Number_Of_Provinces 
{
	public int findCircleNum(int[][] adj)
	{
		int n=adj.length;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++)
			list.add(new ArrayList<Integer>());
		
		// converting Adjacency Matrix to Adjacency List for easy traversal
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j && adj[i][j]==1)
					list.get(i).add(j);
			}
		}
		
		boolean[] visited=new boolean[n];
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				Queue<Integer> q=new LinkedList<Integer>();
				q.add(i);
				visited[i]=true;
				while(!q.isEmpty())
				{
					int temp=q.poll();
					for(int nei:list.get(temp))
					{
						if(!visited[nei])
						{
							visited[nei]=true;
							q.add(nei);
						}
					}
				}
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) 
	{
		
	}
}
