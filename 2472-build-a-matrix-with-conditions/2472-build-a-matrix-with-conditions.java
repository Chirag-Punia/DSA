import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rc, int[][] cc) {
        int[] rd = getInDegree(k, rc);
        int[] cd = getInDegree(k, cc);
        Map<Integer, List<Integer>> rg = constructGraph(rc);
        Map<Integer, List<Integer>> cg = constructGraph(cc);
        List<Integer> rr = topologicalSort(k, rg, rd);
        List<Integer> cr = topologicalSort(k, cg, cd);
        for (int i = 1; i <= k; i++) {
            if (rd[i] != 0 || cd[i] != 0) {
                return new int[0][0];
            }
        }
        int[][] r = new int[k][k];
        for (int i = 1; i <= k; i++) {
            int rw = rr.indexOf(i);
            if (rw == -1) {
                rw = k - 1;
            }
            int cl = cr.indexOf(i);
            if (cl == -1) {
                cl = k - 1;
            }
            r[rw][cl] = i;
        } 
        return r;
    }
    public Map<Integer, List<Integer>> constructGraph(int[][] c) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            int[] cd = c[i];
            if (g.containsKey(cd[0])) {
                List<Integer> l = g.get(cd[0]);
                l.add(cd[1]);
                g.put(cd[0], l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(cd[1]);
                g.put(cd[0], l);
            }            
        }
        return g;
    }
    public int[] getInDegree(int k, int[][] c) {
        int[] d = new int[k + 1];
        for (int i = 0; i < c.length; i++) {
            int[] cd = c[i];      
            d[cd[1]]++;
        }
        return d;
    }
    public List<Integer> topologicalSort(int k, Map<Integer, List<Integer>> g, int[] d) {
        List<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= k; i++) {
            if (d[i] == 0) {
                s.add(i);
            }
        }
        while (!s.isEmpty()) {
            int i = s.pop();
            r.add(i);
            List<Integer> n = g.get(i);
            if (n == null) {
                continue;
            }
            for (int nb : n) {
                d[nb]--;
                if (d[nb] == 0) {
                    s.add(nb);
                }
            }
        }
        return r;
    }
}