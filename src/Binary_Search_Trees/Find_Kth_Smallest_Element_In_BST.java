// leetcode - 230
// https://youtu.be/9TJYWh0adfk
package Binary_Search_Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Find_Kth_Smallest_Element_In_BST 
{
	class Node
	{
		int data; Node left; Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	Node root;
	public void insert(int data)
	{
		root=insert(root,data);
	}
	public Node insert(Node root, int data)
	{
		Node n=new Node(data);
		if(root==null)
		{
			root=n;
			return root;
		}
		if(data<root.data)
		{
			root.left=insert(root.left,data);
		}
		else
		{
			root.right=insert(root.right,data);
		}
		return root;
	}
	////////////////////////////////// Using InOrder Traversal ///////////////////////
	public int kThSmallest(Node root,int k)
	{
		List<Integer> arr=inOrder(root, new ArrayList<Integer>());
		return arr.get(k-1);
	}
	public List<Integer> inOrder(Node root,List<Integer> list)
	{
		if(root==null)
			return list;
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
		return list;
	}
	/////////////////////////////////////// Using Iterative Method ///////////////////////
	public int kthSmallest(Node root, int k)
	{
		Stack<Node> stk=new Stack<Find_Kth_Smallest_Element_In_BST.Node>();
		Node temp=root;
		while(!stk.isEmpty() || temp!=null)
		{
			// Go as left as possible and push all nodes onto stack
			while(temp!=null)
			{
				stk.push(temp);
				temp=temp.left;
			}
			 // Pop the node from stack (next smallest element)
			temp=stk.pop();
			k--; // decrement k for each visited node
			if(k==0)
				return temp.data; // Found kth smallest
			temp=temp.right;
		}
		return -1;
	}
	public static void main(String[] args) 
	{
		Find_Kth_Smallest_Element_In_BST b=new Find_Kth_Smallest_Element_In_BST();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		System.out.println(b.kThSmallest(b.root, 2));
		System.out.println(b.kthSmallest(b.root, 2));
	}
}
