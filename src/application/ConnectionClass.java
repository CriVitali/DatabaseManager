package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	
    public Connection connection;
    public  Connection getConnection(){


        String dbName="test";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"?user="+userName+"&"+"password="+password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}
