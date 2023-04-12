package sample01;

//import java.io.FileWriter;
//import java.io.IOException;

public class ExceptionApp4 {

	
//	public static void test1() throws IOException, ClassNotFoundException {  // static 만드는 이유는 한 소스코스에서 다 보려고 한거니까 static과 연관짓지 말 것
//		System.out.println("예외처리 위임하기 연습1");
//		test2(); 
//	}
//	
//	public static void test2() throws IOException, ClassNotFoundException{
//		System.out.println("예외처리 위임하기 연습2");
//		test3(); 
//	}
//	
//	public static void test3() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습3");
//		test4(); 
//		
//		Class.forName("java.io.String"); 
//	}
//	
//	public static void test4() throws IOException {
//		FileWriter writer = new FileWriter("src/sample01/sample04.txt");
//		writer.write("파일쓰기 연습");
//		writer.close(); 
//	}
	// test1~4까지 계속 throws IOException 던지는게 얼마나 짜증나니 
	// checked exception은 반드시 예외처리(둘 중 하나는 무조건)해야 한다.
	// 하지만 unchecked exception은 이런 상황이 없다. 
	
	public static void test2(String str) { // 예외처리를 test2도 안했네? 그럼 main에 위임돼 
		test1(str); 
	}
	
	public static void test1(String str) {  // 근데 parseInt가 NumberFormatException 예외가 있지만 빨간줄이 따로 뜨지 않는다. 예외처리 안해서 test2에게 자동으로 위임된다. 
		int number = Integer.parseInt(str);
		System.out.println("number -> " + number);
	}
	
	public static void main(String[] args) { 
		try {
			test2("1234");
			test2("1234오");
		} catch(NumberFormatException ex) {
			System.out.println("유효한 숫자형식의 문자열이 아닙니다.");
			
		} // 예외처리 위임할 때 unchecked exception이 훨씬 더 편한다. --> 왜??? 아니 언제 unchecked고 언제 checked인지 알아? 
		
	}
}
