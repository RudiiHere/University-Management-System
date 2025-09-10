package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbdept,cbsemester;
    JLabel labeltotal;
    JButton update, pay, back;

    StudentFeeForm() {
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
        
                  JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
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
           
            JLabel lblname = new JLabel("Name");
           lblname.setBounds(40, 100, 150, 20);
           lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
           add(lblname);
           
           JLabel labelname= new JLabel();
           labelname.setBounds(200, 100, 150, 20);
           labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
           add(labelname);
           
           JLabel lblfname = new JLabel("Father's Name");
           lblfname.setBounds(40, 140, 150, 20);
           lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
           add(lblfname);
           
           JLabel labelfname= new JLabel();
           labelfname.setBounds(200, 140, 150, 20);
           labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
           add(labelfname);
           
        try{
             Conn c=new Conn();
             String query = "Select * from student where rollno='"+crollno.getSelectedItem()+"'";
             ResultSet rs = c.s.executeQuery(query);
             while(rs.next()){
             labelname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
           
             }
                   
                      
           } catch(Exception e){
               e.printStackTrace();
           } 
         crollno.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ie){
                 
               try{
             Conn c=new Conn();
             String query = "Select * from student where rollno='"+crollno.getSelectedItem()+"'";
             ResultSet rs = c.s.executeQuery(query);
             while(rs.next()){
             labelname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
      
             }
                   
                      
           } catch(Exception e){
               e.printStackTrace();
           } 
              
              }
          });
            
             JLabel lbldept = new JLabel("Department");
           lbldept.setBounds(40, 180, 150, 20);
           lbldept.setFont(new Font("Tahoma", Font.BOLD, 16));
           add(lbldept);
           
           String department[] = {"CSE","EEE","CIVIL","ARCHITECHTURE","THM","BBA","LAW","ENGLISH","IS"};
           cbdept= new JComboBox(department);
           cbdept.setBounds(200,180,150,25);
           cbdept.setBackground(Color.WHITE);
           add(cbdept);
           
               JLabel lblsemester = new JLabel("Semester");
          lblsemester.setBounds(40,220,150,20);
            lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
          add(lblsemester);
          
          String semester[]= {"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
          cbsemester= new JComboBox(semester);
          cbsemester.setBounds(200, 220, 150, 20);
          cbsemester.setBackground(Color.WHITE);
          add(cbsemester);
        
                   JLabel lbltotal = new JLabel("Total Payable");
           lbltotal.setBounds(40, 250, 150, 20);
           lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
           add(lbltotal);
           
                  
                 labeltotal = new JLabel();
           labeltotal.setBounds(200, 250, 150, 20);
           labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
           add(labeltotal);
           
                update = new JButton("Update");
         update.setBounds(30,380,100,20);
         update.setBackground(Color.BLACK);
         update.setForeground(Color.WHITE);
         update.addActionListener(this);
         add(update); 
        
          pay = new JButton("Pay");
         pay.setBounds(150,380,100,20);
         pay.setBackground(Color.BLACK);
         pay.setForeground(Color.WHITE);
         pay.addActionListener(this);
         add(pay);
        
          back = new JButton("Back");
          back.setBounds(270,380,80,20);
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);

          back.addActionListener(this);
          add(back);
             


        setVisible(true);
    }
    
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == update) {
        String course = (String) cbdept.getSelectedItem();
        String semester = (String) cbsemester.getSelectedItem();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee where course = '" + course + "'");
            while(rs.next()) {
                labeltotal.setText(rs.getString(semester));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == pay) {
        String rollno= crollno.getSelectedItem();
         String course = (String) cbdept.getSelectedItem();
        String semester = (String) cbsemester.getSelectedItem();
        String total= labeltotal.getText();
        try {
            Conn c = new Conn();
            String query= "Insert into collegefee values ('"+rollno+"','"+course+"','"+semester+"','"+total+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "College fee submitted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}
     public static void main(String[] args) {
            new StudentFeeForm();
       }

}