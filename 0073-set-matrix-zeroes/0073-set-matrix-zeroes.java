class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                temp.add(matrix[i][j]);
            }
            arr.add(temp);
            temp = new ArrayList<>();
        }

        for(int row = 0;row<m;row++){
            for(int col = 0;col<n;col++){
                if(matrix[row][col] == 0){
                    for(int i = 0;i<m;i++){
                    arr.get(i).set(col,0);
                    }
                    for(int i = 0;i<n;i++){
                    arr.get(row).set(i,0);
                    } 
                }
            }
        }
       
       for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = arr.get(i).get(j);
            }
        }
        

        
                
    }
}