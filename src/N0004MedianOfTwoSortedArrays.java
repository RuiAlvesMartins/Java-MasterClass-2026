import java.util.Arrays;

public class N0004MedianOfTwoSortedArrays {
    
    //  todo remove static
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];

        int i1 = 0;
        int i2 = 0;
        int cycles = 0;
        boolean isFirstCycleReset = false;
        boolean isSorted = false;

        while (!isSorted) {
            
            isSorted = true;

            for(int i0=1; i0 < mergedArray.length - cycles; i0++) {

                int p1 = i0 - 1;
                int p2 = i0;
                int temp;

                boolean isPopulated = i1 > nums1.length-1 && i2 > nums2.length-1;

                //  initializes the first 2 slots of merged array;
                if (i0 == 1 && !isPopulated) {
                    if (nums1[0] >= nums2[0]) {
                        mergedArray[p1] = nums2[i2++];
                        mergedArray[p2] = nums1[i1++];
                    }
                    else {
                        mergedArray[p1] = nums1[i1++];
                        mergedArray[p2] = nums2[i2++];
                    }
                    continue;
                }

                //  populates mergedArray with nums1 and nums2 on the first cycle, following bubble sort logic;
                if (i0 > 1 && !isPopulated) {

                    //  prevent indexOutOfBounds;
                    //  nums1 depleted; will insert from nums2;
                    if (i1 >= nums1.length) {
                        //  will insert new element from nums2 at p2;
                        if (nums2[i2] >= mergedArray[p1]) {
                            mergedArray[p2] = nums2[i2++];
                        }
                        //  will insert new element from nums2 at p1;
                        else {
                            mergedArray[p2] = mergedArray[p1];
                            mergedArray[p1] = nums2[i2++];
                        }
                        continue;
                    }
                    //  nums2 depleted; will insert from nums1;
                    if (i2 >= nums2.length) {
                        //  will insert new element from nums1 at p2;
                        if (nums1[i1] >= mergedArray[p1]) {
                            mergedArray[p2] = nums1[i1++];
                        }
                        //  will insert new element from nums1 at p1;
                        else {
                            mergedArray[p2] = mergedArray[p1];
                            mergedArray[p1] = nums1[i1++];
                        }
                        continue;
                    }

                    //  will insert one element from nums1 or nums2, whichever smaller;
                    if (nums1[i1] >= nums2[i2]) {
                        //  will insert new element from nums2 at p2;
                        if (nums2[i2] >= mergedArray[p1]) {
                            mergedArray[p2] = nums2[i2++];
                        }
                        //  will insert new element from nums2 at p1;
                        else {
                            mergedArray[p2] = mergedArray[p1];
                            mergedArray[p1] = nums2[i2++];
                        }
                    }
                    else {
                        //  will insert new element from nums1 at p2;
                        if (nums1[i1] >= mergedArray[p1]) {
                            mergedArray[p2] = nums1[i1++];
                        }
                        //  will insert new element from nums1 at p1;
                        else {
                            mergedArray[p2] = mergedArray[p1];
                            mergedArray[p1] = nums1[i1++];
                        }
                    }

                    isSorted = false;
                    continue;
                }

                //  regular bubble sort
                if (isPopulated) {
                    if (mergedArray[p1] > mergedArray[p2]) {
                        temp = mergedArray[p1];
                        mergedArray[p1] = mergedArray[p2];
                        mergedArray[p2] = temp;
                        isSorted = false;
                    }
                }

            }

            cycles++;  
            
            if (!isFirstCycleReset) {
                cycles--;
                isFirstCycleReset = true;
            }

        }

        // System.out.println(Arrays.toString(mergedArray));

        int len = mergedArray.length;
        return len%2 != 0 ? mergedArray[len/2] : (double) (mergedArray[len/2 - 1] + mergedArray[len/2]) / 2;

    }

    public static void main(String[] args) {
        
        System.out.println(4/2);

        int[] a = new int[] {1, 2, 3, 4, 5};

        double d = a.length%2 != 0 ? a[a.length/2] : (double) (a[a.length/2 - 1] + a[a.length/2]) / 2;
        System.out.println("result of d: " + d);

        int[] b = new int[5];
        System.out.println(b[0]);

        int[] c = new int[] {5, 4, 3, 2, 1};

        d = findMedianSortedArrays(a, c);
        System.out.println("result = " + d);

    }

}

