package december2015;

import java.io.*;
import java.util.*;

public class bcount {

	public static int[] cows;
	public static int[][] queries;

	//one per query
	public static int[][] data;

	
	public static void main(String[] args) throws IOException {
		String path = "/Users/michaelzman/Desktop/USACO/";
		path = "";
		BufferedReader f = new BufferedReader(new FileReader(path + "bcount.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "bcount.out")));

		StringTokenizer st = new StringTokenizer(f.readLine());
		//num of cows
		int N = Integer.parseInt(st.nextToken());
		//num of queries
		int Q = Integer.parseInt(st.nextToken());

		cows = new int[N];
		queries = new int[Q][2];
		//data = new int[Q][3];
		
		for(int n=0;n<N;n++){
			st = new StringTokenizer(f.readLine());
			cows[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int q=0;q<Q;q++){
			st = new StringTokenizer(f.readLine());
			queries[q][0] = Integer.parseInt(st.nextToken());
			queries[q][1] = Integer.parseInt(st.nextToken());
		}
		
		f.close();
		int[] data;
		for(int[] q: queries){
			data = tally(q);
			String val = data[0] + " " + data[1] + " " + data[2];
			System.out.println(val);
			out.println(val);
		}
		out.close();
		
		/*
		Integer[] idx = new Integer[Q];
		for(int x = 0; x<Q;x++){
			idx[x] = x;
		}
		
		Arrays.sort(idx, new Comparator<Integer>() {
		    @Override public int compare(Integer o1, Integer o2) {
		        return queries[o1][0] - queries[o2][0];
		    }
		});		
		
		
		Arrays.sort(queries, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		int index = 0;
		int toChange = 0;
		ArrayList<int[]> queryList = new ArrayList<int[]>();
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		//for each cow
		for(int i = 0; i<N;i++){
			//System.out.println("Cow: " + (i +1));
			//start relevant queries
			while(index < queries.length && queries[index][0] == i+1){
				queryList.add(queries[index]);
				//System.out.println("Added range: " + queries[index][0] + " - " + queries[index][1]);
				data[index] = new int[3];
				indexes.add(index);
				index++;
			}
			
			toChange = cows[i] - 1;
			
			for(int j=0;j<queryList.size();j++){
				data[indexes.get(j)][toChange]++;
			}
			
			for(int j =0; j<queryList.size();j++){
				//end irrelevant queries
				if(queryList.get(j)[1] == i+1){
					//System.out.println("Ended range: " + queryList.get(j)[0] + " - " + queryList.get(j)[1]);
					queryList.remove(j);
					indexes.remove(j);
				}
			}
		}
	
		
		int[][] newList = new int[idx.length][3];
				
		int z = 0;
		for(int y:idx){
			newList[y] = data[z];
			z++;
		}
		
		for(int[] d : newList){
			String val = d[0] + " " + d[1] + " " + d[2];
			System.out.println(val);
			out.println(val);
		}
	
		f.close();
		out.close();
		*/
	}
	
	
	public static int[] tally(int[] q){
		int[] tal = new int[3];
		for(int j : Arrays.copyOfRange(cows,q[0]-1,q[1])){
			tal[j-1]++;
		}
		return tal;
	}

}
