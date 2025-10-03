// leetcode - 98
// https://youtu.be/f-sj7I5oXEI
package Binary_Search_Trees;

public class Validate_Binary_Search_Tree 
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
	public boolean isValidBinaryTree(Node root)
	{
		return isValidBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean isValidBST(Node root, int minVal, int maxVal)
	{
		if(root==null)
			return true;
		if(root.data>=maxVal || root.data<=minVal)
			return false;
		return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
	}
	public static void main(String[] args) 
	{
		Validate_Binary_Search_Tree b=new Validate_Binary_Search_Tree();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		System.out.println(b.isValidBinaryTree(b.root));
	}
}
