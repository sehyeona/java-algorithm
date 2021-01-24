package stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class programmers03 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++)
            bridge.add(0);
        int nowWeight = 0;
        int answer = 0;
        for (int truck : truck_weights) {
            while (nowWeight - bridge.peek() + truck > weight){ // 다음 트럭이 진입 못하는 경우
                answer++;
                bridge.poll();
                bridge.add(0);
            }
            // 다음 트럭이 진입 가능한 경우
            bridge.poll();
            bridge.add(truck);
            answer++;
            nowWeight += truck;
        }
        answer += bridge_length;
        return answer;
    }
}
