class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int [] mapped = new int[nums.length];
        int n = nums.length;

        for(int i = 0; i < n; i++){
            mapped[i] = convert(nums[i],mapping);
        }

        Pair[] mappedValues = new Pair[n];

        for(int i = 0; i < n; i++){
            mappedValues[i] = new Pair(nums[i], mapped[i]);
        }

        Arrays.sort(mappedValues, (a,b) -> a.modified - b.modified);

        int [] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = mappedValues[i].original;
        }

        return ans;
    }

    public int convert(int num, int[] mapping){
        String str = Integer.toString(num);
        StringBuilder newStr = new StringBuilder();

        for(char digit : str.toCharArray()){
            newStr.append(mapping[Character.getNumericValue(digit)]);
        }
        return Integer.parseInt(newStr.toString());
    }

    public class Pair{
        int original;
        int modified;

        Pair(int original, int modified){
            this.original = original;
            this.modified = modified;
        }
    }
}