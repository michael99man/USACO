package january2015silver;

import java.io.*;
import java.util.*;

public class meeting {

	public static void main(String[] args) throws IOException{
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/";
		BufferedReader f = new BufferedReader(new FileReader(path + "meeting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "meeting.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] aPaths = new int[N][N];
		int[][] bPaths = new int[N][N];
		
		for(int i = 0; i<M;i++){
			st = new StringTokenizer(f.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			aPaths[A][B] = Integer.parseInt(st.nextToken());
			bPaths[A][B] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] aCan = solve(aPaths);
		System.out.println(Arrays.toString(aCan));
		boolean[] bCan = solve(bPaths);
		System.out.println(Arrays.toString(bCan));
		
	    int best = Integer.MAX_VALUE;
	    for(int i = 0; i < aCan.length; i++) {
	      if(aCan[i] && bCan[i]) {
	        best = i;
	        break;
	      }
	    }
	    if(best == Integer.MAX_VALUE) {
	      out.println("IMPOSSIBLE");
	    }
	    else {
	      out.println(best);
	      System.out.println(best);
	    }
	    out.close();
	}
	
	static boolean[] solve(int[][] dist){
		int n = dist.length;
		boolean[][] dp = new boolean[n][100*n+1];
		dp[0][0] = true;
		//iterate through each row
		//for each starting point
		for(int i=0;i<n;i++){
			//for each possible time
			for(int j=0;j<dp[i].length;j++){
				if(dp[i][j]){
					//for each field you can move from i
					for(int k = i+1;k<n;k++){
						dp[k][j+dist[i][k]] = true;
					}
				}
			}	
		}
		return dp[n-1];
	}

}
