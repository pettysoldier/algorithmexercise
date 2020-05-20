package com.richborn.happynumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhusg
 * @date 2020/5/20 14:53
 */
public class HappyNumber {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean ishappy = happyNumber.isHappy(29);
        System.out.println(ishappy);
    }
}
