package com.muhammedokumus;

class Main {

    public static void main(String[] args) {
	    Solver mySolver = new Solver();

	    mySolver.setSolvingStrategy(new GaussianEliminationStrategy());
        float[][] eqs = {
                { 0, 1,  1, 4},
                { 2, 4, -2, 2},
                { 0, 3, 15, 36}};


	    mySolver.solveSystem(eqs);

        Matrix m = new Matrix(5);
        m.display();
        System.out.println("m= " + m.getM());



    }
}
