import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
            * 큐 문제 : 먼저 들어온게 먼저 나가야되는 구조임
            1. progresses 값과 speeds 값을 비교하여 완성되는데 며칠이나 걸릴 지 계산
            2. 몇개가 배포될 지 계산
       */
            
        List<Integer> workTimeList = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){            
            if((100 - progresses[i]) >= speeds[i]){
               if((100 - progresses[i]) % speeds[i] > 0){
                   workTimeList.add(((int)(100 - progresses[i]) / speeds[i]) + 1); 
               }else  workTimeList.add((100 - progresses[i]) / speeds[i]);   
            }else workTimeList.add(1);          
        }
        
        List<Integer> deploymentList = new ArrayList<>();
        int prevNum = workTimeList.get(0);
        int cnt = 0;
        
        for(int i=0; i<workTimeList.size(); i++){
            if(workTimeList.get(i) <= prevNum) cnt++;                           
            else{
                deploymentList.add(cnt);
                
                cnt = 1;                
                prevNum = workTimeList.get(i);
            }                        
            if(i == (workTimeList.size()-1)) deploymentList.add(cnt);      
        }
        
        int[] answer = deploymentList.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}
