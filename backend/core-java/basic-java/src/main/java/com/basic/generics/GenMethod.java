package com.basic.generics;

public class GenMethod {
    public <T> void printArray(T[] t){
        for(T item: t){
            System.out.println(item);
        }
        System.out.println("----------------------------");
    }


    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        GenMethod gm = new GenMethod();
        gm.printArray(intArray);
        gm.printArray(doubleArray);
        gm.printArray(charArray);
    }

}
