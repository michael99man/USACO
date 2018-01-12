
/*
ID: michael99man
LANG: JAVA
PROG: milk
*/
package training;

import java.io.*;
import java.util.*;

public class milk {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> farmers = new ArrayList<int[]>();

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(f.readLine());
			int[] a = new int[2];
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = Integer.parseInt(st.nextToken());
			farmers.add(a);
		}
		f.close();
		Collections.sort(farmers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return new Integer(o1[0]).compareTo(new Integer(o2[0]));
			}
		});
		/*
		 * for(int[] i: farmers){ System.out.println(i[0] + " " + i[1]); }
		 */
		int money = 0;
		int amount = 0;
		int index = 0;

		while (amount < N) {
			int x = farmers.get(index)[0];
			int y = farmers.get(index)[1];

			amount += y;
			money += x * y;
			index++;
		}
		if (amount > N) {
			money -= (amount - N) * farmers.get(index - 1)[0];
			System.out.println(money);
		}
		out.println(money);
		out.close();
	}

}
