package com.muhammedokumus;


import static java.lang.Math.abs;

/**
 * Solver strategy class that utilizes Gaussian Elimination
 */
public class GaussianEliminationStrategy implements SolvingStrategy {


    /**
     * Solves linear equation system using Gaussian Elimination method(Wrapper)
     * @param augmentedMatrix an augmented matrix(m x (m+1) sized)
     * @return float[m] of solution in respect to x0,x1,... xn
     */
    public float[] solveLinearEquations(float[][] augmentedMatrix) {
        System.out.println("Gaussian way!");
        Matrix m = new Matrix(augmentedMatrix);
        System.out.println("Matrix inputted: ");

        if(m.isValidInput()){
            m.displayAugmented();
            return solve(m);
        }

        else{
            m.displayAugmented();
            System.out.println("Invalid matrix format, it should be m x (m+1) sized augmented matrix.");
            return null;
        }

    }


    /**
     * Solves linear equation system using Gaussian Elimination method(Actual method)
     * @param augmentedMatrix an augmented matrix(m x (m+1) sized)
     * @return float[m] of solution in respect to x0,x1,... xn
     */
    private float[] solve(Matrix augmentedMatrix) {
        float[][] m = augmentedMatrix.getM();
        int n = m.length; //Number of rows

        for (int i = 0; i < n; i++) {
            // Search for maximum in this column
            float maxEl = abs(m[i][i]);
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (abs(m[k][i]) > maxEl) {
                    maxEl = abs(m[k][i]);
                    maxRow = k;
                }
            }
            // Swap maximum row with current row (column by column)
            for (int k = i; k < n + 1; k++) {
                float tmp = m[maxRow][k];
                m[maxRow][k] = m[i][k];
                m[i][k] = tmp;
            }
            // Make all rows below this one 0 in current column
            for (int k = i + 1; k < n; k++) {
                float c = -m[k][i]/m[i][i];
                for (int j = i; j < n + 1; j++) {
                    if (i==j) {
                        m[k][j] = 0;
                    } else {
                        m[k][j] += c * m[i][j];
                    }
                }
            }
        }
        System.out.println("Reduced Matrix: ");
        augmentedMatrix.displayAugmented();

       if(augmentedMatrix.isUpperTriangle()){
           float[] solutions = new float[m.length];
           for (int i = n - 1; i >= 0; i--) {
               solutions[i] = m[i][n]/m[i][i];
               for (int k = i - 1; k >= 0; k--) {
                   m[k][n] -= m[k][i] * solutions[i];
               }
           }
           //Print results
           System.out.println("Solution: ");
           for(int i=0; i <solutions.length; i++)
               System.out.println("x" + i + ": " + solutions[i]);

           return solutions;
       }
       else{
           System.out.println("Couldn't reduce the matrix to upper triangle form.");
           return null;
       }
    }
}
