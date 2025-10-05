// leetcode - 208
// https://youtu.be/dBGUmUQhjaM
package Tries;

public class Trie 
{
	class Node
	{
		Node[] children=new Node[26];
		boolean isWord=false;
	}
	Node root;
	public Trie() {
		root=new Node();
	}
	
	public void insert(String word)
	{
		Node temp=root;
		for(char c:word.toLowerCase().toCharArray())
		{
			int index=c-'a';
			if(temp.children[index]==null)
				temp.children[index]=new Node();
			temp=temp.children[index];
		}
		temp.isWord=true;
	}
	public boolean search(String word)
	{
		Node temp=root;
		for(char c:word.toLowerCase().toCharArray())
		{
			int index=c-'a';
			if(temp.children[index]==null)
				return false;
			temp=temp.children[index];
		}
		return temp.isWord;
	}
	
	public boolean startWith(String prefix)
	{
		Node temp=root;
		for(char c:prefix.toLowerCase().toCharArray())
		{
			int index=c-'a';
			if(temp.children[index]==null)
				return false;
			temp=temp.children[index];
		}
		return true;
	}
	public static void main(String[] args) 
	{
		Trie t=new Trie();
		t.insert("Balaji"); t.insert("Sushanth"); t.insert("Deekshith");
		System.out.println(t.search("Sushanth"));
		System.out.println(t.startWith("Bala"));
	}
}
