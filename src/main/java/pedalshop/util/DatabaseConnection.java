/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedalshop.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Jacob
 */
public final class DatabaseConnection {
    //jdbc:derby://localhost:1527/pedalSHOP;create=true;user=root;password=derby;

    private static final String CREATE_URL;
    private static final String URL;
    private static final String DRIVER;
    private static final String USER;
    private static final String PASSWORD;

    static {
        ResourceBundle properties = ResourceBundle.getBundle("config");
        CREATE_URL = properties.getString("CREATE_URL");
        URL = properties.getString("URL");
        DRIVER = properties.getString("DRIVER");
        USER = properties.getString("USER");
        PASSWORD = properties.getString("PASSWORD");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException x) {
            System.out.println(String.format("%s: %s", Util.DATABASE_ERROR, x));
        }
    }

    private DatabaseConnection() {//SUCH A DISSAPOINTMENT, JAVA DOES NOT TRULY HAVE AN EQUIVALENT OF INTERNAL(C#) 
        //SINCE NOT SPECIFYING A ACCESSMODIFIER MAKES IT PACKAGE SCOPED NOT INVISIBLE LIKE INTERNAL, THE CLOSEST WE'LL GET IS USING PRIVATE
        //THEN AGAIN IT ISN'T THE SAME
    }

    /*public static DatabaseConnection getInstance(){
    return DatabaseConnectionHolder.INSTATNCE;
    }
    
    static class DatabaseConnectionHolder {
    static DatabaseConnection INSTATNCE = new DatabaseConnection();
    }*/
    public static Connection getConnection() {
        Connection conn = null;
        Statement st = null;
        try {
            System.out.println(Util.CONNECTING_TO_DATABASE);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            /*st = conn.createStatement();
            try {
            //st.execute(Files.readAllLines(Paths.get("src/main/resources/schema.sql")).stream().collect(Collectors.joining()));
            String sql = Files.readAllLines(Paths.get("src/main/resources/schema.sql")).stream().collect(Collectors.joining());
            String[] commands = sql.split(";");
            for(String s : commands){
            System.out.println(s);
            st.execute(s);//.stream().collect(Collectors.joining()));
            }
            
            } catch (IOException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            System.out.println(Util.CONNECTION_SUCCESS);
        } catch (SQLException x) {
            System.out.printf("%s: %s\n", Util.DATABASE_CONNECTION_ERROR, x);
            //8001 DATABASE NOT FOUND?
            //System.out.println(String.format("%s: %s - ERROR CODE: %d STATE: %s", Util.DATABASE_ERROR, x, x.getErrorCode(), x.getSQLState()));
            if (x.getSQLState().equals(Util.DATABASE_NOT_FOUND_CODE)) {
                System.out.printf("%s. %s\n", Util.DATABASE_NOT_FOUND, Util.CREATING_SCHEMA);
                //Statement st = null;
                try {
                    conn = DriverManager.getConnection(CREATE_URL, USER, PASSWORD);
                    st = conn.createStatement();
                    String sql = Files.readAllLines(Paths.get("src/main/resources/schema.sql")).stream().collect(Collectors.joining());
                    String[] commands = sql.split(";");
                    for(String s : commands){
                        System.out.println(s);
                        st.execute(s);//.stream().collect(Collectors.joining()));
                    }
                    System.out.println(Util.CONNECTION_SUCCESS);
                } catch (SQLException x2) {
                    System.out.printf("%s: %s\n", Util.DATABASE_ERROR, x2);
                } catch (IOException x2) {
                    System.out.printf("%s: %s\n", Util.IO_ERROR, x2);
                } finally {
                    try {
                        if (st != null && !st.isClosed()) {
                            st.close();
                        }
                    } catch (SQLException x2) {
                        System.out.printf("%s: %s\n", Util.DATABASE_ERROR, x2);
                    }
                }
            }
        }
        return conn;
    }
}
