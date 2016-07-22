package com.hihuaning.algorithm.list;

/*
 * 题2.27
 * 按序插入两有序表中不同元素
 * 利用两顺序链表归并的方法，预进入c的顺序是有序的，所以如果有相同元素只需设置一个pre，在放入c前先判断是否和pre的值一样，若不一样就插入*/
public class MergeListInOrder {
	public static ListNode construct(ListNode a, ListNode b){
		ListNode c = null;
		ListNode pre = c;
		while(a!=null || b!=null){
			if(a!=null&&b!=null&&a.data<b.data || b==null){
				if(pre==null || pre.data!=a.data){
					if(pre == null){
						c = a;
						pre = c;
					}
					else{
						pre.next = a;
					}
					pre = a;
				}
				a = a.next;
			}
			else{
				if(pre==null || pre.data!=b.data){
					if(pre == null){
						c = b;
						pre = c;
					}
					else{
						pre.next = b;
					}
					pre = b;
				}
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