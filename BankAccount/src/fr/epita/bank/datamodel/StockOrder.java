package fr.epita.bank.datamodel;

public class StockOrder {
	double unitPrice;
	double commission;
	int quantity;

	InvestmentAccount account;
	Stock stock;


	public StockOrder(InvestmentAccount account, Stock stock) {
		this.account = account;
		this.stock = stock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
