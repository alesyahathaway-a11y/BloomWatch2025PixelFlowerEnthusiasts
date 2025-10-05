import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Rectangle; 

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    /*int numPoppy = 0;
    int numPoppyOrange = 0;*/

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        //returns the center of the screen
        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 8;
        worldY = gp.tileSize * 6;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/front_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/front_2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/back_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("src/main/java/player/left_2.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction = "up";
            }
            if(keyH.downPressed == true){
                direction = "down";
            }
            if(keyH.leftPressed == true){
                direction = "left";
            }
            if(keyH.rightPressed == true){
                direction = "right";
            }

            //check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);

            //check object collision
            int objectIndex = gp.collisionChecker.checkObject(this, true);
            //pickUpObject(objectIndex);

            //if collision is false, player can move
            if(collisionOn == false){
                //if the player is not at the edge of the world, they can move
                if(direction == "up" && worldY > gp.maxScreenRow * gp.tileSize/2)
                    worldY -= speed;
                if(direction == "down" && worldY < gp.worldHeight - gp.tileSize)
                    worldY += speed;
                if(direction == "left" && worldX > gp.maxScreenCol * gp.tileSize/2)
                    worldX -= speed;
                if(direction == "right" && worldX < gp.worldWidth - gp.tileSize)
                    worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1)
                    spriteNum = 2;
                else if(spriteNum == 2)
                    spriteNum = 1;
                spriteCounter = 0;
            }
        }
        
    }

    /*public void pickUpObject(int i){
        if(i != 999){
            String objectName = gp.obj[i].name;
            switch(objectName){
                case "Poppy":
                    numPoppy++;
                    gp.obj[i] = null;
                    break;
                case "Poppy Orange":
                    numPoppyOrange++;
                    gp.obj[i] = null;
                    break;
            }
        }
    }*/

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        if(direction.equals("up")){
            if(spriteNum == 1)
                image = up1;
            if(spriteNum == 2)
                image = up2;
        } 
        
        else if(direction.equals("down")){
            if(spriteNum == 1)
                image = down1;
            if(spriteNum == 2)
                image = down2;
        } 
        
        else if(direction.equals("left")){
            if(spriteNum == 1)
                image = left1;
            if(spriteNum == 2)
                image = left2;
        } 
        
        else if(direction.equals("right")){
            if(spriteNum == 1)
                image = right1;
            if(spriteNum == 2)
                image = right2;
        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}