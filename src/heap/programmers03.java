package heap;

import java.util.*;

public class programmers03 {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();


            for (String operation : operations) {
                switch (operation) {
                    case "D 1":
                        if (!maxHeap.isEmpty())
                            deleteValue(minHeap, maxHeap.poll());
                        break;
                    case "D -1":
                        if (!minHeap.isEmpty())
                            deleteValue(maxHeap, minHeap.poll());
                        break;
                    default :
                        String op = operation.replace("I ", "");
                        int temp = Integer.parseInt(op);
                        maxHeap.add(temp);
                        minHeap.add(temp);
                        break;
                }
            }

            if (maxHeap.isEmpty()) {
                return new int[]{0, 0};
            }

            return new int[]{maxHeap.peek(), minHeap.peek()};
        }

    public void deleteValue(Queue<Integer> queue, int num) {
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            int extract = queue.poll();
            if(extract == num) break;
            temp.add(extract);
        }
        queue.addAll(temp);
    }
}
