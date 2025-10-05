import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class TileManager{
    GamePanel gp;
    public Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("src/main/java/map data/world.txt");
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("src/main/java/tiles/grass.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("src/main/java/tiles/water.png"));
            tile[1].collision = true;
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String fileName){
        try{
            InputStream is = getClass().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int c = 0;
            int r = 0;

            while(c < gp.maxWorldCol && r < gp.maxWorldRow){
                String line = br.readLine();

                while(c < gp.maxWorldCol){
                    String numbers[] = line.split(" "); //splits the string at a space (basically, once it reads a space, it will put that number from the world txt file into the array)

                    //making this into an int
                    int num = Integer.parseInt(numbers[c]);

                    mapTileNum[c][r] = num;
                    c++;
                }
                if(c == gp.maxWorldCol){
                    c = 0;
                    r++;
                }
            }
            br.close();
        }
        catch(Exception e){
            
        }
    }

    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
            
        }
        
    }
}
