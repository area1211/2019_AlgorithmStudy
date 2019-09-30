package others.kakao2019;

import java.util.HashMap;
import java.util.Map;

public class p4 {

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(solution(words, queries));
    }


    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

//        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            String regexPattern = createRegexPattern(queries[i]);
//            if(map.containsKey(regexPattern)) continue;

            int count = 0;
            for (String word : words) {
                if (word.matches(regexPattern)) {
                    count++;
                }
            }
            answer[i] = count;
//            map.put(regexPattern, count);
        }

        return answer;
    }

    private static String createRegexPattern(String original) {
        StringBuilder out = new StringBuilder("^");
        for (int i = 0; i < original.length(); ++i) {
            final char c = original.charAt(i);
            switch (c) {
                case '*':
                    out.append(".*");
                    break;
                case '?':
                    out.append('.');
                    break;
                case '.':
                    out.append("\\.");
                    break;
                case '\\':
                    out.append("\\\\");
                    break;
                default:
                    out.append(c);
            }
        }
        out.append('$');
        return out.toString();
    }
}
