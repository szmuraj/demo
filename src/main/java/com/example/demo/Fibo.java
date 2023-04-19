package com.example.demo;


import java.util.ArrayList;

import java.util.List;


public class Fibo {


    public static void main(String[] args) throws Exception {
        List<String> logs = new ArrayList<>();
        logs.add("2");
        logs.add("99 6 sas");
        logs.add("99 7 as");
        logs.add("3");
        System.out.println(processLogs(logs,5));
    }
    public static List<String> processLogs(List<String> logs, int maxSpan) {
        int delta = 0;
        List<String> result = new ArrayList<>();
        String[] log = new String[logs.size() * 3 + 2];
        String[] fLog = new String[3];

        for(int i=0; i<Integer.parseInt(logs.get(0)); i++) {
            fLog = logs.get(i+1).split(" ");
            log[i*3] = fLog[0];
            log[i*3+1] = fLog[1];
            log[i*3+2] = fLog[2];
        }

        for(int k=1; k<=Integer.parseInt(logs.get(0)+2); k+=3) {
            if(log[k-1].equals(log[k+3])) delta = Integer.parseInt(log[k-1]) - Integer.parseInt(log[k+2]);
            if(delta >= maxSpan) result.add(log[k-1]);
        }
        return result;
    }
}
