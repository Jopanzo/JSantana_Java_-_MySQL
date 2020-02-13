/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author johnn
 */

public class SQLProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try 
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1?autoReconnect=true&useSSL=false","root","password!");
            Class.forName("com.mysql.cj.jdbc.Driver");
             stmt = conn.createStatement();
             rs = stmt.executeQuery("SELECT * FROM patientbed");
             while(rs.next())
             {
                 int id = rs.getInt("PatientID");
                 int bed = rs.getInt("BedID");     
        // print the results
        System.out.format("%s, %s\n", id, bed);
             }
             stmt.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            // handle the error         
        }
          catch (Exception ex) {
            // handle the error
        }
        finally 
        {
        if (stmt != null) { stmt.close(); }
        }
    }
    
}
