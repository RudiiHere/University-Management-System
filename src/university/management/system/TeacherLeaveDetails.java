package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
    
    Choice cempid;
    JTable table;
    JButton search,  print,  cancel;
    
    TeacherLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,30,150,20);
        add(heading);
        
        cempid = new Choice();
        cempid.setBounds(180, 30, 150, 20);
        add(cempid);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacher");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select * from teacherleave");
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
        
    
        cancel = new JButton("Cancel");
        cancel.setBounds(320,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900, 700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query ="Select * from teacherleave where empid= '"+cempid.getSelectedItem()+"'";
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
        }else{
            setVisible(false);
        }
        
    }

    
    
    
    
    public static void main(String[] args){
        new TeacherLeaveDetails();
    }
}
