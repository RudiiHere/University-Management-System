package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice empid;
    JTable table;
    JButton search, add, print, update, cancel;
    
    TeacherDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,30,150,20);
        add(heading);
        
        empid = new Choice();
        empid.setBounds(180, 30, 150, 20);
        add(empid);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            while(rs.next()){
                empid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(120,70,80,20);
        search.addActionListener(this);
        add(search); 
        
          print = new JButton("Print");
        print.setBounds(220,70,80,20);
      print.addActionListener(this);
        add(print);
        
          add = new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);
        
          update = new JButton("Update");
        update.setBounds(420,70,80,20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(20,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900, 700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query ="Select * from teacher where empid= '"+empid.getSelectedItem()+"'";
            try{
                Conn c= new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
                
            
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
              e.printStackTrace();  
            }
        }else if(ae.getSource()==add){
            setVisible(false);
            new AddTeacher();
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateTeacher();
        }else{
            setVisible(false);
        }
        
    }
    
    
    public static void main(String[] args){
        new TeacherDetails();
    }
}
