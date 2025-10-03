// leetcode - 94
package Binary_Trees;

import java.util.Stack;

public class In_Order_Traversal 
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
	////////////////////////////////// Recursive Method /////////////////////
	public void inorder(Node root) // (left, root, right)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+",");
		inorder(root.right);
	}
	///////////////////////////////// Iterative Method ///////////////////////////
	public void inOrder(Node root)
	{
		Stack<Node> stk=new Stack<>();
		Node temp=root;
 		while(!stk.isEmpty() || temp!=null)
		{
			if(temp!=null)
			{
				stk.push(temp);
				temp=temp.left;
			}
			else
			{
				temp=stk.pop();
				System.out.print(temp.data+",");
				temp=temp.right;
			}
		}
	}
	public static void main(String[] args) 
	{
		In_Order_Traversal b=new In_Order_Traversal();
		b.createBinaryTree();
		b.inorder(b.root);
		System.out.println();
		b.inOrder(b.root);
		
	}
}
