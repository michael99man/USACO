
/*
ID: michael99man
LANG: JAVA
PROG: barn1
*/

package training;

import java.io.*;
import java.util.*;

public class barn1 {

	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "barn1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		//number of boards
		int M = Integer.parseInt(st.nextToken());
		//number of stalls
		int S = Integer.parseInt(st.nextToken());
		//number of cows
		int C = Integer.parseInt(st.nextToken());
		
		//from 0 to S-1
		BitSet cows = new BitSet(S+1);
		for(int c=0;c<C;c++){
			cows.set(Integer.parseInt(f.readLine()));
		}
		f.close();
		//blocked or not
		BitSet stalls = new BitSet(S+1);
		
		//sets all stalls
		stalls.set(0, S+1);
		
		/*
		for(int i=1; i <= S; i++){
			System 
		
		//remove beginning and ending gaps
		
		int l = 1;
		
		while(!cows.get(l)){
			stalls.set(l,false);
			l++;
		}
		
		l = S;
		
		while(!cows.get(l)){
			stalls.set(l,false);
			l--;
		}
		
		
		*/
		
		for(int boards = 1; boards <M; boards++){
			//find largest hole
			int[] loc = largestGap(stalls, cows);
			//unblock the hole
			System.out.println("Unblock: " + loc[0] + " - " + loc[1]);
			stalls.set(loc[0],loc[1]+1,false);
		}
		
		System.out.println(stalls.toString());
		int count = 0;
		for(int i=1;i<=S;i++){
			if(stalls.get(i)){
				count++;
			}
		}
		System.out.println(count);
		out.println(count);
		out.close();
	}
	
	public static int[] largestGap(BitSet s, BitSet c){
		int[] loc = new int[2];
		int longest = 0;
		int current = 0;
		int start = 1;
		
		for(int i=1;i<=c.length();i++){
			//if no cow and covered
			if(!c.get(i) && s.get(i)){
				current++;
			} else {
				if(current > longest){
					System.out.println("Start: " + start + " - End: " + (i-1));
					loc[0] = start;
					loc[1] = i-1;
					longest = current;
				}
				start = i+1;
				current = 0;
			}
		}
		System.out.println(loc[0] + " " + loc[1]);
		return loc;
	}

}
