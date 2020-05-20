package com.richborn.intersection;

import java.util.*;

/**
 * @author zhusg
 * @date 2020/5/20 14:15
 */
public class Intersection {
    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] aaa = {4,7,9,7,6,7};
        int[] bbb = {5,0,0,6,1,6,2,2,4};
        int[] ccc  = intersection.intersection(aaa,bbb);
        for (int i : ccc){
            System.out.println(i);
        }
    }
}
