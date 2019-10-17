package com.muhammedokumus;

import java.util.ArrayList;

public class GaussianEliminationStrategy implements SolvingStrategy {


    @Override
    public double solveLinearEquation(ArrayList<ArrayList<Integer>> equationMatrix) {
        Matrix m = new Matrix(equationMatrix);
        System.out.println("Gaussian way!\n" + m);
        return 0;
    }
}
