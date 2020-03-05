//package com.paula.joc;

import javafx.application.Application;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameMenu extends JPanel {
    JFrame fereastra=new JFrame();
    public GameMenu(){

        fereastra.add(this);
        fereastra.setSize(1024,500);
        fereastra.setLocation(50,50);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fereastra.setVisible(true);

        try{
            File sound=new File("sounds//music.wav");
            //if(sound.exists()) {
            AudioInputStream str = AudioSystem.getAudioInputStream(sound);
            Clip c = AudioSystem.getClip();
            c.open(str);

            c.start();
           // while ((sound.exists())) {
            //c.loop(Clip.LOOP_CONTINUOUSLY);
            //long clipTime = c.getMicrosecondPosition();
            //OptionPane.showMessageDialog(null, "Sound off");

            //c.stop();
            //JOptionPane.showMessageDialog(null, "Sound on");
            //c.setMicrosecondPosition(clipTime);
            //c.start();
            //Thread.sleep(100);

            //}

            try{
                Thread.sleep(1800);
                fereastra.dispose();
                Meniu m=new Meniu();
            }catch(Exception e) {System.out.println(e);};


        }catch(Exception e){System.out.println("eroare:" +e);};



    }

    public void paint(Graphics g)
    {
        ImageIcon background=new ImageIcon("photos//menu.jpg");
        g.drawImage(background.getImage(),0,0, null);

    }

}
