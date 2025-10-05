// https://youtu.be/OsNklbh9gYI
package Graphs;

public class Adjacency_Matrix 
{
	int n=4;
	int m=4;
	int arr[][]=new int[n+1][m+1];
	public void addEdge(int u, int v)
	{
		arr[u][v]=1;
		arr[v][u]=1;
	}
	public void display()
	{
		System.out.print(0+"  "+1+"  "+2+"  "+3+"  "+4);
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(i+" : ");
			for(int j=0;j<arr[i].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Adjacency_Matrix graph=new Adjacency_Matrix();
		graph.addEdge(2, 3); graph.addEdge(1, 2);
		graph.addEdge(3,4);  graph.addEdge(1, 4);
		graph.display();
		
	}
}
