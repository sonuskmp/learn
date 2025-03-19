package com.basic.enums;
public enum Category {
    CAT("cat"),
    DOG("dog"),
    LION("lion"),
    ELEPHANT("elephant"),
    MONKEY("monkey"),
    DONKEY("donkey");

    private String name;

    Category(String name){
       this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
