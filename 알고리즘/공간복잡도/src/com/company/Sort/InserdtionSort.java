package com.company.Sort;

import java.util.ArrayList;
import java.util.Collections;

public class InserdtionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for(int idx1 = 0; idx1 < dataList.size() - 1; idx1++) {
            for(int compareIdx = 0; compareIdx < idx1 + 1; compareIdx++) {
                if(dataList.get(idx1 - compareIdx + 1) < dataList.get(idx1 - compareIdx)) {
                    Collections.swap(dataList, idx1 - compareIdx + 1, idx1 - compareIdx);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }
}
