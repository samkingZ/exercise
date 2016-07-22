package com.hihuaning.niuke;

/**
 * Created by disneyland on 7/21/16.
 */
public class Q26058 {
    public static void main(String[] args){
        int choise = 4;
        int count = 0;
        switch (choise){
            case 1:
                count++;
            case 2:
                count++;
            case 3:
                count++;
            case 4:
                count++;
            case 5:
                count++;
            //这里default 也会被执行。
            default:
                count++;
        }
        System.out.println(count);
    }
}
