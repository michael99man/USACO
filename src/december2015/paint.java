package december2015;
import java.io.*;
import java.util.*;

public class paint {

	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "paint.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "paint.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(f.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		f.close();
		int lowest, highest;
		int total;
		
		if(a<c){
			lowest = a;
		} else {
			lowest = c;
		}
		
		if(b>d){
			highest = b;
		} else {
			highest = d;
		}
		total = highest - lowest;
		
		
		//if a-b doesnt overlap with c-d
		if(lowest == a && b < c){
			total = (b-a) + (d-c);
		}
		
		if(lowest == c && d < a){
			total = (b-a) + (d-c);
		}
		
		
		System.out.println(total);
		out.println(total);
		out.close();
	}

}
