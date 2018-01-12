/*
ID: michael99man
LANG: JAVA
PROG: friday
*/
package training;
import java.util.*;
import java.io.*;

public class friday {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "friday.out")));
		
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int N = Integer.parseInt(f.readLine());
		int[] amounts = new int[7];
		int day = 13;
		int month = 1;
		int year = 1900;
		
		
		//1:monday 7:sunday
		int type = 6;
		amounts[5]++;
		
		while(year!=(1900 + N-1) || month !=12){
			type += months[month-1];
			if(year % 4 == 0 && month == 2 && (year % 100 != 0 || year % 400 == 0)){
				System.out.println("Year: " + year + " is a leap year");
				type++;
			}
			type = type % 7;
			if(type==0){
				type = 7;
			}
			month++;
			System.out.println("MONTH: " + month);
			if(month > 12){
				month = 1;
				year++;
			}
			amounts[type-1]++;
			System.out.println(type);
		}
		String result = amounts[5] + " " + amounts[6] + " " + amounts[0] + " " + amounts[1] + " " + amounts[2] + " " + amounts[3] + " " + amounts[4];
		System.out.println(result);
		out.println(result);
		out.close();
	}

}
