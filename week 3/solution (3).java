import java.util.*;

class solution1 {
    public String largestNumber(int[] nums) {
        // Convert all numbers to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0", return "0"
        if (arr[0].equals("0")) return "0";

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(new int[]{10, 2}));       // Output: "210"
        System.out.println(sol.largestNumber(new int[]{3,30,34,5,9})); // Output: "9534330"
    }
}
