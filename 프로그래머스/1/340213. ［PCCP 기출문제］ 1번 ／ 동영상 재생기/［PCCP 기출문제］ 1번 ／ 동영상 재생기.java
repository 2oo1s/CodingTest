class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] vLen = video_len.split(":");
        String[] cPos = pos.split(":");
        String[] sPos = op_start.split(":");
        String[] ePos = op_end.split(":");
        
        int vSec = Integer.parseInt(vLen[0]) * 60 + Integer.parseInt(vLen[1]);
        int cSec = Integer.parseInt(cPos[0]) * 60 + Integer.parseInt(cPos[1]);
        int sSec = Integer.parseInt(sPos[0]) * 60 + Integer.parseInt(sPos[1]);
        int eSec = Integer.parseInt(ePos[0]) * 60 + Integer.parseInt(ePos[1]);
        
        if(cSec >= sSec && cSec <= eSec) 
            cSec = eSec;
        
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next")) {
                cSec += 10;
                
                if(cSec > vSec)
                    cSec = vSec;
                
                if(cSec >= sSec && cSec <= eSec) 
                    cSec = eSec;
            } else {
                cSec -= 10;
                
                if(cSec < 0)
                    cSec = 0;
                
                if(cSec >= sSec && cSec <= eSec) 
                    cSec = eSec;
            }
        }
        
        int si = cSec / 60;
        int bun = cSec % 60;
        
        if(si < 10) 
            answer += "0" + String.valueOf(si) + ":";
        else
            answer += String.valueOf(si) + ":";
        
        if(bun < 10)
            answer += "0" + String.valueOf(bun);
        else
            answer += String.valueOf(bun);
        
        return answer;
    }
}