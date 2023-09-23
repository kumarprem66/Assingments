package gPay;

public class TransactionService {

	
	AccountDetailsDao accountDetailsDao;
	
	

	public void setAccountDetailsDao(AccountDetailsDao accountDetailsDao) {
		this.accountDetailsDao = accountDetailsDao;
	}



	public void calculateTransaction() {
		
		accountDetailsDao.getAccountDetails();
		System.out.println("Transaction computed");
	}
}
