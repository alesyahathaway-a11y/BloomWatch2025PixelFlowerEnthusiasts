import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjArrowDown extends SuperObject{
  public ObjArrowDown(){
    name = "Arrow";
    try{
      image = ImageIO.read(getClass().getResourceAsStream("src/main/java/objects/arrow_down.png"));
    }
    catch(IOException e){
      e.printStackTrace(); 
    }
    collision = false;
  }
}