package com.company;

import java.util.ArrayList;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        public T data;
        public Node<T> prev = null;
        public Node<T> next = null;
        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        // if DoubleLinkedList's head is null
        if(this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;

            while(node.next != null) {
                node = node.next;
            }
            // head -> node -> node -> null
            //          -> (point this) <-
            // add node
            Node<T> newNode = new Node<T>(data);
            // head -> node -> node -> newNode -> null
            node.next = newNode;
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll() {
        ArrayList<T> resultArray = new ArrayList<>();
        if(this.head != null) {
            Node<T> node = this.head;
//            System.out.println(node.data);
            resultArray.add(node.data);
            while(node.next != null) {
                node = node.next;
//                System.out.println(node.data);
                resultArray.add(node.data);
            }
        }
        System.out.println(resultArray);
    }

    // search from Head (Node)
    public Node<T> searchFromHead(T isData) {
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == isData) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    // search from Tail (Node)
    public Node<T> searchFromTail(T isData) {
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == isData) {
                    return node;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }

    public boolean insertToFront(T existedData, T addData) {
        if(this.head == null) {
            Node<T> node = new Node<T>(addData);
            this.head = node;
            this.tail = head;
            return true;
        }else {
            Node<T> node = this.head;
            if(node.data == existedData) {
                Node<T> newHead = new Node<T>(addData);
                newHead.next = this.head;
                this.head = newHead;
                this.head.next.prev = this.head;
                return true;
            } else {
                while(node != null) {
                    // head -> node -> node -> tail
                    if(node.data == existedData) {
                        // first node
                        Node<T> nodePrev = node.prev;
                        // new Node ( for add )
                        Node<T> newNode = new Node<T>(addData);

                        // optioning next
                        nodePrev.next = newNode;
                        nodePrev.next.next = node;

                        //optioning prev
                        nodePrev.next.prev = nodePrev;
                        node.prev = nodePrev.next;
                        return true;
                    } else {
                        node = node.next;
                    }
                }
            }
            return false;
        }
    }
}
