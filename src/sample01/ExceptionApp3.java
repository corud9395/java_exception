package sample01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp3 {
	
	/*
	 * 예외처리하기
	 * 	throws 키워드를 이용해서 예외처리 위임하기
	 * 형식
	 *  	public void test() throws 예외클래스명1, 예외클래스명2, 예외클래스명3{
	 *  		예외발생이 예상되는 수행문;
	 *  		예외발생이 예상되는 수행문;
	 *  		예외발생이 예상되는 수행문; 
	 *  		수행문; 
	 *  		수행문; 
	 *  }	
	 *  
	 *  	*throws 키워드를 사용해서 예외처리를 위임할 예외클래스를 지정할 수 있다. 
	 *  	* 예외클래스명1, 예외클래스명2, 예외클래스명3은 test() 메소드에서 발생이 예상되는 예외클래스다. 
	 *  	* test() 메소드를 호출하는 측에서는 try ~ catch블록으로 직접 예외를 처리하거나 throws 키워드를 사용해서 다시 예외처리를 위임할 수 있다. 
	 *  	* 예외처리를 위임하는 목적은 여러 예외를 한 군데에서 일괄처리하기 위해서 사용한다. 
	 */
	
	// 예외를 readerFile호출한 자에게 다시 던지는 것(=다시 예외처리 위임한다) / [목적] 예외처리 위임하면 한 군데서 일괄처리가 가능하다. 
	public static void readFile(String path) throws FileNotFoundException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		String text = br.readLine();
		System.out.println("파일내용 --> " + text);
		br.close();
	}

	public static void writeFile(String path, String content) throws IOException {
		// 위 문장의 뜻은 writeFile를 호출한 측에서 IOException 예외처리를 위임처리하라고 한 뜻. 어디에서 예외를 처리하는지는 신경쓰지 않는다. 여기서는
		FileWriter writer = new FileWriter(path);
		writer.write(content);
		writer.close();

	}
	
	public static void main(String[] args) {
	// readFile() 메소드와 writeFile() 메소드가 위임한 예외처리를 직접 처리하고 있다. 
	// (ExceptionApp3.writeFile~ 이렇게 해야 하는데 그냥 같은 클래스라서 냅뒀음)	
	try {
		writeFile("src/sample01/sample03.txt", "예외처리 위임하기"); 	
		readFile("src/sample01/sample03.txt");
	} catch (FileNotFoundException ex) {
		System.out.println("파일을 찾을 수 없습니다.");
	} catch (IOException ex) {
		System.out.println("파일 읽기 쓰기 작업 중 오류가 발생하였습니다.");
	}	
	
	}
}
