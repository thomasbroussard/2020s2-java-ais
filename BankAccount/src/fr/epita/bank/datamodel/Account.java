package fr.epita.bank.datamodel;

import java.math.BigDecimal;

public abstract class Account {
	double balance;
	Customer customer;

	public double getBalance() {

		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
