package gui;

import business.FahrradModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class FahrradView {

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblName = new Label("Name:");
	private Label lblRahmennummer = new Label("Rahmennummer:");
	private Label lblFahrradtyp = new Label("Fahrradtyp:");
	private Label lblDamenHerrenKinder = new Label("Damen/Herren/Kinder:");
	private Label lblGroessen = new Label("Groessen:");
	private TextField txtName = new TextField();
	private TextField txtRahmennummer = new TextField();
	private TextField txtFahrradtyp = new TextField();
	private TextField txtDamenHerrenKinder = new TextField();
	private TextField txtGroessen = new TextField();
	private TextArea txtAnzeige = new TextArea();
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");
	// -------Ende Attribute der grafischen Oberflaeche-------

	// speichert temporaer ein Objekt vom Typ Fahrrad
	private FahrradControl fahrradControl;
	private FahrradModel fahrradModel;

	public FahrradView(Stage primaryStage, FahrradControl fahrradControl, FahrradModel fahrradModel) {
		this.fahrradControl = fahrradControl;
		this.fahrradModel = fahrradModel;

		Scene scene = new Scene(this.pane, 700, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Verwaltung eines Fahrradgeschaefts");
		primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}

	public TextField getTxtName() {
		return txtName;
	}

	public void setTxtName(TextField txtName) {
		this.txtName = txtName;
	}

	public TextField getTxtRahmennummer() {
		return txtRahmennummer;
	}

	public void setTxtRahmennummer(TextField txtRahmennummer) {
		this.txtRahmennummer = txtRahmennummer;
	}

	public TextField getTxtFahrradtyp() {
		return txtFahrradtyp;
	}

	public void setTxtFahrradtyp(TextField txtFahrradtyp) {
		this.txtFahrradtyp = txtFahrradtyp;
	}

	public TextField getTxtDamenHerrenKinder() {
		return txtDamenHerrenKinder;
	}

	public void setTxtDamenHerrenKinder(TextField txtDamenHerrenKinder) {
		this.txtDamenHerrenKinder = txtDamenHerrenKinder;
	}

	public TextField getTxtGroessen() {
		return txtGroessen;
	}

	public void setTxtGroessen(TextField txtGroessen) {
		this.txtGroessen = txtGroessen;
	}

	public FahrradControl getFahrradControl() {
		return fahrradControl;
	}

	public void setFahrradControl(FahrradControl fahrradControl) {
		this.fahrradControl = fahrradControl;
	}

	public FahrradModel getFahrradModel() {
		return fahrradModel;
	}

	public void setFahrradModel(FahrradModel fahrradModel) {
		this.fahrradModel = fahrradModel;
	}

	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblName.setLayoutX(20);
		lblName.setLayoutY(90);
		lblRahmennummer.setLayoutX(20);
		lblRahmennummer.setLayoutY(130);
		lblFahrradtyp.setLayoutX(20);
		lblFahrradtyp.setLayoutY(170);
		lblDamenHerrenKinder.setLayoutX(20);
		lblDamenHerrenKinder.setLayoutY(210);
		lblGroessen.setLayoutX(20);
		lblGroessen.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblName, lblRahmennummer, lblFahrradtyp, lblDamenHerrenKinder,
				lblGroessen);

		// Textfelder
		txtName.setLayoutX(180);
		txtName.setLayoutY(90);
		txtName.setPrefWidth(200);
		txtRahmennummer.setLayoutX(180);
		txtRahmennummer.setLayoutY(130);
		txtRahmennummer.setPrefWidth(200);
		txtFahrradtyp.setLayoutX(180);
		txtFahrradtyp.setLayoutY(170);
		txtFahrradtyp.setPrefWidth(200);
		txtDamenHerrenKinder.setLayoutX(180);
		txtDamenHerrenKinder.setLayoutY(210);
		txtDamenHerrenKinder.setPrefWidth(200);
		txtGroessen.setLayoutX(180);
		txtGroessen.setLayoutY(250);
		txtGroessen.setPrefWidth(200);
		pane.getChildren().addAll(txtName, txtRahmennummer, txtFahrradtyp, txtDamenHerrenKinder, txtGroessen);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menue
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImport);
		this.mnDatei.getItems().add(mnItmTxtImport);
		this.mnDatei.getItems().add(new SeparatorMenuItem());
		this.mnDatei.getItems().add(mnItmCsvExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	public void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.nehmeFahrradAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFahrraederAn();
			}
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.leseAusDatei("csv");
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				fahrradControl.schreibeFahrraederInCsvDatei();
			}
		});
	}

	private void zeigeFahrraederAn() {
		if (fahrradModel.getFahrrad() != null) {
			txtAnzeige.setText(this.fahrradModel.getFahrrad().gibFahrradZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Fahrrad aufgenommen!");
		}
	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

}
