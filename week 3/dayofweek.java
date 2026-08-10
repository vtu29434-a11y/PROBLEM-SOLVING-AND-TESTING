import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dow = date.getDayOfWeek(); 
        // Convert to string with first letter capitalized
        String result = dow.toString().substring(0,1) + dow.toString().substring(1).toLowerCase();
        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.dayOfTheWeek(31, 8, 2019)); 
        System.out.println(sol.dayOfTheWeek(18, 7, 1999)); 
        System.out.println(sol.dayOfTheWeek(15, 8, 1993));
    }
}
