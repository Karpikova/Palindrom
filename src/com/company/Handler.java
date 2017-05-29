package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 29.05.2017
 * 
 * Karpikova
 */
public class Handler {

    public static void findTheLongestOne(String str) {
        Set<Palindrom> pairs = new HashSet<Palindrom>();
        fillFirstPalindroms(pairs, str);
        lookForTheLongest(pairs, str);
        countLengthOfTheLongest(pairs);
    }

    private static void countLengthOfTheLongest(Set<Palindrom> pairs) {
        int length;
        for (Palindrom palindrom:
                pairs) {
            length = palindrom.getLength();
            if (length > GlobalConfig.getMax()) {
                GlobalConfig.setMax(length);
            }
        }
    }

    private static void lookForTheLongest(Set<Palindrom> pairs, String str) {
        char[] letters = str.toCharArray();
        boolean madeLonger = true;
        while (madeLonger) {
            madeLonger = checkNextLevel(pairs, letters);
        }
    }

    private static boolean checkNextLevel(Set<Palindrom> pairs, char[] letters) {
        boolean madeLonger = false;
        Iterator<Palindrom> iter = pairs.iterator();

        while(iter.hasNext()){
            Palindrom next = iter.next();
            if (next.getFirstPosition() == 1)
            {
                handleEdgePalindrom(iter, next);
                madeLonger = true;
                continue;
            }

            if (next.getFirstPosition()+next.getLength() == letters.length+1)
            {
                handleEdgePalindrom(iter, next);
                madeLonger = true;
                continue;
            }

            if(letters[next.getFirstPosition()-2] == letters[next.getFirstPosition() + next.getLength()-1]) {
                next.setFirstPosition(next.getFirstPosition() -1);
                next.setLength(next.getLength() + 2);
                madeLonger = true;
            }
        }

        return madeLonger;
    }

    private static void handleEdgePalindrom(Iterator<Palindrom> iter, Palindrom next) {
        if (next.getLength() > GlobalConfig.getMax()){
            GlobalConfig.setMax(next.getLength());
        }
        iter.remove();
    }

    private static void fillFirstPalindroms(Set<Palindrom> pairs, String str) {
        char[] symbols = str.toCharArray();
        for (int i = 0; i<str.length(); i++){
            Palindrom palindrom = new Palindrom(i+1, 1);
            pairs.add(palindrom);
        }
        int pos = 1;
        char previous = '\u0000';
        for (char symb:
                symbols) {
            if (pos == 1) {
                pos ++;
                previous = symb;
                continue;
            }
            if (previous == symb) {
                Palindrom palindrom = new Palindrom(pos-1, 2);
                pairs.add(palindrom);
            }
            previous = symb;
            pos++;
        }
    }
}
