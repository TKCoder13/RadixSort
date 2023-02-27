public class RadixSort {

    public static int[] radixSort(int[] list) {
        int buckets[][] = new int[10][list.length];
        int bucketCounts[];
        int keySize = 10; // refer to pusedocode in CSC 310 Notes
        int shift = 1;
        for (int i = 0; i < keySize; i++) {
            bucketCounts = new int[10];
            for (int j = 0; j < list.length; j++) {
                int bn = (list[j] / shift) % 10; // bn --> bucketNumber
                buckets[bn][bucketCounts[bn]++] = list[j];
                // or you can do the following
                // buckets[bn][bucketCounts[bn]] = list[j];
                // ++bucketCounts[bn];
            }
            list = combineBuckets(buckets, bucketCounts);
            shift *= 10;
        }
        return list;
    }

    private static int[] combineBuckets(int buckets[][], int bucketCounts[]) { // You can also pass in N as an argument, but here we calc in the method.
        int N = 0;
        for (int i = 0; i < bucketCounts.length; i++) {
            N += bucketCounts[i];
        }
        int combinedBuckets[] = new int[N];
        int j = 0;
        for (int bn = 0; bn < buckets.length; ++bn) {
            for (int b = 0; b < bucketCounts[bn]; ++b) {
                combinedBuckets[j++] = buckets[bn][b];
            }
        }
        return combinedBuckets;
    }

    public static void main(String args[]) {
        int[] list = {10,9,8,5,1,2,3,4};
        int[] test = radixSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(test[i]);
        }
    }
}