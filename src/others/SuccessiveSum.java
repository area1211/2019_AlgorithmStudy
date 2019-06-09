package others;

public class SuccessiveSum {
    public static void main(String[] args) {
        int[] list = {-1, 3, -1, 5};

        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < list.length; i++) {
            maxEndingHere += list[i];
            if(maxEndingHere < 0)
                maxEndingHere = 0;

            if(maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
        }

        System.out.println(maxSoFar);
    }

}
