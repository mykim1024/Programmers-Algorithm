import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        /*
            카테고리 → +
            다른 카테고리 → *
            map key값은 카테고리 value는 이 카테고리에 해당되는 옷의 개수
        */
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){  
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        if(map.size() == 1) return clothes.length;
        
        int allCase = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){            
            allCase *= (entry.getValue() + 1);
        }
        
        return allCase - 1;
    }
}