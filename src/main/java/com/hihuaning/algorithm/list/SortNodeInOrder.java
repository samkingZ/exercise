package com.hihuaning.algorithm.list;

/*
将链表里的节点按规则排列
 */

public class SortNodeInOrder {
	public static CircleListNode construct(CircleListNode a){
		CircleListNode pointer = a;
		CircleListNode rear = a.prior;
		CircleListNode originalRear = a.prior;
		while(pointer !=originalRear && pointer.next != originalRear){
			CircleListNode temp = pointer.next;
			pointer.next.next.prior = pointer;
			pointer.next = pointer.next.next;
			rear.next = temp;
			temp.prior = rear;
			temp.next = a;
			a.prior = temp;
			rear = temp;
			pointer = pointer.next;
		}
		return a;
	}

	public static CircleListNode createCircleList(CircleListNode a){
		for(int i=0; i<10; i++){
			CircleListNode temp = new CircleListNode(i);
			if(i == 0){
				a.next = temp;
				a.prior = temp;
				temp.next = a;
				temp.prior = a;
			}
			else{
				CircleListNode pointer = a.prior;
				pointer.next = temp;
				temp.prior = pointer;
				temp.next = a;
				a.prior = temp;
			}
		}
		return a;
	}

	public static void printCircleList(CircleListNode a){
		CircleListNode pointer = a;
		boolean flag = true;
		while(pointer != a || flag){
			flag = false;
			System.out.print(pointer.data + " ");
			pointer = pointer.next;
		}
		System.out.println();
		flag = true;
		while(pointer != a || flag){
			flag = false;
			System.out.print(pointer.data + " ");
			pointer = pointer.prior;
		}
	}

	public static void main(String[] args){
		CircleListNode a = new CircleListNode(-1);
		createCircleList(a);
		printCircleList(construct(a));
	}
}

