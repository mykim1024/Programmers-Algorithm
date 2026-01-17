import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        for (int w : win_nums) winSet.add(w);

        int match = 0;
        int zero = 0;

        for (int n : lottos) {
            if (n == 0) zero++;
            else if (winSet.contains(n)) match++;
        }

        int best = rank(match + zero);
        int worst = rank(match);

        return new int[]{best, worst};
    }

    private int rank(int cnt) {
        // 6->1, 5->2, 4->3, 3->4, 2->5, 1/0->6
        return (cnt >= 2) ? 7 - cnt : 6;
    }
}

/* 기존 풀이 방법은 중첩루프문이라서 set 방시긍로 바꾸는게 시간적으로 더 효율적임 시간복잡도가 O(nm) -> O(n+m)으로 변함*/
