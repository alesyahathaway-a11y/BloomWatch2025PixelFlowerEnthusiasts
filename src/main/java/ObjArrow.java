import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjArrow extends SuperObject{
  public ObjArrow(){
    name = "Arrow";
    try{
      image = ImageIO.read(getClass().getResourceAsStream("src/main/java/objects/arrow.png"));
    }
    catch(IOException e){
      e.printStackTrace(); 
    }
    collision = false;
  }
}