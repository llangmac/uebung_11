package h2;

import java.util.ArrayList;
import java.util.Arrays;

public class H2_main {

    private static int[] fibonacci_cached = new int[1000];

    public static void main(String[] args) {
        //benchmark(20);
    }

    public static void benchmark(int n) {
        long b = System.nanoTime();
        System.out.println(fibonacci(new ArrayList<Integer>(), n));
        long a = System.nanoTime();
        System.out.println("Method a) : " + "Elapsed nano-seconds: " + (a - b));

        b = System.nanoTime();
        System.out.println(Arrays.toString(fibonacciCached(n)));
        a = System.nanoTime();
        System.out.println("Method b) : " + "Elapsed nano-seconds: " + (a - b));

        b = System.nanoTime();
        System.out.println(Arrays.toString(fibonacci_for(n)));
        a = System.nanoTime();
        System.out.println("Method c) : " + "Elapsed nano-seconds: " + (a - b));

    }

    public static ArrayList<Integer> fibonacci(ArrayList<Integer> list, int n) {

        if(list.toArray().length < 2) {
            list.add(0, 1);
            list.add(1, 1);
        }

        list.add((list.get(list.toArray().length - 1)) + (list.get(list.toArray().length - 2)));

        if(list.toArray().length >= n) {
            return list;
        }
        else {
            fibonacci(list, n);
        }
        return list;
    }

    public static int[] fibonacciCached(int n) {
        fibonacci_cached[0] = 1;
        fibonacci_cached[1] = 1;
        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {
            if(fibonacci_cached[i] == 0) {
                fibonacci_cached[i] = fibonacci_cached[i-1] + fibonacci_cached[i-2];
                temp[i] = fibonacci_cached[i];
            }
            else{
                temp[i] = fibonacci_cached[i];
            }
        }

        return temp;
    }

    public static int[] fibonacci_for(int n) {

        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i = 2; i < n; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        return fibonacci;
    }

}
