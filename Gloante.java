

import javax.swing.*;
import java.awt.*;

public class Gloante {
    private int x;
    private int y;

    public Gloante(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.imagePath = imagePath;
    }

    private String imagePath;



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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void paintGlont(Graphics g)
    {
        ImageIcon glont=new ImageIcon(imagePath);
        g.drawImage(glont.getImage(),x,y, null);

    }
}
