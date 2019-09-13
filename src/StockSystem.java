/*class StockTradingSystem {

	Market market;
	Map<Integer, TradingAccount> accounts;	

	StockTradingSystem(Market market, Map<Integer, TradingAccount> accounts) {
		this.market = market;
		this.accounts = accounts;
	}
	
	// API method
	public void buy(TradingAccount account, int stockId, double amount) {
		if(canBuy(account, stockId, amount)) {
			Transaction t = createTransaction(generateID(), stockId, TransactionType.BUY, amount, price);
			processTransaction(t, new Callback {
				@Override
				void onSuccess() {
					updateMarket();
					updateAccount();
				}
				@Override
				void onFailure() {
					showError();
				}
			});
		} else {
			showError();
		}
	}

	private int generateID() {
		//todo
	}

	// API method
	public void sell(TradingAccount account, int stockid, double amount) {
		if(canSell(account, stockId, amount)) {
			Transaction t = createTransaction(generateID(), stockId, TransactionType.SELL, amount, price);
			processTransaction(t, new Callback {
				@Override
				void onSuccess() {
					updateMarket();
					updateAccount();
					account.completedTransactions.add(t);
				}
				@Override
				void onFailure() {
					showError();		
				}
			});
		} else {
			showError();
		}
	}

	// API method	
	public List<Transaction> getTransactions(TradingAccount account) {
		return account.getTransactions();
	}


	private Transaction createTransaction(int transactionId, int stockId, TransactionType type, double amount, double price) {
		return new Transaction(transactionId, stockId, type, amount, price);
	}

	private void processTransaction(Transaction transaction, Callback callback) {
		// contact broker
		// submit transaction request
		// return response success/failure
	}

	private void updateMarket(TransactionType type, int stockId, int amount) {
		// if BUY, remove amount from market
		// else if SELL, add amount to market
	}

	private void updateAccount(TransactionType type, int accountId, int amount) {
		// if BUY, add amount to account and reduce from balance
		// else if SELL, remove amount from account and add to balance
	}

	private boolean canBuy(TradingAccount account, int stockid, double amount) {
		return doesStockExist(stockId) && isStockAmountAvailable(stockId, amount) && account.canAfford(totalPrice);
	}

	private boolean canSell(TradingAccount account, int stockId, double amount) {
		return doesStockExist(stockId) && account.doesOwnStock(totalPrice) account.doesOwnAmount(stockId, amount);
	}

	class Market {
		Map<Integer, StockInfo> market;

		boolean doesStockExist(int stockId) {}
		boolean isStockAmountAvailable(int stockId, double amoount) {}
	}

	class StockInfo {
		int id;
		String name;
		double amountAvailable;
		double pricePerShare;
	}

	class TradingAccount {
		int id;
		double balanceAvailable;
		Map<Integer, Double> stocksInventory;
		List<Transaction> completedTransactions;

		List<Transaction> getTransactions() {
			return completedTransactions;
		}

		boolean canAfford(int totalCost) {
			return balanceAvailable >= totalCost;
		}

		boolean doesOwnAmount(int stockId, double amount) {
			return stocksInventory.get(stockId) >= amount;
		}

		boolean doesOwnStock(int stockId) {
			return stocksInventory.containsKey(stockId);
		}
	}

	class Transaction {
		int id;
		int stockId;
		TransactionType type;
		double amount;
		double price;

		public Transaction(int id, int stockId, TransactionType type, double amount, double price) {
			// set all member variables
		}
	}

	enum TransactionType {
		BUY, SELL
	}
}*/