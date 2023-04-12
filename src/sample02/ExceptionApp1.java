package sample02;

public class ExceptionApp1 {
	
	/**
	 * 문자열을 전달받아서 정수로 변환해서 반환한다. 
	 * @param text 숫자로 구성된 문자열
	 * @return 정수값 
	 */
	public static int toInt(String text) {
		int number = Integer.parseInt(text); // 문자열을 전달받아서 정수로 바꾸는 것 
		return number;
	}

	public static void main(String[] args) {
		
		try {
		int value = toInt("1234가"); // 이때 발생하는 예외는(NumberFormatException)이고 이는 unchecked exception이고, 예외처리 안했을 때는 JVM에게 전달된다. 
		System.out.println(value);
		} catch (NumberFormatException ex) {
			// main에게 exception이 전달안되고 catch해버려서! // 이렇게 아무런 코드도 작성하지 않으면 예외가 발생했는지도 모르게 된다. // JVM에게 전달되지 않아서 강제종료되지는 않는다. 
		String errorMessage = ex.getMessage();
		System.out.println("오류 메세지: " + errorMessage);
		
		String text = ex.toString();
		System.out.println("toString() -> " + text);
		
		ex.printStackTrace();
		}
	}
}
