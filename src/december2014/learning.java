package december2014;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class learning {

	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "learning.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "learning.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] cows = new int[n+2][2];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(f.readLine());
			String str = st.nextToken();
			if(str.equals("NS")){
				cows[i][0] = 0;
			} else {
				cows[i][0] = 1;
			}
			cows[i][1] = Integer.parseInt(st.nextToken());
		} 
		cows[n][0] = 0;
		cows[n][1] = -100000000;
		cows[n+1][0] = 0;
		cows[n+1][1] = 100000000;
		
		Arrays.sort(cows, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
		
		int spots = 0;
		for(int i=0; i<cows.length-1;i++){
			int S = cows[i][1];
			int E = cows[i+1][1];
			double M = (S+E)/2;
			/*
			System.out.println("Index: " + i);
			System.out.println("S: " + S);
			System.out.println("E: " + E);
			System.out.println("M: " + M);
			*/
			
			if(cows[i][0] == 1){
				int s = Math.max(a,S+1);
				double e = Math.min(b,M);
				if(e>=s){
					spots += e-s+1;
				}
			}
			
			if(cows[i+1][0] == 1){
				double s = Math.max(a,M+1);
				double e = Math.min(b,E);
				if(e>=s){
					spots += e-s+1;
				}
			}
			
			if(cows[i+1][0] == 1 && cows[i][0] == 0 && (S%2) == (E%2) && a<=M && M<=b){
				spots++;
			}
		}
		//System.out.println(spots);
		out.println(spots);
		out.close();
	}
	
	public class ArrayComparator implements Comparator<Integer[]>{
		@Override
		public int compare(Integer[] o1, Integer[] o2) {
			return o1[1].compareTo(o2[1]);
		}
	}

}
