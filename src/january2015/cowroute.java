package january2015;



import java.io.*;
import java.util.*;

public class cowroute {

	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		//path = "/Users/michaelzman/Desktop/cowroute_bronze/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "cowroute.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + ".out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		//ArrayList<Integer>[] routes = new ArrayList[n];
		
		int[][] routes = new int[n][];
		int[] costs = new int[n];
		//System.out.println("A: " + a + " B: " + b);
		//System.out.println("There are: " + n + " routes");
		
		int lowest = -1;
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(f.readLine());
			//cost
			costs[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			routes[i] = new int[num];
			st = new StringTokenizer(f.readLine());
			for(int j = 0; j<num;j++){
				routes[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int aIndex = search(routes[i],a);
			int bIndex = search(routes[i],b);

			if(aIndex != -1 && bIndex != -1 && aIndex<bIndex){
				if(lowest == -1 || costs[i] < lowest){
					lowest = costs[i];
				}
			}
		} 
		f.close();
		System.out.println(lowest);
		out.println(lowest);
		out.close();
	}

	public static int search(int[] array, int element){
		for(int k=0;k<array.length;k++){
			if(array[k] == element){
				return k;
			}
		}
		return -1;
	}
}
