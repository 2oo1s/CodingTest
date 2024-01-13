class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int maxNum = 0; // 그래프에서 사용된 노드 개수
        
        for(int[] edge : edges){
            int s = edge[0];
            int e = edge[1];
            
            if(maxNum < s)
                maxNum = s;
            if(maxNum < e)
                maxNum = e;
        }
        
        int[] inCnt = new int[maxNum + 1];
        int[] outCnt = new int[maxNum + 1];

        boolean[] fromCore = new boolean[maxNum + 1];
        boolean[] usedNode = new boolean[maxNum + 1];

        int graphTot = 0;   // 그래프 총 개수
        int coreNode = 0;   // 생성노드

        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];

            usedNode[s] = true;
            usedNode[e] = true;

            inCnt[e] += 1;
            outCnt[s] += 1;
        }

        for (int i = 1; i <= maxNum; i++) {
            if (inCnt[i] == 0 && outCnt[i] >= 2)
                coreNode = i;
        }

        answer[0] = coreNode;

        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];

            if (s == coreNode) {
                fromCore[e] = true;
                inCnt[e] -= 1;
                graphTot += 1;
            }
        }

        for (int i = 1; i <= maxNum; i++) {
            if (usedNode[i]) {
                if (inCnt[i] == 2 && outCnt[i] == 2)
                    answer[3] += 1;
                else if (outCnt[i] == 0)
                    answer[2] += 1;
            }
        }
        
        answer[1] = graphTot - answer[2] - answer[3];

        return answer;
    }
}