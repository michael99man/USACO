package december2015;

import java.io.*;
import java.util.*;

public class highcard {

	public static boolean print = true;
	
	public static ArrayList<Integer> eCards;
	public static ArrayList<Integer> bCards;
	
	public static void main(String[] args) throws IOException{
		String path = "/Users/michaelzman/Desktop/USACO/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "highcard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "highcard.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		// num of cards
		int N = Integer.parseInt(st.nextToken());
		
		eCards = new ArrayList<Integer>();
		bCards = new ArrayList<Integer>();
		
		for(int n=0;n<N;n++){
			st = new StringTokenizer(f.readLine());
			eCards.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(eCards);
		//System.out.println(eCards);
		
		int cur;
		int next;
		
		if(eCards.get(0) > 1){
			for(int k = 1; k<eCards.get(0);k++){
				bCards.add(k);
			}
		}
		
		for(int i=0;i<eCards.size()-1;i++){
			cur = eCards.get(i);
			next = eCards.get(i+1);
			if(cur+1 != next){
				for(int j=1;j<next-cur;j++){
					bCards.add(cur+j);
				}	
			}
		}
		
		if(eCards.get(N-1) < 2*N){
			for(int k = eCards.get(N-1) + 1; k<= 2*N;k++){
				bCards.add(k);
			}
		}
		//System.out.println(bCards);
		
		int wins = 0;
		int e,index,b;
		for(int i = 0; i<eCards.size();i++){
			e = eCards.get(i);
			index = closest(bCards,e);
			if(index!=-1){
				//b = bCards.get(index);
				//used up!
				bCards.remove(index);
				//System.out.println(b + " beats " + e);
				wins++;
			} /*else{
				System.out.println("CONCEDE AGAINST: " + e);
			}*/
		}
		out.println(wins);
		f.close();
		out.close();
	}
	
	//closest above
	//returns INDEX
	//-1 if no possible larger
	public static int closest(ArrayList<Integer> b, int i){
		int count = 0;
		for(int card: b){
			if(card>i){
				return count;
			}
			count++;
		}
		return -1;
	}

}
