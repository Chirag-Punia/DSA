//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         HashMap<Integer,Integer> frequency  =  new HashMap<>();
        
        Comparator<Integer> comparator = new Comparator<>()
        {
            public int compare(Integer a , Integer b)
            {
                   int diff= frequency.get(b)-frequency.get(a);
                   return (diff==0)?a-b:diff;
            }
        };
        for(int i=0;i<arr.length;i++)
        {
            
         ArrayList<Integer> ar = new ArrayList<>();
         
                frequency.put(arr[i],frequency.getOrDefault(arr[i],0)+1);
                
                for(int n:frequency.keySet())
                ar.add(n);
      
          Collections.sort(ar,comparator);
          
          if(ar.size()>K)
          {
               ArrayList<Integer> a = new ArrayList<>();
              for(int j=0;j<K;j++)
              a.add(ar.get(j));
              
               result.add(a);
          }
          else
                     result.add(ar);
                
        }
        return result;
    }
}