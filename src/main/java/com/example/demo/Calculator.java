package com.example.demo;

import java.io.*;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IOException {
        File file = new File("C://Java//kodilla-course//demo//src//main//java//com//example//demo//Calculate.txt");

        Scanner scanner = new Scanner(file);
        String words = "";

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            words += line + " ";
        }
        System.out.println(method(words));
    }

    public static int method(String str) {
        String[] words = str.toLowerCase().split(" ");
        int apply = Integer.parseInt(words[words.length - 1]);

        for (int i = 0; i < words.length - 2; i += 2) {
            if (words[i].equals("add")) {
                apply += Integer.parseInt(words[i + 1]);
            } else if (words[i].equals("multiply")) {
                apply *= Integer.parseInt(words[i + 1]);
            } else if (words[i].equals("subtract")) {
                apply -= Integer.parseInt(words[i + 1]);
            } else if (words[i].equals("divide")) {
                apply /= Integer.parseInt(words[i + 1]);
            }
        }
        return apply;
    }
}
