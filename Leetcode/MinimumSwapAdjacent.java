package Leetcode;

public class MinimumSwapAdjacent {

    public static void main(String args[]) {
        int arr[] = { 0, 2, 1, 3, 4, 5, 6 };

        int pair[] = { 0, 6, 5, 4, 3, 2, 1 };

        System.out.println(minimumNumberOfSwaps(arr, pair));
    }

    private static int minimumNumberOfSwaps(int[] arr, int[] pair) {

        if (arr == null || pair == null) {
            throw new IllegalArgumentException();
        }

        if (arr.length == 0 && pair.length == 0) {
            return 0;
        }

        if (arr.length == 0 || pair.length == 0) {
            return 0;
        }

        int indexArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexArr[arr[i]] = i;
        }

        int count = 0;
        for (int i = 1; i < arr.length - 2; i += 2) {
            int j = i + 1, k = i + 2;
            if (arr[j] == pair[arr[i]]) {
                continue;
            } else {
                if ((arr[j] != pair[arr[i]]) && (arr[j] == pair[arr[k]])) {
                    int temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;
                }

                else {
                    int temp = arr[indexArr[pair[arr[i]]]];
                    arr[indexArr[pair[arr[i]]]] = arr[j];
                    arr[j] = temp;
                }
                count++;
            }
        }
        return count;
    }
}
