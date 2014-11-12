package com.gemsedu.adt;
//Comment

public class BinaryNode<T extends Comparable>  {
	T data;
	BinaryNode<?> left;
	BinaryNode<?> right;
	
	public BinaryNode(T data) {
		this.data = data;
	}
}
