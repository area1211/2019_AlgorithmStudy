package others;

// TODO: 2019-06-27
public class ReverseWords {

    public static void main(String[] args) {
        String[] s = "i like this program very much".split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = s.length - 1; i >= 0; i--) {

            ans.append(s[i]).append(" ");

        }
        System.out.print("Reversed String: ");
        System.out.println(ans);
    }


}
