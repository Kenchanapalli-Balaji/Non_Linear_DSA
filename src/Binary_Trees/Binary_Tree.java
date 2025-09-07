package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree 
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
	public static void main(String[] args) 
	{
		Binary_Tree b=new Binary_Tree();
		b.createBinary();
		b.inOrder(b.root);
		
	}
	public void inOrder(Node root)
	{
		Stack<Node> stk=new Stack<Binary_Tree.Node>();
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
}
