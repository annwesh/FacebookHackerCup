package facebook.hackerup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TravelRestrictions {
	public static void main(String args []) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/annwesh/eclipse-workspace/Leetcode/src/facebook/hackerup/travel_restrictions_input.txt")); 
			PrintWriter pw=new PrintWriter(new File("/Users/annwesh/eclipse-workspace/Leetcode/src/facebook/hackerup/output.txt")); 
			
			
			String line = br.readLine();
			int t = Integer.parseInt(line);
			int caseNo = t;
			while(t-- >0) {
				int n = Integer.parseInt(br.readLine());
				String I = br.readLine();
				String O = br.readLine();
				char output[][] =new char[n][n];
				
				// distance of length 0 and 1
				for(int i =0 ;i < n;i++) {
					output[i][i] = 'Y';
					if((i+1) < n) {
						output[i][i+1] = ((O.charAt(i) == 'Y') && (I.charAt(i+1) == 'Y')) ? 'Y' : 'N';
					}
					if((i-1) >=0) {
						output[i][i-1] = ((O.charAt(i) == 'Y') && (I.charAt(i-1) == 'Y')) ? 'Y' : 'N';
					}
				}
				
				for(int i=2;i<n;i++) {
					for(int j=0;j<n;j++) {
						int destback = j-i;
						int destfront = j+i;
						
						if(destback >=0) {
							output[j][destback] = (output[j-1][destback] == 'Y') && (output[j][destback+1] == 'Y') ? 'Y' : 'N' ; 
						}
						
						if(destfront < n) {
							output[j][destfront] = (output[j][destfront-1] == 'Y') && (output[j+1][destfront] == 'Y') ? 'Y' : 'N' ; 
						}
						
					}
				}
				pw.println("Case #"+(caseNo-t)+":");
				for(int i =0 ;i<n;i++) {
					pw.println(String.valueOf(output[i]));
				}
			}

		// Your code goes Here 

		pw.flush();
		pw.close();
		br.close();
		} catch(Exception e) {
			System.out.println("Error Occured: "+e);
		}
		
		
	}
}
