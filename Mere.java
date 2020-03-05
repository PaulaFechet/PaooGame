

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;

public class Mere extends Thread {

    Gloante glont;
    NivelI n;
    NivelIII  nivel;

    Candy[][] bomboane;
    public static int scor;

    Mere(Gloante glont, NivelI n, Candy[][] bomboane){
        this.glont=glont;
        this.n=n;
        this.bomboane=bomboane;
    }


    public void run()
    {
        while(glont.getY()>-100)
        {
            tinta();
            glont.setY(glont.getY()-20);

            try {
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            n.repaint();

        }
    }

    public void tinta(){
        Rectangle gloante=new Rectangle(glont.getX(), glont.getY(), 19, 40);
        for(int i=0;i<bomboane.length;i++)
        {
            for(int j=0;j<bomboane[i].length;j++)
            {
                Rectangle bomboanele=new Rectangle(bomboane[i][j].getX(), bomboane[i][j].getY(), 25, 25);
                if(bomboanele.intersects(gloante))
                {
                    scor++;
                    bomboane[i][j].setX(10000);
                    glont.setX(-50000);


                    try{
                        File sound=new File("sounds//hit.wav");
                        //if(sound.exists()) {
                        AudioInputStream str = AudioSystem.getAudioInputStream(sound);
                        Clip c = AudioSystem.getClip();
                        c.open(str);

                        c.start();

                    }catch (Exception e)
                    {System.out.println(e);
                    }
                }

            }
        }
    }




}