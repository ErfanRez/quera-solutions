import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++)
                pq.add(Long.parseLong(st.nextToken()));
            long ans = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long s = a + b;
                ans += s;
                pq.add(s);
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}