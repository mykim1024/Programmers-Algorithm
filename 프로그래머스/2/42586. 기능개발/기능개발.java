import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int day = 100 - progresses[i];
            days.add((day + speeds[i] - 1) / speeds[i]);
        }
        
        List<Integer> answer = new ArrayList<>();
        int start = days.poll();
        int function = 1;
        
        while(!days.isEmpty()){
            int end = days.poll();
            
            if(start >= end) {
                function++;
            }else{
                answer.add(function);
                function = 1;
                start = end;
            }
        }
        
        answer.add(function);
        
        return answer;
    }
}