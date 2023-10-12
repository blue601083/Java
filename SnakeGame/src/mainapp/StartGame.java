package mainapp;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args){
    	
        //建立遊戲視窗
        JFrame frame = new JFrame("Java-貪吃蛇小遊戲");//標題
        frame.setSize(910,750);//視窗大小
        frame.setLocationRelativeTo(null);//視窗顯示螢幕中間
        frame.setResizable(false);//固定視窗大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//設定表單關閉事件
        frame.add(new GamePanel());//新增遊戲內容
        frame.setVisible(true);//設定表單可見   
        
        playsound pl = new playsound();  //音樂背景
        pl.playmusic();

    }
 }
