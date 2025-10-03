// leetcode - 701
// https://youtu.be/FiFiNvM29ps
package Binary_Search_Trees;

public class Binary_Search_Tree 
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
		Binary_Search_Tree b=new Binary_Search_Tree();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		b.preOrder(b.root);
	}
}
