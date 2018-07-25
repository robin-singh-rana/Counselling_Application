/**
 * @author robin
 */

package Councelling_App;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Registration extends JFrame implements ActionListener 
{
   //------- BEGINNING OF GUI -------// 
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,background;
    JTextField tf1,tf2,tf7;
    JRadioButton r1,r2;
    JPasswordField p1,p2;
    JButton btn1,btn2,btn3;
    JComboBox cb;
    ButtonGroup bg;
    String state[]={"CHOOSE","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
    
    Registration() throws IOException
    {
        setSize(850,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("                                                              REGISTER YOURSELF HERE");
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon("resources\\images\\registration.jpg")));
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
        
        l1=new JLabel("Registration Form:");
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif",Font.BOLD,25));
        
        l2=new JLabel("Name:");
        l2.setFont(new Font("Serif",Font.BOLD,20));
        l3=new JLabel("E.mail-ID:");
        l3.setFont(new Font("Serif",Font.BOLD,20));
        l4=new JLabel("Create Password");
        l4.setFont(new Font("Serif",Font.BOLD,20));
        l5=new JLabel("Confirm Password");
        l5.setFont(new Font("Serif",Font.BOLD,20));
        l6=new JLabel("Sex:");
        l6.setFont(new Font("Serif",Font.BOLD,20));
        l7=new JLabel("State:");
        l7.setFont(new Font("Serif",Font.BOLD,20));
        l8=new JLabel("JEE Marks(outof 500):"); 
        l8.setFont(new Font("Serif",Font.BOLD,20));
        
        tf1=new JTextField();
        tf2=new JTextField();
        p1=new JPasswordField();
        p2=new JPasswordField();
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        cb=new JComboBox(state);
        tf7=new JTextField();
        
        btn1=new JButton("Submit");
        btn1.setFont(new Font("Serif",Font.BOLD,20));
        btn2=new JButton("Clear");
        btn2.setFont(new Font("Serif",Font.BOLD,20));
        btn3=new JButton("Main Menu");
        btn3.setBackground(Color.red);
        btn3.setFont(new Font("Serif",Font.BOLD,20));
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        r1.setBounds(300,230,70,30);
        r2.setBounds(400,230,70,30);
        cb.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        btn1.setBounds(150, 350, 100, 30);
        btn2.setBounds(270, 350, 100, 30);
        btn3.setBounds(650,500,150,30);
 
        bg=new ButtonGroup();// for adding radio buttons
        bg.add(r1);bg.add(r2);
        
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(r1);add(r2);
        add(l7);
        add(cb);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
        add(btn3);
        
        setVisible(true);
        
    }
    
    //------ ENDING OF GUI ------//
    
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn3) 
        {
            try {
                Homepage hp= new Homepage();
                hp.setVisible(true);
                dispose();
            } 
            catch (IOException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource()==btn2)
        {
            int a=JOptionPane.showConfirmDialog(btn2,"All The Changes Will Be Lost!");
            if(a==JOptionPane.YES_OPTION)
            {
                tf1.setText("");
                tf2.setText("");
                p1.setText("");
                p2.setText("");
                tf7.setText("");
                cb.setSelectedIndex(0);
                r1.setSelected(false);
                r2.setSelected(false);
            }
        }
        else if(e.getSource()==btn1)
        {
            //main submit button code
            String s5 ="";
            int mark = 0;
            String s1=tf1.getText();//name
            if(s1.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter Name!");
            }
            String s2=tf2.getText();//email-id
            if(s2.equals("")||(s2.endsWith(".com")==false))
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid Email!");
                s2="";
            }
            
            char c3[]=p1.getPassword();// create password
            char c4[]=p2.getPassword();// confirm password
            
            
            String s3=new String(c3);// cp
            String s4=new String(c4);// cp
            if((s3.equals(s4)==false)||s3.equals("")||s4.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Password Doesn't Match!");
                s3="";
                s4="";
            }
            
            if(r1.isSelected()==true)//gender
                s5="Male";
            else s5="Female";
            
            String s6=(String) cb.getSelectedItem();//state
            if(s6.equals("CHOOSE")==true)
            {
                JOptionPane.showMessageDialog(null,"Please Select State!");
            }
            
            String s7=tf7.getText();
            if(s7.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid Marks!");
            }
            try{
            mark=Integer.parseInt(s7);//JEEmarks
            if(mark>500)
            {
                JOptionPane.showMessageDialog(null,"PLEASE ENTER VALID MARKS!");
                tf7.setText("");
                s7="";
            }
            }catch(NumberFormatException ex){}
            
            if(s1.equals("")||s2.equals("")||s5.equals("")||s6.equals("CHOOSE")||s7.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Fill All The Required Values!");
            }
            
            //System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+mark);
            
            else if(s3.equals(s4)&&((s3.equals("")==false)||(s4.equals("")==false)))
            {
                try{
                    //DATABASE WORK HERE
                    String host="jdbc:mysql://localhost:3306/student";
                    String username="root";
                    String upassword="robin#root";
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection(host, username, upassword);
                    
                    String query="insert into stud_info(name,email,password,gender,state,marks) values(?,?,?,?,?,?)";
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setString(1,s1);
                    ps.setString(2,s2);
                    ps.setString(3,s4);
                    ps.setString(4,s5);
                    ps.setString(5,s6);
                    ps.setInt(6,mark);
                    
                    int x=ps.executeUpdate();
                    x++;
                    if(x>0)
                    {
                        JOptionPane.showMessageDialog(null,"Registered Successsfully");
                        con.close();
                        new Homepage().setVisible(true);
                        dispose();
                    }
                }
                catch (Exception err)
                {
                    System.out.println( err.getMessage( ) );
                }
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException
    {
        Registration rn=new Registration();
    }
    
}
