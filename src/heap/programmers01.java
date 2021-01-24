package heap;

import java.util.PriorityQueue;

public class programmers01 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int food : scoville) {
            heap.add(food);
        }
        while (heap.peek() < K) {
            if (heap.size() <= 1)
                return -1;
            heap.offer(heap.poll() + 2 * heap.poll());
            answer++;
        }
        return answer;
    }
}
