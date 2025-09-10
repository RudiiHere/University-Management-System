package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener {
    
    Choice crollno, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
   
    StudentLeave(){
        setSize(600, 650);
        setLocation(650,200);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(100,50,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
         JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60,100,150,20);
         lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(220, 100, 150, 25);      
        add(crollno);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,150,150,20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbldate);
        
            
           dcdate = new JDateChooser();
           dcdate.setBounds(220,150, 150, 25);
           add(dcdate);
           
             JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,200,150,20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(220, 200, 150, 25); 
        ctime.add("Fullday");
        ctime.add("Halfday");
        add(ctime);
        
           
           submit= new JButton("submit");
           submit.setBounds(60,350,100,30);
           submit.setBackground(Color.BLACK);
           submit.setForeground(Color.WHITE);
           submit.addActionListener(this);
           submit.setFont(new Font("Tahoma", Font.BOLD,16));
           add(submit);
        
         cancel= new JButton("Cancel");
         cancel.setBounds(300,350,100,30);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.addActionListener(this);
         cancel.setFont(new Font("Tahoma", Font.BOLD,16));
         add( cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
             String rollno= crollno.getSelectedItem();
             String date= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
             String duration = ctime.getSelectedItem();
             
             String query = "Insert into studentleave values ('"+rollno+"', '"+date+"', '"+duration+"')";
             try{
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Leave Confirmed");
                 setVisible(false);
             }catch(Exception e){
                e.printStackTrace(); 
             }
         }else{
             setVisible(false);
         }
    }
    
    public static void main(String[] args){
       
        new StudentLeave();
    }
}
