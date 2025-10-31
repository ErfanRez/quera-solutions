import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n1 = br.readLine();
        String n2 = br.readLine();
        if (n1 == null) n1 = "";
        if (n2 == null) n2 = "";

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char c : n1.toCharArray()) {
            f1[c - 'a']++;
        }
        for (char c : n2.toCharArray()) {
            f2[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder(n1.length() + n2.length());
        for (int i = 0; i < 26; i++) {
            int cnt = Math.max(f1[i], f2[i]);
            for (int k = 0; k < cnt; k++) {
                sb.append((char) ('a' + i));
            }
        }

        System.out.println(sb.toString());
    }
}
