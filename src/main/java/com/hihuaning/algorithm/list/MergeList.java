package com.hihuaning.algorithm.list;
/*
 *  合并单链表
 *  题2.23*/
public class MergeList {
	public static ListNode constructList(ListNode a, ListNode b){
		if(a == null){
			return b;
		}
		else if(b == null){
			return a;
		}
		ListNode c = a;
		ListNode p = a;
		ListNode p1 = a.next;
		ListNode p2 = b;
		while(p1!=null || p2!=null){
			if(p2 != null){
				p.next = p2;
				p = p.next;
				p2 = p2.next;
			}
			if(p1 != null){
				p.next = p1;
				p = p.next;
				p1 = p1.next;
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
		list = constructList(list,list1);
		ListNode pointer = list;
		while(pointer != null){
			System.out.print(pointer.data);
			pointer = pointer.next;
		}
	}
}
