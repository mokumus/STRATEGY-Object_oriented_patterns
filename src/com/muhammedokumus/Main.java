package com.muhammedokumus;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Solver mySolver = new Solver();

	    mySolver.setSolvingStrategy(new GaussianEliminationStrategy());
        float[][] eqs = {
                { 0, 1,  1, 4},
                { 2, 4, -2, 2},
                { 0, 3, 15, 36}};


	    mySolver.solveSystem(eqs);



    }
}
