import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class KthSmallestElement {
    private static Random rand = new Random();
    private static Scanner keyboard = new Scanner(System.in);

    // implementation of Algorithm #1
    public static int select1(int k, int[] S) {
        //base case
        if (S.length == 1)
            return S[0];

        //choose an element m randomly from S
        int m = S[rand.nextInt(S.length)];

        //3 sequences from S
        ArrayList<Integer> S1 = new ArrayList<Integer>();
        ArrayList<Integer> S2 = new ArrayList<Integer>();
        ArrayList<Integer> S3 = new ArrayList<Integer>();

        int p = 0;
        int q = 0;
        int r = 0;
        System.out.println("m ="+m);

        for (int i = 0; i < S.length; i++) {
            //case1 where S[i] less than m
            if (S[i] < m) {
                S1.add(S[i]);
                p++;
                System.out.println("S["+i+"]=" +S[i] + " p= "+p);

            //case2 where s[i] equal m
            } else if (S[i] == m) {
                S2.add(S[i]);
                q++;
                System.out.println("S["+i+"]=" +S[i] + " q= "+q);
            //case3 where s[i] bigger than m
            } else {
                S3.add(S[i]);
                r++;
                System.out.println("S["+i+"]=" +S[i] + " r= "+r);
            }
        }


        if (S1.size() >= k)
            return select1(k, toArray(S1));
        else if (S1.size() + S2.size() >= k)
            return m;
        else
            return select1(k - S1.size() - S2.size(), toArray(S3));
    }

    public static int select2(int k, int[] S){
        if (S.length <50){
            Arrays.sort(S);
            return S[k-1];
        }
        else {
            printArray(S);
            int j=0;
            for (int i = 0; i < S.length; i += 5)
            {
                j=i+5;
                if (j < S.length)
                    Arrays.sort(S, i, j);
                else
                    Arrays.sort(S, i, S.length);
            }
            printArray(S);
        }

        int[] M = new int[S.length/5];
        System.out.println("size of M="+ M.length);
        printArray(S);
        int j=0;
        for (int i=2; i< S.length-(S.length%5); i+=5){
            M[j] = S[i];
            j++;
        }
        printArray(M);

        int m = select2(M.length/2 +1, M);
        System.out.println("value of m="+ m);
        printArray(M);

        return 1;
    }


    private static int[] toArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", "); // Print a comma and space for all elements except the last one
            }
        }
        System.out.println(); // Print a newline after printing all elements
    }
}
