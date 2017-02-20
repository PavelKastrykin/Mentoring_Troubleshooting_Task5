import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		File file = new File(classloader.getResource("Data.txt").getFile());

		BufferedReader reader;
		String line;
		List<String> fileContent = new ArrayList<String>();
		List<String> fileContentCut = new ArrayList<String>();

		while (true) {

			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			try {
				while ((line = reader.readLine()) != null) {
					fileContent.add(line);
				}
			} finally {
				reader.close();
			}

			for (String string : fileContent) {
				fileContentCut.add(string.substring(0, 3));
			}
			fileContent.clear();
			fileContentCut.clear();
		}
	}
}
