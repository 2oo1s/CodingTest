class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int cont = 1;           // 연속 성공
        int max = bandage[0];   // 연속 몇 초 참아야 하는지
        int cur = 0;            // 몇번째 공격인지

        int ran = attacks[attacks.length - 1][0];

        for (int i = 1; i <= ran; i++) {
            if (attacks[cur][0] == i) {
                // 공격 시작
                cont = 0;
                answer -= attacks[cur][1];
                
                cur += 1;   // 다음 공격으로 이동

                if (answer <= 0)
                    return -1;
            } else {
                cont += 1;
                answer += bandage[1];
                answer = answer > health ? health : answer;

                if (cont == max) {
                    answer += bandage[2];
                    answer = answer > health ? health : answer;
                    cont = 0;
                }
            
            }
        }

        return answer;
    }
}