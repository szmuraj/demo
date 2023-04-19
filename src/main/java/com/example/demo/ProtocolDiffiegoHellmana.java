package com.example.demo;

import java.math.BigDecimal;

public class ProtocolDiffiegoHellmana {


    public static void main(String[] args) {
        long g = 2;
        long a;
        long b;

        BigDecimal p = new BigDecimal("10332921861938291919377635159012636040519117927041835671194203494937679183911345052843111512544303969800681115505917911462916407940308340306260755239268943");
        BigDecimal aA = new BigDecimal("8370337962458643162004582468469045984889816058567658904788530882468973454873284491037710219222503893094363658486261941098330951794393018216763327572120126");
        BigDecimal bB = new BigDecimal("9755909033513767641159594933585734179714892615169429957597029280980531443144704341694474385957669949989090202320232433789032328934018623049865998847328154");

        //aA = Math.pow(g,a) % p;
        //bB = Math.pow(g,b) % p;

        //double sA = Math.pow(bB, a) % p;
        //double sB = Math.pow(aA, b) % p;
        //boolean s = sA == sB;


        System.out.println(aA);
        System.out.println(bB);
        //System.out.println(sA + " " + s);
    }
}
