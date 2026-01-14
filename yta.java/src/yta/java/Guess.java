package yta.java;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.lang.foreign.AddressLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Guess extends JFrame{
	private JButton guess;
	private JTextField input; // 玩家輸入數字的欄位
	private JTextArea  log ;  //顯示猜測紀錄
	private String answer;    //存「正確答案」
	private final int times = 3; //最大猜測次數 = 3
	private int counter;   //計算目前猜了幾次
	
public Guess () {
	super ("猜數字遊戲");
	
	//按鈕與文字欄位初始化
	guess = new JButton("猜");
	input = new JTextField();
	log = new JTextArea();
	
	//輸入框外型與顏色
	input.setFont(new Font(null, Font.BOLD | Font.ITALIC, 24));
	input.setForeground(Color.BLUE);
	
	setLayout(new BorderLayout());
	add(log, BorderLayout.CENTER);
	
	JPanel top = new JPanel (new BorderLayout());
	add(top, BorderLayout.NORTH);	
	
	top.add(guess, BorderLayout.EAST);
	top.add(input, BorderLayout.CENTER);
	
	
	setLayout(new FlowLayout());
	setSize(480,480);
	setVisible(true);  // 顯示視窗
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
}


	public static void main(String[] args) {
		new Guess(); // 建立視窗物件
		


	}
	
}

