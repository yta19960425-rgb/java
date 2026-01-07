// 環境準備
package yta.java;

import java.awt.BorderLayout;     	 //版面配置
import java.awt.Color;  			
import java.awt.Font;				
import java.awt.event.ActionEvent;	//
import java.awt.event.ActionListener;	//按鈕事件監聽

import javax.swing.JButton;			//按鈕
import javax.swing.JFrame; 			//視窗
import javax.swing.JOptionPane;		//跳出對話框
import javax.swing.JPanel;			//
import javax.swing.JTextArea;		//多行文字區（顯示紀錄）
import javax.swing.JTextField;		//單行輸入框

public class a05 extends JFrame implements ActionListener{
	// 成員變數
	private JButton guess; 		//猜的按鈕
	private JTextField input;	//使用者輸入
	private JTextArea log;		//顯示歷史紀錄
	private String answer;		//正確答案
	//  final  不能被改
	private final int times = 10;	//最多猜的數字
	private int counter;		//	已猜數字
	
	// 建構式（畫面＋初始化）
	// 呼叫 jframe 的建構式
	// 設定視窗標題
	// super 呼叫父類別
	public a05() {
		super("猜數字遊戲");
		
		//建立元件
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		// 設定輸入框外觀
		input.setFont(new Font(null, Font.BOLD | Font.ITALIC , 24));
		input.setForeground(Color.BLUE);
		
		// 視窗版面配置  整體用BorderLayout
		setLayout(new BorderLayout());
		add(log, BorderLayout.CENTER);
		
		// 上方輸入區，再包一層JPanel
		JPanel top = new JPanel(new BorderLayout());
		add(top, BorderLayout.NORTH);
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		//視窗基本設定
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 初始化遊戲＋綁定事件
		initGame(); 						//產生答案、清空狀態
		guess.addActionListener(this);		//代表事件按鈕交給guess自己處理
		
//		guess.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("OK2");
//			}
//		});
	}
	
	// 重新開始遊戲
	//做的事情：
	//清空紀錄
	//產生3位不重複答案
	//次數歸零
	private void initGame() {
		log.setText("");
		answer = createAnswer(3);
		counter = 0;
		System.out.println(answer); //印答案自己看
	}
	
	//  createAnswer(int d) 產生不重複數字  （洗牌）
	private String createAnswer(int d) {
		final int num = 10;
		//  建立0-9
		int[] poker = new int[num];
		for (int i=0; i<num; i++) poker[i] = i;
		// 隨機打亂陣列
		for (int i = num - 1; i > 0; i--) {
			int r = (int)(Math.random()*(i+1));
			// poker[i] <=> poker[r]
			int temp = poker[i];
			poker[i] = poker[r];
			poker[r] = temp;
		}		
		// 取前d個數字組成答案字串
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<d; i++) sb.append(poker[i]);
		
		return sb.toString();
	}
	
	//   main 程式進入點
	// 只要a05() 視窗就出來了
	public static void main(String[] args) {
		new a05();
	}

	// actionPerformed 按下猜會發生的事
	@Override
	public void actionPerformed(ActionEvent e) {
		// 取得使用者輸入
		String g = input.getText();
		// 檢查機制（一定要放在這裡）chatgpt說不合法輸入不算一次猜測，但位置老師放的
		//不能是空的、長度一定要是3、只能是數字、數字不能重複
		// 1.檢查空字串
		if(g.length() == 0) {
			JOptionPane.showMessageDialog(this, "請輸入數字");
			return;
		}
		//長度一定是3
		if(g.length() != 3) {
			JOptionPane.showMessageDialog(this, "請輸入數字");
			return;
		}
		// 只能是數字
		for (int i = 0; i < g.length(); i++) {
		    if (!Character.isDigit(g.charAt(i))) {
		        JOptionPane.showMessageDialog(this, "只能輸入數字");
		        return;
		    }
		}

		// 4. 是否重複
		for (int i = 0; i < g.length(); i++) {
		    for (int j = i + 1; j < g.length(); j++) {
		        if (g.charAt(i) == g.charAt(j)) {
		            JOptionPane.showMessageDialog(this, "數字不能重複");
		            return;
		        }
		    }
		}
		// 為什麼一直用return 
		// 一但輸入不合理，立刻結束這次事件處理
		
		
		// 次數+1、清空輸入框
		counter++;
		input.setText("");
		
		//計算a、b
		String result = checkAB(g);
		// 顯示紀錄
		log.append(String.format("%d. %s => %s\n", counter, g, result));
		
		//判斷輸贏
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "恭喜老爺");
			initGame();
		}else if (counter == times) {
			JOptionPane.showMessageDialog(null, "Answer is " + answer);
			initGame();
		}
		
	}
	//checkAB(1A2B的核心邏輯）
	private String checkAB(String g) {
		int A, B; A = B = 0;
		
		for (int i=0; i<answer.length() ;i++) {
			// 判斷規則
			if (answer.charAt(i) == g.charAt(i)) {
				A++;  // 數字、位置一樣
			}else if (answer.indexOf(g.charAt(i)) != -1){
				B++;   //數字有、位置不一樣
			}
		}
		
		return String.format("%dA%dB", A, B);
	}
	
	
}

// 在做什麼？
//開一個視窗jframe
//產生3個不重複的隨機數字當答案
//使用者輸入3個數字按『猜』
//系統隨機傳回幾a幾b
//最多猜10次
//猜對 恭喜 重來
//猜錯10次 顯示答案 重來

//重點：
//gui程式 不等於 從上跑到下（是物件導向）
//initGame()= 重來一次



