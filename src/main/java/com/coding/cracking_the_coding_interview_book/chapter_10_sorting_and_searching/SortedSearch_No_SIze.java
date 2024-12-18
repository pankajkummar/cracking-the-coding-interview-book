package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

public class SortedSearch_No_SIze {
    static class Listy{
        private int[] array;
        public Listy(int[] arr){
            this.array = arr;
        }
        public int getElementAt(int index){
            if(index<0 || index>=array.length){
                return -1;
            }
            return array[index];
        }
    }
    public static int serach(Listy listy, int target){
        int low=0;
        int high=1;
        while(listy.getElementAt(high)!=-1 && listy.getElementAt(high)<target){
            low=high;
            high=high*2;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            int value = listy.getElementAt(mid);
            if(value==target){
                return mid;
            }
            else if (value == -1 || value > target){
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Listy listy = new Listy(arr);
        System.out.println(serach(listy,5));
    }
}
