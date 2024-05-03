package statsVisualiser.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Countries {

	public static List<List<String>> Countires() {
		String fileName = "src\\main\\resources\\all_countries.csv";
		File file = new File(fileName);
		List<List<String>> lines = new ArrayList<List<String>>();
		Scanner inputStream;

		try {
			inputStream = new Scanner(file);

			while (inputStream.hasNext()) {
				String line = "";
				line = inputStream.nextLine();

				lines.add(Arrays.asList(line));

			}

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
