import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }
        
        int match = 0;
        
        while(!queue.isEmpty()){
            if(queue.poll() == ')'){
                if(match == 0) return false;
                else match--;
            }else match++;
        }
        
        return match == 0 ? true : false;
    }
}