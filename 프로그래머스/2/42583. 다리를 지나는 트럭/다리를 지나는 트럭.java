import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int index = 0;
        int time = 0;
        int truck = 0;
        int total = 0;
        boolean lastIndex = true;

        Queue<Integer> bridge = new LinkedList<>();

        while (lastIndex) {

            // 다리 길이를 초과하면 제일 앞에 있는 트럭 제거
            if (bridge.size() == bridge_length) {
                total -= bridge.poll();
            }

            if(index >= truck_weights.length) {
                lastIndex = false;
                break;
            }
            
            truck = truck_weights[index];
           
            if (total + truck <= weight) {
                index++;
            }else{
                truck = 0;
            }

            bridge.offer(truck);
            total += truck;
            time++;
        }

        time += bridge_length;
        
        return time;
    }
}