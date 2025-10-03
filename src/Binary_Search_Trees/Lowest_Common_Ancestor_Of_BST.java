// leetcode - 235
// https://youtu.be/cX_kPV_foZc
/*
 Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q 
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
package Binary_Search_Trees;

public class Lowest_Common_Ancestor_Of_BST 
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
	public Node LCA(Node root, int p, int q)
	{
		if(root==null)
			return null;
		int temp=root.data;
		if(temp<p &&temp<q)
				return LCA(root.right,p,q);
		if(temp>p && temp>q)
			return LCA(root.left,p,q);
		return root;
	}
	public void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) 
	{
		Lowest_Common_Ancestor_Of_BST b=new Lowest_Common_Ancestor_Of_BST();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		Node res=b.LCA(b.root, 20, 40);
		b.preOrder(res);
	}
}
