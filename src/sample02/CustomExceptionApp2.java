package sample02;

public class CustomExceptionApp2 {
	
	/**
	 * 고객등급과 구매금액을 전달받아서 적립포인트를 반환하는 메소드 
	 * @param grade 고객등급
	 * @param amount 주문금액 
	 */
	public static int getDepositPoint(String grade, int amount) {
		if(grade == null || grade.isBlank()) {  // 고객등급이 잘못 온 경우자나. 정상적인 업무로직 실행할 수 없는 상황이니까, 예외! 
			// 예외객체 사용 목적: 오류 내용을 더 풍부하게(?) 알려주기 위해 
			// 예외상황 맞딱드렸을 때는 무조건 예외객체 생성하기! 
			throw new CustomException("고객등급 정보가 없습니다."); 
		}
		
		double depositRate = 0.0;
		if("골드".equals(grade)) {
			depositRate = 0.05;
		} else if ("실버".equals(grade)) {
			depositRate = 0.02;
		} else if ("브론즈".equals(grade)) {
			depositRate = 0.01;
		}
		return (int) (amount*depositRate);
	}

}
