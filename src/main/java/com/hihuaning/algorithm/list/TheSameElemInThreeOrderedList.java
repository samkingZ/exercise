package com.hihuaning.algorithm.list;

/*
 * 三个有序列表中输出其中相同的元素
 * 每个列表设置一个指针放在其首部，判断b,c指针所指节点的值是否都不小于a指针的值，若小于则向后移动直到不小于a的值，然后分别判断b,c指针的值是否等于a，若等于则插入*/
public class TheSameElemInThreeOrderedList {
	public static ListNode construct(ListNode a, ListNode b, ListNode c){
		ListNode d = null;
		ListNode pre = d;
		while(a != null){
			boolean flag1 = false;
			boolean flag2 = false;
			while(b.data < a.data){
				b = b.next;
			}
			while(c.data < a.data){
				c = c.next;
			}
			if(c.data == a.data && b.data == a.data){
				if(pre == null){
					d = a;
					pre = d;
				}
				else{
					pre.next = a;
					pre = pre.next;
				}
			}
			a = a.next;
		}
		return d;
	}

	public static void main(String[] args){
		ListNode list = null;
		ListNode pre = null;
		ListNode list1 = null;
		ListNode pre1 = null;
		ListNode list2 = null;
		ListNode pre2 = null;
		for(int i=1; i<6;i++){
			if(i==1){
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
		for(int i=4; i<9;i++){
			if(i==4){
				list2 = new ListNode(i);
				pre2 = list2;
			}
			else{
				pre2.next = new ListNode(i);
				pre2 = pre2.next;
			}
		}
		list = construct(list,list1,list2);
		ListNode pointer = list;
		while(pointer != null){
			System.out.print(pointer.data);
			pointer = pointer.next;
		}
	}
}
