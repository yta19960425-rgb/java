package yta.java;

import java.awt.print.Printable;

public class a06 {
	//for 迴圈  1~100 的總和
	public static void main(String[] args) {
		
		int sum = 0;
		for (int i =1; i<=100; i++) {
			sum += i;
			
		}
	
			System.out.println("1-100的總和是" + sum);
		
		int i = 998;
		if(i % 2 == 0) {
			System.out.println("是偶數");
		}else {
			System.out.println("是奇數");
		}
		
		int count = 0;
		for(int a=0; a<=100; a+=2) {
			System.out.print(a + "\t");
			count++;
			if(count %10 == 0) {
			System.out.println();
			}
		}
			System.out.println();
		
		
		
		count = 0;
		for(int b=1; b<=100; b+=2) {
			System.out.print(b + "\t");
			count++;
			if(count %10 == 0) {
				System.out.println();
			}
			
			
		}
		
		

	}

}

//
//判斷輸入的數字是奇數或偶數
//建立一個陣列，印出所有元素
//