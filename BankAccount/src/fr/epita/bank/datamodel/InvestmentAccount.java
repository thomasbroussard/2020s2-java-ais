package fr.epita.bank.datamodel;

public class InvestmentAccount extends Account {

	StockOrder buy(Stock stock, int quantity){
		return null;
	}

	public InvestmentAccount(Customer customer, double balance) {
		this.balance = balance;
		this.customer = customer;
	}

}
