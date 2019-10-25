package com.muhammedokumus;


import static java.lang.Math.abs;

public class GaussianEliminationStrategy implements SolvingStrategy {


    @Override
    public float[] solveLinearEquation(float[][] equationMatrix) {
        Matrix m = new Matrix(equationMatrix);
        return gaussianElimination(m);
    }


    private float[] gaussianElimination(Matrix augmentedMatrix) {
        float[][] m = augmentedMatrix.getM();
        int n = m.length; //Number of rows

        System.out.println("Gauss Elimination Input Matrix: ");
        augmentedMatrix.displayAugmented();

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
        // Solve equation Ax=b for an upper triangular matrix A
        float[] solutions = new float[m.length];
        for (int i = n - 1; i >= 0; i--) {
            solutions[i] = m[i][n]/m[i][i];
            for (int k = i - 1; k >= 0; k--) {
                m[k][n] -= m[k][i] * solutions[i];
            }
        }
        //Print results
        System.out.println("Solution: ");
        for(int i=0; i <m.length; i++)
            System.out.println("x" + i + ": " + solutions[i]);

        return solutions;
    }
}
