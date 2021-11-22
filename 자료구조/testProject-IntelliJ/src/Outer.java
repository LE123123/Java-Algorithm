// Inner Class (None-Static Nested Class)
//public class Outer {
//    int outerAge;
//    String outerName;
//
//    // innerClass
//    public class Inner {
//        int innerAge;
//        String innerName;
//        Inner(int age, String name){
//            this.innerAge = age;
//            this.innerName = name;
//        }
//    }
//
//    Outer(int age, String name) {
//        this.outerAge = age;
//        this.outerName = name;
//    }
//}


// Static Nested Class
//public class Outer {
//    static int outerAge;
//    static String outerName;
//
//    // innerClass
//    public static class Inner {
//        int innerAge;
//        String innerName;
//        Inner(int age, String name){
//            this.innerAge = age;
//            this.innerName = name;
//        }
//    }
//
//    Outer(int age, String name) {
//        this.outerAge = age;
//        this.outerName = name;
//    }
//}

// Method Local Inner Class
public class Outer {
    // field
    static int outerAge;
    static String outerName;

    // method
    public void outerMethod() {
        // Method Local Inner CLass
        class Inner {
            int innerAge;
            String innerName;
            Inner(int age, String name){
                this.innerAge = age;
                this.innerName = name;
            }
        }
        Inner inner = new Inner(20, "Hyunseo");
        System.out.println("inner_age >> " + inner.innerAge);
        System.out.println("inner_name >> " + inner.innerName);
    }

    // constructor
    Outer(int age, String name) {
        this.outerAge = age;
        this.outerName = name;
    }
}