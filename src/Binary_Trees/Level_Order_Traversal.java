// leetcode - 102
// https://youtu.be/hXAqTO7VqUQ?list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d
package Binary_Trees;
import java.util.*;

public class Level_Order_Traversal 
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
	public List<List<Integer>> levelorder(Node root)
	{
		List<List<Integer>> ans=new ArrayList<>();
		if(root==null)
			return ans;
		Queue<Node> q=new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty())
		{
			List<Integer> list=new ArrayList<Integer>();
			int n=q.size();
			for(int i=0;i<n;i++)
			{
				Node temp=q.poll();
				list.add(temp.data);
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
			}
			ans.add(list);
		}
		return ans;
	}
	public static void main(String[] args) 
	{
		Level_Order_Traversal b=new Level_Order_Traversal();
		b.createBinaryTree();
		List<List<Integer>> res=b.levelorder(b.root);
		System.out.println(res);
	}
}
