package yta.java;

import java.awt.BorderLayout; // // 排版管理器
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import apis.MyDrawer;


public class MySign extends JFrame{
// 新增視窗、設定大小 j frame setting
	private MyDrawer myDrawer = new MyDrawer();
	private JButton clear; // 宣告變數，整個class可以使用
	
	
	
	public MySign() {  		//跟爸爸j frame說視窗標題叫
		super("Mysign");  // 視窗的標題名字
		
		
		
		
		setLayout(new BorderLayout());  // 設定j frame（或任何容器）裡面的排版方式
		
		
		// 建立一個j panel叫做 top，設定layout為flow layout
		// flow layout 元件從左到右排列、自動換行，適合放按鈕、文字欄位等元件
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear"); // 建立j button 物件，賦予給變數
		top.add(clear);
		add(top, BorderLayout.NORTH);
		add(myDrawer, BorderLayout.CENTER);
		
		
		setSize(800, 400);
		setVisible(true); // 布林值 true是可以被看見
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//綁定事件 initEvent();
		
		
	}
	 
	
	

	
	
	
	
	
	public static void main(String[] args) {
	 new MySign();

	}

}


//  private MyDrawer myDrawer;       // 宣告成員變數
//  myDrawer = new MyDrawer();      // 建立物件（初始化）
