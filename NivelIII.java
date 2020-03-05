import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class NivelIII extends JPanel implements KeyListener {
    JFrame f=new JFrame("Al treilea nivel");
    Shooter loveste=new Shooter(400,455, "photos/capsuna11.png");
    Candy[][] candy =new Candy[2][11];
    Gloante[] glont=new Gloante[10000];
    int counter=0;
    private boolean esuat=false;

    //o sa le manipulez
    int x=0;
    int y=0;
    // public static int scor=0;
    Dropper2 dropper=new Dropper2(this, candy);

    NivelIII(){
        this.setFocusable(true);
        this.addKeyListener(this);


        f.add(this);

        for(int i=0;i<candy.length;i++) {
            for (int j = 0; j < candy[i].length; j++) {
                if (j % 2 == 0) {
                    candy[i][j] = new Candy(x, y, "photos/apple.png");
                    x += 90;
                }
                else if (j % 3 == 0) {
                    candy[i][j] = new Candy(x, y, "photos/bomboana3.png");
                    x += 90;
                }

            else
            {
                candy[i][j] = new Candy(x, y, "photos/bomboana.png");
                x += 90;
            }



            }

            y+=100;
            x=0;
        }

         dropper.start();



        for(int i=0;i<glont.length;i++){
            glont[i]=new Gloante(380,450,"photos/capsuna2.png");
        }

        f.setSize(1000, 600);
        f.setLocation(50,50);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void paint(Graphics g){
        ImageIcon fundal=new ImageIcon("photos/backg.jpg");

        g.drawImage(fundal.getImage(),0,0, null);

        loveste.paintShoo(g);

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
        g.drawString("Scor: "+(Mere.scor+Banane.scor+Capsuni.scor), 700, 30);
        esuare() ;

        NivelComplet3();



    }


    public void NivelComplet3()   {
        if((Mere.scor +Banane.scor+Capsuni.scor)>=40)
        {
            f.dispose();
            dropper.stop();
            JOptionPane.showMessageDialog(null, "Level completed");

            GameOver oveer=new GameOver();
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
            f.dispose();
            dropper.stop();
            JOptionPane.showMessageDialog(null, "You lost");
           GameOver ovver=new GameOver();




        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent kp) {

        if(kp.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if (loveste.getX() < 980)
            {
                loveste.setX(loveste.getX() + 20);
            }
            this.repaint();
        }

        else if(kp.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if (loveste.getX() > -2)
            {
                loveste.setX(loveste.getX() - 20);

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
            Capsuni f=new Capsuni(glont[counter], this, candy);
            glont[counter].setX(loveste.getX());
            f.start();
            counter++;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}