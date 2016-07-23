package com.hihuaning.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by disneyland on 7/23/16.
 */
public class ThreadDemo6 {
    private List<String> nameList;

    public ThreadDemo6(){
        nameList = new ArrayList();
    }

    public synchronized void add(String name){
       nameList.add(name);
    }

    public synchronized void printAll(){
        for(String str : nameList){
            System.out.println(str);
        }
    }

    public static void  main(String[] args){
        final ThreadDemo6 demo = new ThreadDemo6();
        for(int i=0; i<2; i++){
            new Thread(){
                public void run(){
                    demo.add("A");
                    demo.add("B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {


                    }
                    demo.add("C");
                    demo.printAll();
                }
            }.start();
        }
    }

}
