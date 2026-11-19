package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsAlhalak.ReaderConcreteCreatorAlhalak_AB;
import fileCreatorsAlhalak.ReaderCreatorAlhalak;
import fileCreatorsAlhalak.ReaderProductAlhalak;

public class FahrradModel {
	private Fahrrad fahrrad;

	public Fahrrad getFahrrad() {
		return fahrrad;
	}

	public void setFahrrad(Fahrrad fahrrad) {
		this.fahrrad = fahrrad;
	}
	
	public void leseAusDatei(String typ) throws IOException{
		ReaderCreatorAlhalak creatorAlhalak= new ReaderConcreteCreatorAlhalak_AB();
		ReaderProductAlhalak productAlhalak = creatorAlhalak.factoryMethod(typ);
		
		String [] zeile= productAlhalak.leseAusDatei();
			this.fahrrad = new Fahrrad(zeile[0], 
  					zeile[1], 
  					zeile[2], 
  					zeile[3].charAt(0), 
  					zeile[4].split("_"));
				
			productAlhalak.schliesseDatei();
		
	}

			
		public void schreibeFahrraederInCsvDatei() throws IOException {
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("FahrraederAusgabe.csv", true));
				aus.write(fahrrad.gibFahrradZurueck(';'));
				aus.close();
		}
}
