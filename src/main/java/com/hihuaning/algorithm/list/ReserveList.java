package com.hihuaning.algorithm.list;
/*
 * 《数据结构》严蔚敏版2.22*/
public class ReserveList {
	public static ListNode reserve(ListNode list){
		if(list == null){
			return list;
		}
		ListNode p1 = list;
		ListNode p2 = list.next;
		ListNode head = list;
		while(p2 != null){
			p1.next = p2.next;
			p2.next = head;
			head = p2;
			p2 = p1.next;
			System.out.println(head.data);
		}
		return head;
	}

	public static void main(String[] args){
		ListNode list = null;
		ListNode pre = null;
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
		ListNode pointer = list;
		while(pointer != null){
			System.out.print(pointer.data);
			pointer = pointer.next;
		}
		System.out.println();
		list = reserve(list);
		pointer = list;
		while(pointer != null){
			System.out.print(pointer.data);
			pointer = pointer.next;
		}
	}
}

