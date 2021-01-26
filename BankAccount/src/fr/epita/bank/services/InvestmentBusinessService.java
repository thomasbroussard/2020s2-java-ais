package fr.epita.bank.services;

import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;

public class InvestmentBusinessService {


	double commissionRate;

	public InvestmentBusinessService(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public StockOrder buy(InvestmentAccount investmentAccount, Stock stock, int quantity) {
		StockOrder stockOrder = new StockOrder(investmentAccount, stock);

		stockOrder.setQuantity(quantity);
		double currentPrice = stock.getCurrentPrice();
		double totalPrice = stockOrder.getQuantity() * currentPrice;
		stockOrder.setCommission(commissionRate * totalPrice);
		stockOrder.setUnitPrice(currentPrice);

		investmentAccount.setBalance(investmentAccount.getBalance() - totalPrice);
		return stockOrder;
	}


}
