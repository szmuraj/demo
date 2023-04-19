package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Persist {

    public static void main(String[] args) {
        System.out.println(points("is2 Thi1s T4est 3a"));
        System.out.println(printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
        System.out.println(shortcut("hello"));
    }


    public static String points(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }

    public static String printerError(String s) {
        long errs = s.chars().filter(ch -> ch > 'm').count();
        return errs + "/" + s.length();
    }

    public static String shortcut(String input) {
        return input.replaceAll("[aeiou]", "");
    }
}