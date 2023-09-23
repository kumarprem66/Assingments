package gPay;

public class PaymentPresentation {

	TransactionService transactionService;
	
	public void setTranasctionService(TransactionService transactionService) {
		
		this.transactionService = transactionService;
	}
	
	public void presentTransactionDetails() {
		transactionService.calculateTransaction();
		System.out.println("here is the final ammount");
	}
	
}
