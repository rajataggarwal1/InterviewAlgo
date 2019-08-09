package com.tries;

import java.util.Iterator;
import java.util.Set;

public class TriesClass {

	Node root;
	
	public TriesClass()
	{
		root=new Node();
		root.isWorld=false;
	}
	
	public void insertIntoTries(String strtoInsert)	
	{
		
		char[] ch= strtoInsert.toCharArray();
		
		
		Node tempRoot=root;
		
		Node newChild;

		
		for(int i=0; i<ch.length; i++)
		{
			if(tempRoot.map.containsKey(ch[i])==true)
			{
				tempRoot=(Node)tempRoot.map.get(ch[i]);
			}
			else
			{
				
				if(i==ch.length-1)
				{
					 newChild=new Node(ch[i], true);
				}
				else
				{
					 newChild=new Node(ch[i],false);
				}
				tempRoot.map.put(ch[i], newChild);
				tempRoot=newChild;
			}
		}
	}
	
	
	public boolean searchWord(String strToSearch)
	{
		Node tempRoot=root;
		boolean isWordExist=false;

		char[] ch= strToSearch.toCharArray();
		for(int i=0; i<ch.length; i++)
		{
			if(tempRoot.map.containsKey(ch[i])==true)
			{
				tempRoot=(Node)tempRoot.map.get(ch[i]);
				if((tempRoot.isWorld == true) && (i==ch.length-1))
					isWordExist=true;
				else
				{
					isWordExist=false;
					continue;
				}
			}
			else
				isWordExist= false;
				
		}
		
		return isWordExist;
		
	}
	
	
	public String longestPrefixMatching(String strToSearch)
	{
		Node tempRoot=root;
		boolean isWordExist=false;
		String strtoReturn="";
		int matchPosition=0;
		char[] ch= strToSearch.toCharArray();
		for(int i=0; i<ch.length-1; i++)
		{
			if(tempRoot.map.containsKey(ch[i])==true)
			{
				strtoReturn=strtoReturn+ch[i];
				tempRoot=(Node)tempRoot.map.get(ch[i]);
				if(tempRoot.isWorld==true)
				{
					matchPosition=i+1;
				}
					
			}
			else
				break;
				
		}
		
		if (tempRoot.isWorld!=true)
		{
			strtoReturn=strToSearch.substring(0,matchPosition);
			 
		}
		
		return strtoReturn;
		
	}
	
	public boolean hasChild(Node chileNode) {
		
		if(chileNode.map.size()>0)
			return true;
		
		return false;
				
		
	}
	
	public void deleteWord(String strToDelete)
	{
		Node tempRoot=root;
		Node movingRoot=root;
		boolean isWordExist=false;
		Node child;
		
		char[] ch= strToDelete.toCharArray();
		for(int i=0; i<ch.length; i++)
		{
			if(hasChild(movingRoot)==true)
			{
				if(movingRoot.map.containsKey(ch[i])==true)
				{
					movingRoot=(Node)tempRoot.map.get(ch[i]);
					
					if(hasChild(movingRoot)!=true)
					{
						tempRoot.map.remove(movingRoot.ch);
					}
					else if((movingRoot.isWorld == true) && (i==ch.length-1))
						movingRoot.isWorld=false;
				}
				else
				{
					System.out.println("Word no exit in tree");
					break;
				}
				
				tempRoot = movingRoot;
			}
			else
				tempRoot.map.remove(ch[i]);

		}
	}
	
	public void displayTree()
	{
		Node tempRoot=root;
		Node movingRoot=root;
		boolean isWordExist=false;
		Node child;
		
		int chVal='a';
		System.out.println(chVal);
		chVal='z';
		System.out.println(chVal);
		char ch=97;
		System.out.println(ch);
		
		
		for(int i=0; i<26;i++)
		{			
			if(tempRoot.map.containsKey(ch))
			{
				tempRoot.map.
				for(int j=0; i<)
				
				
				tempRoot=(Node)tempRoot.map.get(ch);
				System.out.print(tempRoot.ch);
				if(tempRoot.isWorld==true)
				{
					System.out.print("\n");
				}
				
			}
			
		ch=ch++;	
		}
		
		
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TriesClass tri=new TriesClass();
		tri.insertIntoTries("am");
		tri.insertIntoTries("amena");
		tri.insertIntoTries("ask");
		tri.insertIntoTries("boy");
		tri.insertIntoTries("boll");
		
		tri.insertIntoTries("are");
		tri.insertIntoTries("area");
		tri.insertIntoTries("base");
		tri.insertIntoTries("cat");
		tri.insertIntoTries("cater");
		tri.insertIntoTries("children");
		tri.insertIntoTries("basement");
		
		/*
		System.out.println(tri.longestPrefixMatching("caterer"));
		System.out.println(tri.longestPrefixMatching("basemexy"));
		System.out.println(tri.longestPrefixMatching("child"));
		*/
		
		/*
		System.out.println(tri.searchWord("am"));
		System.out.println(tri.searchWord("ame"));
		System.out.println(tri.searchWord("ama"));
		System.out.println(tri.searchWord("bo"));
		System.out.println(tri.searchWord("boll"));
		*/
		
		
		tri.deleteWord("am");
		System.out.println(tri.searchWord("am"));
		tri.deleteWord("area");
		System.out.println(tri.searchWord("area"));
		tri.deleteWord("are");
		System.out.println(tri.searchWord("are"));
		
		
		tri.displayTree();
	}

}
