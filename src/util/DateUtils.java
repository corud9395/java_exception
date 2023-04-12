package util;

import java.text.SimpleDateFormat;
import java.util.Date;

// static 메소드 -> 광범위하게 사용되는 기능들 
// = 클래스 메소드 -> 객체 생성 없이 바로 사용할 수 있는 기능들 
public class DateUtils {
	
	public static SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 날짜를 'yyyy-MM-dd'형식의 텍스트로 변환해서 반환한다. 
	 * @param date 날짜
	 * @return 지정된 포맷의 문자열 
	 */
	public static String toText(Date date) {
		if (date == null) {
			return ""; // 안좋은 상황을 빨리 찾아서 끝내버리자는 취지. 
		}
		String formattedText = YYYYMMDD.format(date); //  format은 반환타입이 String
		return formattedText;
	}
	
	
	
}
