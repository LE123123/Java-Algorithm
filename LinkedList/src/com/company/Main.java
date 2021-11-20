package com.company;

public class Main {
    public static void main(String[] args) {
//        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
//        MyLinkedList.addNode(1);
//        MyLinkedList.addNode(2);
//        MyLinkedList.addNode(3);
//
//        // add
//        MyLinkedList.addNodeInside(5, 1);
//
//        // delete
//        MyLinkedList.delNode(3);
//        MyLinkedList.printAll();


//        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();
//        MyLinkedList.addNode(2);
//        MyLinkedList.addNode(4);
//        MyLinkedList.addNode(5);
//        MyLinkedList.addNode(8);
//        MyLinkedList.addNode(3);
//
//        MyLinkedList.printAll();

        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("------------------------");
        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("------------------------");
        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("------------------------");
        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }
}
