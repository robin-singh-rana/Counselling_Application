/**
 *
 * @author robin
 */
package Councelling_App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;


public class Display_result extends JFrame implements ActionListener
{
    //------------ BEGINNING OF GUI -------------//
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton btn;
    private String seat=""; 
    
    public Display_result(String name,String pass,int rank) throws HeadlessException 
    {
        setSize(1300,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("                                                                                                                               DISPLAYING RESULT ");
        setContentPane(new JLabel(new ImageIcon("resources\\images\\hello.jpg")));
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
        
        try{
            String host="jdbc:mysql://localhost:3306/student";
            String uname="root";
            String upassword="robin#root";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(host, uname, upassword);
              
            String query="select * from stud_result where name=? and password=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,pass);
                
            ResultSet rs=ps.executeQuery();             
            
            if(rs.next())
            {
                seat=rs.getString("seat_allocated");
            }
            
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        
        l1=new JLabel("WELCOME "+name.toUpperCase());                                        // LABELS
        l1.setForeground(Color.red);
        l1.setFont(new Font("Serif",Font.BOLD,50));
        l2=new JLabel("Your Result Is As:-");
        l2.setForeground(Color.darkGray);
        l2.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        l3=new JLabel("RANK:");
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Serif",Font.BOLD,30));
        l4=new JLabel("NAME:");
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Serif",Font.BOLD,30));
        l5=new JLabel("SEAT-ALLOCATED:");
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Serif",Font.BOLD,25));
        l6=new JLabel(String.valueOf(rank));
        l6.setForeground(Color.red);
        l6.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        l7=new JLabel(name.toUpperCase());
        l7.setForeground(Color.red);
        l7.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        l8=new JLabel(seat.toUpperCase());
        l8.setForeground(Color.red);
        l8.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        btn=new JButton("SAVE");
        btn.setBackground(Color.green);
        btn.setFont(new Font("Serif",Font.BOLD,35));
        btn.addActionListener(this);
        
        l1.setBounds(400,30,1200,52);
        l2.setBounds(30,120,500,32);
        l3.setBounds(160,220,500,32);
        l4.setBounds(160,320,500,32);
        l5.setBounds(70,420,500,27);
        l6.setBounds(680,220,500,37);
        l7.setBounds(680,320,500,32);
        l8.setBounds(390,420,1200,27);
        btn.setBounds(580,490,130,37);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(btn);
        
        
        setVisible(true);
        
        
    }
    
    
    
    //------------ ENDING OF GUI -------------//

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn)                                                    // SIMPLY GETTING SCREENSHOT
        {
            try{
                Dimension screenSize = getSize();
                Rectangle screenRectangle = new Rectangle(311,240, screenSize.width,screenSize.height);    // WIDTH=> 1920-1300=620    =>620/2=310   HEIGHT=>1080-600=480 =>480/2=240
                Robot robot = new Robot();
                BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "jpg", new File("E:\\projects\\Councelling\\resources\\results\\RESULT_"+Result.name+".jpg"));
                JOptionPane.showMessageDialog(null,"RESULT STORED IN YOUR COMPUTER!");
                new Homepage().setVisible(true);
                dispose();
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Display_result dr=new Display_result("a","b",1);
       /* Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize.getWidth());                                  // GETTING DIMENSIONS OF THE SCREEN 
        System.out.println(screenSize.getHeight()); */                              // == 1920*1080
    }
    
}
