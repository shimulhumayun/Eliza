package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextIO {
	private String fileName;

	public TextIO(String fileName) {
		this.fileName = fileName;

	}

	public void createNewFile() {
		//try with resources
		try (PrintWriter outStream = new PrintWriter(fileName)) {
		} catch (FileNotFoundException e) {
			System.err.println("Could not create file " + fileName + " MESSAGE " + e.getMessage());
		}
		System.out.println("End of creating new file");

	}

	public void appendToFile(String text) {
		
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName, true));
			outStream.println(text + "\n");
		} catch (FileNotFoundException e) {
			System.err.println("Could not append to file " + fileName + " MESSAGE " + e.getMessage());
		} finally {
			if (outStream != null) {
				outStream.close();
			}
			System.out.println("End of write to new file");
		}

		System.out.println("SUCCESS writing new File");
	}

	public String readFile(String fileName) {
		Scanner inStream = null;
		String fileContents = "";
		try {

			inStream = new Scanner(new File(fileName));
			while (inStream.hasNextLine()) {
				fileContents += inStream.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inStream != null) {
				inStream.close();
			}
		}

		return fileContents;
	}
	//if the file specified in constr
	

}
