package com.muhammedokumus;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Solver mySolver = new Solver();

	    mySolver.setSolvingStrategy(new GaussianEliminationStrategy());

        ArrayList<ArrayList<Integer>> eqs = new ArrayList<>();

        ArrayList<Integer> eq1 = new ArrayList<>();
        eq1.add(2);
        eq1.add(-1);
        eq1.add(3);
        eq1.add(5);

        ArrayList<Integer> eq2 = new ArrayList<>();
        eq2.add(2);
        eq2.add(2);
        eq2.add(3);
        eq2.add(7);

        ArrayList<Integer> eq3 = new ArrayList<>();
        eq3.add(-2);
        eq3.add(3);
        eq3.add(0);
        eq3.add(-3);

        eqs.add(eq1);
        eqs.add(eq2);
        eqs.add(eq3);

	    mySolver.solveSystem(eqs);



    }
}
