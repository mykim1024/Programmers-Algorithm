class Solution {
    public int[] solution(String s) {
        /*
        s 문자열을 다 까보면서 앞에 각 위치의 문자가 없으면 -1, 
        있으면 자신기준 몇번째 앞에 있는지 계산        
        */
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // 처음은 무조건 -1
            if(i == 0){
                answer[i] = -1;
                continue;
            }
            
            int num = 0;
            for(int k = 0; k < i; k++){
                char d = s.charAt(k);
                
                // 일치하면 자릿수 계산 후 종료
                if(c == d){
                    num = i - k;
                    continue;
                }
            }
            // 일치하는 값이 있을 경우 자릿수 기입 없으면 -1
            answer[i] = num == 0 ? -1 : num;
        }
        
        return answer;
    }
}