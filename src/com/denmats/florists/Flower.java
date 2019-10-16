package com.denmats.florists;

public enum Flower {
	TULIP("Tulip", 15, 3.2),
	DAFFODIL("Daffodil", 20, 2.5),
	POPPY("Poppy" , 25, 2.1),
	SUNFLOWER("Sunflower", 18, 2.4),
	BlUEBELL("Bluebell", 14, 1.5),
	ROSE("Rose",25, 5),
	SNOWDROP("Snowdrop", 30, 3.5),
	ORCHID("Orchid", 16, 4.5),
	IRIS("Iris", 20, 2.7),
	PEONY("Peony",  50, 3.2);
	
	private String fname;
	private int numOfPetals;
	private double price;
	
	Flower(String fname, int numOfPetals, double price) {
		this.fname = fname;
		this.numOfPetals = numOfPetals;
		this.price = price;
	}

	public String getFname() {
		return fname;
	}

	public int getNumOfPetals() {
		return numOfPetals;
	}

	public double getPrice() {
		return price;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setNumOfPetals(int numOfPetals) {
		this.numOfPetals = numOfPetals;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
