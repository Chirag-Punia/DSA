import java.util.*;
import java.lang.*;
import java.io.*;
//https://www.codechef.com/START139D/problems/DISCOOKIE
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0;i<T;i++){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int multiplier = m/n;
		    int prev = multiplier * n;
		    int next = ((multiplier + 1)*n);
		    int prevDiff = Math.abs(prev - m);
		    int nextDiff = Math.abs(next - m);
		    if(n > m){
		        System.out.println(nextDiff);
		    }
		    else if(m % n == 0){
		        System.out.println(0);
		    }
		    else if(prevDiff == 0){
		        System.out.println(nextDiff);
		    }
		    else if(nextDiff == 0){
		        System.out.println(prevDiff);
		    }
		    else{
		        System.out.println(Math.min(prevDiff,nextDiff));
		    }
		    
		    
		}

	}
}
