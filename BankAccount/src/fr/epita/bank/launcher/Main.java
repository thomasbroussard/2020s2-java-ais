package fr.epita.bank.launcher;

import java.util.*;

import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.InvestmentBusinessService;

public class Main {



	public static void main(String[] args) {

		//welcome message
		System.out.println("Hello, welcome to this application");

		//initialization of instances
		Customer customer = new Customer("thomas", null);

		SavingsAccount savingsAccount = new SavingsAccount(customer, 0.005, 100);
		customer.setAddress("Paris");

		InvestmentAccount investmentAccount = new InvestmentAccount(customer, 1000);
		Stock stock = new Stock("gold", 100);
		int quantity = 3;

		//business logic, buy some stocks
		InvestmentBusinessService regularInvestmentService = new InvestmentBusinessService(0.02);
		InvestmentBusinessService companiesInvestmentService = new InvestmentBusinessService(0.01);
		regularInvestmentService.buy(investmentAccount, stock, quantity);


	}


}
