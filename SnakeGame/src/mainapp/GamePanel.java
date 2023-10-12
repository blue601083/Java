package mainapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Random;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int[] snakeX = new int[500];//貪吃蛇橫座標
    int[] snakeY = new int[500];//貪吃蛇縱座標
    int foodX;//食物橫座標
    int foodY;//食物蛇縱座標
    int length;//貪吃蛇的長度
    String  direction;//貪吃蛇頭方向
    int score;//積分
    Random r = new Random();
    Timer timer = new Timer(100,this);
    boolean isStart;
    boolean isFail;
        
    //建構函式
    public GamePanel(){
        init();
        this.setFocusable(true);  //使用JFrame的KeyListener事件，那麼Focus一定要在JFrame上才有作用
        this.addKeyListener(this);
        timer.start();
    }
    private void init(){
        length=3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        direction = "R";
        eat(foodX,foodY);
        isStart = false;
        isFail = false;
        score = 0;

    }
    private void eat(int x,int y){
        x= 25 + 25*r.nextInt(34);   // X[] 850/25/點  g.fillRect(25,75,850,600); 2534 7524
        y= 75 + 25*r.nextInt(24);   // Y[] 600/25/點
        for (int i = 0; i < length; i++) {
            if(snakeX[i]==x&&snakeY[i]==y){
                x = 25 + 25*r.nextInt(34);
                y = 75 + 25*r.nextInt(24);
            }
        }
        foodX = x;foodY = y;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);//設定背景板為白色
        //畫標題
        g.setColor(Color.pink);
        g.setFont(new Font("微軟正黑體",Font.BOLD,60));
        g.drawString("貪吃蛇遊戲",300,60);
        //繪製遊戲區域
        g.setColor(Color.DARK_GRAY);
        g.fillRect(25,75,850,600);  //用來畫出填滿顏色的長方形
        //畫貪吃蛇頭部
        if(direction=="R"){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(direction=="L"){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if(direction=="U"){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(direction=="D"){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        //畫身體
        for (int i = 1; i < length ; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //畫食物
        Data.food.paintIcon(this,g,foodX,foodY);
        //繪製積分欄
        g.setColor(Color.BLACK);
        g.setFont(new Font("微軟正黑體",Font.HANGING_BASELINE,20));
        g.drawString("長度："+length,730,30);
        g.drawString("得分："+score,730,60);
        //遊戲開始提醒
        if(isStart==false){
            g.setColor(Color.orange);
            g.setFont(new Font("微軟正黑體",Font.BOLD,40));
            g.drawString("按 Enter 開始遊戲囉!",260,400);
        }
        //失敗判斷
        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微軟正黑體",Font.BOLD,40));
            g.drawString("遊戲失敗，按Enter重新開始!",190,400);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//獲取按下的按鍵
        //判斷空格
        if(keyCode==KeyEvent.VK_ENTER){
            if(isFail){
                isFail = false;
                init();
            }
            else{
                isStart = !isStart;
            }
            repaint();
        }
        //判斷方向
        if(keyCode==KeyEvent.VK_LEFT){direction = "L";}
        else if(keyCode==KeyEvent.VK_RIGHT){direction = "R";}
        else if(keyCode==KeyEvent.VK_UP){direction = "U";}
        else if(keyCode==KeyEvent.VK_DOWN){direction = "D";}
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void actionPerformed(ActionEvent e) { //Timer与 ActionListener 组合使用才能生效
        //判斷遊戲狀態
        if(isStart&&!isFail){
            //移動身體
            for (int i = length-1; i > 0 ; i--) {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            //移動頭部
            if(direction=="R"){
                snakeX[0] += 25;
            }
            else  if(direction=="L"){
                snakeX[0] -= 25;
            }
            else  if(direction=="U"){
                snakeY[0] -= 25;
            }
            else  if(direction=="D"){
                snakeY[0] += 25;
            }
            //吃食物
            if(snakeX[0]==foodX&&snakeY[0]==foodY){
                length++;
                score += 10;
                eat(foodX,foodY);
            }
            //死亡判定
            for (int i = 1; i < length; i++) {
                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                    isFail=true;
                }
            if(snakeX[0]>=875||snakeX[0]<=0  //邊界+-5 g.fillRect(25,75,850,600)
            		||snakeY[0]>=675||snakeY[0]<=50){
            	isFail=true;
            	
            }

            }
            repaint();
        }
        timer.start();
    }
 }
