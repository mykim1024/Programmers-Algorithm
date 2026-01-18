import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> type = new HashMap<>();
        
        // 미리 성격 유형 map 안에 저장해두기 (디폴트값 : 0)
        char[] types = {'R','T','C','F','J','M','A','N'};
        
        for (char t : types) {
            type.put(t, 0);
        }
        
        return calculateChoice(type, survey, choices);
    }
    
    // 성격 유형 값 누적
    public String calculateChoice(Map<Character, Integer> type, String[] survey, int[] choices){
        int [] score = {3, 2, 1, 0, 1, 2, 3};
        
        for(int i = 0; i < survey.length; i++){
            char[] charArray = survey[i].toCharArray();

            if(choices[i] == 4){
                 continue;
            }
            
            //동의와 비동의 구간 나누기
            int position = choices[i] < 4 ? 0 : 1;
            
            int num = type.get(charArray[position]);
            num += score[choices[i] - 1];
            type.put(charArray[position], num);
        }
        return ExtractResults(type);
    }
    
    //각 지표 내 비교하여 결과값 추출
    public String ExtractResults(Map<Character,Integer> type){
        String answer = "";
        
        answer += type.get('R') >= type.get('T') ? "R" : "T";
        answer += type.get('C') >= type.get('F') ? "C" : "F";
        answer += type.get('J') >= type.get('M') ? "J" : "M";
        answer += type.get('A') >= type.get('N') ? "A" : "N";
        
        return answer;
    }
}