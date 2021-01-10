package hash;

import java.util.HashMap;

public class programmers01 {
    static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (String person : participant) {
                Integer num = map.get(person);
                if (num == null) map.put(person, 1);
                else map.put(person, ++num);
            }
            for (String s : completion) {
                Integer num = map.get(s);
                if (num == 1) map.remove(s);
                else map.put(s, --num);
            }
            for (String s : map.keySet()) {
                answer += s;
            }
            return answer;
        }
    }
}
