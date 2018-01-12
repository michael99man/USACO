/*
ID: michael99man
LANG: JAVA
PROG: milk2
*/

package training;

import java.io.*;
import java.util.*;

public class milk2 {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "milk2.out")));
		int N = Integer.parseInt(f.readLine());
		int[][] times = new int[N][2];

		int largest = 0;
		int smallest = 0;
		int a, b;
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(f.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a < smallest || smallest == 0) {
				smallest = a;
			}
			if (b > largest) {
				largest = b;
			}
			times[n][0] = a;
			times[n][1] = b;
		}
		System.out.println("Full range: " + smallest + " -> " + largest + "\n");

		// N nCr 2 time
		BitSet used = new BitSet();
		ArrayList<int[]> newList = new ArrayList<int[]>();
		int[] merge = new int[2];
		for (int n = 0; n < N; n++) {
			if (!used.get(n)) {
				merge = times[n];
				System.out.println("Checking: " + merge[0] + " " + merge[1]);

				// combine this with each of the already merged intervals
				for (int k = newList.size() - 1; k >= 0; k--) {
					// System.out.println("Check: " + merge[0] + " " + merge[1]
					// + " with " + newList.get(k)[0] + " " +
					// newList.get(k)[1]);
					if (overlap(merge, newList.get(k))) {
						merge = combine(merge, newList.get(k));
						System.out.println("Removed: " + newList.get(k)[0] + " " + newList.get(k)[1]);
						newList.remove(k);
					}
				}

				for (int j = n + 1; j < N; j++) {
					if (overlap(merge, times[j])) {
						merge = combine(merge, times[j]);
						used.set(j);
					}
				}

				System.out.println("Added: " + merge[0] + " " + merge[1]);
				newList.add(merge);
			}
		}

		Collections.sort(newList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return new Integer(o1[0]).compareTo(new Integer(o2[0]));
			}
		});
		System.out.println("\nUnique Intervals: ");
		for (int[] az : newList) {
			System.out.println(az[0] + " " + az[1]);
		}

		ArrayList<int[]> copyList = new ArrayList<int[]>(newList);

		boolean go, changed;
		int[] A;
		int[] B;
		int counter = 0;
	
		for (int i = 0; i < copyList.size() - 1; i++) {
			A = newList.get(i);
			go = true;
			counter = 0;
			changed = false;
			while (go) {
				counter++;
				if (i + counter < newList.size()) {
					B = newList.get(i + counter);
					if (A[1] > B[0]) {
						A = combine(A, B);
						if (!changed) {
							changed = true;
						}
						newList.remove(i + counter);
					} else {
						go = false;
					}
				} else {
					go = false;
				}
			}
			if (changed) {
				newList.set(i, A);
			}
			if(i>=newList.size()-1){
				break;
			}
		}

		int longestOn = 0;
		int diff;
		for (int[] interval : newList) {
			diff = interval[1] - interval[0];
			if (diff > longestOn) {
				longestOn = diff;
			}
		}
		System.out.println("Longest On: " + longestOn);

		int longestOff = 0;
		int[] interval;
		for (int i = 0; i < newList.size(); i++) {
			interval = newList.get(i);
			if (i == 0) {
				diff = interval[0] - smallest;
			} else {
				diff = interval[0] - newList.get(i - 1)[1];
			}
			if (diff > longestOff) {
				longestOff = diff;
			}
		}
		System.out.println("Longest Off: " + longestOff);

		out.println(longestOn + " " + longestOff);
		out.close();
	}

	public static boolean overlap(int[] foo, int[] bar) {
		int a1 = foo[0];
		int b1 = foo[1];
		int a2 = bar[0];
		int b2 = bar[1];

		// System.out.println(a1 + " " + b1 + " <-> " + a2 + " " + b2);
		if ((a2 >= a1 && a2 <= b1) || (b2 >= a1 && b2 < b1)) {
			return true;
		}

		// if completely within
		if ((a1 >= a2 && b1 <= b2) || (a2 >= a1 && b2 <= b1)) {
			return true;
		}
		return false;
	}

	public static int[] combine(int[] foo, int[] bar) {
		int a1 = foo[0];
		int b1 = foo[1];
		int a2 = bar[0];
		int b2 = bar[1];

		int[] merged = new int[2];
		merged[0] = Math.min(a1, a2);
		merged[1] = Math.max(b1, b2);
		return merged;
	}
}
