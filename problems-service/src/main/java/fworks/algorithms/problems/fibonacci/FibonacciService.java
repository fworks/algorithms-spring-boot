package fworks.algorithms.problems.fibonacci;

/**
 * Fibonacci Service.<br/>
 * <br/>
 * In mathematics, the Fibonacci numbers are the numbers in the following integer sequence, called
 * the Fibonacci sequence, and characterized by the fact that every number after the first two is
 * the sum of the two preceding ones: <br/>
 * <br/>
 * 0,1,1,2,3,5,8,13,21,34,55,89,144,...<br/>
 * <br/>
 * The sequence Fn of Fibonacci numbers is defined by the recurrence relation:<br/>
 * <br/>
 * F{n}=F{n-1}+F{n-2} with seed F{0}=0, F{1}=1.
 * 
 * @author flaviolcastro
 *
 */
public interface FibonacciService {

  /**
   * Calculate the fibonacci function value.
   * 
   * @param number function number
   * @return value returned
   */
  default long fibonacci(int number) {
    if (number == 0 || number == 1) {
      return number;
    }
    return fibonacci(number - 1) + fibonacci(number - 2);
  }

  /**
   * Calculate fibonacci sequence over a number of iterations.
   * 
   * @param numberOfIterations iterations
   * @return queue with the values
   */
  long[] calculateFibonacciSequence(int numberOfIterations);
}
