class Solution {
    public int[] solution(int[] prices) {
        /*
            1.prices 내부 반복문을 돌림.
            2.1번 반복문을 기준으로 이중 반복문을 돌림
            3.값이 떨어질 때까지 count를 세면서 떨어지는 순간 break하고 answer에 저장
            4.중간값이 다시 처음부터 반복문을 돌면서 떨어지는 값을 찾지는 않음
            5.안떨어진다면 반복문돌릴때까지 count를 세면 됨
            6.반복문으로 시간을 계산하다고 생각했을 때 count는 0 부터 시작하고 if문으로 값 비교후 증감
            7.1번 반복문에서 맨 마지막도 체크 필요(i == i.length-1) ary.add(0) break;
            8.다시생각해보니 2번에서 이중 반복문을 돌 때 이전 숫자는 볼 필요가 없음 이후숫자들끼리 비교하면 됨(j=i j<i.length;)    
            9.2번 반복문에서 끝까지 갈 경우도 한번 생각해야됨
        */
        int[] answer = new int[prices.length];        
        for(int i = 0; i < prices.length; i++){
            int time = 0;
            
            for(int j = (i + 1); j < prices.length; j++){
                time++;
                
                if(prices[i] > prices[j]){
                    answer[i] = time;
                    break;
                }
                
                if(j == prices.length - 1) answer[i] = time;
            }
            
        }
        
        return answer;
    }
}