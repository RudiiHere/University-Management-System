package university.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universityManagementSystem","root", "28288346rudro");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
