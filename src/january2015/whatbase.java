package january2015;

import java.io.*;
import java.util.*;

public class whatbase {

	public static void main(String[] args) throws IOException {
		String path;
		//path = "/Users/michaelzman/Desktop/USACO/whatbase";
		path = "whatbase";
		BufferedReader f = new BufferedReader(new FileReader(path + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + ".out")));
		int K = Integer.parseInt(f.readLine());
		
		ArrayList<Integer> aList;
		ArrayList<Integer> bList;
		
		Integer[] aDigits;
		Integer[] bDigits;
		
		ArrayList<Integer> intersection;
		
		for(int i=0;i<K;i++){
			StringTokenizer st = new StringTokenizer(f.readLine());
			aList = new ArrayList<Integer>();
			bList = new ArrayList<Integer>();
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println("Evaluating: " + A + " and " + B);
			
			aDigits = getDigits(A);
			bDigits = getDigits(B);
			
			
			int baseA = 10;
			int baseB = 10;
			
			int newA = decimal(aDigits,baseA);
			int newB = decimal(bDigits,baseB);
			
			while(newA != newB){
				if(newA < newB){
					baseA++;
					newA = decimal(aDigits,baseA);
				} else {
					baseB++;
					newB = decimal(bDigits,baseB);
				}
			}
			System.out.println(newA + " " + newB);
			System.out.println(baseA + " " + baseB);
			out.println(baseA + " " + baseB);
			/*
			for(int base = 10; base<=15000; base++){
				aList.add(();
				bList.add(((int)Math.pow(base,2) *bDigits[0] + bDigits[1] * base + bDigits[2]));
			}
			
			intersection = (ArrayList<Integer>) intersection(aList,bList);
			
			if(!intersection.isEmpty()){
				System.out.println(intersection.get(0));
				System.out.println("Length: " + intersection.size());
				int baseA = 10 + aList.indexOf(intersection.get(0));
				int baseB = 10 + bList.indexOf(intersection.get(0));
				out.println(baseA + " " + baseB);
			}
			*/
		}
		f.close();
		out.close();
	}

	
	public static int decimal(Integer[] digits, int base){
		return (int)Math.pow(base,2) *digits[0] + digits[1] * base + digits[2];
	}
	
	public static Integer[] getDigits(int num) {
	    List<Integer> digits = new ArrayList<Integer>();
	    collectDigits(num, digits);
	    return digits.toArray(new Integer[]{});
	}
	

	private static void collectDigits(int num, List<Integer> digits) {
		if(num / 10 > 0) {
			collectDigits(num / 10, digits);
		}
		digits.add(num % 10);
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
