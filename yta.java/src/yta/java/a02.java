package yta.java;

import java.util.Scanner;

public class a02 {
// 使用者輸入剪刀石頭布，電腦都會贏的寫法
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String string = scanner.nextLine();
		
		if(string.equals("剪刀")) 
			System.out.println("石頭");
		else {
		if(string.equals("布")) 
				System.out.println("剪刀");
		else {
				System.out.println("布");
			}
		}
		
	}

}
