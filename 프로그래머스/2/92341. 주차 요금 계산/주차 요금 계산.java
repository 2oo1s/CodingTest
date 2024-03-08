import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        String[][] record = new String[records.length][3];
        TreeSet<String> set = new TreeSet<>();  // 차량번호 저장
        
        for(int i = 0; i < records.length; i++) {
            record[i] = records[i].split(" ");
            set.add(record[i][1]);
        }
        
        System.out.println(Arrays.deepToString(record));
        answer = new int[set.size()];
        String[] carNum = set.toArray(new String[0]);
        
        for(int i = 0; i < carNum.length; i++) {
            int cnt = 0;               // 인아웃 쌍 이루는지 확인하기 위해
            String car = carNum[i];    // 요금 계산할 차량
            Queue<String> q = new LinkedList<>();  // 각 차량 입출 기록 저장
            
            for(int j = 0; j < record.length; j++) {
                if(record[j][1].equals(car))
                    q.add(record[j][0]);
            }   // 차량별 입출 기록 queue에 저장
            
            System.out.println(q);
            
            int tot = 0;
            
            while(!q.isEmpty()) {
                String inTime = q.poll();
                int inH = Integer.parseInt(inTime.split(":")[0]);
                int inM = Integer.parseInt(inTime.split(":")[1]);
                String out = "";
                
                if(q.size() >= 1) {
                    out = q.poll();     
                    int outH = Integer.parseInt(out.split(":")[0]);
                    int outM = Integer.parseInt(out.split(":")[1]);
                    
                    if(outM < inM) {
                        outM += 60;
                        outH -= 1;
                    }
                    tot += (outM - inM) + (outH - inH) * 60;
                }
                else {
                    int outH = 23;
                    int outM = 59;
                    
                    tot += (outM - inM) + (outH - inH) * 60;
                }
            }
            
            if(tot <= fees[0]) 
                answer[i] = fees[1];
            else
                answer[i] = fees[1] + (int)(Math.ceil((double)(tot - fees[0]) / fees[2]) * fees[3]);
        }   // 차량별 요금 결제 for문
        
        
        return answer;
    }
}