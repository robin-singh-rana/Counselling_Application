
/**
 *
 * @author robin
 */

package Councelling_App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Result extends JFrame implements ActionListener
{
    //------------ BEGINNING OF GUI -------------//
    
    JLabel l,l1,l2;
    JPasswordField p1;
    JTextField tf;
    JButton btn,btn2;
    public static String name,pass;
    
    Result() throws IOException
    {
        setSize(850,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("                                                                               RESULT LOGIN");
        setContentPane(new JLabel(new ImageIcon("resources\\images\\result.jpg")));
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
        
        l=new JLabel("Login Here To Get Your Result:-");
        l.setForeground(Color.green);
        l.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        
        l1=new JLabel("Username:");                    //1.OBJECTS
        l1.setFont(new Font("Serif",Font.BOLD,20));
        l1.setForeground(Color.white);
        l2=new JLabel("Enter Password:");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Serif",Font.BOLD,20));
        
        tf=new JTextField();
        p1=new JPasswordField();
        btn=new JButton("Login");
        btn.setBackground(Color.green);
        btn.setFont(new Font("Serif",Font.BOLD,25));
        btn2=new JButton("Main Menu");
        btn.addActionListener(this);
        btn2.addActionListener(this);
        btn2.setBackground(Color.red);
        btn2.setFont(new Font("Serif",Font.BOLD,20));
        
        l.setBounds(30,30,600,30);
        l1.setBounds(130,100, 200, 30);                   //2. LOCATIONS
        l2.setBounds(130, 150, 200, 30);
        tf.setBounds(330,100,200,30);
        p1.setBounds(330,150,200,30);
        btn.setBounds(360,200,100,30);
        btn2.setBounds(650,500,150,30);
        
        add(l);
        add(l1);                                       //3. ADDING
        add(tf);
        add(l2);
        add(p1);
        add(btn);
        add(btn2);
        
        setVisible(true);
    }
    
    
    //------------ ENDING OF THE GUI ------------//   
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn2)
        {
            try {
                Homepage hp = new Homepage();
                hp.setVisible(true);
                dispose();
            } 
            catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==btn)
        {
            //main logic button code
            try{
                String host="jdbc:mysql://localhost:3306/student";
                String uname="root";
                String upassword="robin#root";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(host, uname, upassword);
                
                name=tf.getText();
                char s[]=p1.getPassword();
                pass=new String(s);
                
                String query="select * from stud_result where name=? and password=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,name);
                ps.setString(2,pass);
                
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    int rank=rs.getInt("rank");
                    JOptionPane.showMessageDialog(null,"Login Successfull.");
                    // ADD CHOICEFILLING INSTANCE/OBJECT HERE
                    new Display_result(name,pass,rank).setVisible(true);
                    dispose();
                }
                else 
                {
                    JOptionPane.showMessageDialog(btn,"CHECK YOUR USERNAME OR PASSWORD AGAIN! OR NO SEAT ALLOCATED DUE TO LOW RANK!");
                    new Homepage().setVisible(true);
                    dispose();
                }
                
                        
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Result rr=new Result();
    }
    
}
