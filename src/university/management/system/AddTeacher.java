package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname, tffname,tfaddress, tfphone, tfemail, tfx, tfxii,tfnid;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbdept,cbqlfc;
    JButton submit,cancel;
    
    Random ran = new Random();
    long first4 = Math.abs(ran.nextLong() % 9000L) + 1000L;

    
       AddTeacher(){
           setSize(900, 700);
           setLocation(350, 50);
           
           setLayout(null);
           
           JLabel heading = new JLabel("New Teacher Details");
           heading.setBounds(310, 30, 500, 50);
           heading.setFont(new Font("serif", Font.BOLD, 30));
           add(heading);
           
            JLabel lblname = new JLabel("Name");
           lblname.setBounds(50, 150, 100, 30);
           lblname.setFont(new Font("serif", Font.BOLD, 20));
           add(lblname);
           
           tfname= new JTextField();
           tfname.setBounds(200, 150, 150, 30);
           add(tfname);
           
           JLabel lblfname = new JLabel("Father's Name");
           lblfname.setBounds(400, 150, 200, 30);
           lblfname.setFont(new Font("serif", Font.BOLD, 20));
           add(lblfname);
           
           tffname= new JTextField();
           tffname.setBounds(600, 150, 150, 30);
           add(tffname);
           
           JLabel lblempid = new JLabel("Employee Number");
           lblempid.setBounds(50, 200, 200, 30);
           lblempid.setFont(new Font("serif", Font.BOLD, 20));
           add(lblempid);
          
            
           labelempid = new JLabel("101" + first4);
           labelempid.setBounds(250, 200, 200, 30);
           labelempid.setFont(new Font("serif", Font.BOLD, 20));
           add(labelempid);
           
           JLabel lbldob = new JLabel("Date of Birth");
           lbldob.setBounds(400, 200, 200, 30);
           lbldob.setFont(new Font("serif", Font.BOLD, 20));
           add(lbldob);
           
           dcdob = new JDateChooser();
           dcdob.setBounds(600,200, 150, 30);
           add(dcdob);
           
            JLabel lbladdress = new JLabel("Address");
           lbladdress.setBounds(50, 250, 200, 30);
           lbladdress.setFont(new Font("serif", Font.BOLD, 20));
           add(lbladdress);
           
           tfaddress= new JTextField();
           tfaddress.setBounds(200, 250, 150, 30);
           add(tfaddress);
           
           JLabel lblphone = new JLabel("Phone");
           lblphone.setBounds(400, 250, 200, 30);
           lblphone.setFont(new Font("serif", Font.BOLD, 20));
           add(lblphone);
           
           tfphone= new JTextField();
           tfphone.setBounds(600, 250, 150, 30);
           add(tfphone);
           
             JLabel lblemail = new JLabel("Email");
           lblemail.setBounds(50, 300, 200, 30);
           lblemail.setFont(new Font("serif", Font.BOLD, 20));
           add(lblemail);
           
           tfemail= new JTextField();
           tfemail.setBounds(200, 300, 150, 30);
           add(tfemail);
           
           JLabel lblx = new JLabel("Class X (%)");
           lblx.setBounds(400, 300, 200, 30);
           lblx.setFont(new Font("serif", Font.BOLD, 20));
           add(lblx);
           
           tfx= new JTextField();
           tfx.setBounds(600, 300, 150, 30);
           add(tfx);
           
             JLabel lblxii = new JLabel("Class XII (%)");
           lblxii.setBounds(400, 350, 200, 30);
           lblxii.setFont(new Font("serif", Font.BOLD, 20));
           add(lblxii);
           
           tfxii= new JTextField();
           tfxii.setBounds(600, 350, 150, 30);
           add(tfxii);
           
              JLabel lblnid = new JLabel("NID NO");
           lblnid.setBounds(50, 350, 200, 30);
           lblnid.setFont(new Font("serif", Font.BOLD, 20));
           add(lblnid);
           
           tfnid= new JTextField();
           tfnid.setBounds(200, 350, 150, 30);
           add(tfnid);
           
           
                 JLabel lblqlc = new JLabel("Qualification");
           lblqlc.setBounds(50, 400, 200, 30);
           lblqlc.setFont(new Font("serif", Font.BOLD, 20));
           add(lblqlc);
           
           
           String qualification[] = {"BSc","MSc","BBA","MBA","BA","MA","BCOM","MCOM"};
           cbqlfc= new JComboBox(qualification);
           cbqlfc.setBounds(200,400,150,30);
           cbqlfc.setBackground(Color.WHITE);
           add(cbqlfc);
           
            
             JLabel lbldept = new JLabel("Department");
           lbldept.setBounds(400, 400, 200, 30);
           lbldept.setFont(new Font("serif", Font.BOLD, 20));
           add(lbldept);
           

           String department[] = {"CSE","EEE","CIVIL","ARCHITECHTURE","THM","BBA","LAW","ENGLISH","IS"};
           cbdept= new JComboBox(department);
           cbdept.setBounds(600,400,150,30);
           cbdept.setBackground(Color.WHITE);
           add(cbdept);
             
           
           submit= new JButton("submit");
           submit.setBounds(250,550,120,30);
           submit.setBackground(Color.BLACK);
           submit.setForeground(Color.WHITE);
           submit.addActionListener(this);
           submit.setFont(new Font("Tahoma", Font.BOLD,16));
           add(submit);
        
         cancel= new JButton("Cancel");
         cancel.setBounds(450,550,120,30);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.addActionListener(this);
         cancel.setFont(new Font("Tahoma", Font.BOLD,16));
         add( cancel);
           
           setVisible(true);
       }
       public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==submit){
              String name= tfname.getText();
              String fname=tffname.getText();
              String empid= labelempid.getText();
              String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
              String address= tfaddress.getText();
              String phone = tfphone.getText();
              String email = tfemail.getText();
              String x = tfx.getText();
              String xii = tfxii.getText();
              String nid = tfnid.getText();
              String qlc = (String) cbqlfc.getSelectedItem();
              String dept = (String) cbdept.getSelectedItem();
              
              try{
                  String query = "Insert into teacher values('"+name+"', '"+fname+"', '"+empid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"','"+x+"','"+xii+"', '"+nid+"','"+qlc+"','"+dept+"')";
                  Conn con =new Conn();
                  con.s.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                  setVisible(false);
                  
              }catch(Exception e){
                  e.printStackTrace();
              }
              
              
           }else{
               setVisible(false);
           }
       }
    
    public static void main(String[] args){
        
     
        new AddTeacher();
    }
}
