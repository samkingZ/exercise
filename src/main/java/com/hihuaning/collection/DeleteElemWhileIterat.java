package com.hihuaning.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by disneyland on 7/22/16.
 */
public class DeleteElemWhileIterat {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<5; i++){
            list.add(i);
        }
        int index = 0;
        Iterator<Integer> it = list.iterator();
        //最好使用it.remove();安全性更高
        while(it.hasNext()){
            int data = it.next();
            if(data == 3){
               list.remove(data);
            }
            index++;
        }
        for(int i : list){
            System.out.println(i);
        }
    }
}
