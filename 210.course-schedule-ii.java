class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] mat = new boolean[numCourses][numCourses];
        int[] outDegree = new int[numCourses];
        int[] res = new int[numCourses];

        for (int[] e : prerequisites) {
            mat[e[0]][e[1]] = true;
            outDegree[e[0]]++;
        }

        int cnt = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int toRemoveNode = q.poll();
            res[cnt++] = toRemoveNode;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][toRemoveNode]) {
                    mat[i][toRemoveNode] = false;
                    outDegree[i]--;
                    if (outDegree[i] == 0) {
                        q.offer(i);

                    }
                }
            }
        }

        return (cnt == numCourses) ? res :  new int[0];
    }
}
