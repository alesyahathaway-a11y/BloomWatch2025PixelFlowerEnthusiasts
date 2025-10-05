import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjArrowLeft extends SuperObject{
  public ObjArrowLeft(){
    name = "Arrow";
    try{
      image = ImageIO.read(getClass().getResourceAsStream("src/main/java/objects/arrow_left.png"));
    }
    catch(IOException e){
      e.printStackTrace(); 
    }
    collision = false;
  }
}