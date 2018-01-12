package january2015;


import java.io.*;
import java.util.*;

public class cowroute2 {

	public static void main(String[] args) throws IOException {
		String path;
		//path = "/Users/michaelzman/Desktop/USACO/cowroute";
		//path = "/Users/michaelzman/Desktop/cowroute2_bronze/6";
		path = "cowroute";
		BufferedReader f = new BufferedReader(new FileReader(path + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + ".out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		//ArrayList<Integer>[] routes = new ArrayList[n];
		
		ArrayList<Integer>[] routes = new ArrayList[n];
		int[] costs = new int[n];
		//System.out.println("A: " + a + " B: " + b);
		//System.out.println("There are: " + n + " routes");
		
		//holds the routes that have A
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		//holds the routes that have B
		ArrayList<Integer> bList = new ArrayList<Integer>();
		
		int lowest = -1;
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(f.readLine());
			//cost
			costs[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			routes[i] = new ArrayList<Integer>();
			st = new StringTokenizer(f.readLine());
			for(int j = 0; j<num;j++){
				routes[i].add(Integer.parseInt(st.nextToken()));
			}
			
			//TRUNCATE LISTS
			
			
			int aIndex = routes[i].indexOf(a);
			int bIndex = routes[i].indexOf(b);

			if(aIndex != -1 && aIndex < routes[i].size()-1){
				aList.add(i);
				System.out.println(i + " has a");
			}
			
			if(bIndex != -1 && bIndex > 0){
				bList.add(i);
				System.out.println(i + " has b");
			}
			
			if(aIndex != -1 && bIndex != -1 && aIndex<bIndex){
				if(lowest == -1 || costs[i] < lowest){
					lowest = costs[i];
				}
			}
		} 
		
		
		List<Integer> intersections;
		
		for(int aIndex : aList){
			for (int bIndex : bList){
				
				List<Integer> aListList = routes[aIndex].subList(routes[aIndex].indexOf(a)+1, routes[aIndex].size());
				List<Integer> bListList = routes[bIndex].subList(0,routes[bIndex].indexOf(b));
				
				intersections = intersection(aListList,bListList);
				if(!intersections.isEmpty()){
					int cost = costs[aIndex] + costs[bIndex];
					if(cost < lowest || lowest == -1){
						lowest = cost;
					}
				}
			}
		}
		
		f.close();
		System.out.println(lowest);
		out.println(lowest);
		out.close();
	}

	public static int search(int[] array, int element){
		for(int k=0;k<array.length;k++){
			if(array[k] == element){
				return k;
			}
		}
		return -1;
	}
	
    public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<Integer>();

        for (int t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
