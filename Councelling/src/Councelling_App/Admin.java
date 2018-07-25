
/**
 *
 * @author robin
 */

package Councelling_App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends JFrame implements ActionListener
{
    // --------- BEGINNING OF GUI -----------//
    
    JLabel l,l1,l2;
    JTextField tf1;
    JPasswordField p2;
    JButton btn;
    private String Adminname="ROBIN";
    private String Adminpassword="ROBIN#ROOT";

    public Admin() throws IOException
    {   
        setSize(850,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("                                                                   ADMIN SECTION");
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon("resources\\images\\admin.jpg")));
        setResizable(false);
        this.addWindowListener(new WindowAdapter() {
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
        
        l=new JLabel("HELLO ADMIN");
        l.setForeground(Color.red);
        l.setFont(new Font("Serif",Font.BOLD,40));
        l1=new JLabel("Enter Admin Name:");
        l1.setFont(new Font("Serif",Font.BOLD,20));
        l2=new JLabel("Enter Admin Password:");
        l2.setFont(new Font("Serif",Font.BOLD,20));
        
        tf1=new JTextField();
        p2=new JPasswordField();
        
        btn=new JButton("Submit");
        btn.setBackground(Color.red);
        btn.setFont(new Font("Serif",Font.BOLD,33));
        btn.addActionListener(this);
        
        l.setBounds(220,30,800,40);
        l1.setBounds(80,100,200,30);
        l2.setBounds(80,160,200,30);
        tf1.setBounds(320,100,200,30);
        p2.setBounds(320,160,200,30);
        btn.setBounds(280,230,140,35);
        
        add(l);
        add(l1);
        add(tf1);
        add(l2);
        add(p2);
        add(btn);
        
        setVisible(true);
        
    }
    
    
    
    // --------- ENDING OF GUI ----------//
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn)
        {
            String s1=tf1.getText();
            char c2[]=p2.getPassword();
            
            String s2=new String (c2);
            
            if((s1.equals(Adminname))&&(s2.equals(Adminpassword))&&((s1.equals("")==false)||(s2.equals("")==false)))
            {
                try {
                    new Performallocation().setVisible(true);
                    dispose();
                } catch (IOException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD WRONG !");
            }
                
        }
    }
    
    public static void main(String[] args) throws IOException {
        Admin ad=new Admin();
    }
    
}
