// leetcode - 145
package Binary_Trees;

import java.util.Stack;

public class Post_Order_Traversal 
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
	//////////////////////////// Recursive Method //////////////////
	public void postorder(Node root) // (left,right,root)
	{
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+",");
	}
	///////////////////////// Iterative 2 Stacks /////////////////////
	/*
	public void postOrder(Node root)
	{
		Stack<Node> stk1 =new Stack<Post_Order_Traversal.Node>();
		Stack<Node> stk2=new Stack<Post_Order_Traversal.Node>();
		stk1.push(root);
		while(!stk1.isEmpty())
		{
			Node temp=stk1.pop();
			stk2.push(temp);
			if(temp.left!=null)
				stk1.push(temp.left);
			if(temp.right!=null)
				stk1.push(temp.right);
		}
		while(!stk2.isEmpty())
			System.out.print(stk2.pop().data+",");
	}
	*/
	///////////////////////////////// Iterative Using 1 Stack ///////////////
	public void postOrder(Node root)
	{
		Node current=root;
		Stack<Node> stk=new Stack<Post_Order_Traversal.Node>();
		while(current!=null || !stk.isEmpty())
		{
			if(current!=null)
			{
				stk.push(current);
				current=current.left;
			}
			else
			{
				Node temp=stk.peek().right;
				if(temp==null)
				{
					temp=stk.pop();
					System.out.print(temp.data+",");
					while(!stk.isEmpty() && temp==stk.peek().right)
					{
						temp=stk.pop();
						System.out.print(temp.data+",");
					}
				}
				else
				{
					current=temp;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Post_Order_Traversal b=new Post_Order_Traversal();
		b.createBinaryTree();
		b.postorder(b.root);
		System.out.println();
		b.postOrder(b.root);
	}
}
