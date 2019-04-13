package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.DatePicker;

public class SampleController {
	@FXML
	private Label avvisoText;
	@FXML
	private TextField idInsert;
	@FXML
	private TextField cognomeDelete;
	@FXML
	private TextField cognomeUpdate;
	@FXML
	private TextField cognomeInsert;
	@FXML
	private TextField nomeDelete;
	@FXML
	private TextField nomeUpdate;
	@FXML
	private TextField nomeInsert;
	@FXML
	private TextField idDelete;
	@FXML
	private TextField idUpdate;
	@FXML
	private DatePicker dataInsert;
	@FXML
	private DatePicker dataDelete;
	@FXML
	private DatePicker dataUpdate;

	// Event Listener on Button.onAction
    @FXML
	public void insertButton(ActionEvent event) throws SQLException {
		
    	ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        
        // prendere valori da campi testo
        String id = idInsert.getText();
        String nome = nomeInsert.getText();
		String cognome = cognomeInsert.getText();
		LocalDate ld = dataInsert.getValue();
		String sqlData = ld.toString();
		
        String sql="INSERT INTO amici (id, nome, cognome, dataNascita) "
        		 + "VALUES ('"+ id + "','" + nome + "','" + cognome + "','" + sqlData+"')";
        
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
        avvisoText.setText("Elemento inserito con successo! ["
        		          + id + "," + nome + "," + cognome + "," + sqlData+"]");
    	
	}
	// Event Listener on Button.onAction
	@FXML
	public void updataButton(ActionEvent event) throws SQLException {

		ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        
        // prendere valori da campi testo
        String id = idUpdate.getText();
        String nome = nomeUpdate.getText();
		String cognome = cognomeUpdate.getText();
		LocalDate ld = dataUpdate.getValue();
		String sqlData = ld.toString();
		
		String sql = "UPDATE amici SET nome = '" + nome + "', cognome = '" 
					+ cognome + "', dataNascita='" + sqlData + "' WHERE id=" + id ;
        
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
        avvisoText.setText("Elemento modificato con successo! ["
        		          + id + "," + nome + "," + cognome + "," + sqlData+"]");
		
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void DeleteButton(ActionEvent event) throws SQLException {
		
		ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();

        // prendere valori da campi testo
        String id = idDelete.getText();

        System.out.println("id passato" + id);
        String sql = "DELETE FROM amici WHERE id =" + id;
        System.out.println(sql);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
        avvisoText.setText("Elemento cancellato con successo! ["+ id +"]");
		
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void VisualizzaButton(ActionEvent event) {
		
	}
}
