import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        /*
        시작한 날(startday)부터 일주일동안 한번도 지각하지 않은 직원을 조회(주말제외)
        희망시간+10분까지 출근해야 지각 x
        시간은 시*100 + 분으로 표현됨
        schedules: 희망 출근 시간
        timelogs: 직원들의 실제 출근 시간(일주일)
        반복문을 돌면서 직원들의 실제 출근 시간과 희망 출근 시간을 비교해야 됨
        반복문 돌면서 주말 및 지각 체크
        */
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++){
            int late = 0; // 지각 카운트
            // 1시간은 60분. 60을 넘어가면 시간대를 바꿔서 계산해야 됨! 
            int hopeWorkTime = calculateHopeTime(schedules[i]);
            
            for(int k = 0; k < timelogs[i].length; k++){
                int realWorkTime = timelogs[i][k]; // 실제 출근 시간
                
                // 주말 확인
                boolean isWeekend = calculateWeekend(startday, k);
                
                if(realWorkTime > hopeWorkTime && !isWeekend){
                    late++; // 지각 카운트 + 1
                }
            }
            
            if(late == 0) answer++;
                
        }
    
        return answer;
    }
    
    // 60분 확인
    public int calculateHopeTime(int time) {
        int hour = time / 100;   // 시
        int minute = time % 100; // 분

        minute += 10;

        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }

        return hour * 100 + minute;
    }

    // 주말 확인
    public boolean calculateWeekend(int startday, int nowday){
        List<Boolean> weekend = List.of(false, false, false, false, false, true, true);
        
        // 요일은 1 ~ 7만 존재
        // 월요일 시작이 아니면 7을 넘어감
        int num = ((startday + nowday) - 1) % 7;
        
        return weekend.get(num);
    }
}