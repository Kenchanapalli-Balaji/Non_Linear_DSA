// leetcode - 103
// https://youtu.be/3OXWEdlIGl4
/*
 Given the root of a binary tree, return the zigzag level order traversal of its nodes' 
 values. (i.e., from left to right, then right to left for the next level and alternate between).

 Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
 */
package Binary_Trees;

import java.util.*;

public class ZigZag_Level_Order_Traversal 
{
	class Node
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	Node root;
	public void createBinaryTree()
	{
		Node first=new Node(10);
		Node second=new Node(20);
		Node third =new Node(30);
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
	
	public List<List<Integer>> zigzagLevel(Node root)
	{
		List<List<Integer>>  res=new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		boolean leftToRight=true;
		
		while(!q.isEmpty())
		{
			List<Integer> list=new ArrayList<Integer>();
			int n=q.size();
			for(int i=0;i<n;i++)
			{
				Node temp=q.poll();
				
				if(leftToRight==true)
					list.addLast(temp.data);
				else
					list.addFirst(temp.data);
				
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				
			}
			res.add(list);
			leftToRight=!leftToRight;
		}
		return res;
	}
	public static void main(String[] args) 
	{
		ZigZag_Level_Order_Traversal b=new ZigZag_Level_Order_Traversal();
		b.createBinaryTree();
		List<List<Integer>> res=b.zigzagLevel(b.root);
		System.out.println(res);
	}
}
