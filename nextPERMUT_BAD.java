class Solution {
    public static void  GAP(int[] A,HashMap<Integer,Boolean> mpp, ArrayList<ArrayList<Integer>> ans , ArrayList<Integer>temp){
           if(temp.size() == A.length){
               ans.add(new ArrayList<>(temp));
               return;
           }
            for (int i : A) {
                if (!mpp.get(i)) {
                    mpp.put(i, true);
                    temp.add(i);
                    GAP(A, mpp, ans, temp);
                    temp.remove(temp.size() - 1);
                    mpp.put(i, false);
                }
            }
        }

    public void nextPermutation(int[] A) {
        ArrayList<Integer> x = new ArrayList<>();
        for(int i = 0; i<A.length;i++){
            x.add(A[i]);
        }
        Arrays.sort(A);
        HashMap<Integer,Boolean> mpp = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int j : A){
            mpp.put(j,false);
        }
        GAP(A, mpp, ans, temp);
        System.out.println(ans);
        int index = 0;
        boolean xx = false;
        for(int i =0;i<ans.size();i++){
            xx = x.equals(ans.get(i));
            if(xx){
                index = i;
                break;
            }
        }
        if (index == -1 || index == ans.size() - 1) {
            index = 0;
        } else {
            index += 1;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = ans.get(index).get(i);
        }
        
    }
}
