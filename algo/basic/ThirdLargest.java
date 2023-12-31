package basic;

import java.util.Random;

public class ThirdLargest {
    public static void main(String[] args) {
        test_Algorithm_1();
        System.out.println("\n");
        test_Algorithm_2();
    }

    /**
     * Algorithm 2 :
     * Idea – Use one loop. Maintain three variable max, preMax and prePreMax such that max
     * will have the maximum value, preMax will have the second largest and prePreMax will have the
     * third largest value.
     */
    public static int findThirdLargest_2(int size) {
        int[] a = randomInt(20);
        //int a[] = {7, 20, 18, 4, 21, 19, 20, 3};
        int first = 0;
        int second = 0;
        int third = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] > first ){
                third = second;
                second = first;
                first = a[i];
            }
            else if(a[i] > second){
                third = second;
                second = a[i];
            }
            else if(a[i] > third)
                third = a[i];
        }
        System.out.println("first="+first+", second="+ second + ", third="+ third);
        return third;
    }

    /**
     * Algorithm 1 : Idea – Use three loops one after another.
     * First will find Max. Second will find Second Max, Third will find third max.
     */
    public static int findThirdLargest_1(int size) {
        int[] array = randomInt(size);
        int first = 0;
        int second = 0;
        int third = 0;
        //loop 1
        for (int i = 0; i<array.length; i++) {
            int current1 = array[i];
            if (current1 > first) {
                first = current1;
            }
        }
        //loop 2
        int counter = 0;
        for (int i = 0; i<array.length; i++) {
            int current1 = array[i];
            if (current1 == first) {
                counter++;
            }
            if (counter > 1 && current1 == first) {
                second = first;
            } else if (current1 > second && current1 < first) {
                second = current1;
            }
        }
        //loop 3
         counter = 0;
         int counter2 = 0;
        for (int i = 0; i<array.length; i++) {
            int current1 = array[i];
            if (current1 == first) {
                counter++;
            }
            if (current1 == second && current1 != first) {
                counter2++;
            }
            if (counter > 1 && current1 == first && counter2 <= 1) {

                int secondT = second;
                second = current1;
                if (counter > 2) {
                    third = secondT;
                }
            } else
            if (counter2 > 1 && current1 == second) {
                third = second;
            }
            if (current1 > third && current1 < second && current1 < first) {
                third = current1;
            }
        }
        //end loop
        System.out.println("first="+first+", second="+ second + ", third="+ third);
        return third;
    }

    public static int[] randomInt(int size) {
        Random random = new Random(); // creating Random object
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            int r = 1 + (random.nextInt(size));
            arr[i] = r;
            //System.out.print(arr[i]+","); // printing each array element
        }
        return arr;
    }

    public static void test_Algorithm_1() {
        System.out.println("-----Algorithm_1 with random of 1000 numbers - START");
        long startTime = System.currentTimeMillis();
        findThirdLargest_1(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 1000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_1 with random of 2000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_1(2000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 2000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_1 with random of 4000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_1(4000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 4000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_1 with random of 10000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_1(10000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 10000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
        System.out.println("-----Algorithm_1 with random of 30000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_1(30000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_1 with random of 30000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
    }

    public static void test_Algorithm_2() {
        System.out.println("-----Algorithm_2 with random of 1000 numbers - START");
        long startTime = System.currentTimeMillis();
        findThirdLargest_2(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 1000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_2 with random of 2000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_2(2000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 2000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_2 with random of 4000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_2(4000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 4000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");

        System.out.println("-----Algorithm_2 with random of 10000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_2(10000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 10000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
        System.out.println("-----Algorithm_2 with random of 30000 numbers - START");
        startTime = System.currentTimeMillis();
        findThirdLargest_2(30000);
        endTime = System.currentTimeMillis();
        System.out.println("-----Algorithm_2 with random of 30000 numbers - END - Time=" + ""+(endTime-startTime) + " milliseconds");
    }

}
