package training;
/*
 ID: michael99man
 LANG: JAVA
 PROG: ride
 */

import java.io.*;

public class ride {

	public static void main(String[] args) throws IOException {
		String path = "";
		//path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "ride.out")));

		String a = f.readLine();
		String b = f.readLine();
		int valA = 1;
		int valB = 1;
		
		for(char c:a.toCharArray()){
			valA *= ((int) c - 64);
		}
		
		for(char c:b.toCharArray()){
			valB *= ((int) c - 64);
		}
		
		if(valA % 47 == valB % 47){
			out.println("GO");
		} else {
			out.println("STAY");
		}
		out.close();
	}

} 
