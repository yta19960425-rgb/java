package yta.java;

import java.util.Arrays;


// 更改1122
public class Poker {
//建立52張牌，做洗牌
//輪流發給4個玩家
//將號碼做花色跟號碼的安排
//按照順序排列
	public static void main(String[] args) {
	//final這個變數不能被改值
	//int 整數
	//num 變數名稱 = 52（張）;
	
	final int num = 52;
	
	// 宣告一個可以存放很多整數的陣列，名字叫poker，
	// 並在記憶體中建立一個長度為num(52)的整數陣列，把他交給poker使用。
	//[] 陣列  int[] 一排很多個整數
	//poker 變數名稱，陣列叫poker，用來存放一副牌
	// = assignment 把右邊建立出來的陣列，指定給左邊的變數
	//int[num] 建立一個長度為num的整數陣列（建立一個有52個格子的整數陣列，每個格子預設值都是0
	
	int []poker = new int[num];
	
	// 我的想法：迴圈 i是變數名稱？  從0開始 i++代表每次加一張，最多到51號(注意）
	//chatgpt回答：
	//i = 整數變數名稱 (index) 
	// i++ 每跑一次迴圈 i＋1
	//不是加一張牌而是『處理下一個陣列位置』
	//第一次 i = 0 設定[poker] = 0
	//第二次 i = 1  設定[poker] =1
	//第52次 i=51 設定 poker = 51
	
	for	(int i=0; i<num; i++)poker[i] = i;
	
	//洗牌的核心程式碼fisher-yates shuffle
	// for迴圈：從最後一張開始往前洗
	//從最後一張開始，隨機找一張來交換
	//一路往前，直到整副牌被完全打亂
	for (int i = num -1; i>0; i--) {
	// 產生一個隨機位置r （0-i之間的隨機整數）
		int r = (int)(Math.random()*(i+1));
		//先用 temp暫存其中一個值，把另一個值蓋過來，再把暫存的值放回去 
		int temp = poker[i];
		poker[i]= poker[r];
		poker[r] = temp ; 
		
		
		
		}
	// int [][] players 宣告一個二維整數陣列，名字叫players
	// 在記憶體中建立一個：外層長度：4，內層長度:13 （也就是一個4*13的表格）
			int [][] players = new int[4][13];
			
		// 	從0跑到poker.length-1（牌數52 ->i = 0~51)
		// 這裡的 i 代表第幾張牌要發出來
	for (int i =0; i <poker.length; i++) {
		
		//二維陣列索引
		// players[玩家編號][第幾張牌]
		//外層索引[0-3]玩家0-3（4位玩家） 內層索引[0-12]（每位玩家的13張牌）
		//%取餘數  i%4的結果會循環：0、1、2、3、0、1、2、3、0
		// i/4 玩家手排位置 （/ 整數除法，小數點捨去）
		// poker[i]; 第i張洗好的牌
		// i % 4 給哪位玩家
		// i / 4 放到該玩家手排第幾張
		players[i%4][i/4] = poker[i];
	}
		// 定義花色與點數對照表
		//String[] 字串陣列
		//suit  陣列名稱，用來存放牌的『花色』
		//編排號/13 來決定花色
		//0~12   0/13 =0  黑桃
		//13~25  13/13=1  紅心
		//26~38        2  方塊
		//39~51        3  梅花
		String[] suits = {"黑桃", "紅心", "方塊", "梅花",};
		
		// 點數陣列
		//values 存放牌的點數
		//13牌對應13個元素
		// 牌編號％13 來決定點數
		//0  % 13 = 0  A
		//1  % 13 = 1  2
		//12 % 13 = 12 K
		//13 % 13 = 0  A
		String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 "
				,"8 ","9 ","10","J ","Q ", "K "};
		
	//for(int[] player :players)  增強型for迴圈（exhanced for loop)
	//players 是二維陣列，外層4個玩家，內層是每個玩家的13張牌
	//每次迴圈：player 代表「一位玩家的整副手牌』（長度為13的一維陣列）
	//迴圈會依序處理4位玩家
	
	for (int[] player : players) {
			//Arrays.sort(player); 把這位玩家的手牌按照編號順序
			//相同花色會牌再一起，從a-k排序
			Arrays.sort(player);
			
			//又是一個增強型的for迴圈
			//迴圈一次取出玩家手牌中的一張牌編號 （0~51）
			//card  代表該張牌的編號
			for (int card : player) {
				//把牌案編號轉換成『花色＋點數』的形式印出
				//card / 13  花色索引
				//card % 13  點數索引
				System.out.printf("%s%s ", suits[card/13], values[card%13]);
			}
			System.out.println();
		}		
  }
}



