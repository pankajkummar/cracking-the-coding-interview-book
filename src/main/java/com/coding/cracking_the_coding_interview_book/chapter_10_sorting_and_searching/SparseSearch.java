package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

public class SparseSearch {
    public static int sparseSearch(String[] arr, String target){
        if(arr==null || target== null || target.isEmpty()){
            return -1;
        }
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(arr[mid].isEmpty()){
                int left = mid-1;
                int right = mid+1;
                while(true){
                    if(left<low && right>high){
                        return -1;
                    } else if(right <= high && !arr[right].isEmpty()){
                        mid = right;
                        break;
                    } else if(left>=low && !arr[left].isEmpty()){
                        mid = left;
                        break;
                    }
                    right++;
                    left--;
                }
            }
            if (arr[mid].equals(target)) {
                return mid;
            } else if(arr[mid].compareTo(target)<0){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ball";
        System.out.println("Index of '" + target + "': " + sparseSearch(arr, target)); // Output: 4

        target = "at";
        System.out.println("Index of '" + target + "': " + sparseSearch(arr, target)); // Output: 0

        target = "dad";
        System.out.println("Index of '" + target + "': " + sparseSearch(arr, target)); // Output: 10

        target = "cat";
        System.out.println("Index of '" + target + "': " + sparseSearch(arr, target)); // Output: -1
    }
}
