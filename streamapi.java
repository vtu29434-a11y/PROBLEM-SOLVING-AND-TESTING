import java.util.*;
import java.io.*;

public class StreamAnalytics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // Map to store sensor readings
        Map<String, List<Integer>> sensorData = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            String sensorId = parts[0];
            int temp = Integer.parseInt(parts[1]);

            // Step 1: Filter temperatures > 50
            if (temp > 50) {
                sensorData.putIfAbsent(sensorId, new ArrayList<>());
                sensorData.get(sensorId).add(temp);
            }
        }

        // Step 2 & 3: Compute average temperature per sensor
        Map<String, Double> avgTemp = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : sensorData.entrySet()) {
            List<Integer> temps = entry.getValue();
            double sum = 0;
            for (int t : temps) sum += t;
            avgTemp.put(entry.getKey(), sum / temps.size());
        }

        // Step 4: Sort sensors by average temperature descending
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(avgTemp.entrySet());
        sortedList.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Output
        for (Map.Entry<String, Double> entry : sortedList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}