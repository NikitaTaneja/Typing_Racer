import java.sql.*;

public class DB_ref
{
    // varaibles
    private java.sql.Connection con=null;

    //constructor
    DB_ref(String name)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+name,"root","");
        }
        catch(Exception e)
        {
            System.out.println("exp in connect_to_db : "+e);
        }
    }
    // method for queries
    private ResultSet selectfrom(String TableName,String whattosel,String condi)
    {
          ResultSet rs=null;
         try
         {
             Statement stmt = con.createStatement();
             rs = stmt.executeQuery("SELECT "+whattosel+ " from "+TableName +" where "+condi);
         }
         catch(Exception e)
         {
             System.out.println("Exception in selectfrom : "+e);
         }
         return rs;
      }
    public boolean checkmypass(String username,String password)
    {
        System.out.println("un = "+username+" pw = "+password);
        String s=null;
        try 
        {
            ResultSet rs = selectfrom("fan","password","username = '"+username+"'");
            rs.next();
            s = rs.getString(1);
        }
        catch(Exception e)
        {
            System.out.println("Exp in checkmypass : "+e);
        }
        return password.equals(s);
    }
    public void insertinto(String TableName,String x,String y)
    {
        // x = "(regno,name)"
        // y = "(20158007,'smit')"
      try
      {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into "+TableName+x+" values"+y);
      }
      catch(Exception e)
      {
          System.out.println("exp in inserinto : "+e);
      }
    }
}
