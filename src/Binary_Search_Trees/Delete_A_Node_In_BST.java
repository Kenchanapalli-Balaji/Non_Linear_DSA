// leetcode - 450
// https://youtu.be/kouxiP_H5WE
/*
 Given a root node reference of a BST and a key, delete the node with the given key in the BST.
  Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.

Example:
============
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 */
package Binary_Search_Trees;

public class Delete_A_Node_In_BST 
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
	public Node deleteNode(Node root, int key)
	{
		if(root==null)
			return null;
		if(root.data==key)
			return helper(root);
		
		Node temp=root;
		while(root!=null)
		{
			if(root.data>key)
			{
				if(root.left!=null && root.left.data==key)
				{
					root.left=helper(root.left);
					break;
				}
				else
				{
					root=root.left;
				}
			}
			else
			{
				if(root.right!=null && root.right.data==key)
				{
					root.right=helper(root.right);
					break;
				}
				else
					root=root.right;
			}
		}
		return temp;
	}
	public Node helper(Node root)
	{
		if(root.left==null)
			return root.right;
		else if(root.right==null)
			return root.left;
		else
		{
			Node rightChild=root.right;
			Node lastRight=findLastRight(root.left);
			lastRight.right=rightChild;
			return root.left;
		}
	}
	public Node findLastRight(Node root)
	{
		if(root.right==null)
			return root;
		return findLastRight(root.right);
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
		Delete_A_Node_In_BST b=new Delete_A_Node_In_BST();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		System.out.println("Before Deleting Node :  ");
		b.preOrder(b.root);
		Node afterDeleted=b.deleteNode(b.root, 30);
		System.out.println();
		System.out.println("After Deleting Node :  ");
		b.preOrder(afterDeleted);
		
	}
}
