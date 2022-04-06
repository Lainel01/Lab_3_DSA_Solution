package com.greatlearning.Question_2;

import java.util.ArrayList;

public class LongestPathNode {
	
	static class Node{
		Node leftNode;
		Node rightNode;
		int nodeData;
	}
	
	static Node newNode(int nodeData) {
		Node temp = new Node();
		
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		
		return temp;
		
	}
	
	public static ArrayList<Integer> longestPath(Node root){
		if(root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		
		ArrayList<Integer> right = longestPath(root.rightNode);
		ArrayList<Integer> left = longestPath(root.leftNode);
		if (right.size()<left.size()) {
			left.add(root.nodeData);
		}
		else {
			right.add(root.nodeData);
		}
		
		return (left.size() > right.size()? left:right);
		
	}
	public static void main(String[] args) {
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.leftNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);
		
		ArrayList<Integer> output = longestPath(root);
		int n = output.size();
		
		System.out.print(output.get(n - 1));
		for(int i = n - 2; i >= 0; i--) {
			System.out.println("->" + output.get(i));
		}
			
	}

}
