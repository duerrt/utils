package com.tom;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Main m = new Main();
        boolean stat = m.ghappy("xxggxx");
        System.out.println("stat is " + stat);
    }

    private boolean ghappy(String str) {
        boolean happy = false;

        int unhappy = 0;
        char[] chars = str.toCharArray();

        if (chars[0] == 'g' && chars[1] == 'g') {
            if (chars[1] != 'g'){
                unhappy++;
            }
        }
        if (chars[chars.length - 1] == 'g' && chars[chars.length - 2] == 'g') {
            if (chars[chars.length - 2] != 'g') {
                unhappy++;
            }
        }
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == 'g') {
                if (chars[i - 1] == 'g' || chars[i + 1] == 'g') {
                    happy = true;
                } else {
                    unhappy++;
                }
            }
        }

        return (unhappy > 0) ? false : true;
    }
}