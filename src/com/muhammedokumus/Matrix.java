package com.muhammedokumus;

import java.util.ArrayList;

class Matrix {

    private ArrayList<ArrayList<Integer>> m;

    Matrix(ArrayList<ArrayList<Integer>> m) {
        //Matrix is complete and square.
        if(isValid(m) & m.size() == m.get(0).size() - 1){
            this.m = m;
        }
        else
            throw new IllegalArgumentException("Matrix doesn't have same amount of columns.");
    }


    /**
     * Checks if the matrix has same number of columns.
     * @return true if matrix is valid, false otherwise
     */
    private boolean isValid(ArrayList<ArrayList<Integer>> m){
        int tempSize = m.get(0).size();

        for(ArrayList<Integer> e : m){
            if(e.size() != tempSize)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrix" + m;
    }
}
