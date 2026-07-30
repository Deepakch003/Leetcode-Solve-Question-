class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int len = n; len > 2; len--) {
            for (int i = 0; i < len - 1; i++) {
                int sum = (arr[i] - '0') + (arr[i + 1] - '0');
                arr[i] = (char) ((sum % 10) + '0');
            }
        }

        return arr[0] == arr[1];
    }
}