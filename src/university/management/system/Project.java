package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    
    Project(){
        setSize(1540,850);
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LU1.jpeg"));
        Image i2= i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        //Information
        JMenu Information = new JMenu("New Information");
        Information.setForeground(Color.BLUE);
        mb.add(Information);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        Information.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        Information.add(studentInfo);
        
         //Details   
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        //Leave
        
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        //Leave Details
        
        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.RED);
        mb.add(leavedetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);
        
        //Exams
        
        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.BLUE);
        mb.add(Exam);
        
        JMenuItem Examdetails = new JMenuItem("Examination Results");
        Examdetails.setBackground(Color.WHITE);
         Examdetails.addActionListener(this);
        Exam.add(Examdetails);
        
        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        Exam.add(EnterMarks);
        
        //UpdateInfo
        
        JMenu UpdateInfo = new JMenu("Update Details");
        UpdateInfo.setForeground(Color.RED);
        mb.add(UpdateInfo);
        
        JMenuItem UpdateFacultyInfo = new JMenuItem("Update Faculty Details");
        UpdateFacultyInfo.setBackground(Color.WHITE);
        UpdateFacultyInfo.addActionListener(this);
        UpdateInfo.add(UpdateFacultyInfo);
        
        JMenuItem UpdateStudentsInfo = new JMenuItem("Update Student Details");
        UpdateStudentsInfo.setBackground(Color.WHITE);
         UpdateStudentsInfo.addActionListener(this);
        UpdateInfo.add(UpdateStudentsInfo );
        
        //Fees
        
        JMenu Fee = new JMenu("Fee Details");
        Fee.setForeground(Color.BLUE);
        mb.add(Fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        Fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Studetn Fee Form");
        feeform.setBackground(Color.WHITE);
             feeform.addActionListener(this);
        Fee.add(feeform);
        
         //Utility
        
        JMenu Utility = new JMenu("Utility");
        Utility.setForeground(Color.RED);
        mb.add(Utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        Utility.add(calc);
        
        //exit
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
       
        setJMenuBar(mb);
        
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String msg= ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc");
            }catch (Exception e){
              e.printStackTrace();  
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad");
            }catch (Exception e){
                 e.printStackTrace();  
            }
        }else if (msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if (msg.equals("New Student Information")){
           new AddStudent();
        }else if (msg.equals("View Faculty Details")){
           new TeacherDetails();
        }else if (msg.equals("View Student Details")){
           new StudentDetails();
        }else if (msg.equals("Faculty Leave")){
           new TeacherLeave();
        }else if (msg.equals("Student Leave")){
           new StudentLeave();
        }else if (msg.equals("Faculty Leave Details")){
           new TeacherLeaveDetails();
        }else if (msg.equals("Student Leave Details")){
           new StudentLeaveDetails();
        }else if (msg.equals("Update Faculty Details")){
           new UpdateTeacher();
        }else if (msg.equals("Update Student Details")){
           new UpdateStudent();
        }else if (msg.equals("Enter Marks")){
           new EnterMarks();
        }else if (msg.equals("Examination Results")){
           new ExaminationDetails();
    }else if (msg.equals("Fee Structure")){
           new FeeStructure();
    }else if (msg.equals("Student Fee Form")){
           new StudentFeeForm();
   }
  }
   
        
     public static void main(String[] args){
        new Project();
    }
}
