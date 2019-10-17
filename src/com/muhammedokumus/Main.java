package com.muhammedokumus;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Solver mySolver = new Solver();

	    mySolver.setSolvingStrategy(new GaussianEliminationStrategy());

        ArrayList<String> eqs = new ArrayList<>();
        eqs.add("a");
        eqs.add("b");
        eqs.add("c");

	    mySolver.solveSystem(eqs);


    }
}
