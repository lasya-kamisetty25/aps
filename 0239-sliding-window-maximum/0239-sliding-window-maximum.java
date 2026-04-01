import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {

        if (a == null || k <= 0) {
            return new int[0];
        }

        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        // store indices in deque
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < a.length; i++) {

            // 1. remove indices out of this window
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            // 2. remove smaller values from back (not useful)
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            // 3. add current index
            q.offer(i);

            // 4. store answer when first window is formed
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }

        return r;
    }
}
