package training;

/*
 ID: michael99man
 LANG: JAVA
 PROG: gift1
 */

import java.util.*;
import java.io.*;

public class gift1 {
	public static String[] names;

	public static void main(String[] args) throws IOException {
		String path = "";
		//path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "gift1.out")));
		int NP = Integer.parseInt(f.readLine());
		names = new String[NP];
		int[] money = new int[NP];

		for (int n = 0; n < NP; n++) {
			names[n] = f.readLine();
		}

		StringTokenizer st;
		String line = f.readLine();
		while (line != null) {
			// line is who's giving money
			int index = pos(line);
			st = new StringTokenizer(f.readLine());
			int amount = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (num != 0) {
				money[index] -= (amount - amount % num);
				int each = (amount - amount % num) / num;

				for (int i = 0; i < num; i++) {
					String name = f.readLine();
					money[pos(name)] += each;
				}
			}
			line = f.readLine();
		}

		for (int i=0;i<NP;i++) {
			out.println(names[i] + " " + money[i]);
		}
		out.close();
	}

	static int pos(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
