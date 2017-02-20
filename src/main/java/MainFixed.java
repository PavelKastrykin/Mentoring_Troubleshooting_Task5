import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainFixed {

	public static void main(String[] args) throws IOException {

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		File file = new File(classloader.getResource("Data.txt").getFile());

		BufferedReader reader;
		String line;
		List<String> fileContentCut = new ArrayList<String>();

		//TODO: this application fails with "java.lang.OutOfMemoryError: GC overhead limit exceeded" on -Xmx4096k

		while (true) {

			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			try {
				while ((line = reader.readLine()) != null) {
					fileContentCut.add(line.substring(0, 3));
				}
			} finally {
				reader.close();
			}

			fileContentCut.clear();
		}
	}
}
