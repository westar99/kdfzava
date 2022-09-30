package entity;

//import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp,KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		solidArea = new Rectangle(0,0,48,48);
		
		setDefaultValues();
		getPlayerImage();//함수를 정의해놓고 호출을 안하다니 ...ㅠ.ㅠ.
	}
	public void setDefaultValues() {
		
		x= 100;
		y= 100;
		speed =4;
		direction ="down";//어느방향이든 상관없지만서도...
		
	}
	public void getPlayerImage() {
		System.out.println("getPlayerImage함수 호출됨");
		try {
			
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true|| 
				keyH.leftPressed == true||keyH.rightPressed == true) {
			if(keyH.upPressed == true) {//키핸들러 x0 y0는 상단왼쪽)
				direction = "up";
				y -= speed;
			}
			else if(keyH.downPressed == true) {
				direction = "down"; 
				y += speed;
			}
			else if(keyH.leftPressed == true) {
				direction = "left"; 
				x -= speed;
			}
			else if(keyH.rightPressed == true) {
				direction = "right"; 
				x += speed;
			}
			
			spriteCounter++;
			if(spriteCounter>10) {//10프레임마다 바꾸라
				if(spriteNum==1) {
					spriteNum=2;				
				}
				else if(spriteNum==2) {
					spriteNum=1;				
				}
				spriteCounter =0;
			}
		}
		
		
	}
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);//하얀 박스
//		g2.fillRect(x,y,gp.tileSize,gp.tileSize);//플레이어의 위치
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum ==1) {
				image = up1;
			}
			if(spriteNum ==2) {
				image = up2;
			}	
			break;
		case "down":
			if(spriteNum ==1) {
				image = down1;
			}
			if(spriteNum ==2) {
				image = down2;
			}	
			break;
		case "left":
			if(spriteNum ==1) {
				image = left1;
			}
			if(spriteNum ==2) {
				image = left2;
			}	
			break;	
		case "right":
			if(spriteNum ==1) {
				image = right1;
			}
			if(spriteNum ==2) {
				image = right2;
			}	
			break;	
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
		
	}
}
