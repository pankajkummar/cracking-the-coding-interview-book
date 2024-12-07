package com.coding.cracking_the_coding_interview_book.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static String twoSum(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(target-arr[i])){
                return i+","+map.get(target-arr[i]);
            }
            else{
                map.put(arr[i],i);
            }

        }
        return "no pair found";
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target));
    }
}
