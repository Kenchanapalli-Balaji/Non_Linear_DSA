// leetcode - 543
// https://youtu.be/Rezetez59Nk
/*
 Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
package Binary_Trees;

public class Diameter_Of_Binary_Tree 
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
	int res=0;
	public int diaMeterOfTree(Node root)
	{
		dfs(root);
		return res;
	}
	public int dfs(Node root)
	{
		if(root==null)
			return 0;
		int lh=dfs(root.left);
		int rh=dfs(root.right);
		res=Math.max(lh+rh,res); // adding left height & right height and taking maximum of these
		
		return 1+Math.max(lh, rh);
	}
	public static void main(String[] args) 
	{
		Diameter_Of_Binary_Tree b=new Diameter_Of_Binary_Tree();
		b.createBinary();
		System.out.println(b.diaMeterOfTree(b.root));
	}
}
