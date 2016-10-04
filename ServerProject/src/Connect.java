


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Connect {
    public static Connection ConnectDB()
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Project","postgres","dungnhi");
                return con;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Connection:"+ex);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class:"+ex);
        }
        return null;
    }
}
