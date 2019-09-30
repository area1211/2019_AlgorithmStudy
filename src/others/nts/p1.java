package others.nts;

public class p1 {
    public static void main(String[] args) {
        String str = "bBa";
        String solution = new p1().solution(str);
        System.out.println(solution);
    }

    public String solution(String s) {
        int[] arr = new int[26];
        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        int max = 0;
        for (char ch :
                chars) {
            arr[ch - 97]++;
            if (max < arr[ch - 97])
                max = arr[ch - 97];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (max == arr[i])
                sb.append((char)(i + 97));
        }

        return sb.toString();
    }

    public String solution(String start, String end) {
        String answer = "";
        return answer;
    }

}
