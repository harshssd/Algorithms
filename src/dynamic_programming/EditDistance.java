package dynamic_programming;

public class EditDistance {

	public static int findEditDistance(String str1, String str2) {
		
		//matrix containing the status of the sub problems
		int[][] D = new int[str1.length()+1][str2.length()+1];
		
		//initialize first row and column of matrix
		for(int i=0; i<str1.length(); i++){
			D[i][0] = i;  
		}
		for(int j=0; j<str2.length(); j++){
			D[0][j] = j;  
		}
		
		//extend the subproblem by iterating over every element of the string
		int D1, D2, D3;
		for(int i=1; i<=str1.length(); i++){
			for(int j=1; j<=str2.length(); j++){
				D1 = D[i-1][j] + 1; 
				D2 = D[i][j-1] + 1;
				if(str1.charAt(i-1) == str2.charAt(j-1))
					D3 = D[i-1][j-1];
				else
					D3 = D[i-1][j-1]+2;
				D[i][j] = getMinimum(D1, D2, D3);
			}
		}
		return D[str1.length()][str2.length()];
	}

	private static int getMinimum(int d1, int d2, int d3) {
		int min12 = Math.min(d1, d2); 
		return Math.min(min12, d3);
	}

}
