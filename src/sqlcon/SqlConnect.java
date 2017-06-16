
package sqlcon;
import java.sql.*;

public class SqlConnect 
{
   public   Connection con ;
   private Statement st;
   private ResultSet rs;
   public  SqlConnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","");
            System.out.println("connection Established");
            st = con.createStatement();
        }
        catch(Exception e)
                {
                    System.out.println("Connection Failed due to : "+e);
                }
    }
  /*  public static void main(String args[])
    {
        sqlconnect c=new sqlconnect();
    }*/
    public void getData()
    {
        try{
            String query = "select * from final";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String nume=rs.getString("Name");
                String user=rs.getString("User");
                System.out.println("Nameee: "+ nume + " " + "ID: " + user);
        }
            
        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }
    }
}
