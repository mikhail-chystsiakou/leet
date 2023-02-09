package by.mich;

import java.util.*;

public class L0399_EvaluateDivision {
    public static void main(String[] args) {
        tc1();

    }

    public static void tc2() {
        // [["x1","x2"],["x2","x3"],["x1","x4"],["x2","x5"]]
        //[3.0,0.5,3.4,5.6]
        //[["x2","x4"],["x1","x5"],["x1","x3"],["x5","x5"],["x5","x1"],["x3","x4"],["x4","x3"],["x6","x6"],["x0","x0"]]

        L0399_EvaluateDivision ed = new L0399_EvaluateDivision();
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("x1", "x2"),
            Arrays.asList("x2", "x3"),
            Arrays.asList("x1", "x4"),
            Arrays.asList("x2", "x5")
        );

        // a/b b/c
        // a/c = a/b * b/c
        double[] values = new double[] {3.0, 0.5, 3.4, 5.6};
        List<List<String>> queries = Arrays.asList(
            Arrays.asList("x2", "x4"),
            Arrays.asList("x1", "x5"),
            Arrays.asList("x1", "x3"),
            Arrays.asList("x5", "x5"),
            Arrays.asList("x5", "x1"),
            Arrays.asList("x3", "x4"),
            Arrays.asList("x4", "x3"),
            Arrays.asList("x6", "x6"),
            Arrays.asList("x0", "x0")
        );

        ed.calcEquation(equations, values, queries);
    }

    public static void tc1() {
        L0399_EvaluateDivision ed = new L0399_EvaluateDivision();
        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );

        ed.calcEquation(equations, values, queries);
    }

    Map<String, List<Dest>> direct = new HashMap<>(); // a / b
    Map<String, List<Dest>> reverse = new HashMap<>(); // b / a


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            Dest directDest = new Dest(equation.get(1), values[i]);
            direct.compute(equation.get(0), (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(directDest);
                return v;
            });

            Dest reverseDest = new Dest(equation.get(0), 1 / values[i]);
            reverse.compute(equation.get(1), (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(reverseDest);
                return v;
            });
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = dfs(
                queries.get(i).get(0),
                queries.get(i).get(1),
                1,
                new HashSet<>()
            );
            System.out.println(results[i]);
        }

        return results;

    }

    public double dfs(String from, String to, double value, Set<String> visited) {
        if (!direct.containsKey(from) && !reverse.containsKey(from)) return -1;
        if (from.equals(to)) return value;
        if (visited.contains(from)) return -1;

        visited.add(from);

        if (direct.containsKey(from)) {
            for (Dest dest : direct.get(from)) {
                value *= dest.cost;
                if (dest.to.equals(to)) {
                    return value;
                }
                double dfsRes = dfs(dest.to, to, value, new HashSet<>(visited));
                if (dfsRes != -1) {
                    return dfsRes;
                }
                value /= dest.cost;
            }
        }

        if (reverse.containsKey(from)) {
            for (Dest dest : reverse.get(from)) {
                value *= dest.cost;
                if (dest.to.equals(to)) {
                    return value;
                }
                double dfsRes = dfs(dest.to, to, value, new HashSet<>(visited));
                if (dfsRes != -1) {
                    return dfsRes;
                }
                value *= dest.cost;
            }
        }
        return -1;
    }

    class Dest {
        String to;
        double cost;

        public Dest(String to, double cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
