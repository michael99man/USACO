package december2014;
/*
 ID: michael99man
 LANG: JAVA
 TASK: cowjog 
 */

import java.io.*;
import java.util.*;

public class cowjog {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("cowjog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
		
		int n = Integer.parseInt(f.readLine());
		int[][] cows = new int[n][2];
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			cows[i][0] =Integer.parseInt(st.nextToken());
			cows[i][1] =Integer.parseInt(st.nextToken());
		}
		f.close();
		
		int groups = 1;
		int prevSpeed = cows[n-1][1];
				
		for(int cow = n-2; cow >= 0; cow--){
			 if(cows[cow][1] > prevSpeed){
				 cows[cow][1] = prevSpeed;
			 } else {
				 groups++;
				 prevSpeed = cows[cow][1];
			 }
		}
		out.println(groups);
		out.close();
		System.exit(0);
	}

}
