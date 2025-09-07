// leetcode - 199
// https://youtu.be/KV4mRzTjlAk
/*
 Given the root of a binary tree, imagine yourself standing on the right side of it, 
 return the values of the nodes you can see ordered from top to bottom.
 Input: root = [1,2,3,4,null,null,null,5]

 Output: [1,3,4,5]
 */
package Binary_Trees;

import java.util.ArrayList;
import java.util.List;

public class Right_Side_View 
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
	public List<Integer> rightSideView(Node root)
	{
		List<Integer> result=new ArrayList<Integer>();
		preOrder(root,0,result);
		return result;
	}
	public void preOrder(Node root, int depth, List<Integer> res)
	{
		if(root==null)
			return;
		// First time visiting this depth → take it
		if(depth==res.size())
			res.add(root.data);
		
		preOrder(root.right, depth+1, res); // go right first
		preOrder(root.left, depth+1, res);
		
	}
	public static void main(String[] args) 
	{
		Right_Side_View b=new Right_Side_View();
		b.createBinaryTree();
		System.out.println(b.rightSideView(b.root));
		
	}
}
