

import java.sql.*;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.xml.soap.Text;
//import javax.xml.soap.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class  Meniu extends JPanel implements ActionListener, KeyListener {


    JFrame fereastra=new JFrame();
    JButton play=new JButton();
    JButton exit=new JButton();
    Font custom=new Font("Italic", Font.ITALIC,13);

    JLabel imagine=new JLabel();
    JButton informatii=new JButton();
    JButton buton=new JButton("SPACE- SHOOT \n");
    JButton but=new JButton("OPTIUNI");

    Meniu(){



        // fereastra.add(this);
        // fereastra.add(info);
        fereastra.setSize(1024, 500);

        this.setBackground(Color.RED);
        this.setForeground(Color.RED);
        fereastra.add(this);


        play.setIcon(new ImageIcon("photos//icon_play.png"));
        play.setBackground(Color.RED);
        play.setSize(20, 20);
        play.addActionListener(this);
        play.addKeyListener(this);

        fereastra.add(play, BorderLayout.NORTH);

        buton.setBackground(Color.RED);
        //buton.setIcon(new ImageIcon(""));

        but.setBackground(Color.RED);
        but.setFont(custom);
        but.addActionListener(this);
        but.addKeyListener(this);
        but.setPreferredSize(new Dimension(200,100));
        fereastra.add(but, BorderLayout.WEST);

        exit.setIcon(new ImageIcon("photos//exit.png"));
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        exit.addKeyListener(this);

        fereastra.add(exit, BorderLayout.SOUTH);

        imagine.setBackground(Color.RED);
        imagine.setIcon(new ImageIcon("photos/sweet.jpg"));


        fereastra.add(imagine, BorderLayout.CENTER);

        informatii.setText("SPACE- shoot\n ROWS-move ");

        informatii.setFont(custom);

        informatii.setBackground(Color.RED);
        informatii.setForeground(Color.BLACK);
        fereastra.add(informatii, BorderLayout.EAST);

        fereastra.setUndecorated(true);

        fereastra.setBackground(Color.RED);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fereastra.setLocation(50,50);
        fereastra.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {
            fereastra.dispose();
        }
        if(e.getSource()==play){
            fereastra.dispose();
            Nivele n=new Nivele();

            // GameMenu a=new GameMenu();

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {
            fereastra.dispose();
        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER){
            fereastra.dispose();
            Nivele s=new Nivele();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public static void main(String[]args)
    {
        GameMenu a=new GameMenu();


    }

}
