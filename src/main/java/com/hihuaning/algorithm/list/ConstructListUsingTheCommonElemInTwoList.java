package com.hihuaning.algorithm.list;
/*
 * 按序插入两有序表中相同元素
 * 题2.25*/
public class ConstructListUsingTheCommonElemInTwoList {
	public static ListNode construct(ListNode a, ListNode b){
		ListNode c = null;
		ListNode pre = c;
		boolean flag = true;
		while(a!=null && b!=null){
			if(a.data == b.data){
				if(flag){
					c = pre = a;
					flag = false;
					a = a.next;
				}
				else{
					pre.next = a;
					pre = pre.next;
					a = a.next;
				}
			}
			else if(a.data < b.data){
				a = a.next;
			}
			else{
				b = b.next;
			}
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
		for(int i=3; i<8;i++){
			if(i==3){
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
