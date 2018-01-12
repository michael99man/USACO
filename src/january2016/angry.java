//package january2016;

import java.io.*;
import java.util.*;

public class angry {

	public static void main(String[] args) throws IOException{
		String path = "";
		//path = "/Users/michaelzman/Desktop/USACO/";
		BufferedReader f = new BufferedReader(new FileReader(path + "angry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "angry.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		//number of hay
		int N = Integer.parseInt(st.nextToken());
		
		//number of shots
		int K = Integer.parseInt(st.nextToken());

		
		LinkedList<Integer> hay = new LinkedList<Integer>();
		
		for(int i = 0; i<N;i++){
			st = new StringTokenizer(f.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			if(!hay.contains(t)){
				hay.add(t);
			}
		}
		
		Collections.sort(hay);
		System.out.println(hay);
		
		int total = 0;
		int[] diff = new int[hay.size()-1];
		for(int i=0;i<hay.size()-1;i++){
			diff[i] = hay.get(i+1) - hay.get(i);
			total += diff[i];
		}
		
		System.out.println(Arrays.toString(diff));
		System.out.println("Total: " + total);
		double interval = total/K;
		System.out.println("Each interval: " + interval);
		
		int largest = 0;
		int a = 0;
		int b = 0;
		
		int i=0;
		while(i<diff.length){
			System.out.println("Start: " + i);
			int sum = 0;
			int start = i;
			while(sum < interval && i<diff.length){
				sum+=diff[i];
				i++;
			}
			if(i>=diff.length){
				i++;
			}
			
			System.out.println("Interval: " + start + " " + (i-1));
			int s = hay.get(start);
			int e = hay.get(i-1);
			System.out.println("Values: " + s + " " + e);
			
			if(e-s > largest){
				a = s;
				b = e;
				largest = e-s;
			}
		}
		
		System.out.println("Largest: " + a + " " + b);
		
		int mid = (int) Math.ceil((a+b)/2);
		System.out.println(mid);
		
		int power = Math.max(mid-a, b-mid);
		System.out.println(power);
		out.println(power);
		
		/*
		for(int r = 1; r<Integer.MAX_VALUE;r++){
			BitSet covered = new BitSet(N-1);
			for(int cow = 1;cow<K+1;cow++){
				covered = most(hay,covered,r);
			}
			
			System.out.println(covered);
			if(check(hay,covered)){
				out.println(r);
				System.out.println("POWER: " + r);
				break;
			}
		}
		*/
		out.close();
	
	}

	
}
