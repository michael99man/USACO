package december2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class crosswords {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crosswords.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] grid = new char[n][m];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(f.readLine());
			String str = st.nextToken();
			grid[i] = str.toCharArray();
		} 
		f.close();

		int clues = 0;
		int[][] coords = new int[500][2];
		boolean record = false;
		
		for(int y = 0; y<n;y++){
			for(int x = 0;x<m;x++){
				//horizontal checking
				record = false;
				if(x+1 <m && x+2 <m && grid[y][x] == '.'){
					if((x-1 < 0 || grid[y][x-1] == '#') && grid[y][x+1] == '.' && grid[y][x+2] == '.'){
						if(!record){
						coords[clues][0] = x+1;
						coords[clues][1] = y+1;
						record = true;
						clues++;
						};
					}
				}
				
				if(y+1 <n && y+2 <n && grid[y][x] == '.'){
					if((y-1 <0 || grid[y-1][x] == '#') && grid[y+1][x] == '.' && grid[y+2][x] == '.' ){
						if(!record){
						coords[clues][0] = x+1;
						coords[clues][1] = y+1;
						record = true;
						clues++;
						};
					}
				}
			}
		}

		out.println(clues);
		int newX,newY;
		
		for(int clueNum = 0; clueNum < clues;clueNum++){
			newX = coords[clueNum][1];
			newY = coords[clueNum][0];
			if(newX>0 && newY>0){
				out.println(newX + " " + newY);
			}
		}
		
		out.close();
	}

}
