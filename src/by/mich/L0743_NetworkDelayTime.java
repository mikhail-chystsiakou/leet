package by.mich;

import java.util.*;

public class L0743_NetworkDelayTime {
    Map<Integer, List<Edge>> nodes;
    int[] minTimes;

    public int networkDelayTime(int[][] times, int n, int k) {
        nodes = new HashMap<>();
        for (int[] edge: times) {
            if (!nodes.containsKey(edge[0])) {
                nodes.put(edge[0], new ArrayList<>());
            }
            List<Edge> nodeEdges = nodes.get(edge[0]);
            nodeEdges.add(new Edge(edge[1], edge[2]));
        }

        minTimes = new int[n];
        for (int i = 0; i < n; i++) {
            minTimes[i] = -1;
        }

        for (int node : nodes.keySet()) {
            nodes.get(node).sort(Comparator.comparingInt(a -> a.time));
        }

        networkDelayTimeRecursive(0, k);

        int minTime = 0;
        for (int i = 0; i < n; i++) {
            if (minTimes[i] == -1) return -1;
            minTime = Math.max(minTime, minTimes[i]);
        }
        return minTime;
    }

    public void networkDelayTimeRecursive(int time, int node) {
        if (minTimes[node-1] == - 1 || minTimes[node-1] > time) {
            minTimes[node-1] = time;

            if (!nodes.containsKey(node)) return;

            for (Edge e : nodes.get(node)) {
                networkDelayTimeRecursive(time + e.time, e.to);
            }
        }
    }

    static class Edge {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
}
