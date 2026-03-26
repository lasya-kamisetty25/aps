import java.util.*;

class Solution {
    public int[] finalPrices(int[] A) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                A[stack.pop()] -= A[i];

            stack.push(i);
        }

        return A;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {8,4,6,2,3};

        System.out.println(Arrays.toString(
            s.finalPrices(arr)
        ));
    }
}
