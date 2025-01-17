
package project.d.kost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    private static Connection mysqlconfig;
    public static Connection getConnection() throws SQLException{
        try {
            String url="jdbc:mysql://localhost:3306/dbkost"; 
            String user="root"; 
            String pass=""; 
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());  
            mysqlconfig=DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("Koneksi gagal " + e.getMessage());
        }
        
        return mysqlconfig;
    }
}
