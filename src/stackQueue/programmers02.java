package stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers02 {
    public Integer[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int finishedWork = 1;
            int work = queue.poll();
            while (!queue.isEmpty() && queue.peek() <= work) {
                finishedWork++;
                queue.poll();
            }
            answer.add(finishedWork);
        }

        return answer.toArray(new Integer[answer.size()]);
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        Integer[] solution = new programmers02().solution(progresses, speeds);
        for (Integer integer : solution) {
            System.out.print(integer + " ");
        }
    }
}
