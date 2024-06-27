class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        ArrayList<Integer> change = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int c = bills[i];
            if(c == 5){change.add(c);}
            else{
                int x = c - 5;
                Collections.sort(change);
                for(int j = change.size() - 1;j>=0;j--){
                        if(x >= change.get(j)){
                            x = x - change.get(j);
                            change.remove(j);
                        }
                        if(x == 0){
                            break;
                        }
                }
                if(x != 0) return false;
                change.add(c);
            }
        }
        return true;
    }
}