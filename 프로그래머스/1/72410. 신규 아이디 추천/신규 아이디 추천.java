class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();   // 1단계
        answer = answer.replaceAll("[^a-z0-9-_.]", ""); // 2단계
        answer = answer.replaceAll("\\.{2,}", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계

        // 5단계
        if (answer.equals(""))
            answer = "a";

        // 6-1단계
        if (answer.length() >= 16)
            answer = answer.substring(0, 15);

        // 6-2단계
        answer = answer.replaceAll("[.]$", "");

        char last = answer.charAt(answer.length() - 1);
        if (answer.length() <= 2) {
            while (answer.length() < 3)
                answer += last;
        }
        return answer;
    }
}