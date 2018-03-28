class TestFile {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 3, 3}));

    }

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones ^= num & ~twos;
            twos ^= num & ~ones;
        }
        return ones;
    }
}
