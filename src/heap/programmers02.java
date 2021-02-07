package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers02 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int numOfJobs = jobs.length;
        PriorityQueue<int[]> jobList = new PriorityQueue<>(Comparator.comparing(o -> o[0]));
        for (int[] job : jobs) {
            jobList.add(job);
        }
        PriorityQueue<int[]> pendingJobs = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        while (!(jobList.isEmpty() && pendingJobs.isEmpty())){ // 모든 일이 끝나고, 기다리는 일이 끝나고
            if (jobList.size() != 0 && jobList.peek()[0] > time && pendingJobs.isEmpty()) // 시작 시간 설정
                time = jobList.peek()[0];

            // 일이 끝날때까지 밀린 일들은 순서대로 heap 에 넣음
            while (!jobList.isEmpty() && (time >= jobList.peek()[0])) {
                pendingJobs.add(jobList.poll());
            }

            if (pendingJobs.size() == 0) { // 기다리는 일어 없는 경우
                int[] job = jobList.poll(); // 가장 먼저 처리해야하는 일 선택 후 넣음
                time += job[1]; // job 하나 끝나는시간으로
                answer += job[1];
            } else { // 기다리고 있는 일이 있는 경우
                int[] job = pendingJobs.poll(); // 처리시간이 가장 짧은 일 선택
                time += job[1]; // 처리시간만큼 시간 경과
                answer += (time - job[0]);  // 일이 들어오고부터 처리되기 까지 시간
            }
        }
        return answer / numOfJobs ;
    }

    public static void main(String[] args) {
        int[][] jobs2 = new int[][]{
                {24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}
        };

        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        int answer = new programmers02().solution(jobs2);
        System.out.println("answer = " + answer);
    }
}
