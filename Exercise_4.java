public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Your code here
        int s1 = m - l + 1;
        int s2 = r - m;

        int ar1[] = new int[s1];
        int ar2[] = new int[s2];

        for (int i = 0; i < s1; i++) {
            ar1[i] = arr[l + i];
        }
        for (int j = 0; j < s2; j++) {
            ar2[j] = arr[m + 1 + j];
        }

        int a = 0, b = 0;
        int c = l;
        while (a < s1 && b < s2) {
            if (ar1[a] < ar2[b]) {
                arr[c] = ar1[a];
                a++;

            } else {

                arr[c] = ar2[b];
                b++;
            }
            c++;
        }

        while (a < s1) {
            arr[c] = ar1[a];
            a++;
            c++;
        }

        while (b < s2) {
            arr[c] = ar2[b];
            b++;
            c++;
        }

    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        // Write your code here
        // Call mergeSort from here

        if (l < r) {
            int mid = (l + r) / 2;

            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }

    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}