package others;

import java.util.*;

/**
 * 2019.06.13 (목)
 * 배열의 원소 중에서 median(중간값) 찾기
 * < 동적으로 값을 삽입할 때마다 중간값을 찾는 방법 >
 *      두 개의 heap 을 사용한다.
 *      하나는 max heap, 하나는 mean heap 으로 만든다.
 *      힙을 구성하는 데 까지는 시간이 좀 걸리지만, 값을 계속 추가해나가면서 중간값을 찾을 때는 훨씬 효율적이다.
 * 참고: https://stackoverflow.com/questions/11955728/how-to-calculate-the-median-of-an-array
 */
public class GetMedian {

    public static void main(String[] args) {
        Heap heap = new Heap();

        int[] randomArr = getRandomArr(1000001);

        long start = System.currentTimeMillis();
        for (int i :
                randomArr) {
            heap.add(i);
        }
        System.out.println(heap.median());

        long end = System.currentTimeMillis();

        System.out.println(end - start);


        start = System.currentTimeMillis();
        System.out.println(median(randomArr));
        end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    static int[] getRandomArr(int size) {
        Random random = new Random();

        int[] randomArr = new int[size];
        for (int i = 0; i < size; i++) {
            randomArr[i] = random.nextInt(100) + 1;
        }
        return randomArr;
    }

    // 정렬로 중간값 구하는 방법
    public static double median(int[] arr) {
        Arrays.sort(arr);
        double result = 0;
        int size = arr.length;


        if (size % 2 == 1) { // 배열의 개수가 홀수일 때
            result = arr[((size - 1) / 2) + 1];
            System.out.println(" uneven size : " + result);
        } else { // 배열의 개수가 짝수일
            int middle_pair_first_index = (size - 1) / 2;
            result = (arr[middle_pair_first_index + 1] + arr[middle_pair_first_index]) / 2;
            System.out.println(" Even size : " + result);
        }

        return result;
    }
}

class Heap {
    private Queue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> high = new PriorityQueue<>();

    public void add(int number) {
        // size 크기가 더 작은 queue 에 number 를 추가한다.
        Queue<Integer> target = low.size() <= high.size() ? low : high;
        target.add(number);
        balance();
    }

    private void balance() {
        // low.peek() 값이 high.peek() 값보다 작을 때까지 두 개의 queue 에 있는 값을 교환한다.
        if (!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek()) {
            Integer lowHead = low.poll();
            Integer highHead = high.poll();
            low.add(highHead);
            high.add(lowHead);
        }
    }

    public double median() {
        if (low.isEmpty() && high.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        } else {
            // 배열의 개수가 짝수일 때(두 heap 의 크기가 같을 때)
            // 두 heap 의 peek() 값의 평균이 중간값이다.
            // 배열의 개수가 홀수일 때는 low heap(최소 힙)의 peek()이 중간값이다.
            return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : low.peek();
        }
    }
}