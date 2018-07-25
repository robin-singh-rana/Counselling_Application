
/**
 *
 * @author robin
 */

package Councelling_App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import sun.audio.AudioDevice;

public class Choicefilling extends JFrame implements ActionListener
{
    //-------BEGINNING OF GUI----------//
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    JComboBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15;
    public String c1="CDAC-MOHALI: COMPUTER SCIENCE AND ENGINEERING";
    public String c2="CDAC-MOHALI: ELECTRICAL ENGINEERING";
    public String c3="CDAC-MOHALI: MECHANICAL ENGINEERING";
    public String c4="CDAC-MOHALI: ELECTRONICS AND COMMUNICATION ENGINEERING";
    public String c5="CDAC-MOHALI: CIVIL ENGINEERING";
    public String c6="CDAC-DELHI: COMPUTER SCIENCE AND ENGINEERING";
    public String c7="CDAC-DELHI: ELECTRICAL ENGINEERING";
    public String c8="CDAC-DELHI: MECHANICAL ENGINEERING";
    public String c9="CDAC-DELHI: ELECTRONICS AND COMMUNICATION ENGINEERING";
    public String c10="CDAC-DELHI: CIVIL ENGINEERING";
    public String c11="CDAC-NOIDA: COMPUTER SCIENCE AND ENGINEERING";
    public String c12="CDAC-NOIDA: ELECTRICAL ENGINEERING";
    public String c13="CDAC-NOIDA: MECHANICAL ENGINEERING";
    public String c14="CDAC-NOIDA: ELECTRONICS AND COMMUNICATION ENGINEERING";
    public String c15="CDAC-NOIDA: CIVIL ENGINEERING";
    String choice1[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice2[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice3[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice4[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice5[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice6[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice7[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice8[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice9[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice10[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice11[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice12[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice13[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice14[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15},
           choice15[]={"NONE","SELECT",c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15};
    JButton btn1,btn2;
    
    public Choicefilling() throws IOException                     // OVERLOAD THE CONSTRUCTOR FOR JUST RUNNING THE JFRAME
    {
        setTitle("                                                                                                                                                                                                                WELCOME TO CHOICE FILLING");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("resources\\images\\hello.jpg")));
        //setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
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
        
        l16=new JLabel("WELCOME");                                        // LABELS
        l16.setForeground(Color.red);
        l16.setFont(new Font("Serif",Font.BOLD,60));
        l17=new JLabel("Please Fill Your Choices Here:--");
        l17.setForeground(Color.darkGray);
        l17.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        
        l1=new JLabel("CHOICE 1:");
        l1.setFont(new Font("Serif",Font.BOLD,25));
        l1.setForeground(Color.red);
        l2=new JLabel("CHOICE 2:");
        l2.setFont(new Font("Serif",Font.BOLD,25));
        l2.setForeground(Color.red);
        l3=new JLabel("CHOICE 3:");
        l3.setFont(new Font("Serif",Font.BOLD,25));
        l3.setForeground(Color.red);
        l4=new JLabel("CHOICE 4:");
        l4.setFont(new Font("Serif",Font.BOLD,25));
        l4.setForeground(Color.red);
        l5=new JLabel("CHOICE 5:");
        l5.setFont(new Font("Serif",Font.BOLD,25));
        l5.setForeground(Color.red);
        l6=new JLabel("CHOICE 6:");
        l6.setFont(new Font("Serif",Font.BOLD,25));
        l6.setForeground(Color.red);
        l7=new JLabel("CHOICE 7:");
        l7.setFont(new Font("Serif",Font.BOLD,25));
        l7.setForeground(Color.red);
        l8=new JLabel("CHOICE 8:");
        l8.setFont(new Font("Serif",Font.BOLD,25));
        l8.setForeground(Color.red);
        l9=new JLabel("CHOICE 9:");
        l9.setFont(new Font("Serif",Font.BOLD,25));
        l9.setForeground(Color.red);
        l10=new JLabel("CHOICE 10:");
        l10.setFont(new Font("Serif",Font.BOLD,25));
        l10.setForeground(Color.red);
        l11=new JLabel("CHOICE 11:");
        l11.setFont(new Font("Serif",Font.BOLD,25));
        l11.setForeground(Color.red);
        l12=new JLabel("CHOICE 12:");
        l12.setFont(new Font("Serif",Font.BOLD,25));
        l12.setForeground(Color.red);
        l13=new JLabel("CHOICE 13:");
        l13.setFont(new Font("Serif",Font.BOLD,25));
        l13.setForeground(Color.red);
        l14=new JLabel("CHOICE 14:");
        l14.setFont(new Font("Serif",Font.BOLD,25));
        l14.setForeground(Color.red);
        l15=new JLabel("CHOICE 15:");
        l15.setFont(new Font("Serif",Font.BOLD,25));
        l15.setForeground(Color.red);
        
        btn1=new JButton("SUBMIT");                                 // BUTTONS
        btn1.setBackground(Color.green);
        btn1.setFont(new Font("Serif",Font.BOLD,35));
        btn2=new JButton("CLEAR");
        btn2.setBackground(Color.green);
        btn2.setFont(new Font("Serif",Font.BOLD,35));
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);  
        
        cb1=new JComboBox(choice1);                                        // COMBOBOXES
        cb2=new JComboBox(choice1);
        cb3=new JComboBox(choice1); 
        cb4=new JComboBox(choice1); 
        cb5=new JComboBox(choice1);
        cb6=new JComboBox(choice1);                                        // COMBOBOXES
        cb7=new JComboBox(choice1);
        cb8=new JComboBox(choice1); 
        cb9=new JComboBox(choice1); 
        cb10=new JComboBox(choice1);
        cb11=new JComboBox(choice1);                                        // COMBOBOXES
        cb12=new JComboBox(choice1);
        cb13=new JComboBox(choice1); 
        cb14=new JComboBox(choice1); 
        cb15=new JComboBox(choice1);
        
        l1.setBounds(250,200,300,28);                                       // BOUNDING
        l2.setBounds(250,250,300,28);
        l3.setBounds(250,300,300,28);
        l4.setBounds(250,350,300,28);
        l5.setBounds(250,400,300,28);
        l6.setBounds(250,450,300,28);
        l7.setBounds(250,500,300,28);
        l8.setBounds(250,550,300,28);
        l9.setBounds(250,600,300,28);
        l10.setBounds(250,650,300,28);
        l11.setBounds(250,700,300,28);
        l12.setBounds(250,750,300,28);
        l13.setBounds(250,800,300,28);
        l14.setBounds(250,850,300,28);
        l15.setBounds(250,900,300,28);
        l16.setBounds(750,30,600,62);
        l17.setBounds(50,130,600,32);
        btn1.setBounds(750,970,190,40);
        btn2.setBounds(1050,970,180,40);
        cb1.setBounds(500,200,1100,28);
        cb2.setBounds(500,250,1100,28);
        cb3.setBounds(500,300,1100,28);
        cb4.setBounds(500,350,1100,28);
        cb5.setBounds(500,400,1100,28);
        cb6.setBounds(500,450,1100,28);
        cb7.setBounds(500,500,1100,28);
        cb8.setBounds(500,550,1100,28);
        cb9.setBounds(500,600,1100,28);
        cb10.setBounds(500,650,1100,28);
        cb11.setBounds(500,700,1100,28);
        cb12.setBounds(500,750,1100,28);
        cb13.setBounds(500,800,1100,28);
        cb14.setBounds(500,850,1100,28);
        cb15.setBounds(500,900,1100,28);
        
        add(l16);                                                          // ADDING
        add(l17);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(l15);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);
        add(cb6);
        add(cb7);
        add(cb8);
        add(cb9);
        add(cb10);
        add(cb11);
        add(cb12);
        add(cb13);
        add(cb14);
        add(cb15);
        add(btn1);
        add(btn2);
        
        setVisible(true);
    }
    
    public Choicefilling(String uname,String upass) throws IOException         // FOR PASSING DATA FROM ONE FRAME TO ANOTHER
    {
        setTitle("                                                                                                                                                                                                                WELCOME TO CHOICE FILLING");
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon("resources\\images\\hello.jpg")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setResizable(false);
        
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
        
        
        l16=new JLabel("WELCOME "+uname.toUpperCase());                                        // LABELS
        l16.setForeground(Color.red);
        l16.setFont(new Font("Serif",Font.BOLD,60));
        l17=new JLabel("Please Fill Your Choices Here:--");
        l17.setForeground(Color.darkGray);
        l17.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        
        l1=new JLabel("CHOICE 1:");
        l1.setFont(new Font("Serif",Font.BOLD,25));
        l1.setForeground(Color.red);
        l2=new JLabel("CHOICE 2:");
        l2.setFont(new Font("Serif",Font.BOLD,25));
        l2.setForeground(Color.red);
        l3=new JLabel("CHOICE 3:");
        l3.setFont(new Font("Serif",Font.BOLD,25));
        l3.setForeground(Color.red);
        l4=new JLabel("CHOICE 4:");
        l4.setFont(new Font("Serif",Font.BOLD,25));
        l4.setForeground(Color.red);
        l5=new JLabel("CHOICE 5:");
        l5.setFont(new Font("Serif",Font.BOLD,25));
        l5.setForeground(Color.red);
        l6=new JLabel("CHOICE 6:");
        l6.setFont(new Font("Serif",Font.BOLD,25));
        l6.setForeground(Color.red);
        l7=new JLabel("CHOICE 7:");
        l7.setFont(new Font("Serif",Font.BOLD,25));
        l7.setForeground(Color.red);
        l8=new JLabel("CHOICE 8:");
        l8.setFont(new Font("Serif",Font.BOLD,25));
        l8.setForeground(Color.red);
        l9=new JLabel("CHOICE 9:");
        l9.setFont(new Font("Serif",Font.BOLD,25));
        l9.setForeground(Color.red);
        l10=new JLabel("CHOICE 10:");
        l10.setFont(new Font("Serif",Font.BOLD,25));
        l10.setForeground(Color.red);
        l11=new JLabel("CHOICE 11:");
        l11.setFont(new Font("Serif",Font.BOLD,25));
        l11.setForeground(Color.red);
        l12=new JLabel("CHOICE 12:");
        l12.setFont(new Font("Serif",Font.BOLD,25));
        l12.setForeground(Color.red);
        l13=new JLabel("CHOICE 13:");
        l13.setFont(new Font("Serif",Font.BOLD,25));
        l13.setForeground(Color.red);
        l14=new JLabel("CHOICE 14:");
        l14.setFont(new Font("Serif",Font.BOLD,25));
        l14.setForeground(Color.red);
        l15=new JLabel("CHOICE 15:");
        l15.setFont(new Font("Serif",Font.BOLD,25));
        l15.setForeground(Color.red);
        
        btn1=new JButton("SUBMIT");                                 // BUTTONS
        btn1.setBackground(Color.green);
        btn1.setFont(new Font("Serif",Font.BOLD,35));
        btn2=new JButton("CLEAR");
        btn2.setBackground(Color.green);
        btn2.setFont(new Font("Serif",Font.BOLD,35));
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);  
        
        cb1=new JComboBox(choice1);                                        // COMBOBOXES
        cb2=new JComboBox(choice1);
        cb3=new JComboBox(choice1); 
        cb4=new JComboBox(choice1); 
        cb5=new JComboBox(choice1);
        cb6=new JComboBox(choice1);                                        // COMBOBOXES
        cb7=new JComboBox(choice1);
        cb8=new JComboBox(choice1); 
        cb9=new JComboBox(choice1); 
        cb10=new JComboBox(choice1);
        cb11=new JComboBox(choice1);                                        // COMBOBOXES
        cb12=new JComboBox(choice1);
        cb13=new JComboBox(choice1); 
        cb14=new JComboBox(choice1); 
        cb15=new JComboBox(choice1);
        
        l1.setBounds(250,200,300,28);                                       // BOUNDING
        l2.setBounds(250,250,300,28);
        l3.setBounds(250,300,300,28);
        l4.setBounds(250,350,300,28);
        l5.setBounds(250,400,300,28);
        l6.setBounds(250,450,300,28);
        l7.setBounds(250,500,300,28);
        l8.setBounds(250,550,300,28);
        l9.setBounds(250,600,300,28);
        l10.setBounds(250,650,300,28);
        l11.setBounds(250,700,300,28);
        l12.setBounds(250,750,300,28);
        l13.setBounds(250,800,300,28);
        l14.setBounds(250,850,300,28);
        l15.setBounds(250,900,300,28);
        l16.setBounds(650,30,1200,62);
        l17.setBounds(50,130,600,32);
        btn1.setBounds(750,970,190,40);
        btn2.setBounds(1050,970,180,40);
        cb1.setBounds(500,200,1100,28);
        cb2.setBounds(500,250,1100,28);
        cb3.setBounds(500,300,1100,28);
        cb4.setBounds(500,350,1100,28);
        cb5.setBounds(500,400,1100,28);
        cb6.setBounds(500,450,1100,28);
        cb7.setBounds(500,500,1100,28);
        cb8.setBounds(500,550,1100,28);
        cb9.setBounds(500,600,1100,28);
        cb10.setBounds(500,650,1100,28);
        cb11.setBounds(500,700,1100,28);
        cb12.setBounds(500,750,1100,28);
        cb13.setBounds(500,800,1100,28);
        cb14.setBounds(500,850,1100,28);
        cb15.setBounds(500,900,1100,28);
        
        add(l16);                                                          // ADDING
        add(l17);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(l14);
        add(l15);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);
        add(cb6);
        add(cb7);
        add(cb8);
        add(cb9);
        add(cb10);
        add(cb11);
        add(cb12);
        add(cb13);
        add(cb14);
        add(cb15);
        add(btn1);
        add(btn2);
        
        setVisible(true);
    }

    //-------ENDING OF GUI------------//
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn2)
        {
            int a=JOptionPane.showConfirmDialog(null,"All The Changes Will Be Lost!");
            if(a==JOptionPane.YES_OPTION)
            {
                cb1.setSelectedIndex(0);
                cb2.setSelectedIndex(0);
                cb3.setSelectedIndex(0);
                cb4.setSelectedIndex(0);
                cb5.setSelectedIndex(0);
                cb6.setSelectedIndex(0);
                cb7.setSelectedIndex(0);
                cb8.setSelectedIndex(0);
                cb9.setSelectedIndex(0);
                cb10.setSelectedIndex(0);
                cb11.setSelectedIndex(0);
                cb12.setSelectedIndex(0);
                cb13.setSelectedIndex(0);
                cb14.setSelectedIndex(0);
                cb15.setSelectedIndex(0);
            }
        }
        else if(e.getSource()==btn1)
        {
            int flag=0;
            String s1=(String) cb1.getSelectedItem();
            String s2=(String) cb2.getSelectedItem();
            String s3=(String) cb3.getSelectedItem();
            String s4=(String) cb4.getSelectedItem();
            String s5=(String) cb5.getSelectedItem();
            String s6=(String) cb6.getSelectedItem();
            String s7=(String) cb7.getSelectedItem();
            String s8=(String) cb8.getSelectedItem();
            String s9=(String) cb9.getSelectedItem();
            String s10=(String) cb10.getSelectedItem();
            String s11=(String) cb11.getSelectedItem();
            String s12=(String) cb12.getSelectedItem();
            String s13=(String) cb13.getSelectedItem();
            String s14=(String) cb14.getSelectedItem();
            String s15=(String) cb15.getSelectedItem();
            ArrayList<String> check=new ArrayList<String>();   
            ArrayList<String> check2=new ArrayList<String>();
            check.add(s1);
            check.add(s2);
            check.add(s3);
            check.add(s4);
            check.add(s5);
            check.add(s6);
            check.add(s7);                                                        // ALL THIS IS DONE TO AVOID THE CONDITION THAT STUDENT HAS SELECTED A PARTICULAR SEAT MULTIPLE TIMES
            check.add(s8);
            check.add(s9);
            check.add(s10);
            check.add(s11);
            check.add(s12);
            check.add(s13);
            check.add(s14);
            check.add(s15);
            for(String st:check){
                if(st.equals("NONE")==false)
                    check2.add(st);
            }
            int occurances_of_select=Collections.frequency(check2, "SELECT");
            Set<String> set=new HashSet<String>(check2);
            if((set.size()<check2.size())||(occurances_of_select>0))
            {
                flag=1;
                JOptionPane.showMessageDialog(null,"PLEASE SELECT DIFFERENT CHOICES! or AVOID SELECTING \"SELECT\" ");
            }
            else if((flag==0)&&(occurances_of_select==0))
            {
                int a=JOptionPane.showConfirmDialog(null,"ARE YOU SURE TO LOCK YOUR CHOICES ? CHOICES ONCE LOCKED CAN'T BE CHANGED AGAIN!");
                if(a==JOptionPane.YES_OPTION)
                {
                    try
                    {

                        // CONNECTING WITH DATABASE
                        //1. bring uname and upass here  --> \/
                        //2. bring arraylist here
                        String name=Login.name;
                        String pass=Login.pass;
                        //JOptionPane.showMessageDialog(null,name+"  "+ pass);

                        String host="jdbc:mysql://localhost:3306/student";
                        String username="root";
                        String upassword="robin#root";

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(host, username, upassword);

                        String query="insert into stud_choices(name,password,choice_1,choice_2,choice_3,choice_4,choice_5,choice_6,choice_7,choice_8,choice_9,choice_10,choice_11,choice_12,choice_13,choice_14,choice_15) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps=con.prepareStatement(query);
                        ps.setString(1,name);
                        ps.setString(2,pass);
                        ps.setString(3,s1);
                        ps.setString(4,s2);
                        ps.setString(5,s3);
                        ps.setString(6,s4);
                        ps.setString(7,s5);
                        ps.setString(8,s6);
                        ps.setString(9,s7);
                        ps.setString(10,s8);
                        ps.setString(11,s9);
                        ps.setString(12,s10);
                        ps.setString(13,s11);
                        ps.setString(14,s12);
                        ps.setString(15,s13);
                        ps.setString(16,s14);
                        ps.setString(17,s15);

                        int x=ps.executeUpdate();
                        x++;
                        if(x>0)
                        {

                            JOptionPane.showMessageDialog(null,"CHOICES LOCKED SUCCESSFULLY. WAIT FOR RESULTS.");

                            new Homepage().setVisible(true);
                            dispose();
                        }

                    }catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }    
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Choicefilling cf=new Choicefilling();
    }
        
}  

