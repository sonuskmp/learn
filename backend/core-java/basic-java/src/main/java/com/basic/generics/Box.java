package com.basic.generics;
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<String> boxStr = new Box<>();
        boxStr.set("Test String");
        System.out.println(boxStr.get());

        Box<Integer> boxInt = new Box<>();
        boxInt.set(1);
        System.out.println(boxInt.get().toString());
    }



}
