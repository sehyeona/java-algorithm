package sort;

import java.util.Arrays;

// 정렬 - k번째수
public class programmers01 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for (int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(temp);
            answer[i++] = temp[command[2]-1];
        }
        return answer;
    }
}
