用JAVA撰寫的小遊戲，貪吃蛇~

程式設計構思 :
1. 建立遊戲視窗，在視窗中新增一個遊戲面板。
   使用JFrame類建立遊戲視窗，利用add()方法新增一個GamePanel類範例化物件。   
2. 實現遊戲的動態頁面。
   （1）init()方法：初始化小蛇位置。
   （2）eat()方法：用隨機種子隨機食物的位置，並進行判定，食物位置不能和小蛇位置重合。
   （3）paintComponent(Graphics g)方法 : 繼承JPanel，繪製標題列、小蛇的位置（根據direction小蛇頭部方向變數繪製小蛇頭部）、小蛇身體、積分欄、遊戲提醒與失敗判斷
   （4）keyPressed(KeyEvent e)方法 : 實現KeyListener 介面獲取鍵盤輸入，根據鍵盤輸入對遊戲狀態或者小蛇頭部方向direction變數進行方向更改
   （5）actionPerformed(ActionEvent e)方法 : 實現ActionListener介面根據遊戲狀態和direction變數進行小蛇移動操作，進行吃食物判定和死亡判定。使用Timer計時器讓遊戲動態變化，用repaint()方法實時更新介面。   
3. 實現遊戲開啟時加載背景音樂。
   使用javax.sound.sampled包中的AudioSystem + Clip，利用getAudioInputStream方法加載和播放音樂文件。   
4. 連線statics資料夾，將靜態資源包中的圖片轉化為圖示，方便在面板上繪製。
   使用class.getResource( )方法。


專案架構圖 : 
![image](https://github.com/blue601083/Java-Program/assets/136430809/3e9f87b5-e191-4d3c-881a-6b5800a21c77)

遊戲展示圖 :
![image](https://github.com/blue601083/Java-Program/assets/136430809/12260d2c-5ae3-4de0-85f5-e5cb765f3a45)
