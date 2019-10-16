package com.denmats.florists;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Statistics {
	private double medianPrice;
	private double totalPrice = 0;
	private List<FlowerLab> flowers;

	private static int totalFlowersCounter = 0;

	public Statistics() {
		showListOfAvailableFlowers();
		flowers = new ArrayList<>();
		selectAFlower();

		System.out.println(flowers);
		System.out.println("Total Price: "
				+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getTotalPriceOfAllSoldFlowers(flowers)));
		System.out.println("Weighted Average Price: "
				+ NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getWeightedAveragePrice(flowers)));
		System.out.println(
				"Average Price: " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getAveragePrice(flowers)));
		System.out.println(
				"Median Price: " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(getMedianPrice(flowers)));
		System.out.println("The most often type of sold flowers: " + getTheMostOftenSoldFlower(flowers));
	}

	public static int getTotalFlowersCounter() {
		return totalFlowersCounter;
	}

	public static void setTotalFlowersCounter() {
		totalFlowersCounter++;
	}

	public void selectAFlower() {
		Scanner sc = new Scanner(System.in);
		boolean isNextFlower = true;
		while (isNextFlower) {
			System.out.println("\nSelect flowers from the list: 1-10 or q - exit");
			if (sc.hasNextLine()) {
				switch (sc.nextLine()) {
				case "1":
					flowers.add(new FlowerLab(Flower.TULIP));
					Statistics.setTotalFlowersCounter();
					break;
				case "2":
					flowers.add(new FlowerLab(Flower.DAFFODIL));
					Statistics.setTotalFlowersCounter();
					break;
				case "3":
					flowers.add(new FlowerLab(Flower.POPPY));
					Statistics.setTotalFlowersCounter();
					break;
				case "4":
					flowers.add(new FlowerLab(Flower.SUNFLOWER));
					Statistics.setTotalFlowersCounter();
					break;
				case "5":
					flowers.add(new FlowerLab(Flower.BlUEBELL));
					Statistics.setTotalFlowersCounter();
					break;
				case "6":
					flowers.add(new FlowerLab(Flower.ROSE));
					Statistics.setTotalFlowersCounter();
					break;
				case "7":
					flowers.add(new FlowerLab(Flower.SNOWDROP));
					Statistics.setTotalFlowersCounter();
					break;
				case "8":
					flowers.add(new FlowerLab(Flower.ORCHID));
					Statistics.setTotalFlowersCounter();
					break;
				case "9":
					flowers.add(new FlowerLab(Flower.IRIS));
					Statistics.setTotalFlowersCounter();
					break;
				case "10":
					flowers.add(new FlowerLab(Flower.PEONY));
					Statistics.setTotalFlowersCounter();
					break;

				case "q":
					isNextFlower = false;
					sc.close();
					break;

				default:
					System.err.println("Wrong input");
					break;
				}
			}
		}

	}// End of selectFlower()

	public static void showListOfAvailableFlowers() {
		System.out.println("List of available flowers");
		int counter = 1;

		for (Flower f : Flower.values()) {
			System.out.println("[" + counter + "]" + " " + "Flower: " + f.getFname() + ", petals: " + f.getNumOfPetals()
					+ ", price: " + NumberFormat.getCurrencyInstance(Locale.GERMANY).format(f.getPrice()));
			counter++;
		}
	}

	public double getTotalPriceOfAllSoldFlowers(List<FlowerLab> flowers) {

		for (FlowerLab f : flowers) {
			totalPrice += f.getNumOfFlower() * f.getFlower().getPrice();
		}

		return totalPrice;
	}

	public double getWeightedAveragePrice(List<FlowerLab> flowers) {
		int totalNum = 0;
		for (FlowerLab f : flowers) {
			totalNum += f.getNumOfFlower();
		}

		return getTotalPriceOfAllSoldFlowers(flowers) / totalNum;
	}

	public double getAveragePrice(List<FlowerLab> flowers) {
		double priceOfAllSoldFlowers = 0;
		int numOfAllSoldFlowers = 0;
		for (FlowerLab f : flowers) {
			priceOfAllSoldFlowers += f.getFlower().getPrice();
			numOfAllSoldFlowers++;
		}

		return priceOfAllSoldFlowers / numOfAllSoldFlowers;
	}

	public double getMedianPrice(List<FlowerLab> flowers) {
		double arr[] = new double[Statistics.getTotalFlowersCounter()];
		int counter = 0;
		for (FlowerLab f : flowers) {
			arr[counter] = f.getFlower().getPrice();
			counter++;
		}

		Arrays.sort(arr);

		int index = Statistics.getTotalFlowersCounter() / 2;

		if (Statistics.getTotalFlowersCounter() % 2 != 0) {
			medianPrice = arr[index];
		} else {
			medianPrice = (arr[index] + arr[index - 1]) / 2;
		}

		return medianPrice;
	}

	public List<String> getTheMostOftenSoldFlower(List<FlowerLab> flowers) {

		List<String> theMostOftenSoldFlower = new ArrayList<>();
		int maxNumOfSoldFlowers = flowers.get(0).getNumOfFlower();
		for (FlowerLab f : flowers) {
			if (maxNumOfSoldFlowers < f.getNumOfFlower()) {
				maxNumOfSoldFlowers = f.getNumOfFlower();
			}
		}

		for (FlowerLab f : flowers) {
			if (f.getNumOfFlower() == maxNumOfSoldFlowers) {
				theMostOftenSoldFlower.add(f.getFlower().getFname());
			}
		}
		return theMostOftenSoldFlower;
	}

}// End of class
