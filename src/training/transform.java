
/*
ID: michael99man
LANG: JAVA
PROG: transform
*/
package training;

import java.io.*;
import java.util.*;

/*
 * 1: 90 degrees clockwise
 * 2: 180 degrees clockwise
 * 3: 270 degrees clockwise
 * 4: Horizontal Reflection
 * 5: 4 + 1/2/3
 * 6: No Change
 * 7: Invalid
 */
public class transform {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "transform.out")));
		int N = Integer.parseInt(f.readLine());

		char[][] original = new char[N][N];
		char[][] transform = new char[N][N];
		int type = 7;

		for (int n = 0; n < N; n++) {
			original[n] = f.readLine().toCharArray();
		}
		for (int n = 0; n < N; n++) {
			transform[n] = f.readLine().toCharArray();
		}

		// 1: 90 degrees clockwise
		if (Arrays.deepEquals(transform, rotate(original))) {
			type = 1;
		} else if (Arrays.deepEquals(transform, rotate(rotate(original)))) {
			type = 2;
		} else if (Arrays.deepEquals(transform, rotate(rotate(rotate(original))))) {
			type = 3;
		} else if (Arrays.deepEquals(transform, reflect(original))) {
			type = 4;
		} else {
			ArrayList<char[][]> list = new ArrayList<char[][]>();
			char[][] r = reflect(original);
			list.add(rotate(r));
			list.add(rotate(rotate(r)));
			list.add(rotate(rotate(rotate(r))));
			for (char[][] ch : list) {
				if (Arrays.deepEquals(ch, transform)) {
					type = 5;
					break;
				}
			}
			
			if(type == 7 && Arrays.deepEquals(transform, original)){
				type = 6;
			}
		}
		System.out.println(type);
		out.println(type);
		out.close();

	}

	// rotates 90 degrees
	public static char[][] rotate(char[][] array) {
		final int l = array.length;
		char[][] rotated = new char[l][l];
		for (int x = 0; x < l; x++) {
			for (int y = 0; y < l; y++) {
				rotated[y][l - 1 - x] = array[x][y];
			}
		}

		return rotated;
	}

	public static void print(char[][] array) {
		for (char[] sub : array) {
			String s = "";
			for (char c : sub) {
				s += c;
			}
			System.out.println(s);
		}
		System.out.println();
	}

	public static char[][] reflect(char[][] array) {
		final int l = array.length;
		char[][] reflected = new char[l][l];

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				reflected[i][l - 1 - j] = array[i][j];
			}
		}
		return reflected;
	}
}
