package com.hihuaning.thread;

public class ThreadDemo4 {                               //
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static void main(String[] args){
		Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
		int i;
		for(i = 0; i<NACCOUNTS; i++){
			TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}

class Bank{
	private final double[] accounts;
	public Bank(int n,double initialBalance){
		accounts = new double[n];
		for(int i=0;i<accounts.length;i++)
			accounts[i] = initialBalance;
	}

	public void transfer(int from,int to,double amount){
		if(accounts[from]<amount)
			return ;
		System.out.println("current thread is "+Thread.currentThread().getName());
		accounts[from] -= amount;
		accounts[to] += amount;
		System.out.printf("%10.2f from %d to %d",amount,from,to);
		System.out.println("Total Balance:"+getTotalBalance());
	}

	public double getTotalBalance(){
		double sum = 0;
		for(double i : accounts){
			sum += i;
		}
		return sum;
	}

	public int size(){
		return accounts.length;
	}

}


class TransferRunnable implements Runnable{
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;

	public TransferRunnable(Bank b,int from ,double max){
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	public void run(){
		try{
			while(true){
				int toAccount = (int)(bank.size()*Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY*Math.random()));
			}
		}
		catch(InterruptedException e){

		}
	}
}