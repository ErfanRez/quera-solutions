import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().trim().split(" ");
        int numNodes = Integer.parseInt(parts[0]);
        int numWeapons = Integer.parseInt(parts[1]);

        if (numNodes == 1) {
            System.out.println(numWeapons);
            return;
        }

        ArrayList<Integer>[] graph = new ArrayList[numNodes + 1];
        for (int i = 0; i <= numNodes; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numNodes - 1; i++) {
            String[] edge = reader.readLine().trim().split(" ");
            int nodeA = Integer.parseInt(edge[0]);
            int nodeB = Integer.parseInt(edge[1]);
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }

        int leafCount = 0;
        for (int i = 1; i <= numNodes; i++) {
            if (graph[i].size() == 1) {
                leafCount++;
            }
        }

        int minVal = 0;
        int maxVal = numWeapons;
        while (minVal < maxVal) {
            int midVal = (minVal + maxVal) / 2;
            long placeable = (long) (leafCount - 1) * (midVal / 2) + (midVal + 1) / 2;
            if (placeable >= numWeapons) {
                maxVal = midVal;
            } else {
                minVal = midVal + 1;
            }
        }

        System.out.println(minVal);
    }
}