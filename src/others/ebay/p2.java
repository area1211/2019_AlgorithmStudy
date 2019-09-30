package others.ebay;

public class p2 {

    public static void main(String[] args) {
        System.out.println(isPal("abaa"));
        System.out.println(numOfAppends("abcde"));
    }

    public static int solution(String plain) {
        int answer = 0;

        plain.length();


        return answer;
    }

    static int findMinInsertions(char str[], int l,
                                 int h)
    {
        // Base Cases
        if (l > h) return Integer.MAX_VALUE;
        if (l == h) return 0;
        if (l == h - 1) return (str[l] == str[h])? 0 : 1;

        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which subrpoblem(s) to call
        return (str[l] == str[h])?
                findMinInsertions(str, l + 1, h - 1):
                (Integer.min(findMinInsertions(str, l, h - 1),
                        findMinInsertions(str, l + 1, h)) + 1);
    }

    static int numOfAppends(String str) {
        if(isPal(str))
            return 0;

        return 1 + numOfAppends(str.substring(1));
    }

    private static boolean isPal(String str) {
        int length = str.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = str.charAt(forward++);
            char backwardChar = str.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

}
