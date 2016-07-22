package com.hihuaning.mixture;

import java.util.ArrayList;

public class ArrayCopy {
	public static void main(String[] args){
		int[] arr1 = {1,2,3,4};
		int[] arr2 = new int[4];
		ArrayList as = null;
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);  //System类提供的arraycopy(来源，起始索引，目的，起始索引，复制长度)方法可进行数组复制
		for(int i = 0; i < arr2.length; i++)
			System.out.println(arr2[i]);
	}
}
