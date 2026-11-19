package fileCreatorsAlhalak;

import java.io.IOException;

public abstract class ReaderCreatorAlhalak {
	public abstract ReaderProductAlhalak factoryMethod(String typ) throws IOException;
}
