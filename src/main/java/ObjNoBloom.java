import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjNoBloom extends SuperObject{
  public ObjNoBloom(){
    name = "Poppy";
    try{
      image = ImageIO.read(getClass().getResourceAsStream("src/main/java/objects/no_bloom_flowers.png"));
    }
    catch(IOException e){
      e.printStackTrace(); 
    }
    collision = false;
  }
}