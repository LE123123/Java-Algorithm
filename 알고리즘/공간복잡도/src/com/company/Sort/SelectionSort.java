package com.company.Sort;


import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        // 최솟값의 인덱스를 저장하는 변수 선언
        int lowest;
        for(int idx1 = 0; idx1 < dataList.size() - 1; idx1++) {
            // idx1 부터 최솟값을 찾아서 최솟값을 idx1이 가리키는 인덱스와 바꾸는 코드
            lowest = dataList.get(idx1);
            for(int compareIdx = idx1 + 1; compareIdx < dataList.size(); compareIdx++) {
               if(dataList.get(lowest) > dataList.get(compareIdx)) {
                   lowest = compareIdx;
               }
           }
            // swap
            Collections.swap(dataList, lowest, idx1);
        }
        return dataList;
    }
}
