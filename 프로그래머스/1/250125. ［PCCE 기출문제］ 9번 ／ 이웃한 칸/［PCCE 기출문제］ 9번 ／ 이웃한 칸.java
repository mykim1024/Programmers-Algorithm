class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        
        //위 아래 왼 오
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i++){
            int pickh = h + dh[i];
            int pickw = w + dw[i];
            
            if(pickh < 0 || pickh >= board.length) pickh = h;
            if(pickw < 0 || pickw >= board.length) pickw = w;
            
            if(pickh == h && pickw == w) continue;
            
            if(color.equals(board[pickh][pickw])) answer++;
        }
        
        return answer;
    }
}