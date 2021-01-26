package fr.epita.bank.datamodel;

public class SavingsAccount extends Account {
	double interestRate;


	public SavingsAccount(Customer customer, double interestRate, double balance){
		this.customer = customer;
		this.interestRate = interestRate;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "SavingsAccount{" +
				"balance=" + balance +
				", customer=" + customer +
				", interestRate=" + interestRate +
				'}';
	}
}
