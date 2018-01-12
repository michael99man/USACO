/*
ID: michael99man
LANG: JAVA
PROG: dualpal
*/
package training;


import java.io.*;
import java.util.StringTokenizer;

public class dualpal {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		f.close();
		int count = 0;
		int current = Integer.valueOf(S) + 1;
		
		
		while(count < N){
			int pal = 0;
			
			for(int i = 2; i<=10;i++){
				if(check(Integer.toString(current,i))){
					pal++;
				}
				
				if(pal >=2){
					System.out.println(current);
					out.println(current);
					count++;
					break;
				}
			}
			current++;
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
