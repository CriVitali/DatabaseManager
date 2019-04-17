package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import application.model.Amico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.DatePicker;

public class SampleController {

	@FXML
	private TextField idInsert;
	@FXML
	private TextField cognomeInsert;
	@FXML
	private TextField nomeInsert;
	@FXML
	private DatePicker dataInsert;
	@FXML
	private TableView<Amico> personData;
	@FXML
	private TableColumn<Amico, Integer> colonnaId;
	@FXML
	private TableColumn<Amico, String> colonnaNome;
	@FXML
	private TableColumn<Amico, String> colonnaCognome;
	@FXML
	private TableColumn<Amico, LocalDate> colonnaData;

	// Initiialize observableList to hold out database data
	private ObservableList<Amico> amiciObserv;
	private ConnectionClass dc;

	@FXML
	private void initialize() {

		dc = new ConnectionClass();
		aggiornaDatabase();

	}

	// Event Listener on Button.onAction
	@FXML
	public void insertButton(ActionEvent event) throws SQLException {

		ConnectionClass connectionClass = new ConnectionClass();
		Connection cn = connectionClass.getConnection();

		// prendere valori da campi testo
		String id = idInsert.getText();
		String nome = nomeInsert.getText();
		String cognome = cognomeInsert.getText();
		LocalDate ld = dataInsert.getValue();

		String sqlData = ld.toString();
		String sql = "INSERT INTO amici (id, nome, cognome, dataNascita) " + "VALUES ('" + id + "','" + nome + "','"
				+ cognome + "','" + sqlData + "')";

		Statement st = cn.createStatement();
		st.execute(sql);
		cn.close();
		aggiornaDatabase();

		// azzera i campi
		idInsert.setText("");
		nomeInsert.setText("");
		cognomeInsert.setText("");
		dataInsert.setValue(null);

	}

	// Event Listener on Button.onAction
	@FXML
	public void updataButton(ActionEvent event) throws SQLException {

		ConnectionClass connectionClass = new ConnectionClass();
		Connection cn = connectionClass.getConnection();

		// prendere valori da campi testo
		String id = idInsert.getText();
		String nome = nomeInsert.getText();
		String cognome = cognomeInsert.getText();
		LocalDate ld = dataInsert.getValue();

		String sqlData = ld.toString();
		String sql = "UPDATE amici SET nome = '" + nome + "', cognome = '" + cognome + "', dataNascita='" + sqlData
				+ "' WHERE id=" + id;

		Statement st = cn.createStatement();
		st.execute(sql);
		cn.close();
		aggiornaDatabase();

		// azzera i campi
		idInsert.setText("");
		nomeInsert.setText("");
		cognomeInsert.setText("");
		dataInsert.setValue(null);
	}

	// Event Listener on Button.onAction
	@FXML
	public void DeleteButton(ActionEvent event) throws SQLException {

		ConnectionClass connectionClass = new ConnectionClass();
		Connection cn = connectionClass.getConnection();

		// prendere valori da campi testo
		String id = idInsert.getText();
		String sql = "DELETE FROM amici WHERE id =" + id;

		Statement st = cn.createStatement();
		st.execute(sql);
		cn.close();
		aggiornaDatabase();

		// azzera i campi
		idInsert.setText("");
		nomeInsert.setText("");
		cognomeInsert.setText("");
		dataInsert.setValue(null);
	}

	public void aggiornaDatabase() {

		Connection cn = dc.getConnection();
		amiciObserv = FXCollections.observableArrayList();

		String sql = "SELECT * FROM amici;";
		ResultSet rs;
		try {
			rs = cn.createStatement().executeQuery(sql);

			while (rs.next()) {

				amiciObserv.add(new Amico(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"),
						rs.getDate("dataNascita").toLocalDate()));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// set cell value factory to tableview
		colonnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colonnaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colonnaCognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
		colonnaData.setCellValueFactory(new PropertyValueFactory<>("data"));

		personData.setItems(amiciObserv);

	}
}
