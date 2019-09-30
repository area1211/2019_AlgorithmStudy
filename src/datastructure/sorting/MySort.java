package datastructure.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// TODO: 2019-06-05
// merge sort 최적화
public class MySort {

    public static void main(String[] args) {

        int[] list = {5, 3, 8, 4, 9, 1, 6, 2, 7};
//        new MySort().mergeSort(list, 0, list.length - 1);
        new MySort().quickSort(list, 0, list.length - 1);

        for (int l = 0; l < list.length; l++) {
            System.out.print(list[l] + " ");

        }

        List<Integer> listTest = new ArrayList<>();
        for (int i = 0; i < 6100; i++) {
            listTest.add(i);
        }

        List<Integer> integers = reverseRecursive(listTest);
    }

    private static List<Integer> reverseRecursive(List<Integer> list) {
        if(list.size() <= 1) return list;
        else {
            List<Integer> reversed = new ArrayList<>();
            reversed.add(list.get(list.size() - 1));
            reversed.addAll(reverseRecursive(list.subList(0, list.size() - 1)));
            return reversed;
        }
    }



    void mergeSort(int[] list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(int[] list, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        int[] sorted = new int[list.length];
        while (i <= mid & j <= right) {
            if (list[i] < list[j])
                sorted[k++] = list[i++];
            else
                sorted[k++] = list[j++];
        }

//        if(i > mid) {
//            // 왼쪽이 끝난 경우
//            for (int l = j; l <= right ; l++) {
//                sorted[k++] = list[l];
//
//            }
//        } else {
//            // 오른쪽이 끝난 경우
//            for (int l = i; l <= mid; l++) {
//                sorted[k++] = list[l];
//            }
//        }
//
//        for (int l = left; l <= right; l++) {
//            list[l] = sorted[l];
//        }

        if (i > mid) {
            while (j <= right)
                sorted[k++] = list[j++];
        } else {
            while (i <= mid) {
                sorted[k++] = list[i++];
            }
        }

        for (int l = left; l <= right; l++) {
            list[l] = sorted[l];
        }

//        System.arraycopy(sorted, left, list, left, right - left + 1);


//        // 왼쪽이 끝난 경우, 즉 오른쪽 파티션에 값이 남은 경우 이미 정렬된 상태이다.
//        // 따라서 왼쪽이 끝나지 않았을 경우에만 임시 배열로 복사해준다.
//        while(i <= mid) {
//            sorted[k++] = list[i++];
//        }
//
//        // left 부터 정렬된 인덱스 k 까지만 값을 원래 배열에 복사해준다.
//        for (int l = left; l < k; l++) {
//            list[l] = sorted[l];
//        }
    }

    void quickSort(int[] list, int left, int right) {
        if (left < right) {
            int p = partition(list, left, right);
            quickSort(list, left, p - 1);
            quickSort(list, p + 1, right);
        }
    }

    private int partition(int[] list, int left, int right) {
        int pivot = list[left];
        int low = left + 1, high = right;

        while (low < high) {
            while (low <= right && list[low] < pivot)
                low++;
            while (high >= left && list[high] > pivot)
                high--;

            if (low < high) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        int temp = list[left];
        list[left] = list[high];
        list[high] = temp;

        return high;
    }
}
