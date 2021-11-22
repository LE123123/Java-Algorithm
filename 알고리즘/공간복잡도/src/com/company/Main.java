package com.company;

import com.company.Sort.BubbleSort;
import com.company.Sort.InserdtionSort;
import com.company.Sort.SelectionSort;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Integer> testData = new ArrayList<Integer>();
//        for (int i = 0; i < 100; i++) {
//            testData.add((int) (Math.random() * 100));
//        }
//        BubbleSort bSort = new BubbleSort();
//        bSort.sort(testData);
//
//        System.out.println(testData);

//        ArrayList<Integer> testData = new ArrayList<Integer>();
//
//        for(int i = 0; i < 100; i++) {
//            testData.add((int)(Math.random() * 100));
//        }
//        SelectionSort sSort = new SelectionSort();
//        sSort.sort(testData);
//        System.out.println(testData);


        ArrayList<Integer> testData = new ArrayList<Integer>();

        for(int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        InserdtionSort iSort = new InserdtionSort();
        iSort.sort(testData);

        System.out.println(testData);
    }
}
