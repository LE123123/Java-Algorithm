package com.company;

import com.company.Heap.Heap;

public class Main {

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);

        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        // expect
        // [ null, 20, 10, 15, 5, 4, 8]

        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
