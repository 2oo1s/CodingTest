import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }

        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        while (sum1 != sum2) {
            if (answer > (queue1.length + queue2.length) + 1)   // 탈출 조건
                return -1;

            int temp = 0;

            if (sum1 > sum2) {
                temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            } else if (sum1 < sum2) {
                temp = q2.poll();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
            } else
                return answer;
            answer += 1;
        }
        return answer;
    }
}
