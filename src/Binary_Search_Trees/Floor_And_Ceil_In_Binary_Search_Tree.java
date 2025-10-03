 // https://youtu.be/KSsk8AhdOZA
// https://youtu.be/xm_W1ub-K-w
/*
 Given a root of binary search tree and a key(node) value, find the floor and ceil value for that particular key value.
Floor Value Node: Node with the greatest data lesser than or equal to the key value. 
Ceil Value Node: Node with the smallest data larger than or equal to the key value.
If a particular floor or ceil value is not present then output -1.
 */
package Binary_Search_Trees;
public class Floor_And_Ceil_In_Binary_Search_Tree 
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
	public int findCeil(Node root, int key)
	{
		int ceil=-1;
		while(root!=null)
		{
			if(root.data==key)
			{
				ceil=root.data;
				return ceil;
			}
			if(key>root.data)
				root=root.right;	
			else
			{
				ceil=root.data;
				root=root.left;
			}
		}
		return ceil;
	}
	public int findFloor(Node root, int key)
	{
		int floor=-1;
		while(root!=null)
		{
			if(root.data==key)
			{
				floor=root.data;
				return floor;
			}
			if(key>root.data)
			{
				floor=root.data;
				root=root.right;
			}
			else
				root=root.left;
		}
		return floor;
	}
	public static void main(String[] args) 
	{
		Floor_And_Ceil_In_Binary_Search_Tree b=new Floor_And_Ceil_In_Binary_Search_Tree();
		b.insert(50);b.insert(30);b.insert(20);b.insert(40);b.insert(70);b.insert(60);b.insert(80);
		System.out.println(b.findCeil(b.root, 30)); // val>=key
		System.out.println(b.findFloor(b.root, 40)); // val<=key
	}
}
