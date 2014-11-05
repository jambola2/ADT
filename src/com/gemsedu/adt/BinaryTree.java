package com.gemsedu.adt;
import java.util.Random;

public class BinaryTree<T> {
	static BinaryNode<Integer> root = null;
	
	BinaryTree() {}
	
	public static void main(String[] args) {
		BinaryTree<Integer> bTree = new BinaryTree<Integer>();
		Random randomGenerator = new Random();
	    for (int i = 1; i <= 10; i++){
			Integer randomInt = randomGenerator.nextInt(100);
			BinaryNode<Integer> bNode = new BinaryNode<Integer>(randomInt);
			bTree.insert(root, bNode);
	    }
	    display(root);
	}
	
	/**
	 * Checks is the bTree is empty or not
	 * @return
	 */
	boolean isEmpty() {
		return (root == null);
	}
	
	/**
	 * Inserts a bNode into the bTree
	 * @param currentNode
	 * @param newNode
	 */
	void insert(BinaryNode currentNode, BinaryNode newNode) {
		if (isEmpty()) {
			root = newNode;
		}
		else {
			if (currentNode.data.compareTo(newNode.data) == 1) {
				if (currentNode.left == null) {
					currentNode.left = newNode;
				}
				else {
					insert(currentNode.left, newNode);
				}
			}
			else {
				if (currentNode.right == null) {
					currentNode.right = newNode;
				}
				else {
					insert(currentNode.right, newNode);
				}
			}
		}
	}
	
	static void display(BinaryNode root){
	    BinaryTreePrinter.printBinaryNode(root);
	}
	
}
