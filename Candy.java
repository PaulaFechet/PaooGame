
import javax.swing.*;
import java.awt.*;

public class Candy {
    private int x;
    private int y;
    private String imagePath;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }



    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



    public Candy(int x, int y, String imag)
    {
        super();
        this.x=x;
        this.y=y;
        this.imagePath=imag;
    }

    public void paintCandy(Graphics g){
        ImageIcon candy=new ImageIcon(imagePath);
        g.drawImage(candy.getImage(),x,y, null);

    }


}