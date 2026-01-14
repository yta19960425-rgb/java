package apis;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{
	// JPanel 畫布、不能單獨顯示、要放在j frame (常用來放按鈕、繪圖區、簽名板、文字欄位、標籤）
	
	private List<Line> lines;
	//宣告一個變數，但還沒有初始化
	// List<Line>  集合collection 介面，可儲存一串資料（有順序、可重複）
	// lines 變數名稱，可以在程式中用lines 來存取操作這個list
	
	public MyDrawer() {
		setBackground(Color.BLUE);
		
		lines = new ArrayList<Line>(); // 創造一個可以裝line物件的空串列
		

		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
	
}
