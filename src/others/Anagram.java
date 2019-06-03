package others;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        boolean anagram = isAnagram("abbbbcdef", "bbbbbcdef");
        System.out.println(anagram);
    }

    public static boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char tempChar = str1.charAt(i);
            if(map.containsKey(tempChar)) {
                int tempInt = map.get(tempChar);
                map.put(tempChar, tempInt + 1);
            } else {
                map.put(tempChar, 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char tempChar = str2.charAt(i);
            if(map.containsKey(tempChar)) {
                int tempInt = map.get(tempChar);
                if(tempInt == 1)
                    map.remove(tempChar);
                else
                    map.put(tempChar, tempInt - 1);
            } else {
                return false;
            }
        }


        for (var temp :
                map.keySet()) {

            System.out.println(map.get(temp));

        }

        return map.isEmpty();
    }
}
