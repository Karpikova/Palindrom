package com.company;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 28.05.2017
 * 
 * Karpikova
 */

public class Palindrom {
    private int firstPosition;
    private int length;

    public Palindrom(int firstPosition, int length) {
        this.firstPosition = firstPosition;
        this.length = length;
    }

    public int getFirstPosition() {

        return firstPosition;
    }

    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
