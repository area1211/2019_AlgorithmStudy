package datastructure.sorting;

// TODO: 2019-06-05
// merge sort 최적화
public class MySort {

    public static void main(String[] args) {
        int[] list = {1, 9, 4, 3, 8, 5, 2, 7};
        new MySort().mergeSort(list, 0, list.length - 1);

        for (int l = 0; l < list.length; l++) {
            System.out.print(list[l] + " ");

        }
    }

    void mergeSort(int[] list, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid+1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(int[] list, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        int[] sorted = new int[list.length];
        while(i <= mid & j <= right) {
            if(list[i] < list[j])
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


        // 왼쪽이 끝난 경우, 즉 오른쪽 파티션에 값이 남은 경우 이미 정렬된 상태이다.
        // 따라서 왼쪽이 끝나지 않았을 경우에만 임시 배열로 복사해준다.
        while(i <= mid) {
            sorted[k++] = list[i++];
        }

        // left 부터 정렬된 인덱스 k 까지만 값을 원래 배열에 복사해준다.
        for (int l = left; l < k; l++) {
            list[l] = sorted[l];
        }
    }

}
