import javax.swing.*;
import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GameOver extends JPanel {
    JFrame fereastra = new JFrame();

    public GameOver() {

        fereastra.add(this);
        fereastra.setSize(852, 480);
        fereastra.setLocation(50, 50);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setResizable(true);

        fereastra.setVisible(true);



    }

    public void paint(Graphics g) {
        ImageIcon background = new ImageIcon("photos//won.jpg");
        ImageIcon a = new ImageIcon("photos//10.jpg");

        g.setColor(Color.WHITE);
        g.setFont(new Font("", Font.BOLD, 70));


        if ((Mere.scor + Banane.scor+Capsuni.scor) >= 40) {
            g.drawImage(background.getImage(), 0, 0, null);

            try {
                File sound = new File("sounds//aplauze.wav");
                //if(sound.exists()) {
                AudioInputStream str = AudioSystem.getAudioInputStream(sound);
                Clip c = AudioSystem.getClip();
                c.open(str);

                c.start();

            } catch (Exception e) {
                System.out.println(e);
            }

            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:scorul.db");
                stmt = c.createStatement();
                String sql = "CREATE TABLE Score " +
                        "(SCOR1 INT NOT NULL, " +
                        "SCOR2 INT NOT NULL, " +
                        "SCOR3 INT NOT NULL)";
                stmt.executeUpdate(sql);
                String sq = "INSERT INTO Score (SCOR1, SCOR2, SCOR3) " +
                        "VALUES (" + Mere.scor + ", " + Banane.scor + ","+Capsuni.scor+");";
                stmt.executeUpdate(sq);

                String s = "UPDATE Score set SCOR1 = " + Mere.scor + ";";

                stmt.executeUpdate(s);

                ResultSet rs = stmt.executeQuery("SELECT * FROM Score;");
                while (rs.next()) {
                    // int scor1 = rs.getInt("id");
                    //String name = rs.getString("name");
                    //int age = rs.getInt("age");
                    // String address = rs.getString("address");
                    // float salary = rs.getFloat("salary");
                    System.out.println("SCOR1 " + Mere.scor);
                    System.out.println("SCOR2 = " + Banane.scor);
                    System.out.println("SCOR3 = " + Capsuni.scor);
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Operation done successfully");

        } else {

            g.drawImage(a.getImage(), 0, 0, null);
            g.drawString("YOU LOST", 300, 300);

            try {
                File sound = new File("sounds//over1.wav");
                //if(sound.exists()) {
                AudioInputStream str = AudioSystem.getAudioInputStream(sound);
                Clip c = AudioSystem.getClip();
                c.open(str);

                c.start();

            } catch (Exception e) {
                System.out.println(e);
            }

            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:scorul.db");
                stmt = c.createStatement();
                String sql = "CREATE TABLE Score " +
                        "(SCOR1 INT NOT NULL, " +
                        "SCOR2 INT NOT NULL, " +
                        "SCOR3 INT NOT NULL)";
                stmt.executeUpdate(sql);
                String sq = "INSERT INTO Score (SCOR1, SCOR2, SCOR3) " +
                        "VALUES (" + Mere.scor + ", " + Banane.scor + ","+Capsuni.scor+");";
                stmt.executeUpdate(sq);

                String s = "UPDATE Score set SCOR1 = " + Mere.scor + ";";

                stmt.executeUpdate(s);


                ResultSet rs = stmt.executeQuery("SELECT * FROM Score;");
                while (rs.next()) {

                    System.out.println("SCOR1 " + Mere.scor);
                    System.out.println("SCOR2 = " + Banane.scor);
                    System.out.println("SCOR3 = " + Capsuni.scor);
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Operation done successfully");
        }

    }
}
