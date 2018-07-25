
/**
 *
 * @author robin
 */

package Councelling_App;

import java.util.*;
import java.io.*;
import java.sql.*;

public class Logic 
{
    
    public static class stud            // model class(user defined data type)
    {
        private int id;
        private String name;
        private String email;
        private String password;
        private String gender;
        private String state;
        private int marks;
        
        public int getid(){
            return this.id;
        }
        public void setid(int id){
            this.id=id;
        }
        
        public String getname(){
            return this.name;
        }
        public void setname(String name){
            this.name=name;
        }
        
        public String getemail(){
            return this.email;
        }
        public void setemail(String email){
            this.email=email;
        }
        
        public String getpassword(){
            return this.password;
        }
        public void setpassword(String password){
            this.password=password;
        }
        
        public String getgender(){
            return this.gender;
        }
        public void setgender(String gender){
            this.gender=gender;
        }
        
        public String getstate(){
            return this.state;
        }
        public void setstate(String state){
            this.state=state;
        }
        
        public int getmarks(){
            return this.marks;
        }
        public void setmarks(int marks){
            this.marks=marks;
        }
        
    }
    
    
    public static void main(String[] args) throws SQLException
    {
        // 1. COLLECT DATA FROM STUD_INFO AND SORT IT ACCORDING TO THE MARKS PLACE IT IN STUD_RANKS
        // NOW FOR ALL STUDENTS (IN LOOP)
        // 2. FETCH NAME AND PASSWORD FROM STUD_RANKS  (AS RANKWISE WE ARE ALLOCATING SEATS) AND MATCH IT WITH NAME AND PASSWORD FROM STUD_CHOICES
        // 3. STORE ALL THE CHOICES IN AN ARRAYLIST
        // 4. CHECK WHETHER ALL THE SEATS HAVE BEEN ALLOCATED OR NOT
        // 5. FETCH CHOICES 1 BY 1 UNTIL THE LAST CHOICE
        
        
        //  -----------------   1   --------------//
        ArrayList<stud> stud_det=new ArrayList<stud>();
        try{
            String host="jdbc:mysql://localhost:3306/student";
            String username="root";
            String upassword="robin#root";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(host, username, upassword);
            
            String query="select *from stud_info order by marks DESC";
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                stud std=new stud();
                std.setid(rs.getInt("student_id"));
                std.setname(rs.getString("name"));
                std.setemail(rs.getString("email"));
                std.setpassword(rs.getString("password"));
                std.setgender(rs.getString("gender"));
                std.setstate(rs.getString("state"));
                std.setmarks(rs.getInt("marks"));
                
                stud_det.add(std);
                
            }
            
            Iterator itr=stud_det.iterator();
            
            int rk=1;
            while(itr.hasNext())
            {
                stud std=(stud)itr.next();
                //System.out.println(std.id+" "+std.name+" "+std.email+" "+std.password+" "+std.gender+" "+std.state+" "+" "+std.marks);
               
               String query1="insert into stud_ranks(rank,name,email,password,gender,state,marks) values(?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(query1);
                ps.setInt(1,rk++);
                ps.setString(2,std.name);
                ps.setString(3,std.email);
                ps.setString(4,std.password);
                ps.setString(5,std.gender);
                ps.setString(6,std.state);
                ps.setInt(7,std.marks);
                
                int x=ps.executeUpdate();
            }
            
            ArrayList<String> choices=new ArrayList<String>();                                     // for storing choices after fetching from database
            Choicefilling cf=null;
            cf=new Choicefilling();                                                               // AVOIDING NULL POINTER EXCEPTION
            cf.dispose();
            HashMap<String,Integer> map = null;
            map = new HashMap<>();
            map.put(cf.c1,0);
            map.put(cf.c2,0);
            map.put(cf.c3,0);
            map.put(cf.c4,0);
            map.put(cf.c5,0);
            map.put(cf.c6,0);
            map.put(cf.c7,0);
            map.put(cf.c8,0);
            map.put(cf.c9,0);
            map.put(cf.c10,0);
            map.put(cf.c11,0);
            map.put(cf.c12,0);
            map.put(cf.c13,0);
            map.put(cf.c14,0);
            map.put(cf.c15,0);
            
           /* for (Map.Entry<String,Integer> entry : map.entrySet()) 
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());*/
// --------------------------------------------  UPTO THIS WORKS FINE --------------------------------//               // DEBUGGING #1
            for(int i=0;i<stud_det.size();i++)
            {
                //System.out.println("entering the loop");
                int rank_of_student=i+1;
                String query2="select name,password from stud_ranks where rank= ? ";                    // fetching students rankwise
                PreparedStatement st1=con.prepareStatement(query2);
                st1.setInt(1,rank_of_student);
                ResultSet rs1=st1.executeQuery();
                
                if(rs1.next())
                {
                    String s1=rs1.getString("name");
                    String s2=rs1.getString("password");
                    //System.out.println(s1+" "+s2);
                    
                    String query3="select choice_1,choice_2,choice_3,choice_4,choice_5,choice_6,choice_7,choice_8,choice_9,choice_10,choice_11,choice_12,choice_13,choice_14,choice_15 from stud_choices where name= ? AND password= ?"; // && password='s2' 
                    PreparedStatement st2=con.prepareCall(query3);
                    st2.setString(1,s1);
                    st2.setString(2,s2);
                    ResultSet rs2=st2.executeQuery();
                    
                    if(rs2.next())
                    {
                        String ch1=rs2.getString("choice_1");choices.add(ch1);
                        String ch2=rs2.getString("choice_2");choices.add(ch2);
                        String ch3=rs2.getString("choice_3");choices.add(ch3);
                        String ch4=rs2.getString("choice_4");choices.add(ch4);
                        String ch5=rs2.getString("choice_5");choices.add(ch5);                         // FETCHING AND STORING CHOICES OF PARTICULAR STUDENT IN CHOICES(arraylist)
                        String ch6=rs2.getString("choice_6");choices.add(ch6);
                        String ch7=rs2.getString("choice_7");choices.add(ch7);
                        String ch8=rs2.getString("choice_8");choices.add(ch8);
                        String ch9=rs2.getString("choice_9");choices.add(ch9);
                        String ch10=rs2.getString("choice_10");choices.add(ch10);
                        String ch11=rs2.getString("choice_11");choices.add(ch11);
                        String ch12=rs2.getString("choice_12");choices.add(ch12);
                        String ch13=rs2.getString("choice_13");choices.add(ch13);
                        String ch14=rs2.getString("choice_14");choices.add(ch14);
                        String ch15=rs2.getString("choice_15");choices.add(ch15);
                        choices.removeAll(Arrays.asList("NONE"));                                 // REMOVING ALL THE OCCURANCES OF  "NONE"
                    }
                    
                    for(int j=0;j<choices.size();j++)
                    {
                        String key=choices.get(j);                                               //SELECTING CHOICES ONE BY ONE 
                        int value=map.get(key);                                                      // GETTING THE CORRESPONDING VALUE OF THE KEY(which is choice)
                        if(value==0)
                        {
                            String query4="insert into stud_result(rank,name,password,seat_allocated) values(?,?,?,?)";
                            PreparedStatement ps1=con.prepareStatement(query4);
                            ps1.setInt(1,rank_of_student);
                            ps1.setString(2,s1);
                            ps1.setString(3,s2);
                            ps1.setString(4,key);
                            int x=ps1.executeUpdate();
                            
                            map.replace(key,0,1);                                                       // REPLACING THE SEAT ALLOCATION STATUS IN MAP
                            break;
                            
                        }
                    }
                    choices.clear();
                    
                }
                    
            }
           /* for (Map.Entry<String,Integer> entry : map.entrySet()) 
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());*/
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
// --------------------------------------------  UPTO THIS WORKS FINE --------------------------------//               // DEBUGGING #2
        
    }
    
}
