class Solution {
  public int findDuplicate(int[] nums) {
    int slow = nums[nums[0]];
    int fast = nums[nums[nums[0]]];

    //cycle detection
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    //reset slow to 0
    slow = nums[0];

    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }
}