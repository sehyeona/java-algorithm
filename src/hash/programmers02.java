package hash;

import java.util.ArrayList;
import java.util.HashMap;

public class programmers02 {
   static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            HashMap<Integer, HashMap<Integer, ArrayList<String>>> map = new HashMap<>();
            for (String phoneNumber : phone_book) {
                Integer start = Integer.parseInt(phoneNumber.substring(0, 1));
                HashMap<Integer, ArrayList<String>> lengthMap = map.getOrDefault(start, new HashMap<>());

                Integer length = phoneNumber.length();
                ArrayList<String> phoneSubBook = lengthMap.getOrDefault(length, new ArrayList<>());
                phoneSubBook.add(phoneNumber);
                lengthMap.put(length, phoneSubBook);

                map.put(start, lengthMap);

                for (Integer targetLen : lengthMap.keySet()) {
                    if (targetLen > length) {
                        for (String targetPhone : lengthMap.get(targetLen)) {
                            if (targetPhone.startsWith(phoneNumber)) return false;
                        }
                    }
                    if (targetLen < length) {
                        for (String targetPhone : lengthMap.get(targetLen)) {
                            if (phoneNumber.startsWith(targetPhone)) return false;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
