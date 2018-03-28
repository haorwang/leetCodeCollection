class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] mat = new boolean[numCourses][numCourses];
        int[] outDegree = new int[numCourses];

        for (int[] e : prerequisites) {
            mat[e[0]][e[1]] = true;
            outDegree[e[0]]++;
        }

        Deque<Integer> q = new LinkedList<Integer>();
        int cnt = numCourses;

        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                q.offer(i);
            }
        }

        if (q.isEmpty()) {
            return false;
        }


        while (!q.isEmpty()) {
            int removeNode = q.poll();
            cnt--;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][removeNode]) {
                    mat[i][removeNode] = false;
                    outDegree[i]--;
                    if (outDegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }

        return cnt == 0;
    }
}
