import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjPoppy extends SuperObject{
  public ObjPoppy(){
    name = "Poppy";
    try{
      image = ImageIO.read(getClass().getResourceAsStream("src/main/java/objects/poppy.png"));
    }
    catch(IOException e){
      e.printStackTrace(); 
    }
    collision = true;
  }
}