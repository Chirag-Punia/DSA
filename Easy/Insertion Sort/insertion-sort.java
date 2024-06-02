//{ Driver Code Starts
import java.util.*;
import java.lang.Math;

class Sorting
{
	
	static void printArray(int arr[],int size)
	{
		int i;
		for(i=0;i<size;i++)
		System.out.print(arr[i]+" ");
	    System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
		
			for(int i=0;i<n;i++)
			a[i]= sc.nextInt();
			
			 new Solution().insertionSort(a,n);
			 printArray(a,n);
			
		t--;
		}
		
	}
}
// } Driver Code Ends

class Solution
{
  //Function to sort the array using insertion sort algorithm.
  public static void insertionSortRecursion(int[] arr , int startIndex){
      if(startIndex == arr.length){
          return;
      }
      int j = startIndex;
      while(j > 0 && (arr[j-1] > arr[j])){
          int temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
          j--;
      }
      insertionSortRecursion(arr,startIndex + 1);
  }
  
  
  
  
  public void insertionSort(int arr[], int n)
  {
      //code here
      insertionSortRecursion(arr,1);
    //   for(int i = 1 ; i<n;i++){
    //       int j = i;
    //       while(j > 0 && (arr[j-1] > arr[j]) ){
    //           int temp = arr[j-1];
    //           arr[j-1] = arr[j];
    //           arr[j] = temp;
    //           j--;
    //       }
    //   }
  }
}
