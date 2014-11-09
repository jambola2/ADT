package com.gemsedu.adt;

public class BinaryNode<T extends Comparable>  {
	T data;
	BinaryNode<?> left;
	BinaryNode<?> right;
	
	public BinaryNode(T data) {
		this.data = data;
	}
}
