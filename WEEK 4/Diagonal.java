import java.io.*;
import java.util.*;
class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primary = 0;
        int secondary = 0;
        for (int i = 0; i < n; i++) {
            primary += arr.get(i).get(i);
            secondary += arr.get(i).get(n - 1 - i);
        }
        return Math.abs(primary - secondary);
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] row = bufferedReader.readLine().trim().split(" ");
            List<Integer> list = new ArrayList<>();
            for (String value : row) {
                list.add(Integer.parseInt(value));
            }
            arr.add(list);
        }
        int result = Result.diagonalDifference(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}