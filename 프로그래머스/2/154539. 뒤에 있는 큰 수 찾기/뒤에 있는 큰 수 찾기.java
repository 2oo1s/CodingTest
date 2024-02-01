import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            
            while (!q.isEmpty() && q.peek()[1] < value)
                numbers[q.poll()[0]] = value;

            q.add(new int[] { i, value });
        }

        while (!q.isEmpty())
            numbers[q.poll()[0]] = -1;

        return numbers;
    }
}