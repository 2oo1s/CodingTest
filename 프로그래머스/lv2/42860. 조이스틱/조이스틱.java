import java.util.*;

class Solution {

  public int solution(String name) {
    int answer = 0;
    int len = name.length();
    int move = len - 1; // 오른쪽으로 움직이는 횟수
    for (int i = 0; i < len; i++) {
      // A와 Z 중에 더 가까운 쪽으로부터 접근
      answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
      int next = i + 1;
      while (next < len && name.charAt(next) == 'A') {
        next++;
      }
      move = Math.min(move, i + (len - next) + Math.min(i, len - next));
    }
    return answer + move;
  }
}