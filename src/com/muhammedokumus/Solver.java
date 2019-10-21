package com.muhammedokumus;


class Solver {
    private SolvingStrategy strategy;

    void setSolvingStrategy(SolvingStrategy strategy) {
        this.strategy = strategy;
    }

    void solveSystem(float[][] equations) {
        strategy.solveLinearEquation(equations);
    }
}
