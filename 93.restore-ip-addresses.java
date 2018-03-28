class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs (res, new int[4], s, 0, 0);
        return res;
    }

    public void dfs(List<String> res, int[] curr, String s, int sInd, int aInd) {

        if (sInd == s.length() && aInd == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(curr[0]).append(".");
            sb.append(curr[1]).append(".");
            sb.append(curr[2]).append(".");
            sb.append(curr[3]);
            res.add(sb.toString());
            return;
        } else if (sInd == s.length() || aInd == 4) {
            return;
        }

        if (s.length() - sInd > (4 - aInd) * 3) {
            return;
        }

        if (s.charAt(sInd) == '0') {
            curr[aInd] = 0;
            dfs(res, curr, s, sInd + 1, aInd + 1);
            return;
        }

        for (int i = sInd + 1; i <= s.length() && i <= sInd + 3; i++) {
            int item = Integer.valueOf(s.substring(sInd, i));
            if (Integer.valueOf(s.substring(sInd, i)) >= 256) {
                break;
            }
            curr[aInd] = item;
            dfs(res, curr, s, i, aInd + 1);
        }
    }

}