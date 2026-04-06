import java.util.*;

class Solution {
    public int solution(int[] nums) {
        /*
            중복 제거
            nums를 하나의 map의 key로 저장. 같은 key일 경우 1씩 카운트 시키고 나중에 모든 key의 개수 리턴
            앗 n/2마리!
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return map.size() > (nums.length / 2) ? nums.length / 2 : map.size();
        
        
        /*
        1. 홍박사가 자신의 포켓몬 중 절반을 가져가도 좋다함
        2. 종류가 같은 포켓몬은 번호도 같음
        3. 경우의수를 다 들어서 중복제외하고 폰켓몬 종류의 수를 구해야 됨
        4. 나도 몰랐는데 난 최대한 다양하게 중복없이 고르고싶음
        5. 최종적으로 최대한 중복이 없는 포켓몬수 몇마리가 되는지를 구하셈
        */
        
        //절반의 값을 구하고 그 절반내에서 중복을 제외한 값이 몇개인지 고르셈
        /*
        int half = nums.length/2;        
        List<Integer> numList = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(numList.size()<half){
                if(!numList.contains(nums[i])) numList.add(nums[i]);    
            }            
        }
        
        int answer = numList.size();
        
        return answer;
        */
    }
}