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
        		+ "values ('"+ id + "','" + nome + "','" + cognome + "','" + sqlData+"')";
        
        Statement statement = connection.createStatement();
        statement.execute(sql);
        avvisoText.setText("Elemento inserito con successo! ["
        		          + id + "," + nome + "," + cognome + "," + sqlData+"]");
    	
	}
	// Event Listener on Button.onAction
	@FXML
	public void updataButton(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void DeleteButton(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void VisualizzaButton(ActionEvent event) {
		// TODO Autogenerated
	}
}
