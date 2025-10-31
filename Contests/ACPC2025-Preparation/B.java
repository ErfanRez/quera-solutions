import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split(" ");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(scores);
        int h = 0;

        for (int i = 0; i < n; i++) {
            int k = n - i;
            if (scores[i] >= k) {
                h = k;
                break;
            }
        }

        System.out.println(h);
    }
}