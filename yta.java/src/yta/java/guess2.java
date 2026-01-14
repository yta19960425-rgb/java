package yta.java;
import javax.swing.*;
import java.awt.*;

public class guess2 {
    public static void main(String[] args) {
        // 1️⃣ 建立視窗
        JFrame frame = new JFrame("猜數字遊戲 - 簡化版");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 2️⃣ 建立多行文字區 log
        JTextArea log = new JTextArea();
        log.setEditable(false); // log 不能編輯
        frame.add(log, BorderLayout.CENTER);

        // 3️⃣ 建立輸入框和按鈕
        JTextField input = new JTextField();
        JButton guessButton = new JButton("猜");

        // 4️⃣ 用 JPanel 將輸入框 + 按鈕放一起
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(input, BorderLayout.CENTER);
        topPanel.add(guessButton, BorderLayout.EAST);

        // 5️⃣ 把上方 panel 放到視窗 NORTH
        frame.add(topPanel, BorderLayout.NORTH);

        // 6️⃣ 顯示視窗
        frame.setVisible(true);
    }
}