package com.muhammedokumus;

/**
 *  Solver strategy class that utilizes Matrix Inversion
 */
public class MatrixInversionStrategy implements SolvingStrategy {

    /**
     * Solves linear equation system using Matrix Inversion method(Wrapper)
     * @param augmentedMatrix an augmented matrix(m x (m+1) sized)
     * @return float[m] of solution in respect to x0,x1,... xn
     */
    public float[] solveLinearEquations(float[][] augmentedMatrix)  {
        System.out.println("Matrix inversion way!");
        System.out.println("Matrix inputted: ");

        Matrix m = new Matrix(augmentedMatrix);
        m.displayAugmented();

        return solve(m);
    }

    /**
     * Solves linear equation system using Matrix Inversion method(Actual method)
     * @param augmentedMatrix an augmented matrix(m x (m+1) sized)
     * @return float[m] of solution in respect to x0,x1,... xn
     */
    private float[] solve(Matrix augmentedMatrix){
        System.out.println("Matrix inversion is not implemented :(");
        return null;
    }

}
