package by.mich;

import java.util.*;

public class L1202_SmallestStringWithSwaps {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(2);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        System.out.println(smallestStringWithSwaps("dcab", list));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        char[] sChars = s.toCharArray();
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        for (List<Integer> group : uf.getGroups()) {
            List<Character> chars = group.stream()
                .map(s::charAt)
                .sorted()
                .toList();
            Collections.sort(group);
            for (int i = 0; i < group.size(); i++) {
                sChars[group.get(i)] = chars.get(i);
            }
        }

        return new String(sChars);
    }

    static class UnionFind {
        int[] roots;
        int[] ranks;
        int size;

        public UnionFind(int size) {
            this.size = size;
            roots = new int[size];
            ranks = new int[size];
            for (int i = 0; i < size; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        private int find(int x) {
            if (roots[x] == x) return x;

            return roots[x] = find(roots[x]);
        }

        private void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if (ra == rb) return;

            if (ranks[ra] > ranks[rb]) {
                roots[rb] = ra;
            } else if (ranks[ra] < ranks[rb]) {
                roots[ra] = rb;
            } else {
                roots[rb] = ra;
                ranks[ra]++;
            }
        }

        public Collection<List<Integer>> getGroups() {
            Map<Integer, List<Integer>> results = new HashMap<>();
            for (int i = 0; i < size; i++) {
                List<Integer> group = results.computeIfAbsent(find(i), k -> new ArrayList<>());

                group.add(i);
            }
            return results.values();
        }
    }

}
