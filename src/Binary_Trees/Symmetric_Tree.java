// leetcode -101
// https://youtu.be/nKggNAiEpBE
/*
 Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 Example : 1
 ++++++++++++++
 Input: root = [1,2,2,3,4,4,3]
Output: true
 */
package Binary_Trees;

public class Symmetric_Tree 
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
		Node third =new Node(20);
		Node fourth=new Node(30);
		Node fifth=new Node(40);
		Node sixth=new Node(40);
		Node seventh=new Node(30);
		
		root=first; // 10
		first.left=second; // 20
		first.right=third; // 20
		second.left=fourth; // 30
		second.right=fifth; // 40
		third.left=sixth;	// 40
		third.right=seventh; // 30 
	}
	public boolean isSymmetric(Node root)
	{
		return isMirror(root.left, root.right);
	}
	public boolean isMirror(Node left, Node right)
	{
		if(left==null && right==null)
			return true;
		if(left.data != right.data)
			return false;
		return isMirror(left.left, right.right) && isMirror(left.right, right.left);
	}
	public static void main(String[] args) 
	{
		Symmetric_Tree b=new Symmetric_Tree();
		b.createBinaryTree();
		System.out.println(b.isSymmetric(b.root));
		
	}
}
