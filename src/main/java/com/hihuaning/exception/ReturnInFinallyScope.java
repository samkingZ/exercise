package com.hihuaning.exception;

/**
 * Created by disneyland on 7/23/16.
 * 在try或catch块里return，它会首先执行return 后面的表达式，将结果保存，
 * 故这里的statue虽然被finally块改变了，但是返回的仍然是1.
 * 如果finally快里，有return 语句，则执行finally块里的return ;
 */
public class ReturnInFinallyScope {
    public static void main(String[] args){
        System.out.println(changeStatue(0));
    }

    public static int changeStatue(int statue){
        try{
            statue = 1;
            return statue;

        }
        finally {
            System.out.println("run in finally scope");
            statue = 2;
            //return statue;
        }
    }
}
