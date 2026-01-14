package h3;

import java.util.Arrays;

public class H3_main {

    public static void main(String[] args) {

        //int[] i = {5, 3, 8, 1, 4};
        //System.out.println(Arrays.toString(mergeSort(i)));

    }

    public static int[] mergeSort(int[] list) {

        if (list.length <= 1) {
            return list;
        }

        int mid = list.length / 2;

        int[] lList = new int[mid];
        for(int i = 0; i < mid; i++) {
            lList[i] = list[i];
        }

        int[] rList = new int[list.length - mid];
        for(int i = mid; i < list.length; i++) {
            rList[i - mid] = list[i];
        }

        lList = mergeSort(lList);
        rList = mergeSort(rList);

        return merge(lList, rList);
    }

    public static int[] merge(int[] x, int[] y) {

        int[] temp = new int[x.length + y.length];
        int r = 0;
        int l = 0;
        int i = 0;

        while(l < x.length && r < y.length) {
            if(x[l] < y[r]) {
                temp[i] = x[l];
                i++; l++;
            }
            else {
                temp[i] = y[r];
                r++; i++;
            }
        }

        while(l < x.length) {
            temp[i] = x[l];
            l++; i++;
        }

        while (r < y.length) {
            temp[i] = y[r];
            r++; i++;
        }

        return temp;
    }
}

