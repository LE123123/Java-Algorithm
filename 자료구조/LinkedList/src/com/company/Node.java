package com.company;

// Node 클래스 구현
public class Node<T> {
    private T data;

    // null을 가리키고 있음
    public Node<T> next = null;

    public Node(T data) {
        // set-data
        this.data = data;
    }
}
