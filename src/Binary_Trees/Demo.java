package Binary_Trees;

import java.util.*;
public class Demo 
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
	
	public void createBinary()
	{
		Node first=new Node(10);
		Node second=new Node(20);
		Node third=new Node(30);
		Node fourth=new Node(40);
		Node fifth=new Node(50);
		Node sixth=new Node(60);
		Node seventh=new Node(70);
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=fifth;
		third.left=sixth;
		third.right=seventh;
	}
	
	public static void main(String[] args) 
	{
		Demo b=new Demo();
		b.createBinary();	
	}	
	
}
