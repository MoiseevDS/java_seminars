package seminar_3;

// Task 1 Реализовать алгоритм сортировки слиянием

public class program_3_1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        array = FillRandomArray(10);

        for (int element : array) {
            System.out.printf("%d, ", element);
        }
        mergeSort(array, 10);
        System.out.println();
        System.out.println("Sort Array: ");
        for (int element : array) {
            System.out.printf("%d, ", element);
        }

    }

    public static int[] FillRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((int) (Math.random() * 20));
        }
        return arr;
    }

    public static void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];
        System.arraycopy(arr, 0, leftArr, 0, mid);
        System.arraycopy(arr, mid, rightArr, 0, n - mid);
        mergeSort(leftArr, mid);
        mergeSort(rightArr, n - mid);
        merge(arr, leftArr, rightArr, mid, n - mid);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;
        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }
        while (i < leftLength) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightLength) {
            arr[k++] = rightArr[j++];
        }
    }
}
