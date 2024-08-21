//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends




class GfG
{
    int minEle;
    Stack<Integer> s;
    Stack<Integer> Min;
    
    // Constructor    
    GfG()
	{
	    s=new Stack<>();
	    Min = new Stack<>();

	}
	
    /*returns min element from stack*/
    int getMin()
    {
        if(Min.size()==0){
	    return -1;
	}
        return Min.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here
	if(s.size()==0){
	    return -1;
	}
	int X = s.peek();
	s.pop();
	if(X==Min.peek()){
	    Min.pop();
	}
	return X;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	s.push(x);
	if(Min.isEmpty() ||  x<=Min.peek()){
	    Min.push(x);
	}
    }	
}