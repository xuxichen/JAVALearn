package com.MethodReference.Object;

/**
 * 通过实例对象引用成员方法
 * 使用前提是实例对象已经存在，成员方法也存在
 * 就可以使用（实例对象::成员方法)简写lamda
 */
public class ObjectMethodMain {

    public static void print(PrintAble printAble) {
        printAble.print("xsdsdas");
    }

    public static int method(int i, Calcable calcable) {
        return calcable.cal(i);
    }

    public static void main(String[] args) {
        print((s)->{
            MethodRerObject methodRerObject = new MethodRerObject();
            methodRerObject.printUpperCaseString(s);
        });

        MethodRerObject methodRerObject = new MethodRerObject();
        print(methodRerObject::printUpperCaseString);

        print(StaticMethodRerObject::printUpperCaseString);

        int abs = method(-100, new Calcable() {
            @Override
            public int cal(int i) {
                return Math.abs(i);
            }
        });
        System.out.println("abs == "+abs);

        int abs2 = method(-19, Math::abs);
        System.out.println("abs2 == "+abs2);
    }
}
