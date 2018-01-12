package training;
/*
ID: michael99man
LANG: JAVA
PROG: beads
*/

//package training;

import java.util.*;
import java.io.*;

public class beads {

	public static char[] beads;
	
	public static void main(String[] args) throws IOException {
		String path = "";
		//path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "beads.out")));
		int N = Integer.parseInt(f.readLine());
		String s = f.readLine();
		beads = s.toCharArray();
		
		char t = beads[0];
		boolean all = true;
		for(char c: beads){
			if(t != c && c != 'w'){
				all = false;
			}
		}
		if(all){
			out.println(beads.length);
			out.close();
			return;
		}
		
		int most = 0;
		//breaks between 0,1 thru N,0 
		//break each between i and i+1
		for(int i = 0; i<N;i++){
			//left
			int left = 1;
			char type = beads[i];
			
			int count = 0;
			while(type=='w'){
				count++;
				type = beads[get(i-count)];
			}
			boolean valid = true;
			
			int extreme = 0;
			while(valid){
				if(beads[get(i-left)] == type || beads[get(i-left)] == 'w'){
					left++;
				}else{
					valid = false;
					extreme = i-left;
				}
			}
			
			System.out.println("Break at: " + i + " has " + left + " of type " + type);
			//right
			int right = 1;
			type = beads[get(i+1)];
			
			count = 0;
			while(type=='w'){
				count++;
				type = beads[get(i+count)];
			}

			valid = true;
			while(valid){
				if(beads[get(i+right)] == type || beads[get(i+right)] == 'w' && !equal(extreme,i+right-1)){
					right++;
				}else{
					valid = false;
				}
			}
			
			
			right--;
			System.out.println("Break at: " + i + " has " + right + " of type " + type);
			System.out.println("SUM: " + (left + right));
			
			if(left+right > most){
				most = left + right;
			}
		}
		System.out.println("MOST: " + most);
		out.println(most);
		out.close();
	}

	
	public static int get(int i){
		if(i<0){
			return i+beads.length;
		} else if(i>=beads.length){
			return i-beads.length;
		}
		return i;
	}
	
	public static boolean equal(int a, int b){
		System.out.println("Left: " + a + " right: " + b);
		System.out.println("Leftmost: " + get(a) + " right: " + get(b));
		System.out.println(get(a) == get(b));
		return get(a) == get(b);
	}
}
