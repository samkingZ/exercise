package com.hihuaning.algorithm.list;
/*
 * 题2.24
 * 合并有序列表成一个逆序列表
 * */
public class MergeTwoListToReverseList {
	public static ListNode construct(ListNode a, ListNode b){
		ListNode c = null;
		while(a!=null || b!=null){
			ListNode pointer = null;
			if(a!=null&&b!=null&&a.data<b.data || b==null){
				pointer = a;
				a = a.next;
			}
			else{
				pointer = b;
				b = b.next;
			}
			pointer.next = c;
			c = pointer;
		}
		return c;
	}

	public static void main(String[] args){
		ListNode list = null;
		ListNode pre = null;
		ListNode list1 = null;
		ListNode pre1 = null;
		for(int i=0; i<5;i++){
			if(i==0){
				list = new ListNode(i);
				pre = list;
			}
			else{
				pre.next = new ListNode(i);
				pre = pre.next;
			}
		}
		for(int i=5; i<10;i++){
			if(i==5){
				list1 = new ListNode(i);
				pre1 = list1;
			}
			else{
				pre1.next = new ListNode(i);
				pre1 = pre1.next;
			}
		}
		list = construct(list,list1);
		ListNode pointer = list;
		while(pointer != null){
			System.out.print(pointer.data);
			pointer = pointer.next;
		}
	}
}

