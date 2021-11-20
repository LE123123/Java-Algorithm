package com.company.Heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }

    // 이동할지 말지를 결정하는 함수
    public boolean move_up(Integer inserted_idx) {
        // 만약 최상위 노드거나 음수면 그냥 false
        if(inserted_idx <= 1) {
            return false;
        }
        Integer parent_idx = inserted_idx / 2;
        if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 떄 (자식 노드가 하나도 없을 떄)
        if(left_child_popped_idx >= this.heapArray.size()) {
            return false;
        } else if(right_child_popped_idx >= this.heapArray.size()) {
            // CASE2: 오른쪽 자식 노드만 없을 떄 (왼쪽 노드는 있다는 뜻)
            if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        } else {
            // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 떄
            // 왼쪽 오른쪽 중 뭐가 더 큰지 결정 -> 왼쪽이 더 크다면
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                // 왼쪽이 나올 것 보다 크다면 -> 이제 바꿔야지
                if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean insert(Integer data) {
        // parent node의 인덱스 번호와 추가 된 node의 인덱스 번호를 저장할 변수
        Integer inserted_idx, parent_idx;

        if(heapArray == null) {
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        // 이제 값 추가
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;

        while(this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;
            Collections.swap(heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
        // 그냥 heapArray가 null이라면 null을 반환 하는것이 맞다
        if(this.heapArray == null) {
            return null;
        } else {
            returned_data = this.heapArray.get(1);

            // 이제 가장 위로 올린다
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;

            while(this.move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                // CASE2: 오른쪽 자식 노드만 없을 떄
                if(right_child_popped_idx >= this.heapArray.size()) {
                    // 아래꼐 더 크면 바꾸고 이제 poped_idx를 * 2 해줘서 왼쪽 노드를 가리키게 해야 한다.
                    if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                    // CASE3: 왼쪽/오른쪽 자식 노드가 모두 있을 때
                } else {
                    // 왼쪽이 더 크다면
                    if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        // left_child_popped_idx가 더 크다면 이제 바꿔야지
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }
            }
            return returned_data;
        }
    }
}
