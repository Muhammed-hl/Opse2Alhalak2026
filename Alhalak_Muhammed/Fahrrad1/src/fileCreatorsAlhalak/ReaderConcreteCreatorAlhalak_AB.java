package fileCreatorsAlhalak;

import java.io.IOException;

public class ReaderConcreteCreatorAlhalak_AB extends ReaderCreatorAlhalak{

	@Override
	public ReaderProductAlhalak factoryMethod(String typ) throws IOException {
		if ("txt".equals(typ)) {
			return new ReaderConcreteProductTxtAlhalak();
		}else if ("csv".equals(typ)) {
			return new ReaderConcreteProductAlhalak();
		}
		return null;
	}

}
