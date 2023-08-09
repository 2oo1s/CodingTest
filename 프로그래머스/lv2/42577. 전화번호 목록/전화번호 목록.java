import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> num = new HashSet<>();
        Arrays.sort(phone_book);
        
        for(String s : phone_book)
            num.add(s);
        
        for(int i = 0; i < phone_book.length -1 ; i++){
            if(phone_book[i+1].startsWith(phone_book[i]))
                answer = false;
        }
        return answer;
    }
}