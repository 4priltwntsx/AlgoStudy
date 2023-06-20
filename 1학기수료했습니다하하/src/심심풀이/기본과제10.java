package 심심풀이;

import java.time.LocalDate;
import java.util.*;

public class 기본과제10 {

	public static void main(String[] args) {

        LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		
//		System.out.println(year + " " + month);
		
		HashMap<Integer, Integer> months = new HashMap<>();
		months.put(1, 31);
		if((year%4==0) && (year%100!=0 ) || year%400 ==0) months.put(2, 29);
		else months.put(2, 28);
//		months.put(2, 30);
		months.put(3, 31);
		months.put(4, 30);
		months.put(5, 31);
		months.put(6, 30);
		months.put(7, 31);
		months.put(8, 31);
		months.put(9, 30);
		months.put(10, 31);
		months.put(11, 30);
		months.put(12, 31);
		
		System.out.println(months.get(month) + "days for " + year + "-"+ month);
		
	}

}
