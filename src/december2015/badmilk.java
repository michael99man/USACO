package december2015;

import java.io.*;
import java.util.*;

public class badmilk {

	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "badmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "badmilk.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		//number of people
		int N = Integer.parseInt(st.nextToken());
		//types of milk
		int M = Integer.parseInt(st.nextToken());
		//number of drinks drunk
		int D = Integer.parseInt(st.nextToken());
		//number of people sick
		int S = Integer.parseInt(st.nextToken());
		
		//drink# : person, milk type, time
		int[][] drinkList = new int[D][3];
		
		//sick#: person, time
		int[][] sickList = new int[S][2];
		
		ArrayList<Integer> sicked = new ArrayList<Integer>();
		ArrayList<Integer> timeSick = new ArrayList<Integer>();
		//System.out.println("N:" + N + " M:" + M + " D:" + D + " S:" + S);
		
		for(int d=0;d<D;d++){
			st = new StringTokenizer(f.readLine());
			drinkList[d][0] = Integer.parseInt(st.nextToken());
			drinkList[d][1] = Integer.parseInt(st.nextToken());
			drinkList[d][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int s=0;s<S;s++){
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sicked.add(a);
			timeSick.add(b);
			sickList[s][0] = a;
			sickList[s][1] = b;
		}
		f.close();
		
		//sick person id, drinks drunken
		Map<Integer, ArrayList<Integer>> badDrinks = new HashMap<Integer, ArrayList<Integer>>(1000);
		
		System.out.println("SICKED: " + sicked);
		//DRINK: person, milk, time
		for(int[] drink: drinkList){
			//guy who drank drink got sick
			int index = sicked.indexOf(drink[0]);
			if(index != -1){
				if(timeSick.get(index) > drink[2]){
					if(!badDrinks.containsKey(drink[0])){
						badDrinks.put(drink[0], new ArrayList<Integer>());
					}
					badDrinks.get(drink[0]).add(drink[1]);
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> maybeBad = new ArrayList<ArrayList<Integer>>();
		
		for(Integer key: badDrinks.keySet()){
			//System.out.println("Person: " + key);
			//System.out.println(badDrinks.get(key));
			maybeBad.add(badDrinks.get(key));
		}
		System.out.println(maybeBad);
		
		ArrayList<Integer> bad = maybeBad.get(0);
		for(int i = 1;i<maybeBad.size();i++){
			bad.retainAll(maybeBad.get(i));
		}
		System.out.println(bad);
		

		//RUNTIME ERROR SOMEWHERE BELOW!!
	
		//ArrayList<ArrayList<Integer>> drinksArray = new ArrayList<ArrayList<Integer>>();
		
		Map<Integer, ArrayList<Integer>> personSick = new HashMap<Integer, ArrayList<Integer>>(1000);
		
		for(int[] drinkarino : drinkList){
			int person = drinkarino[0]-1; 
			int milk = drinkarino[1]; 
			if(!personSick.containsKey(person)){
				personSick.put(person, new ArrayList<Integer>());
			}
			
			if(!personSick.get(person).contains(milk)){
				personSick.get(person).add(milk);
			}
		}
		
		int most = 0;
		for(int milkID: bad){
			
			
			int ensickenfied = 0;
			for(ArrayList<Integer> drunked : personSick.values()){
				if(drunked.contains(milkID)){
					ensickenfied++;
				}
			}
			//System.out.println("MILK " + milkID +" AT MOST SICKENED " + ensickenfied + " PEOPLE");
			if(ensickenfied > most){
				most = ensickenfied;
			}
		}
		System.out.println(most);
		out.println(most);
		out.close();
		
		//make list of sick ppl and time sickened
		//make list of lists of drinks drunk before time sick
		//find intersection
		
		//possible bad drinks
		//find max # of ppl who drank one of them
		
	}
}
