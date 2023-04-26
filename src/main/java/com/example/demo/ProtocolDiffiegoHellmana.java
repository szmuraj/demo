package com.example.demo;

import java.math.BigDecimal;

public class ProtocolDiffiegoHellmana {


    public static void main(String[] args) {
        System.out.println(arithmetic(5,2,"add"));
    }

    public static int arithmetic(int a, int b, String operator) {
        switch(operator) {
            case "add": return a + b;
            case "subtract": return a-b;
            case "multiply": return a*b;
            case "divide": return a/b;
        }
        return 0;
    }
}
