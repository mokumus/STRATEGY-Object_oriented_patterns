package com.muhammedokumus;


import static java.lang.Math.abs;

public class GaussianEliminationStrategy implements SolvingStrategy {


    @Override
    public float solveLinearEquation(float[][] equationMatrix) {
        Matrix m = new Matrix(equationMatrix);
        //System.out.println("Gaussian way!\n" + m);

        gauss(m.getM());
        System.out.println("\n");
        m.display();
        return 0;
    }


    private float[] gauss(float[][] A) {
        int n = A.length;

        for (int i=0; i<n; i++) {
            // Search for maximum in this column
            float maxEl = abs(A[i][i]);
            int maxRow = i;
            for (int k=i+1; k<n; k++) {
                if (abs(A[k][i]) > maxEl) {
                    maxEl = abs(A[k][i]);
                    maxRow = k;
                }
            }

            // Swap maximum row with current row (column by column)
            for (int k=i; k<n+1;k++) {
                float tmp = A[maxRow][k];
                A[maxRow][k] = A[i][k];
                A[i][k] = tmp;
            }

            // Make all rows below this one 0 in current column
            for (int k=i+1; k<n; k++) {
                float c = -A[k][i]/A[i][i];
                for (int j=i; j<n+1; j++) {
                    if (i==j) {
                        A[k][j] = 0;
                    } else {
                        A[k][j] += c * A[i][j];
                    }
                }
            }
        }

        // Solve equation Ax=b for an upper triangular matrix A

        float[] x = new float[A.length];
        for (int i=n-1; i>=0; i--) {
            x[i] = A[i][n]/A[i][i];
            for (int k=i-1;k>=0; k--) {
                A[k][n] -= A[k][i] * x[i];
            }
        }

        System.out.println("x = " + x[1]);
        return A[0];
    }
}
