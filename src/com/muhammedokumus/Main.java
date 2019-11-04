package com.muhammedokumus;

import java.util.Scanner;

/**
 * Main class for displaying and testing solver methods
 */
class Main {

    public static void main(String[] args) {
        System.out.println("Create a solver.");
	    Solver mySolver = new Solver();

	    System.out.print("Enter 1: Automated Demo\nEnter 2: Input your own matrix\n>");

        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();

        if(mode == 2){
            int m, n, i, j;
            try (Scanner in = new Scanner(System.in)) {
                System.out.print("Enter row size> ");
                m = in.nextInt();
                System.out.print("Enter column size> ");
                n = in.nextInt();

                float[][] eqf = new float[m][n];

                System.out.println("Enter the elements of the matrix");
                for (i = 0; i < m; i++)
                    for (j = 0; j < n; j++)
                        eqf[i][j] = in.nextFloat();

                //in.nextLine();
                System.out.print("Choose method:\n1 : Gaussian Elimination\n2 : Matrix Inversion\n>");
                int solverType = in.nextInt();

                if(solverType == 1){
                    System.out.println("Set solving method to 'Gaussian Elimination'.");
                    mySolver.setSolvingStrategy(new GaussianEliminationStrategy());
                    mySolver.solveSystem(eqf);
                }
                else{
                    System.out.println("Set solving method to 'Gaussian Elimination'.");
                    mySolver.setSolvingStrategy(new MatrixInversionStrategy());
                    mySolver.solveSystem(eqf);
                }
            } catch (Exception e) {
            }
        }

        else{
            float[][] eq1 = {
                    { 0, 1,  1, 4},
                    { 2, 4, -2, 2},
                    { 0, 3, 15, 36}};
            System.out.println("***********************");
            System.out.println("Set solving method to 'Gaussian Elimination'.");
            mySolver.setSolvingStrategy(new GaussianEliminationStrategy());
            mySolver.solveSystem(eq1);
            System.out.println("***********************");
            float[][] eq2 = {
                    { 0, 1,  1, 4},
                    { 2, 4, -2, 2},
                    { 0, 3, 15, 36}};
            System.out.println("Set solving method to 'Matrix Inversion'.");
            mySolver.setSolvingStrategy(new MatrixInversionStrategy());
            mySolver.solveSystem(eq2);
            System.out.println("***********************");
        }

        sc.close();

    }
}
