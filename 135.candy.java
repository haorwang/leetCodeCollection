class Solution {
    public int candy(int[] ratings) {
        int lastnNotDropingInd = 0;
        int last = 1;
        int sum = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]){
                sum += --last;
                if (i == ratings.length - 1 || ratings[i + 1] >= ratings[i]) { //lastDroping
                    if (last < 1) {
                        sum += (i - lastnNotDropingInd + 1) * (1 - last);
                    } else if (last > 1) {
                        sum -= (i - lastnNotDropingInd) * (last - 1);
                    }
                    last = 1;
                }
            } else {
                lastnNotDropingInd = i;

                if (ratings[i] > ratings[i - 1]) {
                    sum += ++last;
                } else {
                    lastnNotDropingInd = i;
                    last = 1;
                    sum += last;
                }
            }
        }
        return sum;
    }
}
