package december2015;

import java.io.*;
import java.util.*;

public class lightson {

	public static int[][] grid;
	public static int N;

	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		//path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "lightson.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "lightson.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		// size of square grid
		N = Integer.parseInt(st.nextToken());
		// number of switches
		int M = Integer.parseInt(st.nextToken());

		grid = new int[N][N];

		ArrayList<int[]> switches = new ArrayList<int[]>();
		ArrayList<int[]> lights = new ArrayList<int[]>();

		int x1, x2, y1, y2;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(f.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			switches.add(new int[] { x1, y1 });
			lights.add(new int[] { x2, y2 });
		}

		f.close();
		// rooms that have been visited
		ArrayList<int[]> checked = new ArrayList<int[]>();

		// turn the light on
		grid[0][0] = 1;

		// queue of rooms
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 1, 1 });

		int[] curRoom;
		int[] bulb;

		ArrayList<Integer> indexes;
		ArrayList<int[]> possible;

		int[] up;
		int[] down;
		int[] left;
		int[] right;

		ArrayList<int[]> cant = new ArrayList<int[]>();

		int lightNum = 1;
		while (!queue.isEmpty()) {
			curRoom = (int[]) queue.poll();
			if (has(checked, curRoom) == -1 && grid[curRoom[0] - 1][curRoom[1] - 1] == 1) {
				checked.add(curRoom);
				// System.out.println("Looking at room: " + curRoom[0] + " " +
				// curRoom[1]);
				// turn on lights

				indexes = indices(switches, curRoom);
				if (!indexes.isEmpty()) {
					for (int index : indexes) {
						bulb = lights.get(index);
						// if not already illuminated
						if (grid[bulb[0] - 1][bulb[1] - 1] == 0) {
							// System.out.println("Turned on: " + bulb[0] + " "
							// + bulb[1]);
							grid[bulb[0] - 1][bulb[1] - 1] = 1;
							lightNum++;
							
							int cantIndex = has(cant, bulb);
							if (cantIndex != -1 && dontgot(queue, bulb)) {
								// System.out.println("Became available: " +
								// bulb[0] + " " + bulb[1]);
								queue.add(bulb);
								cant.remove(cantIndex);
							}
						}
					}
				}

				possible = possibleR(curRoom);
				// looks for rooms to walk to

				for (int[] room : possible) {
					if (valid(room)) {
						if (has(checked, room) == -1 && grid[room[0] - 1][room[1] - 1] == 1) {
							// System.out.println("Added room: " + room[0] + " "
							// + room[1]);
							if (dontgot(queue, room)) {
								queue.add(room);
							}
							//if not lighted, add to cant list
						} else if (grid[room[0] - 1][room[1] - 1] == 0){
							// System.out.println("Can't go to: " + room[0] + "
							// " + room[1]);
							if (has(cant, room) == -1) {
								cant.add(room);
							}
						}
					}
				}
			}
		}
		int num = 0;
		for(int[] as: grid){
			for(int s : as){
				if(s==1){
					num++;
				}
			}
		}
		//System.out.println(num);
		out.println(num);
		//System.out.println(lightNum);
		out.close();
	}

	
	public static ArrayList<int[]> possibleR(int[] curRoom){
		ArrayList<int[]> possible = new ArrayList<int[]>();
		int[] up = new int[2];
		int[] down = new int[2];
		int[] left = new int[2];
		int[] right = new int[2];

		up[0] = curRoom[0];
		up[1] = curRoom[1] + 1;
		down[0] = curRoom[0];
		down[1] = curRoom[1] - 1;
		left[0] = curRoom[0] - 1;
		left[1] = curRoom[1];
		down[0] = curRoom[0] + 1;
		down[1] = curRoom[1];

		possible.add(up);
		possible.add(down);
		possible.add(left);
		possible.add(right);
		return possible;
	}
	
	
	public static boolean dontgot(Queue<int[]> queue, int[] room) {
		for (int[] aRoom : queue) {
			if (aRoom[0] == room[0] && aRoom[1] == room[1]) {
				return false;
			}
		}
		return true;
	}

	public static int has(ArrayList<int[]> list, int[] point) {
		int i = 0;
		for (int[] aPoint : list) {
			if (aPoint[0] == point[0] && aPoint[1] == point[1]) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static ArrayList<Integer> indices(ArrayList<int[]> list, int[] point) {
		ArrayList<Integer> points = new ArrayList<Integer>();
		int i = 0;
		for (int[] aPoint : list) {
			if (aPoint[0] == point[0] && aPoint[1] == point[1]) {
				points.add(i);
			}
			i++;
		}
		return points;
	}

	public static boolean valid(int[] point) {
		// 1 -> N
		int x = point[0];
		int y = point[1];
		if (x > 0 && y > 0 && x <= N && y <= N) {
			return true;
		}
		return false;
	}
}
