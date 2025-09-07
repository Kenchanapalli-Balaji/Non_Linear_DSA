// leetcode - 110
// https://youtu.be/Yt50Jfbd8Po
/*
 A balanced binary tree, also known as a height-balanced binary tree, is a type of binary tree where the height 
 difference between the left and right subtrees of every node is at most 1. This means the height difference for 
 any node can be -1, 0, or 1. 
 */
package Binary_Trees;

public class Balanced_Binary_Tree 
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
	
	public boolean isBalanced(Node root)
	{
		return checkHeight(root)!=-1;
	}
	public int checkHeight(Node root)
	{
		if(root==null)
			return 0;
		int leftHeight=checkHeight(root.left);
		if(leftHeight==-1)
			return -1;
		int rightHeight=checkHeight(root.right);
		if(rightHeight==-1)
			return -1;
		if(Math.abs(leftHeight-rightHeight)>1)
			return -1;
		return Math.max(leftHeight, rightHeight)+1;
	}
	public static void main(String[] args) 
	{
		Balanced_Binary_Tree b=new Balanced_Binary_Tree();
		b.createBinary();
		System.out.println(b.isBalanced(b.root));
	}
}
