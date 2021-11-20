package com.company;

public class SingleLinkedList<T> {
    // init SingleLinkedList's head for 'null'
    public Node<T> head = null;

    // Node
    public class Node<T> {
        public T data;
        public Node<T> next = null;
        public Node(T data) {
            this.data = data;
        }
    }

    // add One Node
    public void addNode(T data) {
        // if head points nothing
        if(head == null) {
            // head is new Node
            head = new Node<T>(data);
        } else {
            // if has head
            // head -> node -> node -> null
            //            ->  (node)  <-
            // using while to go null
            Node<T> node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            // head -> node -> node -> node -> null
            //                 -> (add this node) <-
            node.next = new Node<T>(data);
        }
    }

    public void printAll() {
        // if SingleLinkedList has head
        if(head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            // cycle to print all value
            while(node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            // if cannot search the data
            return null;
        }
    }

    // add data between the Node
    public void addNodeInside(T data, T isData) {
        // add next to the searchedNode
        Node<T> searchedNode = this.search(isData);
        if(searchedNode == null) {
            this.addNode(data);
        } else {
            // add new Node after searchedNode!
            // make some new node
            Node<T> newNode = new Node<T>(data);
            Node<T> nextNode = searchedNode.next;
            newNode.next = nextNode;
            searchedNode.next = newNode;
        }
    }

    // delete value -> search value
    public boolean delNode(T isData) {
        if(this.head == null) {
            // if Node has no data -> return false
            return false;
        } else {
            Node<T> node = this.head;
            if(node.data == isData) {
                this.head = this.head.next;
                return true;
            } else {
                while(node.next != null) {
                    if(node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                // if cannot search data
                return false;
            }
        }
    }
}
