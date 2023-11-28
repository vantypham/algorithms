package basic;

import java.util.Random;

/**
 * Problem statement.
 * Find the largest distance between any two even integers in an integer array.
 * Note that the distance between 8 and 2 is 6.
 * Further, the distance between 2 and 8 is also 6.
 *
 * @Author: 15. Nguyen, Ha Vu Duy
 * @Author: 20. Pham, Van ty
 */
public class AssignmentOne {
    public static void main(String[] args) {
        test_Algorithm_1();
        System.out.println("\n");
        test_Algorithm_2();
        System.out.println("\n");
        test_Algorithm_3();
    }
    /**
     * Algorithm 1.
     * Create a new array consisting of even numbers only.
     * Then use nested loops to solve the problem using the newly created array of even numbers only.
     *
     */
    public static int getLargestDistance_1(int size) {
        int[] array = randomInt(size);
        //counting the numbers of even integers
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            // identify even number
            if (array[i] % 2 == 0) {
                counter++;
            }
        }
        //create a new array with counter size
        int[] newArray = new int[counter];
        int flag = 0;
        //loop again then put data of even integers to new array
        for (int z = 0; z < array.length; z++) {
            // identify even number
            if (array[z] % 2 == 0) {
                newArray[flag] = array[z];
                flag++;
            }
        }

        //continue loop the even newArray to find the largest distance
        int largestDistance = 0;
        int a = 0;
        int b = 0;
        for (int j=0; j<newArray.length; j++) {
            int x = newArray[j];
            for (int k = 0; k < newArray.length; k++) {
                int y = newArray[k];
                if (Math.abs(x - y) > largestDistance) {
                    largestDistance = Math.abs(x - y);
                    a = x;
                    b = y;
                }
            }
        }
        System.out.println("---     evens="+counter + ", a="+a + ", b="+b + ", largestDistance="+largestDistance);
        return largestDistance;
    }
    /**
     * Algorithm 2.
     * Use a nested loop to solve the problem without creating an extra array.
     */
    public static int getLargestDistance_2(int size) {
        int[] array = randomInt(size);

        int largestDistance = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < array.length; i++) {
            // identify even number
            if (array[i] % 2 == 0) {
                int x = array[i];
                for (int k = 0; k < array.length; k++) {
                    // identify even number
                    if (array[k] % 2 == 0) {
                        int y = array[k];
                        if (Math.abs(x - y) > largestDistance) {
                            largestDistance = Math.abs(x - y);
                            a = x;
                            b = y;
                        }
                    }
                }
            }
        }
        System.out.println("---     a="+a + ",b="+b + ", LargestDistance="+largestDistance);
        return largestDistance;
    }

    /**
     * Algorithm 3.
     * Use one loop. Find max and min of even integers. Compute max – min.
     * Please compute max and min and please do not use Math Library.
     */
    public static int getLargestDistance_3(int size) {
        int[] array = randomInt(size);
        int largestDistance = 0;
        int max = 2;//init data
        int min = 0;//because we randomly generate the array of integers greater than 0, then min of even should be 2

        for (int i = 0; i < array.length; i++) {
            // identify even number
            if (array[i] % 2 == 0) {
                int x = array[i];
                if (min==0) {
                    min = x;
                }
                if (x < min) {
                    min = x;
                } else if (x > max) {
                    max = x;
                } else if (min <= x && x <= max) {
                    //do nothing, continue loop
                }
            }
        }
        largestDistance = max - min;
        System.out.println("---     max="+max + ",min="+min + ", LargestDistance="+largestDistance);
        return largestDistance;
    }

    /**
     * Randomly generate an array of integers base on the size input as parameter.
     * @param size
     * @return
     */
    public static int[] randomInt(int size) {
        Random random = new Random(); // creating Random object
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int r = 1 + (random.nextInt(size));
            arr[i] = r;
            //System.out.println(arr[i]); // printing each array element
        }
        return arr;
    }

    public static void test_Algorithm_1() {
        System.out.println("-----Algorithm_1 with random of 1000 numbers - START");
        long startTime = System.currentTimeMillis();
        getLargestDistance_1(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 1000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_1 with random of 2000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_1(2000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 2000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_1 with random of 4000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_1(4000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 4000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_1 with random of 10000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_1(10000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 10000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
        System.out.println("-----Algorithm_1 with random of 30000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_1(30000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 30000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
    }

    public static void test_Algorithm_2() {
        System.out.println("-----Algorithm_2 with random of 1000 numbers - START");
        long startTime = System.currentTimeMillis();
        getLargestDistance_2(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 1000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_2 with random of 2000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_2(2000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 2000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_2 with random of 4000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_2(4000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 4000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_2 with random of 10000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_2(10000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 10000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
        System.out.println("-----Algorithm_2 with random of 30000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_2(30000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 30000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
    }

    public static void test_Algorithm_3() {
        System.out.println("-----Algorithm_3 with random of 1000 numbers - START");
        long startTime = System.currentTimeMillis();
        getLargestDistance_3(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_3 with random of 1000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_3 with random of 2000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_3(2000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_3 with random of 2000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_3 with random of 4000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_3(4000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_3 with random of 4000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_3 with random of 10000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_3(10000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_3 with random of 10000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
        System.out.println("-----Algorithm_3 with random of 30000 numbers - START");
        startTime = System.currentTimeMillis();
        getLargestDistance_3(30000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_3 with random of 30000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
    }


}
