package january2016;

import java.io.*;
import java.util.*;

public class gates {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/";
		BufferedReader f = new BufferedReader(new FileReader(path + "gates.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "gates.out")));
		int N = Integer.parseInt(f.readLine());
		char[] moves = f.readLine().toCharArray();

		ArrayList<Character> list = new ArrayList<Character>();

		list.add(moves[0]);

		for (int i = 1; i < moves.length; i++) {
			if (list.size() >= 1) {
				char a = list.get(list.size() - 1);
				char b = moves[i];
				if (!(a == 'S' && b == 'N' || a == 'N' && b == 'S')
						&& !(a == 'W' && b == 'E' || a == 'E' && b == 'W')) {
					list.add(b);
				} else {
					list.remove(list.size() - 1);
				}
			} else {
				list.add(moves[i]);
			}
		}

		System.out.println(list);

		System.out.println("Original: " + Arrays.toString(moves));
		
		N = list.size();
		moves = new char[list.size()];
		for(int i=0;i<list.size();i++){
			moves[i] = list.get(i);
		}

		System.out.println("Current:  " + Arrays.toString(moves));
		
		int[][] points = new int[N + 1][3];

		int[] p = new int[3];
		p[0] = 0;
		p[1] = 0;
		p[2] = 0;

		points[0] = p.clone();

		for (int n = 1; n < N + 1; n++) {
			switch (moves[n - 1]) {
			case 'N':
				p[1]++;
				p[2] = 1;
				break;
			case 'S':
				p[1]--;
				p[2] = 2;
				break;
			case 'E':
				p[0] += 1;
				p[2] = 3;
				break;
			case 'W':
				p[0]--;
				p[2] = 4;
				break;
			}
			int[] newP = p.clone();
			points[n] = newP;
		}

		// System.out.println(Arrays.deepToString(points));

		int counter = 0;

		for (int a = 0; a < N + 1; a++) {
			for (int b = a + 1; b < N + 1; b++) {
				int[] j = points[a];
				int[] k = points[b];
				if (j[0] == k[0] && j[1] == k[1] && j[2] != k[2]) {
					counter++;
				}
			}
		}
		System.out.println(counter);
		out.println(counter);
		f.close();
		out.close();
	}

}
