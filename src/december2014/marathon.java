package december2014;

import java.io.*;
import java.util.*;

public class marathon {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
		
		int n = Integer.parseInt(f.readLine());
		int[][] checkpoints = new int[n][2];
		int[] distances = new int[n];
		distances[0] = 0;
		int total = 0;
		
		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			checkpoints[i][0] =Integer.parseInt(st.nextToken());
			checkpoints[i][1] =Integer.parseInt(st.nextToken());
			
			if(i>0){
				distances[i] = distance(checkpoints[i],checkpoints[i-1]);
				total += distances[i];
			}
		}
		f.close();
		
		int savings;
		
		int most = 0;
		int index = 0;
		
		for(int j=1;j<n-1;j++){
			savings = distances[j] + distances[j+1] - distance(checkpoints[j-1],checkpoints[j+1]);
			if(savings > most){
				most = savings;
				index = j;
			}
		}
		System.out.println(index);
		
		int finalDist = total - most;
		
		System.out.println(total + " -> " + finalDist);

		out.println(finalDist);
		out.close();
		System.exit(0);
	}
	
	private static int distance(int[] point1,int[] point2){
		return (Math.abs(point1[0]-point2[0]) + Math.abs(point1[1]-point2[1]));
	}

}
