public class RadixSort {

    public static String[] radixSort(String[] list) { // Passing in a String[] list instead of int[]
        int keySize = 0;
        int N = list.length;
        // Finding the longest string in the list
        for (int i = 0; i < list.length; i++) {
            if (keySize < list[i].length()) {
                keySize = list[i].length();
            }
        }
        //Padding shorter strings with spaces
        for (int i = 0; i < list.length; i++) {
            while (list[i].length() < keySize) {
                list[i] = list[i] + " ";
            }
        }
        
        String buckets[][] = new String[27][list.length];
        int bucketCounts[];
        int shift = keySize - 1;

        // refer to pusedocode in CSC 310 Notes
        for (int i = 0; i < keySize; i++) {
            bucketCounts = new int[27]; // a-z + space
            for (int j = 0; j < list.length; j++) {
                int bn = list[j].charAt(shift); // bn --> bucketNumber
                if (bn == 32) { // space --> 0
                    buckets[0][bucketCounts[0]++] = list[j];
                } else { // a-z
                    buckets[bn - 96][bucketCounts[bn - 96]++] = list[j];
                }
            }
            list = combineBuckets(buckets, bucketCounts, N);
            shift--;
        }
        return list;
    }

    public static String[] combineBuckets(String buckets[][], int bucketCounts[], int N) {
        String combinedBuckets[] = new String[N];
        int j = 0;
        for (int bn = 0; bn < buckets.length; bn++) {
            for (int b = 0; b < bucketCounts[bn]; b++) {
                combinedBuckets[j++] = buckets[bn][b];
            }
        }
        return combinedBuckets;
    }

    public static void main(String args[]) {
        String[] unsorted = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        String[] sorted = radixSort(unsorted);

        System.out.println("Unsorted List");
        for (int i = 0; i < unsorted.length; i++) {
            System.out.println(i + ": \t" + unsorted[i]);
        }
        System.out.println("\nSorted List");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(i + ": \t" + sorted[i]);
        }
        
    }
}