import java.util.Random;

public class AssetSetter{
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        Random random = new Random();
        
        //superbloom quadrant #1: top right, draw 30*12 flowers
        //draw 5 arrows
        for(int i = 0; i < 7; i++){
            gp.obj[i] = new ObjArrow();
            gp.obj[i].worldX = (10 + 2*i) * gp.tileSize;
            gp.obj[i].worldY = 6 * gp.tileSize;
        }

        //draw poppies
        int index = 7;
        for(int i = 0; i < 25; i++){
            for(int j = 0; j < 13; j++){
                int randomNumber = (int) random.nextInt(2);
                if(randomNumber == 0){
                    gp.obj[index] = new ObjPoppy();
                    gp.obj[index].worldX = (25 + i) * gp.tileSize;
                    gp.obj[index].worldY = j * gp.tileSize;
                }
                else{
                    gp.obj[index] = new ObjPoppyOrange();
                    gp.obj[index].worldX = (25 + i) * gp.tileSize;
                    gp.obj[index].worldY = j * gp.tileSize;
                }
                index++;
            }
        }
        
        //no bloom quadrant #2: bottom right
        //draw arrows
        for(int i = 0; i < 8; i++){
            gp.obj[index] = new ObjArrowDown();
            gp.obj[index].worldX = 38 * gp.tileSize;
            gp.obj[index].worldY = (14 + 2*i) * gp.tileSize;
            index++;
        }

        //draw the no bloom state
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 13; j++){
                gp.obj[index] = new ObjNoBloom();
                gp.obj[index].worldX = (25 + i) * gp.tileSize;
                gp.obj[index].worldY = (14 + 16 + j) * gp.tileSize;
                index++;
            }
        }
        
        //superbloom quadrant #3: bottom left
        //draw arrows
        for(int i = 0; i < 5; i++){
            gp.obj[index] = new ObjArrowLeft();
            gp.obj[index].worldX = (15 + 2*i) * gp.tileSize;
            gp.obj[index].worldY = 30 * gp.tileSize;
            index++;
        }

        //draw poppies
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 13; j++){
                int randomNumber = (int) random.nextInt(2);
                if(randomNumber == 0){
                    gp.obj[index] = new ObjPoppy();
                    gp.obj[index].worldX = i * gp.tileSize;
                    gp.obj[index].worldY = (30 + j) * gp.tileSize;
                }
                else{
                    gp.obj[index] = new ObjPoppyOrange();
                    gp.obj[index].worldX = i * gp.tileSize;
                    gp.obj[index].worldY = (30 + j) * gp.tileSize;
                }
                index++;
            }
        }


        
        /*gp.obj[0] = new ObjPoppy();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 21 * gp.tileSize;

        gp.obj[1] = new ObjPoppyOrange();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 22 * gp.tileSize;*/
        
    }
}
