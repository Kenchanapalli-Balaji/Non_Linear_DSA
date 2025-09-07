// leetcode - 144
// https://youtu.be/Bfqd8BsPVuw
package Binary_Trees;

import java.util.Stack;

public class Pre_Order_Traversal 
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
	///////////////////////////////////////// Recursive Method //////////////////////////////
	public void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+",");
		preOrder(root.left);
		preOrder(root.right);
	}
	//////////////////////////////////////////// Iterative Method //////////////////////
	public void preorder(Node root)
	{
		if(root==null)
			return;
		Stack<Node> stk=new Stack<>();
		stk.push(root);
		while(!stk.isEmpty())
		{
			Node temp=stk.pop();
			System.out.print(temp.data+",");
			if(temp.right!=null)
				stk.push(temp.right);
			if(temp.left!=null)
				stk.push(temp.left);
		}
		
		
	}
	public static void main(String[] args) 
	{
		Pre_Order_Traversal b=new Pre_Order_Traversal();
		b.createBinaryTree();
		b.preOrder(b.root);
		System.out.println();
		b.preorder(b.root);
		
	}
}
