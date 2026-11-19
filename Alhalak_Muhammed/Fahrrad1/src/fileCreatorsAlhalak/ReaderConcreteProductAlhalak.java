package fileCreatorsAlhalak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderConcreteProductAlhalak extends ReaderProductAlhalak {
	private BufferedReader ein;

	public ReaderConcreteProductAlhalak() throws IOException {
		this.ein = new BufferedReader(new FileReader("Fahrrad.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
	}

}
