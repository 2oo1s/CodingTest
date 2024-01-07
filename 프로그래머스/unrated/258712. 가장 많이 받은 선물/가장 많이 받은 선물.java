import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> giftGraph = new HashMap<>(); // 서로 선물 주고 받은 기록 저장
        Map<String, Integer> giveNum = new HashMap<>(); // 선물 지수 계산용
        Map<String, Integer> getNum = new HashMap<>();  // 선물 지수 계산용
        Map<String, Integer> presentNum = new HashMap<>();  // 받는 선물 개수

        for (String str : gifts) {
            String[] temp = str.split(" ");
            String s = temp[0];
            String e = temp[1];

            if (!giftGraph.containsKey(s)) {
                HashMap<String, Integer> temp1 = new HashMap<>();
                temp1.put(e, 1);
                giftGraph.put(s, temp1);
            } else {
                giftGraph.get(s).put(e, giftGraph.get(s).getOrDefault(e, 0) + 1);
            }
            giveNum.put(s, giveNum.getOrDefault(s, 0) + 1);
            getNum.put(e, getNum.getOrDefault(e, 0) + 1);
        }
        // System.out.println(giftGraph.get("muzi").get("frodo"));
        // System.out.println(giftGraph.get("frodo").get("muzi"));

        for (String s : friends) {
            if (giftGraph.containsKey(s)) {
                for (String e : friends) {
                    int sGive = giftGraph.get(s).getOrDefault(e, 0);
                    int eGive = 0;
                    if (giftGraph.containsKey(e))
                        eGive = giftGraph.get(e).getOrDefault(s, 0);

                    if (sGive > eGive)
                        presentNum.put(s, presentNum.getOrDefault(s, 0) + 1);
                    else if (sGive == eGive) {
                        int sPresentV = giveNum.getOrDefault(s, 0) - getNum.getOrDefault(s, 0);
                        int ePresentV = giveNum.getOrDefault(e, 0) - getNum.getOrDefault(e, 0);

                        if (sPresentV > ePresentV)
                            presentNum.put(s, presentNum.getOrDefault(s, 0) + 1);
                    }
                }
            }
        }

        for (String s : presentNum.keySet()) {
            if (presentNum.get(s) > answer)
                answer = presentNum.get(s);
        }

        return answer;
    }
}