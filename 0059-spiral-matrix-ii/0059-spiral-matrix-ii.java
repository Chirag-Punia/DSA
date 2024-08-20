class Solution {
    public int[][] generateMatrix(int n) {
       int [][] matrix = new int[n][n];
     int a=1;
      
      int top=0;
      int bottom= n-1;//2
      int left=0;
      int right=n-1;//2
      
      while(top<=bottom && left<=right){
          for(int i  =left;i<=bottom;i++){
               matrix[top][i]=a;
               a++;
          }
          top++;
          for(int i= top;i<=bottom;i++){
              matrix[i][right]=a;
               a++;
          }
          right--;
          if(top<=bottom){
              for(int i=right;i>=left;i--){
                  matrix[bottom][i]= a;
                  a++;
              }
              bottom--;
          }
          if(left<=right){
              for(int i=bottom;i>=top;i--){
                  matrix[i][left]=a;
                  a++;
              }
              left++;
          }
      }    
        
   return matrix;
    }
}