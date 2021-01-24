package stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class programmers04 {
    public int solution(int[] priorities, int location) {
        Deque<Integer> printer = new ArrayDeque<>();
        for (int priority : priorities) {
            printer.add(priority);
        }
        while (true) {
            if (location != 0) { // location 차례가 아닌경우
                int first = printer.poll(); // 첫째 뽑음
                for (Integer priority : printer) // 첫째가 가장 큰애가 아닐경우 뒤에 넣음
                    if (first < priority){
                        printer.add(first);
                        break;
                    } // 만약 첫째가 가장 큰 녀석인 경우 하나 빠짐
                location--; // 뭐가 됐든 하나 뒤로가거나 빠지니까 location 은 1 준다
            } else {
                int prevLength = printer.size();
                int me = printer.poll(); // location 차례가 온경우
                for (Integer priority : printer) { // location 이 가장 큰게 아닐경우 제일 뒤로 보내버림
                    if (me < priority) {
                        printer.add(me);
                        location = printer.size() -1;
                        break;
                    }
                }
                if (printer.size() < prevLength) {
                    return priorities.length - printer.size();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;
        int solution = new programmers04().solution(priorities, location);
        System.out.println("solution = " + solution);
    }
}
