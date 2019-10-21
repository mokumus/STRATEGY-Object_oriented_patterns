package com.muhammedokumus;

import java.util.Arrays;
import java.util.StringJoiner;

class Matrix {

    private float[][] m;

    Matrix(float[][] m) {
        this.m = m;
        display();
    }

    float[][] getM() {
        return m;
    }

    void display() {
        for (float[] floats : m) {
            for (int j = 0; j < m[0].length; j++) {
                if (j == 0)
                    System.out.print(floats[j]);
                else if (j - 1 == m[0].length - 2)
                    System.out.print(String.format(" | %3s", floats[j]));
                else
                    System.out.print(String.format(",%10s", floats[j]));
            }
        }
    }
}
