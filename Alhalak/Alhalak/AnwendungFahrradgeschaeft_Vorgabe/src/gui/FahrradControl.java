package gui;

import java.io.IOException;

import business.Fahrrad;
import business.FahrradModel;
import javafx.stage.Stage;

public class FahrradControl {
	private FahrradView fahrradView;
	private FahrradModel fahrradModel;
	
	public FahrradControl(Stage stage) {
		fahrradModel = new FahrradModel();
		fahrradView = new FahrradView(stage, this, fahrradModel);
	}

	
	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			fahrradModel.leseAusDatei(typ);
      	  			fahrradView.zeigeInformationsfensterAn(
      	  	   			"Das Fahrrad wurde gelesen!");
      		}
       		else{
	   			fahrradView.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			fahrradView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			fahrradView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeFahrraederInCsvDatei() {
		try {
			fahrradModel.schreibeFahrraederInCsvDatei();
			fahrradView.zeigeInformationsfensterAn(
	   			"Die Fahrraeder wurden gespeichert!");
		}	
		catch(IOException exc){
			fahrradView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			fahrradView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	 public void nehmeFahrradAuf(){
	    	try{ 
	    		Fahrrad fahrrad = new Fahrrad(
	    		fahrradView.getTxtName().getText(), 
	    		fahrradView.getTxtRahmennummer().getText(),
	    		fahrradView.getTxtFahrradtyp().getText(),
	    		fahrradView.getTxtDamenHerrenKinder().getText().charAt(0),
	    		fahrradView.getTxtGroessen().getText().split(";"));
	    		
	    		fahrradModel.setFahrrad(fahrrad);
	    		
	    		fahrradView.zeigeInformationsfensterAn("Das Fahrrad wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		fahrradView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	
}
