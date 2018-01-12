package january2015silver;

import java.io.*;
import java.util.*;

public class cowroute {

	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		// path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "cowroute.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + ".out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] cost = new int[1000][1000];

		int maxValue = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			int rCost = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(f.readLine());
			int[] route = new int[num];
			for (int j = 0; j < num; j++) {
				route[j] = Integer.parseInt(st.nextToken()) - 1;
				if (route[j] > maxValue) {
					maxValue = route[j];
				}
				for (int k = 0; k < j; k++) {
					int c = cost[route[k]][route[j]];
					if (c == 0 || c > rCost) {
						cost[route[k]][route[j]] = rCost;
					}
				}
			}
		}

		int[][] newCost = new int[maxValue + 1][maxValue + 1];

		for (int i = 0; i < maxValue; i++) {
			for (int j = 0; j < maxValue; j++) {
				newCost[i][j] = cost[i][j];
			}
		}

		System.out.println(Arrays.deepToString(newCost));
		System.out.println("Max value: " + maxValue);
	}

}
