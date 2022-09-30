package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;


public class TileManager {

	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp=gp;
		tile=new Tile[10];
		mapTileNum = new int [gp.maxScreenCol][gp.maxScreenRow];
		//게임판넬의 maxScreenCol을 못가져 온다.다른 팩키지니까 급한대로 public으로 바꿔주자.
		getTileImage();
		loadMap();//맵을 불러오자
		
	}
	public void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass00.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water00.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[3].collision = true;
					
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pk_i.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pk_pa.png"));
			tile[5].collision = true;
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pk_pi.png"));
			tile[6].collision = true;
			
			System.out.println("타일이미지들을 자바타일배열에 불러오기 완료");
			for(Tile ele : tile) {
				System.out.println(ele);
			}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void loadMap() {
		
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0 ;
			int row = 0 ;
			
			while(col<gp.maxScreenCol && row<gp.maxScreenRow) {
				String line = br.readLine();
				
				while(col<gp.maxScreenCol) {
				String numbers[] = line.split(" ");//line을 읽어서 공백한칸을 기준으로 배열에넣는다
				// 맵 띄어쓰기 똑바로 해라!
				int num = Integer.parseInt(numbers[col]);
				mapTileNum[col][row] = num;
				col++;
				}

				
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e) {
		}
		
	}
	
	
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col<gp.maxScreenCol && row<gp.maxScreenRow) {

			int tileNum = mapTileNum[col][row];	//tileNum이 계속 0인 문제
			
			g2.drawImage(tile[tileNum].image,x,y,gp.tileSize,gp.tileSize,null);
			col++;
			x += gp.tileSize;

			if(col == gp.maxScreenCol) {
				col =0;
				x=0;
				row++;
				y+= gp.tileSize;
			}
			
			
		}

	}


}


