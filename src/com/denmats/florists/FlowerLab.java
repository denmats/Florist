package com.denmats.florists;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class FlowerLab {
	private static Scanner sc = new Scanner(System.in);
	private Flower flower;
	private int numOfFlower;

	public FlowerLab(Flower flower) {
		this.flower = flower;
		setNumberOfFlowers();
	}

	public Flower getFlower() {
		return flower;
	}

	public int getNumOfFlower() {
		return numOfFlower;
	}

	public void setNumberOfFlowers() {
		System.out.println("Enter number of flowers: ");
		if (sc.hasNext()) {
			try {
				this.numOfFlower = sc.nextInt();
			} catch (InputMismatchException e) {
				this.numOfFlower = 0;
			}
		}
	}

	@Override
	public String toString() {
		return flower.getFname() + " [" + "number of petals: " + flower.getNumOfPetals() + ", " + "price: "
				+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(flower.getPrice()) + "] " + "ordered number: "
				+ getNumOfFlower() + "\n";
	}
}
