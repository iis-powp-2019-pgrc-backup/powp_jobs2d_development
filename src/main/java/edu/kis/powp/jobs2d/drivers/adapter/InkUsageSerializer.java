package edu.kis.powp.jobs2d.drivers.adapter;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.kis.powp.jobs2d.file.DataFile;
import edu.kis.powp.observer.Subscriber;

public class InkUsageSerializer implements Subscriber{
	private Job2dDriverUseControlDecorator decorator;
	private DataFile dataFile;
	
	public InkUsageSerializer(Job2dDriverUseControlDecorator decorator) throws FileNotFoundException {
		super();
		this.decorator = decorator;
		this.dataFile = new DataFile();
		try {
			this.decorator.setDistance(dataFile.getCurrentLevel());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		dataFile.setCurrentLevel(decorator.getDistance());
		dataFile.saveData();
	}
}
