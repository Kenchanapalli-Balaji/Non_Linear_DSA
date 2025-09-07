// leetcode - 100
// https://youtu.be/BhuvF_-PWS0
/*
 Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, 
and the nodes have the same value.
Input: p = [1,2,3], q = [1,2,3]
Output: true
 */
package Binary_Trees;

import Binary_Trees.Diameter_Of_Binary_Tree.Node;

public class Check_If_two_Trees_Are_Identical_Or_Not 
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
	public static boolean isSameTree(Node p,Node q)
	{
		// Base case: if both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (p == null || q == null || p.data != q.data) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	public static void main(String[] args) 
	{
		Check_If_two_Trees_Are_Identical_Or_Not a=new Check_If_two_Trees_Are_Identical_Or_Not();
		a.createBinary();
		
		Check_If_two_Trees_Are_Identical_Or_Not b=new Check_If_two_Trees_Are_Identical_Or_Not();
		b.createBinary();
		
		System.out.println(isSameTree(a.root,b.root));
	}
}
