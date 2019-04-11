package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleController {
	
	public TextField textField;
    public Label textLabel;

    public void button(ActionEvent actionEvent) throws SQLException {
 
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        String sql="INSERT INTO USER VALUES('"+textField.getText()+"')";
        Statement statement=connection.createStatement();
        statement.executeUpdate(sql);
        textLabel.setText("L'utente "+textField.getText()+" è stato inserito nel database");
        
    }
}
