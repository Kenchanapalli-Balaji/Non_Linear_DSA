package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

import Binary_Trees.Demo.Node;

public class Left_Side_View 
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
	public void createBinaryTree()
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
		Left_Side_View b =new Left_Side_View();
		b.createBinaryTree();
		System.out.println(b.leftSideView(b.root));
		
	}
	public List<Integer> leftSideView(Node root)
	{
		List<Integer> list=new ArrayList<Integer>();
		preOrder(root, 0, list);
		return list;
	}
	public void preOrder(Node root, int level, List<Integer> list)
	{
		if(root==null)
			return;
		if(level==list.size())
			list.add(root.data);
		preOrder(root.left, level+1,list);
		preOrder(root.right, level+1,list);
	}
}
