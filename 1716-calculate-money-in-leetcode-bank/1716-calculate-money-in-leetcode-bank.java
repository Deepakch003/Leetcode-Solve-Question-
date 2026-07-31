class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int fullWeeks = weeks * (56 + 7 * (weeks - 1)) / 2;
        int remaining = days * (2 * (weeks + 1) + (days - 1)) / 2;

        return fullWeeks + remaining;
    }
}