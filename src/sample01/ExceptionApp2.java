package sample01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionApp2 {
	
	public static void main(String[] args) {
		
		try {
		FileReader reader = new FileReader("src/sample01/sample01.txt"); // sample01.txt였음 
		BufferedReader br = new BufferedReader(reader);
		String text = br.readLine();
		System.out.println(text);
		br.close();
		
	} catch(FileNotFoundException ex) {  // 위의 수행문에서 FileNotFOundException, IOException이 발생해서 아래와 같이 예외처리해준 것이다.
		System.out.println("지정된 파일을 찾을 수 없습니다."); // 여기에는 실제로 log파일이 들어가는데 우리는 일단 여기까지만 진행할 것이다.
	} catch(IOException ex) {
		System.out.println("읽기 작업 중 오류가 발생하였습니다.");
	}  // 자식-부모일 때 항상 부모가 아래 쪽에 있어야 각각에 잡힌다. IOException(부모)과 FileNotFoundException(자식)의 순서를 바꿔버리면 FileNotFoundException에 unrecheable catch block이라는 오류메세지가 뜬다. 
	}	// 사실 웹은 이것과는 좀 다른 방식으로 예외가 처리된다. 

}
