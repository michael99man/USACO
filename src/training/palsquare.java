/*
ID: michael99man
LANG: JAVA
PROG: palsquare
*/
package training;


import java.io.*;

public class palsquare {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "palsquare.out")));

		// between 2 and 20
		int b = Integer.parseInt(f.readLine());
		f.close();
		String a;
		String a2;
		for (int i = 1; i <= 300; i++) {
			a = Integer.toString(i,b).toUpperCase();
			a2 = Integer.toString((int)Math.pow(i, 2),b).toUpperCase();
			if(check(a2)){
				out.println(a + " " + a2);
				System.out.println(a + " " + a2);
			}
		}
		out.close();
	}

	public static boolean check(String s) {
		StringBuilder sb = new StringBuilder(s);
		if (sb.reverse().toString().equals(s)) {
			return true;
		} else {
			return false;
		}
	}

}
