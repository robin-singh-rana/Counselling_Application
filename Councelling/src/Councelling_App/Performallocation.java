
/**
 *
 * @author robin
 */

package Councelling_App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Performallocation extends JFrame implements ActionListener
{
    public static int resultflag=0;
    JLabel l,l1;
    JButton btn;

    public Performallocation() throws IOException 
    {   
        setSize(850,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("                                                              SEAT ALLOCATION BY ADMIN");
        setContentPane(new JLabel(new ImageIcon("resources\\images\\allocation.jpg")));
        setLayout(null);
        setLocationRelativeTo(null);
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
        
        l=new JLabel("WELCOME ADMIN");
        l.setForeground(Color.yellow);
        l.setFont(new Font("Serif",Font.BOLD,60));
        
        l1=new JLabel("CLICK THE FOLLOWING BUTTON TO PERFORM SEAT ALLOCATION:--");
        l1.setForeground(Color.cyan);
        l1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        
        btn=new JButton("PERFORM SEAT ALLOCATION");
        btn.setBackground(Color.red);
        btn.setForeground(Color.white);
        btn.setFont(new Font("Serif",Font.BOLD,50));
        btn.addActionListener(this);
        
        l.setBounds(140,30,800,60);
        l1.setBounds(30,170,800,30);
        btn.setBounds(30,250,790,52);
        
        add(l);
        add(l1);
        add(btn);
        
        setVisible(true);
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==btn)
        {
            try{
            String host="jdbc:mysql://localhost:3306/student";
            String uname="root";
            String upassword="robin#root";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(host, uname, upassword);
              
            String query="select *from stud_result";
            PreparedStatement ps=con.prepareStatement(query);
                
            ResultSet rs=ps.executeQuery();             
            
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"ALLOTTMENT IS ALREADY DONE FOR THIS SESSION!");
                new Homepage().setVisible(true);
                dispose();
            }
            
            else{
                try {
                    Logic.main(null);                    // CALLING MAIN METHOD OF ANOTHER CLASS;
                } catch (SQLException ex) {
                    Logger.getLogger(Performallocation.class.getName()).log(Level.SEVERE, null, ex);
                }



                JOptionPane.showMessageDialog(null,"SEATS ALLOCATED TO STUDENTS SUCCESSFULLY.STUDENTS CAN VIEW THEIR RESULTS.");
                resultflag=1;
                try {
                    Homepage hp= new Homepage();
                    hp.setVisible(true);
                    dispose();
                } 
                catch (IOException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Performallocation pa=new Performallocation();
        
        //CALL LOGIC CLASS HERE
        
    }
    
    
    
}
