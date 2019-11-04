package com.muhammedokumus;


/**
 * Abstract strategy class for linear equation solvers
 */
class Solver {
    private SolvingStrategy strategy;


    /**
     * Sets the solving method
     * @param strategy a solution strategy class
     */
    void setSolvingStrategy(SolvingStrategy strategy) {
        this.strategy = strategy;
    }


    /**
     * Prints the solution of the given system equation
     * @param equations augmented matrix of linear equation as 2D array of floats
     */
    void solveSystem(float[][] equations) {
        strategy.solveLinearEquations(equations);
    }
}
