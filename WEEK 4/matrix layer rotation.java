import java.io.*;
import java.util.*;
public class Solution {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;
            List<Integer> elements = new ArrayList<>();
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            int len = elements.size();
            int rotation = r % len;
            int index = 0;
            for (int j = left; j <= right; j++) {
                matrix.get(top).set(j, elements.get((index + rotation) % len));
                index++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right, elements.get((index + rotation) % len));
                index++;
            }
            for (int j = right - 1; j >= left; j--) {
                matrix.get(bottom).set(j, elements.get((index + rotation) % len));
                index++;
            }
            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left, elements.get((index + rotation) % len));
                index++;
            }
        }
        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(row.get(j));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String[] first = br.readLine().split(" ");
        int m = Integer.parseInt(first[0]);
        int n = Integer.parseInt(first[1]);
        int r = Integer.parseInt(first[2]);
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] values = br.readLine().split(" ");
            List<Integer> row = new ArrayList<>();
            for (String value : values) {
                row.add(Integer.parseInt(value));
            }
            matrix.add(row);
        }
        matrixRotation(matrix, r);
    }
}