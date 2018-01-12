/*
ID: michael99man
LANG: JAVA
PROG: namenum
*/
package training;
import java.io.*;

public class namenum {
	
	public static char[] list = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','W','X','Y'};
			
	public static void main(String[] args) throws IOException {
		String path = "";
		path = "/Users/michaelzman/Desktop/USACO/training/";
		BufferedReader f = new BufferedReader(new FileReader(path + "namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "namenum.out")));
		BufferedReader df = new BufferedReader(new FileReader(path + "dict.txt"));
		String line = df.readLine();
		boolean none = true;
		int count = 0;
		String[] dict = new String[4617];
		while(line != null && !line.isEmpty()){
			dict[count] = line;
			count++;
			line = df.readLine();
		}

		String s = f.readLine();
		long num = Long.parseLong(s);
		int digits = s.length();

		System.out.println(num);
		System.out.println(convert("KRISTOPHER"));
		for(int i=0; i<dict.length;i++){
			if(dict[i].length() == digits){
				if(convert(dict[i]) == num){
					System.out.println(dict[i]);
					out.println(dict[i]);
					none = false;
				}
			}
		}
		if(none){
			System.out.println("NONE");
			out.println("NONE");
		}
		out.close();
	}
	
	public static long convert(String s){
		String str = "";
		for(char c: s.toCharArray()){
			int index = 1;
			for(char z : list){
				if(z == c){
					break;
				} else {
				index++;
				}
			}
			str+= (int) (Math.ceil((double)index/3) + 1);
		}
		return Long.parseLong(str);
	}
}
