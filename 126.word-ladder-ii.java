class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        boolean foundEnd = false;

        Set<String> q = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> parents = new HashMap<>();
        int len = 1;

        q.add(beginWord);
        while (!q.isEmpty() && !foundEnd) {

            Set<String> newQ = new HashSet<>();

            for (String currString : q) {
                visited.add(currString);

                char[] currArray = currString.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < currArray.length; j++) {
                        char oldChar = currArray[j];
                        if (oldChar == c) {
                            continue;
                        }
                        currArray[j] = c;
                        String newString = String.valueOf(currArray);
                        if (set.contains(newString) && !visited.contains(newString) && !q.contains(newString)) {
                            if (newString.equals(endWord)) {
                                foundEnd = true;
                            }
                            newQ.add(newString);
                            //add to parents map
                            if (parents.containsKey(newString)) {
                                parents.get(newString).add(currString);
                            } else {
                                List<String> newList = new ArrayList<>();
                                newList.add(currString);
                                parents.put(newString, newList);
                            }
                        }
                        currArray[j] = oldChar;
                    }
                }
            }
            q = newQ;
            len++;
        }


        List<List<String>> res = new ArrayList<>();
        //trace all the path back from parents map
        List<String> path = new LinkedList<>();
        path.add(endWord);
        dfs(res, path, parents, beginWord, len);




        //System.out.println(parents.get("cog"));

        return res;


    }


    public void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> parents, String beginWord, int len) {

        System.out.println(path.get(0) + " " + len);

        if (len == 1) {
            if (path.get(0).equals(beginWord)) {
                res.add(new ArrayList<String>(path));
            }
            return;
        }

        List<String> parentList = parents.get(path.get(0));

        if (parentList == null) {
            return;
        }

        for (String parent : parentList) {
            path.add(0, parent);
            dfs(res, path, parents, beginWord, len - 1);
            path.remove(0);
        }
    }
}