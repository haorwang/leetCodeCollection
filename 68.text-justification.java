class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int currLen = 0;
        for (int i = 0; i < words.length; i++) {

            if (words[i].length() + currLen + curr.size() > maxWidth) { //add to res and create a new Line
                int spaceNumber = (int) Math.round((maxWidth - currLen) / (double) (curr.size() - 1));
                StringBuilder sb = new StringBuilder();

                //append first word
                sb.append(curr.get(0));
                int spaceNumberFirst = maxWidth - currLen - ((curr.size() > 2) ?
                        (curr.size() - 2) * spaceNumber : 0);
                for (int j = 0; j < spaceNumberFirst; j++) {
                    sb.append(" ");
                }

                for (int j = 1; j < curr.size(); j++) {
                    sb.append(curr.get(j));
                    if (j != curr.size() - 1) {
                        for (int k = 0; k < spaceNumber; k++) {
                            sb.append(" ");
                        }
                    }
                }



                //add result
                res.add(sb.toString());

                //clear curr
                curr = new ArrayList<>();
                currLen = 0;
            }

            curr.add(words[i]);
            currLen += words[i].length();

            if (i == words.length - 1) {// last line
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < curr.size(); j++) {
                    sb.append(curr.get(j));
                    if (j != curr.size() - 1) {
                        sb.append(" ");
                    } else {
                        int lenSoFar = sb.length();
                        for (int k = 0; k < maxWidth - lenSoFar; k++) {
                            sb.append(" ");
                        }
                    }
                }
                res.add(sb.toString());
            }

        }

        return res;

    }
}