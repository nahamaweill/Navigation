package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class MultiCSV {
/**
 * we take this code from https://stackoverflow.com/
 * this code represents recursive reading of any folder
 * while using file array  
 * @param folder
 */
	public static void listAllFiles(File folder) {
		System.out.println("In listAllfiles(File) method");
		File[] fileNames = folder.listFiles();
		for (File file : fileNames) {
			// if directory call the same method again
			if (file.isDirectory()) {
				listAllFiles(file);
			} else {
				try {
					readContent(file);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * this function represents the lines according to the recursive reading function
	 * so,this function work only for one file every round
	 * @param file
	 * @throws IOException
	 */
	public static void readContent(File file) throws IOException {
		System.out.println("read file " + file.getCanonicalPath());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String strLine;
			// Read lines from the file, returns null when end of stream
			// is reached
			while ((strLine = br.readLine()) != null) {
				System.out.println("Line is - " + strLine);
			}
		}
	}

	
	
	public static void main(String[] args) {
		File s = new File("C:\\Users\\DELL\\Desktop\\Ex2\\Ex2");
		listAllFiles(s);
	}
}
