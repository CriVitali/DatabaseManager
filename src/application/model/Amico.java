package application.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Amico {

	private final IntegerProperty id;
	private final StringProperty nome;
	private final StringProperty cognome;
	private final ObjectProperty<LocalDate> data;

	public Amico(int id, String nome, String cognome, LocalDate date) {

		this.id = new SimpleIntegerProperty(id);
		this.nome = new SimpleStringProperty(nome);
		this.cognome = new SimpleStringProperty(cognome);
		this.data = new SimpleObjectProperty<LocalDate>(date);
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public String getCognome() {
		return cognome.get();
	}

	public void setCognome(String cognome) {
		this.cognome.set(cognome);
	}

	public StringProperty cognomeProperty() {
		return cognome;
	}

	public LocalDate getData() {
		return data.get();
	}

	public void setData(LocalDate data) {
		this.data.set(data);
	}

	public ObjectProperty<LocalDate> dataProperty() {
		return data;
	}

}