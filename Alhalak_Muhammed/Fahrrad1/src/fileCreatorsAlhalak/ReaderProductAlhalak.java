package fileCreatorsAlhalak;

import java.io.IOException;

public abstract class ReaderProductAlhalak {
	public abstract String [] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
