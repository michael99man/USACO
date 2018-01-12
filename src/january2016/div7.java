package january2016;

import java.io.*;
import java.util.*;

public class div7 {

	public static void main(String[] args) throws IOException{
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/";
		BufferedReader f = new BufferedReader(new FileReader(path + "div7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "div7.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] id = new int[N];
		long[] sums = new long[N];
		
		long sum = 0;
		
		for(int n=0;n<N;n++){
			id[n] = Integer.parseInt(f.readLine());
			sum += id[n];
			sums[n] = sum;
		}
		f.close();
		System.out.println(Arrays.toString(id));
		System.out.println(Arrays.toString(sums));
		
		
		int longest = 0;
		
		for(int a=0;a<N;a++){
			for(int b = a+1;b<N;b++){
				//System.out.println(sums[b] - sums[a]);
				if((sums[b] - sums[a]) % 7 == 0){
					//System.out.println(a + " " + b);
					if(b-a > longest){
						longest = b-a;
					}
				}
			}
		}
		System.out.println(longest);
		out.println(longest);
		out.close();
	}

}
