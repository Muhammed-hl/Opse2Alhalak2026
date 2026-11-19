package fileCreatorsAlhalak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderConcreteProductTxtAlhalak extends ReaderProductAlhalak {
	private BufferedReader ein;
	
	public ReaderConcreteProductTxtAlhalak() throws IOException {
		this.ein= new BufferedReader(new FileReader("Fahrrad.txt"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String [] ergebnisZeile= new String[5];
		String zeile = ein.readLine();
		int i=0;
		while (i<ergebnisZeile.length) {
			ergebnisZeile[i]=zeile;
			zeile = ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
		
	}

}
