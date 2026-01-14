package yta.java;

public class guessnote {

	public static void main(String[] args) {
		

	}

}

/*
 
 import
 畫面：
 border layout   版面配置
 color			顏色
 font			字型
 
 事件相關（按鈕點擊）：
 action event
 action listener
 implements action listener
 
 swing（畫面上的東西）
 j frame			視窗
 j button		按鈕
 j text field		單行輸入框
 j text area		多行文字區
 j panel			容器	
 j option pane	跳出視窗
 
 宣告類別（非常重要）
 public class Guess extends j frame implements action listener{}
 guess					宣告一個類別叫guess
 extends j frame		
 implements action listener	這個類別會處理『按鈕被點擊』的事件
 		guess.add action listener(this);
 		public void action performed (action event e)
 
 成員變數（整個類別都能用）
 private j button guess;   		guess  按鈕
 private j text field input;	input  輸入框
 private j text area log;		log    顯示紀錄
 
 存『正確答案』
 private string answer;
 
 最多可以猜幾次
 private final int times = 3;
 final 不能改
 
 計數器：現在猜第幾次
 private int counter
 
 建構子constructor
 public guess(){}
 		new guess(){}的時候一定會執行這里
 		
 標題列：
 super("猜數字遊戲");
 		呼叫j frame 的建構子，設定視窗標題
 		
 建立元件（只是『出生』，還沒放上畫面）
 guess = new j button("猜"）;
 input = new j text field ();
 log = new j text area();
 	new出三個元件
 	
 設定輸入框樣式
 input.set font (new font(null, font.bold |font.italic, 24));
 input.set fore ground(coloor.blue);
 		字型大小24/粗體＋斜體/字變藍色
 		
 視窗版面配置（使用東西南北中）版型
 set layout (new border layout());
 	
 add(log, border layout. center)
		log 放在中間（最大塊）
j panel top = new j panel (new border layout());
add(top,border layout.north);
	上方區域再放一個小容器
top.add(guess, border layout. east);
top.add(input, border layout. center);
		上方：右邊按鈕，中間輸入框
		
視窗基本設定：
set size(640, 480);
set visible(true);
set default close operation(exit_on_close);

初始化遊戲＋事件註冊
產生新答案、清空紀錄
 init game();
 
 告訴java，這個按鈕被點擊時，交給我（guess)處理
 guess.add action listener(this);
 
 public static void main(String[] args) {}
 意思是：java程式的『入口點』  程式從這一行開始執行
 public		任何地方都可以存取這個方法
 static		不用建立物件，也可以直接執行這個方法
 void		這個方法不回傳任何值
 main		固定名稱，程式起點
 (String[] args)	接收『命令列參數』用的陣列
 
 main:
 	裡面：程式開始時要做的事（建立物件、呼叫方法、印出結果、啟動視窗、遊戲、程式流程）
 	外面：功能的定義（類別、方法、變數） 
 	例子：開餐廳
 	裡面：開店時的流程（開燈、關門、請第一位客人）
 	外面：菜單、廚師、食譜（你能做什麼）
 
 
 
 
 */
