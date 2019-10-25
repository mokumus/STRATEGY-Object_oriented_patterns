package com.muhammedokumus;


import static java.lang.Math.abs;

public class GaussianEliminationStrategy implements SolvingStrategy {


    @Override
    public float[] solveLinearEquation(float[][] equationMatrix) {
        Matrix m = new Matrix(equationMatrix);
        return gaussianElimination(m);
    }


    private float[] gaussianElimination(Matrix m) {
        float[][] matrixEquations = m.getM();
        int n = matrixEquations.length; //Number of rows
        System.out.println("Gauss Elimination Input Matrix: ");
        m.display();
        for (int i = 0; i < n; i++) {
            // Search for maximum in this column
            float maxEl = abs(matrixEquations[i][i]);
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (abs(matrixEquations[k][i]) > maxEl) {
                    maxEl = abs(matrixEquations[k][i]);
                    maxRow = k;
                }
            }
            // Swap maximum row with current row (column by column)
            for (int k = i; k < n + 1; k++) {
                float tmp = matrixEquations[maxRow][k];
                matrixEquations[maxRow][k] = matrixEquations[i][k];
                matrixEquations[i][k] = tmp;
            }
            // Make all rows below this one 0 in current column
            for (int k = i + 1; k < n; k++) {
                float c = -matrixEquations[k][i]/matrixEquations[i][i];
                for (int j = i; j < n + 1; j++) {
                    if (i==j) {
                        matrixEquations[k][j] = 0;
                    } else {
                        matrixEquations[k][j] += c * matrixEquations[i][j];
                    }
                }
            }
        }
        System.out.println("Reduced Matrix: ");
        m.display();
        // Solve equation Ax=b for an upper triangular matrix A
        float[] solutions = new float[matrixEquations.length];
        for (int i = n - 1; i >= 0; i--) {
            solutions[i] = matrixEquations[i][n]/matrixEquations[i][i];
            for (int k = i - 1; k >= 0; k--) {
                matrixEquations[k][n] -= matrixEquations[k][i] * solutions[i];
            }
        }
        //Print results
        System.out.println("Solution: ");
        for(int i=0; i <matrixEquations.length; i++)
            System.out.println("x" + i + ": " + solutions[i]);

        return solutions;
    }
}
