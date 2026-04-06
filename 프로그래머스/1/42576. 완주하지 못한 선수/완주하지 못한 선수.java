import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {    
        /*
            participant를 map으로 변환한다. 변환할 때 모든 participant의 value를 1으로 지정하는데,
            같은 이름이 있을 수 있으니 그럴경우 value를 1씩 증가시켜준다. 
            completion에 같은 이름이 나올경우 1씩 감소시켜서 마지막에 1이상의 값을 가진 key를 반환한다.
        */
        Map<String, Integer> map = new HashMap<>();
        
        for(String man : participant){
            map.put(man, map.getOrDefault(man, 0) + 1); 
        }
        
        for(String man : completion){
            if(map.containsKey(man)) map.put(man, map.get(man) - 1);
        }
        
        String key = map.entrySet().stream()
                .filter(entry -> 1 == entry.getValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        
        return key;
        /*
            participant는 completion보다 한자리 크다. completion을 기반으로 루프 돌며,
            participant에도 동일한 값이 있다면 삭제한다. 제일 마지막에 남은 하나의 값을 반환한다.
            - 효율성 테스트 꽝
        */
        /*
        List<String> list = new ArrayList<>(Arrays.asList(participant));
        
        for(String man : completion){
            if(list.contains(man)) list.remove(man);
        }
        
        return list.get(0);
        */
        
//        Map<String, Integer> map = new HashMap<>();

        /*참여선수 HashMap*/
        /*
        for(int i=0; i<participant.length; i++){
            if(!map.containsKey(participant[i])) map.put(participant[i],1);
            else {
                int cnt = map.get(participant[i]);
                map.put(participant[i], ++cnt);
            }
        }
        */
        
        /*완료선수에 따라 제거*/
        /*
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                int cnt = map.get(completion[i]);
                map.put(completion[i], --cnt);
            }
        }
        
        String answer = "";
        
        for (String key : map.keySet()) {            
            if (map.get(key) == 1) {
               answer = key;
            }
        }
        return answer;
    */
    }
}