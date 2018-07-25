/**
 * @author robin
 */


package Councelling_App;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame implements ActionListener 
{
    //----- BEGINNING OF GUI ------//
    
    JLabel l,l1,l2;
    JPasswordField p1;
    JTextField tf;
    JButton btn,btn2;
    public static String name,pass;
    
    Login() throws IOException
    {
        setSize(850,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("                                                                  Login Portal");
        setContentPane(new JLabel(new ImageIcon("resources\\images\\Login.jpg")));
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
        
        l=new JLabel("Login Here:");
        l.setForeground(Color.red);
        l.setFont(new Font("Serif",Font.BOLD,25));
        
        l1=new JLabel("Username:");                    //1.OBJECTS
        l1.setFont(new Font("Serif",Font.BOLD,20));
        l1.setForeground(Color.white);
        l2=new JLabel("Enter Password:");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Serif",Font.BOLD,20));
        
        tf=new JTextField();
        p1=new JPasswordField();
        btn=new JButton("Login");
        btn.setBackground(Color.red);
        btn.setFont(new Font("Serif",Font.BOLD,25));
        btn2=new JButton("Main Menu");
        btn.addActionListener(this);
        btn2.addActionListener(this);
        btn2.setBackground(Color.red);
        btn2.setFont(new Font("Serif",Font.BOLD,20));
        
        l.setBounds(100,30,400,30);
        l1.setBounds(80,70, 200, 30);                   //2. LOCATIONS
        l2.setBounds(80, 110, 200, 30);
        tf.setBounds(250,70,200,30);
        p1.setBounds(250,110,200,30);
        btn.setBounds(280,150,100,30);
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
    
    //----- ENDING OF GUI --------//

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
            int flag=0;
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
                
                String query1="select *from stud_choices where name=? and password=?";                                   // EXECUTING ONE RESULTSET BEFORE THE OTHER AS IT BECOMES USELESS WHEN OTHER COMES INTO ATTACK
                PreparedStatement ps1=con.prepareStatement(query1);
                ps1.setString(1,name);
                ps1.setString(2,pass);
                ResultSet rs1=ps1.executeQuery();
                if(rs1.next())
                    flag=1;
                
                
                String query="select * from stud_info where name=? and password=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,name);
                ps.setString(2,pass);
                ResultSet rs=ps.executeQuery();
                
                if(rs.next())
                {
                    if(flag==1)
                    {
                        JOptionPane.showMessageDialog(null,"YOU HAVE ALREADY FILLED CHOICES! WAIT FOR RESULTS!");                  // CHECKING THAT THE STUDENT HAS ALREADY SUBMITTED THE CHOICES OR NOT 
                        new Homepage().setVisible(true);                                                                    // BY CHECKING THE DATABASE stud_choices IF HIS/HER DATA EXISTS THEN AVOID FROM LOGIN
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Login Successfull.");
                        // ADD CHOICEFILLING INSTANCE/OBJECT HERE
                        new Choicefilling(name,pass).setVisible(true);
                        dispose();
                    }
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password!");
                }
                
                        
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Login lg=new Login();
    }

    
}
