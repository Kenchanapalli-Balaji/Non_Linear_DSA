package Binary_Search_Trees;

public class Balanced_Binary_Tree 
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
	public boolean add(int data)
	{
		Node n=new Node(data);
		if(root==null)
		{
			root=n;
			return true;
		}
		Node temp=root;
		while(true)
		{
			if(temp.data==data)
			{
				return false;
			}
			if(temp.data<data)
			{
				if(temp.right==null)
				{
					temp.right=n;
					return true;
				}
				temp=temp.right;
			}
			else
			{
				if(temp.left==null)
				{
					temp.left=n;
					return true;
				}
				temp=temp.left;
			}
		}
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
		Balanced_Binary_Tree b=new Balanced_Binary_Tree();
		b.add(50); b.add(30);b.add(20);b.add(60);b.add(55);b.add(10);b.add(100);
		b.preOrder(b.root);
	}
}
