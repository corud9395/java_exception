package sample03;

import java.util.HashMap;
import java.util.Map;

public class BankingRepository {

	/**
	 * 계좌정보를 저장하는 Map객체다.
	 * 	key는 계좌번호, value는 계좌정보다. 
	 */
	private Map<Integer, Account> map = new HashMap<>();
	
	/**
	 * BankingRepository의 기본 생성자 메소드다. 
	 * 객체 생성 후에 5개의 Account객체를 생성해서 Map객체에 계좌번호를 key로 Account객체를 저장한다. 
	 */
	public BankingRepository() {
		map.put(100, new Account(100, "도민준", 1234, 500000));
		map.put(200, new Account(200, "천송이", 1234, 1500000));
		map.put(300, new Account(300, "김종주", 1234, 24500000));
		map.put(400, new Account(400, "김채경", 1234, 5400000));
		map.put(500, new Account(500, "김이화", 1234, 4500000));
	}
	
	/**
	 * 계좌번호를 전달받아서 계좌번호에 해당하는 계좌정보를 제공한다. 
	 * @param no 계좌번호
	 * @return 계좌정보, 계좌번호가 올바르지 않으면 null이 반환될 수 있다. 
	 */
	public Account getAccountByNo(int no) {
		return map.get(no);
	}
}
