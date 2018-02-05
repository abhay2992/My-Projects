import java.sql.*;
public class InsertRowDemo
{
    public static void main(String[] args)
    {
        try
        {
            int rollno=25;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.137.232:3306/test","root","system");
            System.out.println("Connection Build");
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");
            ResultSet rs=stmt.executeQuery("select * from table_for_jdbc where rollno="+rollno);
            rs.next();
            rs.updateInt("Rollno", 25);
            rs.updateString("Name", "Parwinder123");
            rs.updateString("Marks", "56");
            rs.updateRow();
           // rs.insertRow();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
