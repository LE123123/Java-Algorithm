package com.company.tree;

// Node에는 value, right, left가 있어야 한다
public class Node {
    public Node left;
    public Node right;
    public int value;
    public Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}