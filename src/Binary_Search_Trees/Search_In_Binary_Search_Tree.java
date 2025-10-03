// leetcode - 700
// https://youtu.be/KcNt6v_56cc
package Binary_Search_Trees;

public class Search_In_Binary_Search_Tree 
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
	public Node search(int key)
	{
		return search(root, key);
	}
	public Node search(Node root, int key)
	{
		if(root==null || root.data==key)
			return root;
		if(key<root.data)
			return search(root.left,key);
		else
			return search(root.right,key);
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
		Search_In_Binary_Search_Tree b = new Search_In_Binary_Search_Tree();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		b.preOrder(b.search(30));
	}
}
