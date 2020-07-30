package facebook.hackerup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Alchemy {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/annwesh/eclipse-workspace/Leetcode/src/facebook/hackerup/alchemy_input.txt")); 
			PrintWriter pw=new PrintWriter(new File("/Users/annwesh/eclipse-workspace/Leetcode/src/facebook/hackerup/alchemy_output.txt")); 
		
		
			String line = br.readLine();
			int t = Integer.parseInt(line);
			int caseNo = t;
		
			while(t-- >0) {
				int n = Integer.parseInt(br.readLine());
				String I = br.readLine();
				int a=0,b=0;
				for(int i=0;i<n;i++) {
					if(I.charAt(i) == 'A')
						a++;
					else
						b++;
				}
				if(Math.abs(a-b)>1) {
					pw.println("Case #"+(caseNo-t)+": N");
				} else
					pw.println("Case #"+(caseNo-t)+": Y");
			}
			pw.flush();
			pw.close();
			br.close();
		} catch(Exception e) {
			System.out.println("Error occured");
			e.printStackTrace();
		}
	}
}
