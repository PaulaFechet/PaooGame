import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Nivele extends JPanel implements ActionListener, KeyListener {

    //jcombox ia ca parametru un aray de stringuri

    String[] branches = {"NIVELUL I", "NIVELUL II", "NIVELUL III"};
    JComboBox jc= new JComboBox(branches);
    JFrame fereastra= new JFrame();
    JLabel imagine=new JLabel();

    JButton enterB=new JButton();
    JButton backB=new JButton();

    Font custom=new Font("Bold", Font.BOLD, 20);
    Nivele(){

        this.setBackground(Color.black);
        fereastra.add(this);
        fereastra.setSize(750, 550);


        jc.setFont(custom);
        jc.setForeground(Color.BLACK);
        jc.setBackground(Color.WHITE);
        fereastra.add(jc, BorderLayout.PAGE_START);


        //fereastra.add(this);




        backB.setForeground(Color.WHITE);
        backB.setBackground(Color.WHITE);
        backB.setIcon(new ImageIcon("photos/back.png"));
        backB.addKeyListener(this);
        backB.addActionListener(this);

        fereastra.add(backB, BorderLayout.PAGE_END);


        ImageIcon a=new ImageIcon("photos/inline.jpg");

        enterB.setIcon(a);
        enterB.setPreferredSize(new Dimension(738, 280));
        enterB.addKeyListener(this);
        enterB.addActionListener(this);
        fereastra.add(enterB, BorderLayout.CENTER);

        fereastra.setUndecorated(true);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setLocation(50,50);
        fereastra.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backB)
        {
            fereastra.dispose();
            Meniu m=new Meniu();
        }
        else if(e.getSource()==enterB && jc.getSelectedIndex()==0)
        {
            fereastra.dispose();
            NivelI a=new NivelI();
            //JOptionPane.showMessageDialog(null, "Nivelul I indisponibil");
        }
        else if(e.getSource()==enterB && jc.getSelectedIndex()==1)
        {
            NivelII nou=new NivelII();
            //JOptionPane.showMessageDialog(null, "Nivelul II indisponibil");
        }
        else if(e.getSource()==enterB && jc.getSelectedIndex()==2)
        {
            NivelIII ni=new NivelIII();
            //JOptionPane.showMessageDialog(null, "Nivelul III indisponibil");
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
            Meniu m=new Meniu();
        }


        else if(e.getSource()==enterB && jc.getSelectedIndex()==0)
        {
            //JOptionPane.showMessageDialog(null, "Nivel I deja selectat");
            NivelI a=new NivelI();
        }
        else if(e.getSource()==enterB && jc.getSelectedIndex()==1)
        {
            JOptionPane.showMessageDialog(null, "Nivel II deja selectat");
        }
        else if(e.getSource()==enterB && jc.getSelectedIndex()==2)
        {
            JOptionPane.showMessageDialog(null, "Nivel III deja selectat");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}