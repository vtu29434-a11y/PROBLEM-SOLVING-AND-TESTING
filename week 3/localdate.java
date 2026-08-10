import java.time.LocalDate;

class Solution {
    public int dayOfYear(String date) {
        LocalDate d = LocalDate.parse(date); 
        return d.getDayOfYear();
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.dayOfYear("2019-01-09")); // Output: 9
        System.out.println(sol.dayOfYear("2019-02-10")); // Output: 41
    }
}
