// leetcode - 104
// https://youtu.be/eD3tmO66aBA
/*
	Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down 
to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3 
 */
package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_Of_Binary_Tree 
{
	class Node
	{
		int data; Node left;Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	Node root;
	public void createBinary()
	{
		Node first=new Node(10);
		Node second =new Node(20);
		Node third=new Node(30);
		Node fourth=new Node(40);
		Node fifth=new Node(50);
		Node sixth=new Node(60);
		
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=fifth;
		third.left=sixth;
	}
	///////////////////////////// Recursive Method //////////////////////
	public int maxDepth(Node root)
	{
		if(root==null)
			return 0;
		int lh=maxDepth(root.left);
		int rh=maxDepth(root.right);
		
		return 1+Math.max(lh, rh);
	}
	///////////////////////////// Iterative Method(Level Order) //////////////////
	public int maxdepth(Node root)
 	{
		if(root==null)
			return 0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		int depth=0;
		while(!q.isEmpty())
		{
			depth++;
			int n=q.size();
			for(int i=0;i<n;i++)
			{
				Node temp=q.poll();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return depth;
	}
	public static void main(String[] args) 
	{
		Maximum_Depth_Of_Binary_Tree b=new Maximum_Depth_Of_Binary_Tree();
		b.createBinary();
		System.out.println(b.maxDepth(b.root));
		System.out.println(b.maxdepth(b.root));
	}
}
