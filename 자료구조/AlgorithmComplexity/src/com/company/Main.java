package com.company;

import com.company.Hash.MyHash;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        MyHash mainObject = new MyHash(20);
//        mainObject.saveData("DaveLee", "01022223333");
//        mainObject.saveData("HyunseoLee", "01044445555");
//        mainObject.saveData("David", "01066667777");
//        mainObject.saveData("Dave", "01088889999");
//        System.out.println(mainObject.getData("Dave"));

        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "사과");
        map1.put(2, "바나나");
        map1.put(3, "포도");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("DaveLee", "01033334444");
        map2.put("Dave", "01032221111");
        map2.put("David", "01044445555");

        System.out.println(map1.get(2));
        System.out.println(map2.get("Dave"));
    }
}
