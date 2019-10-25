package com.muhammedokumus;

class Matrix {

    private float[][] m;

    Matrix(float[][] m) { this.m = m; }

    /**
     * Creates a identity matrix with given size parameter
     * @param size size of square matrix
     */
    Matrix(int size) { this.m = createIdentityMatrix(size); }

    float[][] getM() {
        return m;
    }

    /**
     * Prints the Matrix in a user friendly way.
     */
    void display() {
        display(this.m);
    }

    /**
     * Prints the given 2d float array in a user friendly way.
     * @param m matrix to be printed
     */
    void display(float[][] m) {
        for (float[] floats : m) {
            for (int j = 0; j < m[0].length; j++) {
                if (j == 0)
                    System.out.print(floats[j]);
                else
                    System.out.print(String.format(",%6s", floats[j]));
            }
            System.out.println();
        }
    }

    /**
     * Prints the Matrix as if it's an augmented matrix.
     */
    void displayAugmented() {
        displayAugmented(this.m);
    }

    /**
     * Prints the given 2d float array as if it's an augmented matrix.
     * @param m matrix to be printed
     */
    void displayAugmented(float[][] m){
        for (float[] floats : m) {
            for (int j = 0; j < m[0].length; j++) {
                if (j == 0)
                    System.out.print(floats[j]);
                else if (j - 1 == m[0].length - 2)
                    System.out.print(String.format(" | %3s", floats[j]));
                else
                    System.out.print(String.format(",%6s", floats[j]));
            }
            System.out.println();
        }
    }

    private float[][] createIdentityMatrix(int size){
        float[][] m = new float[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j)
                    m[i][j] = 1;
                else
                    m[i][j] = 0;
            }
        }
        return m;
    }

    /**
     * @return true if Matrix is a reducible matrix
     */
    boolean isValidInput(){
        for(float[] i : this.m){
            if(i.length != this.m.length && i.length == this.m[0].length + 1) //+1 because rows include the right side of the equation
                return false;
        }
        return true;
    }
    /**
     * Checks whether the Matrix is reduced to solvable form by LinearSolverDeluxe.
     * @return true when matrix is in upper triangular form and has no zero-only rows
     */
    boolean isUpperTriangle(){
        //Check if there is any zero only rows
        for(float[] i : this.m){
            int zeroCounter = 0;
            for(float j : i){
                if(j == 0)
                    zeroCounter++;
            }
            if(zeroCounter == i.length - 1)//All coefficients are zero, unsolvable
                return false;
        }
        //Check if upper-triangular form is satisfied
        for(int i = 1; i < m.length; i++){
            for(int j = 0; j < i; j++){
                if(m[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
}
