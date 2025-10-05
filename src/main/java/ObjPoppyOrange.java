import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjPoppyOrange extends SuperObject{
  public ObjPoppyOrange(){
    name = "Poppy Orange";
    try{
      image = ImageIO.read(getClass().getResourceAsStream("src/main/java/objects/poppy_orange.png"));
    }
    catch(IOException e){
      e.printStackTrace(); 
    }
    collision = true;
  }
}