package edu.kis.powp.jobs2d.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataFile {
	private double currentLevel;

	public DataFile() throws FileNotFoundException {
		try {
			getDataFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	private void getDataFromFile() throws IOException{
        File file = new File("data.txt");
        Scanner in;
		try {
			in = new Scanner(file);
			String dataString = in.nextLine();

			setCurrentLevel(Double.parseDouble((dataString)));

		} catch (FileNotFoundException e) {
			setCurrentLevel(0);
			file.createNewFile();
			saveData();
		} 
	}
	
	public void saveData() {
		File fnew=new File("data.txt");
		FileWriter f2;

		try 
		{
		    f2 = new FileWriter(fnew,false);
		    f2.write(Double.toString(currentLevel)); 
	
		    f2.close();
		} catch (IOException e) {
		        e.printStackTrace();
		} 
	}
	
	public double getCurrentLevel() throws IOException {
		getDataFromFile();
		return currentLevel;
	}

	public void setCurrentLevel(double d) {
		this.currentLevel = d;
	}
}
