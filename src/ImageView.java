import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageView extends Component {
    private Image image;

    public ImageView(String filename) {
        try(FileInputStream fileInputStream=new FileInputStream(filename)) {
            image= ImageIO.read(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);
    }

}