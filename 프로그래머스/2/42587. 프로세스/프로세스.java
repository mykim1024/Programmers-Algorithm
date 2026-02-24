import java.util.*;

class Solution {
    static class Job {
        int p;
        boolean target;
        Job(int p, boolean target) {
            this.p = p;
            this.target = target;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Job> q = new LinkedList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            int p = priorities[i];
            q.offer(new Job(p, i == location));
            pq.offer(p);
        }

        int printed = 0;

        while (!q.isEmpty()) {
            Job cur = q.poll();

            // 아직 남아있는 것 중 최댓값이 현재보다 크면 뒤로 보냄
            if (cur.p < pq.peek()) {
                q.offer(cur);
            } else {
                // 현재가 최댓값이면 출력
                printed++;
                pq.poll(); // 최댓값 하나 제거(출력했으니까)

                if (cur.target) return printed;
            }
        }

        return printed;
    }
}