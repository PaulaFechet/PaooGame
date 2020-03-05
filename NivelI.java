

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class NivelI extends JPanel implements KeyListener {
    JFrame fereastra=new JFrame("Primul nivel");
    Shooter shoot=new Shooter(400,455, "photos/apple.png");
    Candy[][] candy =new Candy[2][11];
    Gloante[] glont=new Gloante[10000];
    int counter=0;
    private boolean esuat=false;

    //o sa le manipulez
    int x=0;
    int y=0;
   // public static int scor=0;
   // Dropper dropper=new Dropper(this, candy);

    NivelI(){
        this.setFocusable(true);
        this.addKeyListener(this);


        fereastra.add(this);

        for(int i=0;i<candy.length;i++)
        {
            for(int j=0;j<candy[i].length;j++)
            {
                if(j%2==0) {
                    candy[i][j] = new Candy(x, y, "photos/bomboana3.png");
                    x += 90;
                }else if(j%3==0)
                {
                    candy[i][j] = new Candy(x, y, "photos/bomboana1.png");
                    x += 90;

                }else
                {
                    candy[i][j] = new Candy(x, y, "photos/bomboana.png");
                    x += 90;
                }


            }

            y+=100;
            x=0;
        }

       // dropper.start();



        for(int i=0;i<glont.length;i++){
            glont[i]=new Gloante(380,450,"photos/mar.png");
        }

        fereastra.setSize(1000, 600);
        fereastra.setLocation(50,50);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setVisible(true);
    }
    public void paint(Graphics g){
        ImageIcon fundal=new ImageIcon("photos/fundal1.jpg");

        g.drawImage(fundal.getImage(),0,0, null);

        shoot.paintShoo(g);

        for(int i=0;i<candy.length;i++){
            for(int j=0;j<candy[i].length;j++){
                candy[i][j].paintCandy(g);

            }
        }

        for(int i=0;i<glont.length;i++){
            glont[i].paintGlont(g);
        }


        g.setColor(Color.BLACK);
        g.setFont(new Font("", Font.BOLD, 30));
        g.drawString("Scor: "+Mere.scor , 700, 30);
        esuare() ;
        try {
            NivelComplet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void NivelComplet() throws InterruptedException {
        if(Mere.scor >=15)
        {
            fereastra.dispose();
            //dropper.stop();
            JOptionPane.showMessageDialog(null, "Level completed");
            NivelII incep=new NivelII();
        }
    }
    public void esuare()
    {
        for(int i=0;i<candy.length;i++)
        {
            for(int j=0;j<candy[i].length;j++)
            {
                if(candy[i][j].getY()>450)
                {

                    esuat=true;

                    break;

                }
            }
        }
        if(esuat ==true)
        {
            fereastra.dispose();
            JOptionPane.showMessageDialog(null, "You lost");
            // dropper.stop();



        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent kp) {

        if(kp.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if (shoot.getX() < 980)
            {
                shoot.setX(shoot.getX() + 20);
            }
            this.repaint();
        }

        else if(kp.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if (shoot.getX() > -2)
            {
                shoot.setX(shoot.getX() - 20);

            }
            this.repaint();

        }
        else if(kp.getKeyCode()==KeyEvent.VK_SPACE){
            try{
                File sound=new File("sounds//lovit.wav");
                //if(sound.exists()) {
                AudioInputStream str = AudioSystem.getAudioInputStream(sound);
                Clip c = AudioSystem.getClip();
                c.open(str);

                c.start();

            }catch (Exception e)
            {System.out.println(e);
            }
            Mere f=new Mere(glont[counter], this, candy);
            glont[counter].setX(shoot.getX());
            f.start();
            counter++;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}