package fworks.algorithms.problems.josephus;

/**
 * Josephus Problem.<br/>
 * Based on: In the Josephus problem from antiquity, N people are in dire straits and agree to the
 * following strategy to reduce the population. They arrange themselves in a circle (at positions
 * numbered from 0 to N–1) and proceed around the circle, eliminating every Mth person until only
 * one person is left. Legend has it that Josephus figured out where to sit to avoid being
 * eliminated. Write a Queue client Josephus that takes M and N from the command line and prints out
 * the order in which people are eliminated (and thus would show Josephus where to sit in the
 * circle).
 * <br/>
 * % java Josephus 2 7<br/>
 * 1 3 5 0 4 2 6
 * 
 * @author flaviolcastro
 *
 */
public interface JosephusProblemService {

  /**
   * Solve Josephus Problem.
   * @param m eliminator position
   * @param n number of persons
   * @return last position
   */
  int solve(Integer m, Integer n);
}
