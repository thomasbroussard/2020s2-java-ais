package fr.epita.bank.datamodel;

public class Stock {
	String name;
	double currentPrice;

	public Stock(String name, double currentPrice) {

		this.name = name;
		this.currentPrice = currentPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
}
