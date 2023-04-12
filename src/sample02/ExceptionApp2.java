package sample02;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp2 {

	//////////////////////////////////////////////////////////////
	// 예외변환하기를 사용하지 않은 경우
	// - main 메소드에서 호출하는 메소드들이 다양한 예외를 발생시킨다. 
	// - 예외를 일괄처리하는 main 메소드에서 처리할 예외의 갯수가 매우 많아진다.
	//////////////////////////////////////////////////////////////
//	public static void writeText(String text) throws IOException {
//		FileWriter writer = new FileWriter("src/sample02/sample.txt");
//		writer.write(text);
//		writer.close();  // 예외처리안해줬을 때 빨간줄이 간다. 
//	} 
//	
//	public static Date toDate(String text) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = sdf.parse(text);
//		return date;
//	}
//	
//	public static void main(String[] args) {
//		try {
//			writeText("예외변환하기");
//			Date date = toDate("2023-04-11");
//			System.out.println(date);
//		} catch(IOException ex) {  // 예외 잡고
//			ex.printStackTrace();  // 예외의 원인을 알 수 있다. 
//		} catch(ParseException ex) {
//			ex.printStackTrace();
//		}	// 이렇게 하면 예외처리해야 할 것이 많으니깐. 바꿔볼게! IOException과 ParseException대신 다른 것으로 예외를 발생시킬게!
//	}
//}

	//////////////////////////////////////////////////////////////
	// 예외 전환하기를 사용한 경우 
	// - main 메소드에서 호출하는 모든 메소드들이 Exception 예외를 발생하도록 
	//   실제 발생한 예외객체는 catch 블록을 이용해서 가로챘다. 
	// - throw 키워드를 이용해서 Exception 예외를 강제 발생시켰다. 
	// - main 메소드에서 호출하는 모든 메소드들이 Exception 예외를 발생시키기 때문에
	//   main 메소드에서 일괄예외처리가 훨씬 쉬워진다. 
	//////////////////////////////////////////////////////////////
	public static void writeFile(String text) throws Exception{ // (3) 그리고 이 메소드에서 발생한 예외 exception을 전달해 
		try {
			FileWriter writer = new FileWriter("src/sample02/sample.txt");
			writer.write(text);
			writer.close();
		} catch(IOException ex) {  // (1) catch한다고 끝내는게 아니라, 일괄처리할 놈에게 전달해야 해
			throw new Exception("읽고 쓰기 오류 발생", ex); // (2) throw는 예외 강제 발생. 기존의 exception을 잡고 다른 예외를 발생시킨다(예외의 전환) 
		} 	// 예외 객체를 만들 때 매개변수에 어떤 오류가 발생했었는지 작성 
			// 그리고 ", ex"라고도 적는다. 
	}
	
	public static Date toDate(String text) throws Exception{ // (3) 그리고 이 메소드에서 발생한 예외 exception을 전달해라. 
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
			Date date = sdf.parse(text);
			return date;
		} catch(ParseException ex) { // (1) ParseException잡고 
			throw new Exception("날짜 변환 오류 발생", ex); // (2) 새로운 예외 발생시켜(예외의 전환) // 여기서 Exception은 checked Exception이므로 꼭 throws Exception을 해줘야 한다. 
		} // ", ex"는 원인 전달해주면 전체 예외발생 원인을 알려준다. 
		
	}
	
	public static void main(String[] args) {
		try {
			writeFile("예외 전환하기 연습입니다.");
			Date date = toDate("20244-04-"); 
			System.out.println(date);
		} catch (Exception e) {  // 그래서 일괄처리하는 곳에서도 exception만 신경쓰면 된다. 
			e.printStackTrace();
		}
	}
	
	
	}