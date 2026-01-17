class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int jackpot = 0;
        int zero = 0;
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) {
                zero++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]) jackpot++;
            }
        }
        
        answer[0] = findRank(jackpot + zero);
        answer[1] = findRank(jackpot);
        
        
        return answer;
    }
    
    public int findRank(int num) {
        return switch (num) {
            case 2 -> 5;
            case 3 -> 4;
            case 4 -> 3;
            case 5 -> 2;
            case 6 -> 1;
            default -> 6;
        };
    }
}