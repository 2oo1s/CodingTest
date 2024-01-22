import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> blockUser = new HashSet<>();       // 이용 금지 당한 유저
        Map<String, HashSet<String>> info = new HashMap<>();   // 유저별 신고한 유저 모음
        Map<String, Integer> num = new HashMap<>();            // 유저별 신고 당한 수

        for (int i = 0; i < report.length; i++) {
            String[] ppl = report[i].split(" ");

            if (!info.containsKey(ppl[0]))
                info.put(ppl[0], new HashSet<>());
            info.get(ppl[0]).add(ppl[1]);
        }

        for (Map.Entry<String, HashSet<String>> map : info.entrySet()) {
            // System.out.println(map.getKey() + " : " + map.getValue());
            // System.out.println(map.getValue()); // HashSet에 들어있는 값 나옴
            for (String str : map.getValue()) {
                num.put(str, num.getOrDefault(str, 0) + 1);
                if (num.get(str) >= k)
                    blockUser.add(str);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            HashSet<String> values = info.get(name);

            if (values != null) {
                for (String str : blockUser) {
                    if (values.contains(str))
                        answer[i] += 1;
                }
            }
        }
        return answer;
    }
}