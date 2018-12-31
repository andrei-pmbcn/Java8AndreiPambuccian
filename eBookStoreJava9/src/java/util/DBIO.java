/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andrei
 */
public class DBIO {
    private final String user = "test";
    private final String password = "password";
    private final String url = "jdbc:derby:bookdb;create=true"; 
    private final String driver = "org.apache.derby.jdbc.ClientDataSource40";
    private final String sqlFilePath = "/home/andrei/NetBeansProjects/Java9AndreiPambuccian/eBookStoreJava9/web/dbdesign/createdb.sql";
    protected Connection connection = null; 
    protected Statement statement = null;
    protected ResultSet resultSet = null; 
    protected String query = "";
    
    public void connect() {
        try 
        {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        DBIO dbio = new DBIO();
        dbio.connect();
        dbio.createDB();
    
        //System.out.println("**********");
        //dbio.listStocks();
        //System.out.println("**********");
        //dbio.listDeliveredPaid();
        //System.out.println("**********");
        //dbio.listDeliveredUnpaid();
        
        
    }
    
    public void createDB() {
        try 
        { 
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            dropTableIfExists("EBOOKS", "EBOOKS_AUTHORS");
            dropTableIfExists("EBOOKS", "EBOOKS_RATINGS_USERS");
            dropTableIfExists("EBOOKS", "EBOOKS");
            dropTableIfExists("EBOOKS", "BOOK_TYPES");
            dropTableIfExists("EBOOKS", "USERS");
            dropTableIfExists("EBOOKS", "ROLES");
            dropTableIfExists("EBOOKS", "BOOK_PAPER_QUALITIES");
            dropTableIfExists("EBOOKS", "RATINGS");
            dropTableIfExists("EBOOKS", "BOOK_GENRES");
            dropTableIfExists("EBOOKS", "BOOK_AUTHOR");
            dropTableIfExists("EBOOKS", "ORDERS");
            
            StringBuffer strbuf = new StringBuffer();
            FileReader freader = null;
            try {
                freader = new FileReader(sqlFilePath);
                BufferedReader breader = new BufferedReader(freader);
                char[] buf = new char[1024];
                int numRead = 0;
                while ((numRead = breader.read(buf)) != -1) {
                    strbuf.append(String.valueOf(buf, 0, numRead));
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } finally {
                try {
                    freader.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            String[] strs = strbuf.toString().split(";");
            
            for (int i = 0; i < strs.length - 1; i++) {
                statement.execute(strs[i]);
            }
                        
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
/*
eBook/iBook defined by:

    ISBN EPUB/PDF as primary key (where EPUB is present it will be chosen)
    List of authors (peers Username, Password)
    List of ratings (integers from one to five) 
    Price

            
Also persistent support in DB will be created for:

    Authenticated and authorised users
    Archive of all orders (new, in progress, delivered, rejected as status)


As reports we need to be able to generate in real time:

    Stocks
    Delivered and payed (sales)
    Delivered but not payed 
*/        

    public ResultSet getResultSet() {
        return this.resultSet;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
    
    public String getQuery() {
        return this.query;
    }

    public ResultSet runQuery(String query) {
        if (query == "") {
            query = this.query;    
        }
        
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            System.out.println("SQL exception: " + ex);
            return null;
        }
    }   
    
    public void printQuery(String query) {
        if (query == "") {
            query = this.query;    
        }
        
        try {
            resultSet = statement.executeQuery(query);
            printResultSet();
        } catch (SQLException ex) {
            System.out.println(ex);            
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                System.out.println(ex);            
            }
        }
    }
    
    public void listStocks() {
        query = "SELECT ISBN, DENUMIRE, STOCKS FROM EBOOKS.EBOOKS";
    }
  
    public void listDeliveredPaid() {
        query = "SELECT EBOOKS.EBOOKS.ISBN, EBOOKS.EBOOKS.DENUMIRE "
                + "FROM EBOOKS.EBOOKS INNER JOIN EBOOKS.ORDERS "
                + "ON EBOOKS.EBOOKS.ISBN = EBOOKS.ORDERS.ID_ISBN "
                + "WHERE EBOOKS.ORDERS.STATUS = 'delivered' "
                + "AND EBOOKS.ORDERS.PAID = TRUE";
    }

    public void listDeliveredUnpaid() {
        query = "SELECT EBOOKS.EBOOKS.ISBN, EBOOKS.EBOOKS.DENUMIRE "
                + "FROM EBOOKS.EBOOKS INNER JOIN EBOOKS.ORDERS "
                + "ON EBOOKS.EBOOKS.ISBN = EBOOKS.ORDERS.ID_ISBN "
                + "WHERE EBOOKS.ORDERS.STATUS = 'delivered' "
                + "AND EBOOKS.ORDERS.PAID = FALSE";
    }
    
    void dropTableIfExists(String schemaName, String tableName) throws SQLException {
        try {
            resultSet = connection.getMetaData().getTables(null, schemaName, tableName, null);
            if (resultSet.next()) {
                statement.execute("DROP TABLE " + schemaName + "." + tableName);
                //System.out.println("dropped table " + tableName);
            }
        } catch (SQLException ex) {
            if (!ex.getSQLState().equals("proper SQL-state for table does not exist")) {
                throw ex; 
            }
        }
    }
            
    public void closeAll() {
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
    
    void printResultSet() {
        try {
            int nColumns = resultSet.getMetaData().getColumnCount();
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

