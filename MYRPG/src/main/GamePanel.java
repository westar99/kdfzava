package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {// extends 존재를 가져옴:추상클래스 중복코드 줄임

	// 스크린을 세팅
	final int origianlTileSize = 16;
	final int scale = 3;

	public final int tileSize = origianlTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;// 768픽셀
	final int screenHeight = tileSize * maxScreenRow;// 576픽셀

	// FPS(초당프레임)
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this, keyH);
	// 플레이어 기본 위치

	public GamePanel() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));// JPanel로 이클래스 사이즈로 바꿈
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);

	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override // 게임이 실시간으로 움직이도록해야 됨.Japanel의 run을 재정의 하자.

	public void run() {

		double drawInterval = 1000000000 / FPS;// 0.016초
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			} 
			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}

	}

	public void update() {

		player.update();

	}

	public void paintComponent(Graphics g) {// 플레이어의 위치결정

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		tileM.draw(g2);// 타일을 그리는 레이어

		player.draw(g2);// 플레이어 그리는 레이어

		g2.dispose();
	}

}

//public void run() { //런을 델타로 안하면
//
//
//double nextDrawTime = System.nanoTime()+drawInterval;
//
//while(gameThread != null) {
//	
//	//System.out.println("이 게임루프는 실행중입니다.");//움직임 확인
//	long currentTime = System.nanoTime();//나노타임으로 끊임없게함
//	System.out.println("지금시간"+currentTime);//2화20:17
//	
//	
//	update();
//	
//	repaint();
//	
//	
//	
//	try {
//		double remainingTime = nextDrawTime - System.nanoTime();
//		remainingTime = remainingTime/1000000;
//		
//		if(remainingTime<0) {
//			remainingTime=0;
//		}
//		Thread.sleep((long)remainingTime);
//		
//		nextDrawTime += drawInterval;
//		
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
//}
//}
