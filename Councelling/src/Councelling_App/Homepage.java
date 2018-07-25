
/**
 *
 * @author robin
 */

package Councelling_App;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Homepage extends JFrame implements ActionListener 
{
    //---- BEGINNING OF GUI------//
    
    JLabel l1,l2,l3,l4;
    JButton btn1,btn2,btn3,btn4;
    
    Homepage() throws IOException
    {
        setSize(850,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("                                                                             HOMEPAGE");
       // setContentPane(new JLabel(new ImageIcon("E:\\projects\\Councelling\\resources\\images\\intro.jpg")));
        setContentPane(new JLabel(new ImageIcon("resources\\images\\intro.jpg")));
        setResizable(false);
        
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                int a=JOptionPane.showConfirmDialog(null,"Do You Really Want To Exit?");
                if(a==JOptionPane.YES_OPTION)
                {
                    e.getWindow().dispose();
                }
                else {
                    System.out.println("Still Working!");
                }
            }
              });
        
        //Color c=new Color(50,238,243);
        l4=new JLabel("C-DAC MOHALI");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Comic Sans MS",Font.BOLD,60));
        l4.setBounds(170,30,800,60);
        
        l1=new JLabel("Welcome To Online Portal For Counselling:--");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif",Font.BOLD,40));
        l1.setBounds(30,120,800,50);
        
        l2=new JLabel("New Student Register Here:--");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Serif",Font.BOLD,30));
        l2.setBounds(20,180,400,50);
        
        l3=new JLabel("Already Registered Login Here:--");
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Serif",Font.BOLD,30));
        l3.setBounds(415,180,500,50);
        
        btn1=new JButton("REGISTER");
        btn2=new JButton("LOGIN");
        btn3=new JButton("ADMIN LOGIN");
        btn4=new JButton("RESULTS");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        
        btn1.setFont(new Font("Serif",Font.BOLD,30));
        btn1.setBackground(Color.green);
        btn2.setFont(new Font("Serif",Font.BOLD,30));
        btn2.setBackground(Color.green);
        btn3.setFont(new Font("Serif",Font.BOLD,24));
        btn3.setBackground(Color.green);
        btn4.setFont(new Font("Serif",Font.BOLD,30));
        btn4.setBackground(Color.green);
        btn1.setBounds(100,250,210,50);
        btn2.setBounds(500,250,200,50);
        btn3.setBounds(100,320,210,50);
        btn4.setBounds(500,320,200,50);
        
        add(l4);
        add(l1);
        add(l2);
        add(l3);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        
        setVisible(true);
    }
    
    //---- ENDING OF GUI-------//
    
    
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn1)
        {
            try {
                Registration reg=new Registration();
                reg.setVisible(true);
                dispose();
            }
            catch (IOException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==btn2)
        {
            try {
                Login lg = new Login();
                lg.setVisible(true);
                dispose();
            }
            catch (IOException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==btn3)
        {
            try{
                new Admin().setVisible(true);
                dispose();
            }catch(IOException ex)
            {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
        else if(e.getSource()==btn4)
        {
            try {
                new Result().setVisible(true);
                dispose();
            } catch (IOException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
        Homepage hp=new Homepage();
    }
    
}
