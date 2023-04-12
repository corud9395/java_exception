package sample03;

import util.KeyboardReader;

public class BankingApplication {
	
	private KeyboardReader reader = new KeyboardReader();
	private BankingService service = new BankingService();
	
	public void menu() {
		System.out.println("-------------------------------------------------");
		System.out.println("1.조회   2.입금   3.출금   0.종료");
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		System.out.println("### 메뉴선택: ");
		int menuNo = reader.readInt();
		System.out.println();
	
		// 예외 일괄 처리 
		try {  // 여기 menu에서 try catch(예외처리)를 했기 때문에 밑에 다른 곳에서는 안 한다.(예외처리는 프로그램에서 한 곳에서 한다) 우리는 예외 발생에 더 중점둬야 해!!!! 
		if (menuNo == 1) {
			조회하기();
		} else if(menuNo == 2) {
			입금하기();
		} else if(menuNo == 3) {
			출금하기();
		} else if(menuNo == 0) {
			종료하기();
		}
		
		// menu();가 여기에 있으면 프로그램이 중단된다. 다시 menu();가 호출되지 않는다. 
		} catch(BankingException ex) {
			System.out.println("### 오류 발생: " + ex.toString()); // 오류상황 보여준다. 
		//	ex.printStackTrace();
		} catch(Exception ex) {
			System.out.println("### 오류 발생: 알 수 없는 오류가 발생하였습니다.");
		//	ex.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		menu(); // menu();는 오류발생여부와 상관없이 계속 실행되어야 하기 때문에 밖으로 빼놓는다. 
		
	}
	
	private void 조회하기() {
		System.out.println("<< 계좌정보 조회하기 >>");
		System.out.println("### 계좌번호와 비밀번호를 입력하세요.");
	
		System.out.println("### 계좌번호: ");
		int no= reader.readInt();
		System.out.println("###비밀번호: ");
		int password = reader.readInt();
		System.out.println();
		
		Account account = service.getAccountDetail(no, password); // account가 null인지 아닌지는 굳이 확인할 필요 없다. 
		System.out.println("### 계좌상세 정보 출력");
		System.out.println("--------------------------------------");
		System.out.println("계좌번호: " + account.getNo());
		System.out.println("예금주: " + account.getOwner());
		System.out.println("현재잔액: " + account.getBalance());
		System.out.println("--------------------------------------");
	}
	
	private void 입금하기() {
		System.out.println("<< 입금하기 >>");
		System.out.println("### 계좌번호와 입금액을 입력하세요. " );
		
		System.out.print("### 계좌번호: " );
		int no = reader.readInt();
		System.out.print("### 입금액: ");
		long amount = reader.readLong();
		System.out.println();
		
		service.deposit(no, amount);
		System.out.println("### 입금이 완료되었습니다.");
	}
	
	private void 출금하기() {
		System.out.println("<< 출금하기 >>");
		System.out.println("### 계좌번호, 비밀번호, 출금액을 입력하세요.");
		
		System.out.println("### 계좌번호: ");
		int no = reader.readInt();
		System.out.println("### 비밀번호: ");
		int password = reader.readInt();
		System.out.println("### 출금액: ");
		long amount = reader.readLong();
		System.out.println();
		
		
		service.withdraw(no, password, amount);
		System.out.println("### 출금이 완료되었습니다.");
				
	}
	
	private void 종료하기() {
		System.out.println("<< 프로그램 종료 >>");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		BankingApplication app = new BankingApplication();
		app.menu();
	}
	
	
	
	
	
	

}
