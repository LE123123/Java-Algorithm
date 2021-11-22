package com.company.Hash;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        // object list
        this.hashTable = new Slot[size];
    }

    // 내부 클래스
    public class Slot {
        public String key;
        public String value;
        public Slot next;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    // Chaining 기법
//    public boolean saveData(String key, String value) {
//        // 해당 키에 대한 주소를 가져온다.
//        Integer address = this.hashFunc(key);
//
//        // 이미 해당 슬롯이 있다면
//        if(this.hashTable[address] != null) {
//            // linked list 기법을 사용해서 이어 붙여야 한다.
//            // 일종의 해드라고 할 수 있다.
//            Slot findSlot = this.hashTable[address];
//            while(findSlot.next != null) {
//                if(findSlot.key == key){
//                    // 해당되는 키를 찾았다면 value만 바꿔주면 된다.
//                    findSlot.value = value;
//                    return true;
//                } else {
//                    findSlot = findSlot.next;
//                }
//            }
//            // 만약 마지막까지 순회했다면
////            System.out.println("findSlot key >> " + findSlot.key);
////            System.out.println("findSlot value >> " + findSlot.value);
////            System.out.println("key >> " + key + " value >> " + value);
//            findSlot.next = new Slot(key, value);
//        } else {
//            // 해당 슬롯에 아무것도 할당되어 있지 않다면
//            this.hashTable[address] = new Slot(key, value);
//        }
//        return true;
//    }

    // Linear Probing 기법
    public boolean saveData(String key, String value) {
        // 해당 키에 대한 주소를 가져온다.
        Integer address = this.hashFunc(key);

        // 값이 있다면
        if(this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                // linear probing기법을 위해 address를 1더 해준다
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null) {
                    if(this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if(currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }


    // Chaining 기법
//    public String getData(String key) {
////        System.out.println("we're just find >> " + key);
//        Integer address = this.hashFunc(key);
//        if(this.hashTable[address] != null) {
//            Slot findSlot = this.hashTable[address];
//            while(findSlot != null) {
////                System.out.println("Slot key >> " + findSlot.key);
////                System.out.println("Slot value >> " + findSlot.value);
//                if(findSlot.key == key) {
//                    return findSlot.value;
//                } else {
//                    findSlot = findSlot.next;
//                }
//            }
//            return null;
//        } else {
//            return null;
//        }
//    }


    // Linear Probing 기법
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            if(this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address;
                while(this.hashTable[currAddress] != null) {
                    if(this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if(currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
