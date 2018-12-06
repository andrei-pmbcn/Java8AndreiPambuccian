/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andrei
 */
public class TestDatabases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String user = "test"; 
        String password = "password"; 
        String url1 = "jdbc:derby:firstdb;create=true"; 
        String url2 = "jdbc:derby://localhost:1527/seconddb;create=true";
        String driver = "org.apache.derby.jdbc.ClientDataSource40"; 
        Connection connection = null; 
        Statement statement = null;
        ResultSet resultSet = null; 
        try 
        { 
            Class driverClass = Class.forName(driver); 
            connection = DriverManager.getConnection(url1, user, password);
            statement = connection.createStatement();
            DatabaseUtil.dropTableIfExists(connection, statement, "FIRSTTABLE");
            statement.execute("CREATE TABLE FIRSTTABLE (ID INT PRIMARY KEY, NAME VARCHAR(24))");
            statement.execute("INSERT INTO FIRSTTABLE VALUES (10,'TEN'),(20,'TWENTY'),(30,'THIRTY')");
            resultSet = statement.executeQuery("SELECT * FROM FIRSTTABLE");
            DatabaseUtil.printResultSet(resultSet);
            DatabaseUtil.closeAll(connection, statement, resultSet);
            
            System.out.println();
            connection = DriverManager.getConnection(url2, user, password);
            statement = connection.createStatement();
            DatabaseUtil.dropTableIfExists(connection, statement,"SECONDTABLE");
            statement.execute("CREATE TABLE SECONDTABLE (ID INT PRIMARY KEY, NAME VARCHAR(24))");
            statement.execute("INSERT INTO SECONDTABLE VALUES (100,'ONE HUNDRED'),(200,'TWO HUNDRED'),(300,'THREE HUNDRED')");
            resultSet = statement.executeQuery("SELECT * FROM SECONDTABLE");
            DatabaseUtil.printResultSet(resultSet);
            //DatabaseUtil.closeAll(connection, statement, resultSet);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        } finally {
            DatabaseUtil.closeAll(connection, statement, resultSet);
        }
    }
    
}
