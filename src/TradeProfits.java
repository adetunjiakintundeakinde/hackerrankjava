/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
/**
 * h
 *
 * @author Adetunji.Akinde
 *
 */
public class TradeProfits {

    static int traderProfit(int k, int n, Integer[] A) {
        // Complete this function
        List<Integer> listA = (List<Integer>) Arrays.asList(A);
        int maximumProfit = bestProfit(listA);
        if (k == 1) {
            return maximumProfit;
        } else {
            for (int i = 2; i <= k; i++) {
                int largestNumberOfPairs = (i - 1) * 2;
                if (listA.size() >= i * 2) {
                    for (int j = 0; j < listA.size() - 2; j++) {
                        for (int p = 1; p < listA.size(); p++) {
                            List<Integer> firstList = listA.subList(j, j + p + 1);
                            List<Integer> secondList = listA.subList(j + p + 1, listA.size());
                            if (secondList.size() >= largestNumberOfPairs) {
                                int bestOfProfitFirstList = bestProfit(firstList);
                                int bestProfirSecondList = bestProfit(secondList);
                                if ((bestOfProfitFirstList + bestProfirSecondList) > maximumProfit) {
                                    maximumProfit = bestOfProfitFirstList + bestProfirSecondList;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } else {
                    break;
                }
            } 
        }
        return maximumProfit;
    }

    static int bestProfit(List<Integer> A) {
        int minimum = 0;
        int maximum = 0;
        int indexOfMinimum = 0;
        minimum = A.get(0);
        maximum = 0;
        int bestProfit = 0;
        //getMinimum
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) < minimum) {
                minimum = A.get(i);
                indexOfMinimum = i;
            }

            for (int j = indexOfMinimum + 1; j < A.size(); j++) {
                if (A.get(j) > maximum && A.get(j) > minimum) {
                    maximum = A.get(j);
                }
            }
            if (maximum - minimum >= 0 && (maximum - minimum) > bestProfit) {
                bestProfit = maximum - minimum;
            }
        }

        return bestProfit;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int k = in.nextInt();
            int n = in.nextInt();
            Integer[] arr = new Integer[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}
