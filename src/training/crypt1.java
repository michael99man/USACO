/*
ID: michael99man
LANG: JAVA
PROG: crypt1
*/
package training;

import java.io.*;
import java.util.StringTokenizer;

public class crypt1 {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "crypt1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n];
		
		st = new StringTokenizer(f.readLine());
		for(int i=0;i<n;i++){
			num[i] = Integer.parseInt(st.nextToken());
			System.out.println(num[i]);
		}
		f.close();
		
		out.close();
	}

}
