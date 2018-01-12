package december2015;

import java.io.*;
import java.util.*;

public class speeding {

	static int[][] limitSegments;
	static int[][] speedSegments;
	
	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "speeding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "speeding.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//length - limit
		limitSegments = new int[n][2];
		speedSegments = new int[m][2];
		
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(f.readLine());
			limitSegments[i][0] = Integer.parseInt(st.nextToken());
			limitSegments[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 0;j<m;j++){
			st = new StringTokenizer(f.readLine());
			speedSegments[j][0] = Integer.parseInt(st.nextToken());
			speedSegments[j][1] = Integer.parseInt(st.nextToken());
		}
	
		//System.out.println(intersecting(40,60,0,40));
		//System.out.println(limit(0,40));
		
		int worst = 0;
		int total = 0;
		int infraction;
		for(int[] list : speedSegments){
			//System.out.print(total);
			total+=list[0];
			//System.out.println("-" + total);
			//System.out.println("LIMIT: " + limit(total-list[0],total));
			infraction = list[1] - limit(total-list[0],total);
			//System.out.println(infraction);
			if(infraction > 0 && infraction > worst){
				worst = infraction;
			}
		}
		System.out.println(worst);
		out.println(worst);
		out.close();
		f.close();
	}

	//returns the speedlimit at the current distance down the road
	public static int limit(int startDistance, int endDistance){
		ArrayList<Integer> possibleLimits = new ArrayList<Integer>();
		
		int start = 0;
		int end = 0;
		
		for(int i =0;i<limitSegments.length;i++){
			end += limitSegments[i][0];
			if(intersecting(start,end,startDistance,endDistance)){
				possibleLimits.add(limitSegments[i][1]);
			}
			if(end >= endDistance){
				break;
			}
		}
		
		if(possibleLimits.isEmpty()){
			return 0;
		} else {
			return Collections.min(possibleLimits);
		}
	}
	
	
	//ENDS ARE EXCLUSIVE
	public static boolean intersecting(int startA, int endA, int startB, int endB){
		return (startA >= startB && startA < endB) || (endA > startB && endA < endB) || (startB >= startA && startB < endA) || (endB > startA && endB < endA);
	}
}
