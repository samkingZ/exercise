package com.hihuaning.mixture;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args){
		System.out.println(Math.add(1.2222, 2.2222));
	}

    static class Math{
        public static double add(double a, double b){
            BigDecimal d1 = new BigDecimal(Double.toString(a));
            BigDecimal d2 = new BigDecimal(Double.toString(b));
            return d1.add(d2).doubleValue();
        }

        public static double sub(double a, double b){
            BigDecimal d1 = new BigDecimal(Double.toString(a));
            BigDecimal d2 = new BigDecimal(Double.toString(b));
            return d1.subtract(d2).doubleValue();
        }

        public static double mul(double a, double b){
            BigDecimal d1 = new BigDecimal(Double.toString(a));
            BigDecimal d2 = new BigDecimal(Double.toString(b));
            return d1.multiply(d2).doubleValue();
        }

        public static double div(double a, double b){
            BigDecimal d1 = new BigDecimal(Double.toString(a));
            BigDecimal d2 = new BigDecimal(Double.toString(b));
            return d1.divide(d2).doubleValue();
        }

        public static double round(double a){
            BigDecimal d1 = new BigDecimal(Double.toString(a));
            BigDecimal d2 = new BigDecimal(1);
            return d1.divide(d2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

}


