/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andrei
 */
public class DatabaseUtil {
    static void dropTableIfExists(Connection connection, Statement statement, String tableName) throws SQLException {
        try {
            ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null);
            if (resultSet.next()) {
                statement.execute("DROP TABLE " + tableName);
            }
        } catch (SQLException ex) {
            if (!ex.getSQLState().equals("proper SQL-state for table does not exist")) {
                throw ex; 
            }
        }
    }
            
    static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (Exception ex){System.out.println(ex);}
        }
        if (statement != null)
        {
            try
            {
                statement.close();
            }
            catch (Exception ex){System.out.println(ex);}
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (Exception ex){System.out.println(ex);}
        }
    }
    
    static void printResultSet(ResultSet resultSet) {
        try {
            int nColumns = resultSet.getMetaData().getColumnCount();
            System.out.println("test");
            while(resultSet.next()) {
                for (int kColumn = 1; kColumn <= nColumns; kColumn++) {
                    System.out.print(resultSet.getString(kColumn) + " | ");
                }
                System.out.print('\n');
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }    
}
