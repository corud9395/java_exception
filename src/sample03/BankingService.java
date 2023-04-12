package sample03;

public class BankingService {

	/**
	 * 계좌정보에 대한 추가/조회/변경/삭제 기능을 제공하는 객체를 참조한다. 
	 */
	private BankingRepository repo = new BankingRepository(); 
	
	/**
	 * 계좌번호와 비밀번호를 전달받아서 계좌정보를 반환한다.
	 * @param no 계좌번호
	 * @param password 비밀번호
	 * @return 계좌정보 
	 */
	public Account getAccountDetail(int no, int password) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFoundException(String.valueOf(no));  // 예외객체가 발생했을 경우에는 반환타입의 값을 따로 반환할 필요는 없다. 
		}
		
		if(account.getPassword() != password) {
			throw new PasswordMismatchException(); // 비밀번호 뭐라고 입력해서 틀렸다고 따로 알려줄 필요가 없다. 
		}
		
		return account; 
	}
	/**
	 * 계좌번호, 입금액을 전달받아서 계좌의 현재 잔액을 증가시킨다.
	 * @param no 계좌번호
	 * @param amount 입금액 
	 */
	public void deposit(int no, long amount) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFoundException(String.valueOf(no)); // 이거자체가 오류내용이라서 오류내용을 더 빠르게 파악할 수 있다. 
		}
		account.setBalance(account.getBalance() + amount);
	}
	
	/**
	 * 계좌번호, 비밀번호, 출금액을 전달받아서 계좌의 현재 잔액을 감소시킨다. 
	 * @param no
	 * @param password
	 * @param amount
	 */
	public void withdraw(int no, int password, long amount) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFoundException(String.valueOf(no)); 
		} // 이것도 빠른 종료(return으로 혹은 예외객체로)에 해당한다. // 안좋은 경우를 빠르게 먼저 제거해내야 한다. 
		if(account.getPassword() != password) {
			throw new PasswordMismatchException();
		}
		if(account.getBalance() < amount) {
			String message = "현재잔액:"+ +account.getBalance() + ",출금액: " + amount;
			throw new NotEnoughBalanceException(message);
		}
		account.setBalance(account.getBalance() - amount);
	}
}

