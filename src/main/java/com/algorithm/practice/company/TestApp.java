package com.algorithm.practice.company;

import java.util.HashMap;

/**
 * Description
 * Date 2020/3/21 21:18
 * Created by kwz
 */
public class TestApp {
    public static void main(String[] args) {
        HashMap<String, Object> maps = new HashMap<>(8);
        maps.put("one","1");
        maps.put("two","2");
        maps.put("three","3");
        System.out.println(maps);

        System.out.println(maps.hashCode());
        System.out.println("str".hashCode());
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (right + left) / 2;
            System.out.println(nums[mid]);
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
