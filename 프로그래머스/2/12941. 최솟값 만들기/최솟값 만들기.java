import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[B.length - i - 1];
            answer += a * b;
        }
        return answer;
    }
}