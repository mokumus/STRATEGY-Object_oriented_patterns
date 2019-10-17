package com.muhammedokumus;

import java.util.ArrayList;

class Solver {
    private SolvingStrategy strategy;

    void setSolvingStrategy(SolvingStrategy strategy) {
        this.strategy = strategy;
    }

    void solveSystem(ArrayList<ArrayList<Integer>> equations) {
        strategy.solveLinearEquation(equations);
    }
}
