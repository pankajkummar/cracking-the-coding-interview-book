package com.coding.cracking_the_coding_interview_book.chapter_1_arrays_and_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {
    private RotateMatrix rotateMatrix;
    int[][] matrix;
    @BeforeEach
    void setUp() {
        rotateMatrix = new RotateMatrix();
        matrix= new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix.printMatrix(matrix);
    }

    @Test
    void rotate90() {

        rotateMatrix.rotate90(matrix);
        rotateMatrix.printMatrix(matrix);
    }

    @Test
    void rotate180() {
        rotateMatrix.rotate180(matrix);
        rotateMatrix.printMatrix(matrix);
    }

    @Test
    void rotate270() {
        rotateMatrix.rotate270(matrix);
        rotateMatrix.printMatrix(matrix);
    }
}