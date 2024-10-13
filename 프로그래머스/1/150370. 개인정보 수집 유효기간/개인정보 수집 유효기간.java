import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str : terms) {
            String[] temp = str.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        // System.out.println(map);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] time = privacies[i].split(" ");
            String[] date = time[0].split("\\.");
            
            int dur = map.get(time[1]); // 유효기간
            
            date[1] = String.valueOf((Integer.parseInt(date[1]) + dur));
            
            if(Integer.parseInt(date[1]) > 12) {
                int ext = Integer.parseInt(date[1]) / 12;
                
                date[0] = String.valueOf((Integer.parseInt(date[0]) + ext));
                date[1] = String.valueOf((Integer.parseInt(date[1]) % 12));
                
                if(Integer.parseInt(date[1]) == 0) {
                    date[1] = "12";
                    date[0] = String.valueOf((Integer.parseInt(date[0]) - 1));
                }
            }
            
            if(date[2].equals("01")) {
                date[2] = "28";
                date[1] = String.valueOf((Integer.parseInt(date[1]) - 1));
            }
            else
                date[2] = String.valueOf((Integer.parseInt(date[2]) - 1));
            
            // System.out.println(date[0] + " : " + date[1]  + " : " + date[2] );
            String expire = "";
            for(String s : date) {
                if(s.length() == 1)
                    expire += "0" + s;
                else
                    expire += s;
            }
            
            String[] tod = today.split("\\.");
            
            String cur = "";
            for(String s : tod) {
                if(s.length() == 1)
                    cur += "0" + s;
                else
                    cur += s;
            }
            
            System.out.println(expire + "   " + cur);
            
            if(Integer.parseInt(expire) < Integer.parseInt(cur))
                answer.add(i + 1);
        }
        
        return answer;
    }
}