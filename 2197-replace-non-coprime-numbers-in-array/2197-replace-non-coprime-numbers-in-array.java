import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {

        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {

            while (!stack.isEmpty()) {

                int last = stack.get(stack.size() - 1);
                int g = gcd(last, num);

                if (g == 1)
                    break;

                stack.remove(stack.size() - 1);
                num = (int)((long)last / g * num);
            }

            stack.add(num);
        }

        return stack;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}