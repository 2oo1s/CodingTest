class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        for(int i = 0; i < str.length; i++) {
            String temp = str[i];
            
            if(str[i].length() == 0) 
                answer += " ";
    		else {
    			answer += temp.substring(0, 1).toUpperCase();
    			answer += temp.substring(1, temp.length()).toLowerCase() + " ";
    		}
    	}
        // 입력 받은 문자열의 맨 마지막이 공백일 경우
    	if(s.substring(s.length() - 1, s.length()).equals(" "))
    		return answer;
        
        return answer.substring(0, answer.length() - 1);
    }

}