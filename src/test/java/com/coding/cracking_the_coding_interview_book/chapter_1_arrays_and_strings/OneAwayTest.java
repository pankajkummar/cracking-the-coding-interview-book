package com.coding.cracking_the_coding_interview_book.chapter_1_arrays_and_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {
    private OneAway oneAway;

    @BeforeEach
    void setUp() {
        oneAway = new OneAway();
    }

    @Test
    void isOneAwayTest1() {
        String s1="pale";
        String s2="ple";
        Boolean result = oneAway.isOneAway(s1,s2);
        assertEquals(true,result);

    }
    @Test
    void isOneAwayTest2() {
        String s1="pales";
        String s2="pale";
        Boolean result = oneAway.isOneAway(s1,s2);
        assertEquals(true,result);

    }
    @Test
    void isOneAwayTest3() {
        String s1="pale";
        String s2="bale";
        Boolean result = oneAway.isOneAway(s1,s2);
        assertEquals(true,result);

    }
    @Test
    void isOneAwayTest4() {
        String s1="pale";
        String s2="bake";
        Boolean result = oneAway.isOneAway(s1,s2);
        assertEquals(false,result);

    }
    @Test
    void isOneAwayTest5() {
        String s1="pale";
        String s2="pales";
        Boolean result = oneAway.isOneAway(s1,s2);
        assertEquals(true,result);

    }

}