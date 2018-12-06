package Packman_Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Geom.Point3D;

public class Game {

	private ArrayList<Fruit> fruits;
	private ArrayList<Packman> packmans;

	public Game() {
		this.fruits = new ArrayList<Fruit>();
		this.packmans = new ArrayList<Packman>();
	}

	public Game(ArrayList<Fruit> fruits, ArrayList<Packman> packmans) {
		Iterator<Fruit> iter1 = fruits.iterator();
		Iterator<Packman> iter2 = packmans.iterator();
		while (iter1.hasNext()) {
			Fruit runner1 = iter1.next();
			this.fruits.add(runner1);
		}
		while (iter2.hasNext()) {
			Packman runner2 = iter2.next();
			this.packmans.add(runner2);
		}
	}

	public Game(String csvFile) {
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String[]> data = new ArrayList<>();
		String[] dataLine;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				dataLine = line.split(csvSplitBy);
				data.add(dataLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String[]> iter = data.iterator();
		while (iter.hasNext()){
			String[] runner = iter.next();
			if (runner[runner.length - 1].equals("P")) {
				this.packmans.add(new Packman(
						new Point3D(Double.parseDouble(runner[4]), Double.parseDouble(runner[3]),
								Double.parseDouble(runner[2])),
						Long.parseLong(runner[5]), Double.parseDouble(runner[1]), Double.parseDouble(runner[0]),
						"yellow"));
			} else if (runner[runner.length - 1].equals("F")) {
				this.fruits.add(new Fruit(
						new Point3D(Double.parseDouble(runner[4]), Double.parseDouble(runner[3]),
								Double.parseDouble(runner[2])),
						Long.parseLong(runner[5]), Integer.parseInt(runner[1])));
			}
		}

	}

	public ArrayList<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(ArrayList<Fruit> fruits) {
		this.fruits = fruits;
	}

	public ArrayList<Packman> getPackmans() {
		return packmans;
	}

	public void setPackmans(ArrayList<Packman> packmans) {
		this.packmans = packmans;
	}

}
