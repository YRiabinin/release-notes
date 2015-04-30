
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

import com.google.api.services.drive.model.File;
import gglconnector.GGLConnector;
import gglconnector.GGLFileManager;

public class Main {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		GGLFileManager fileManager = new GGLFileManager();
		
		fileManager.insertFile(GGLConnector.getDrive(), "TEST DOCUMENT", "document description", "", "text/plain", "document1.txt");
		
		/*List<File> files = fileManager.retrieveAllFiles(GGLConnector.getDrive());
		Iterator<File> iterator = files.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}*/
	}

}