package com.hihuaning.mixture;
/**
 * 复制对象本身最基本的方法就是实现Cloneable接口*/
public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException{
		Point point = new Point(1,2);
		Table table = new Table();
		table.setCenter(point);
		Table clonetable = (Table) table.clone();
		System.out.println("原table："+table.getCetner().getX()+" "+table.getCetner().getY());
		System.out.println("复制table："+clonetable.getCetner().getX()+" "+clonetable.getCetner().getY());
		clonetable.getCetner().setX(10);
		clonetable.getCetner().setY(20);
		System.out.println("原table："+table.getCetner().getX()+" "+table.getCetner().getY());
		System.out.println("复制table："+clonetable.getCetner().getX()+" "+clonetable.getCetner().getY());
	}

	static class Point implements Cloneable{
		private int x;
		private int y;

		public Point(){

		}

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		public void setX(int x){
			this.x = x;
		}

		public void setY(int y){
			this.y = y;
		}

		public int getX(){
			return x;
		}

		public int getY(){
			return y;
		}

		public Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}


	static class Table implements Cloneable{
		private Point center;

		public void setCenter(Point center){
			this.center = center;
		}

		public Point getCetner(){
			return center;
		}

		public Object clone() throws CloneNotSupportedException{
			Table clonetable = (Table) super.clone();
			if(center != null)
				clonetable.center = (Point) center.clone();
			return clonetable;
		}
	}

}

