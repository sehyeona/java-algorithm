package stackQueue;

import java.util.ArrayList;
import java.util.Stack;

public class programmers01 {
    public int[] solution(int[] prices) {
        ArrayList<Integer> temp = new ArrayList<>();
        int[] answer = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            int term = 0;
            for (int j = temp.size() - 1; j >= 0; j--) {
                if (temp.get(j) >= prices[i]) {
                    term++;
                }
                else {term++; break;}
            }
            answer[i] = term;
            temp.add(prices[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] answer = new programmers01().solution(prices);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
