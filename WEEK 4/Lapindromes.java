import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        {
            String s = sc.next();
            int n = s.length();
            int mid = n / 2;
            int[] freq = new int[26];
            for (int i = 0; i < mid; i++)
            {
                freq[s.charAt(i) - 'a']++;
            }
            int start = (n % 2 == 0) ? mid : mid + 1;
            for (int i = start; i < n; i++)
            {
                freq[s.charAt(i) - 'a']--;
            }
            boolean lapindrome = true;
            for (int i = 0; i < 26; i++)
            {
                if (freq[i] != 0)
                {
                    lapindrome = false;
                    break;
                }
            }
            System.out.println(lapindrome ? "YES" : "NO");
        }
        sc.close();
    }
}