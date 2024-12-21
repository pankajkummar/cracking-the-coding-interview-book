package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.HashMap;

public class LivingPeople {
    public static class person{
        int birth;
        int death;

        public person(int birth, int death) {
            this.birth = birth;
            this.death = death;
        }

    }
    public static int survey(person[] people ){
        int[] alive = new int[101];
        int max = 0;
        int year = 1900;
        int index_birth,index_dead;
        for(person p : people){
             index_birth = p.birth%100;
            if(p.death!=2000) {
                index_dead = p.death % 100;
            }else{
                index_dead = 100;
            }
            for(int i=index_birth; i<=index_dead; i++){
                alive[i]=alive[i]+1;
                if(alive[i]>max){
                    max=alive[i];
                    year=1900+i;
                }
            }
        }
        return year;
    }

    public static void main(String[] args) {
        person p1 = new person(1900,2000);
        person p2 = new person(1902,1999);
        person p3 = new person(1903,1998);
        person[] p = {p1,p2,p3};
        System.out.println(survey(p));
    }
}
