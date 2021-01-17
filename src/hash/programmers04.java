package hash;

import java.util.*;
import java.util.stream.Collectors;

public class programmers04 {
    public Integer[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            ArrayList<int[]> musicList = genreMap.getOrDefault(genres[i], new ArrayList<>());
            musicList.add(new int[]{plays[i], i});
            genreMap.put(genres[i], musicList);
        }
        List<String> genreOrder = genreMap.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().mapToInt(o -> o[0]).sum()))
                .entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).map(Map.Entry::getKey).collect(Collectors.toList());


        List<Integer> collect = genreOrder.stream()
                .map(o -> genreMap.get(o).stream().sorted((o1, o2) -> musicComp.compare(o1, o2)).limit(2).collect(Collectors.toList())).collect(Collectors.toList())
                .stream().flatMap(o -> o.stream().map(a -> a[1])).collect(Collectors.toList());
        Integer[] answer = collect.toArray(new Integer[collect.size()]);
        return answer;
    }

    Comparator<int[]> musicComp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            int listenCompare = -1 * Integer.compare(o1[0], o2[0]);
            if (listenCompare != 0) {

                return listenCompare;
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        }
    };

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop", "dddd"};
        int[] plays = new int[]{500, 600, 150, 800, 2500, 330000};
        Integer[] answer = new programmers04().solution(genres, plays);
        System.out.println("answer = " + answer.toString());
    }
}