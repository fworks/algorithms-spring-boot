package fworks.algorithms.problems.std;

/**
 * Version of the StdRandom from the book.<br/>
 * Described as: apI for our library of static methods for random numbers.
 * 
 * @author flaviolcastro
 *
 */
public interface StdRandom {

  /**
   * initialize.
   * 
   * @param seed for the random
   */
  void setSeed(long seed);

  /**
   * real between 0 and 1.
   * 
   * @return
   */
  double random();

  /**
   * // integer between 0 and N-1.
   * 
   * @param n number
   * @return
   */
  int uniform(int n);

  /**
   * // integer between lo and hi-1.
   * 
   * @param lo lower number
   * @param hi higher number
   * @return
   */
  int uniform(int lo, int hi);

  /**
   * // real between lo and hi.
   * 
   * @param lo min
   * @param hi max
   * @return
   */
  double uniform(double lo, double hi);

  /**
   * // true with probability p.
   * 
   * @param p probability
   * @return
   */
  boolean bernoulli(double p);

  /**
   * // normal, mean 0, std dev 1.
   * 
   * @return
   */
  double gaussian();

  /**
   * // normal, mean m, std dev s.
   * 
   * @param m mean
   * @param s dev
   * @return
   */
  double gaussian(double m, double s);

  /**
   * // i with probability a[i].
   * 
   * @param a array
   * @return
   */
  int discrete(double[] a);

  /**
   * // randomly shuffle the array a[].
   * 
   * @param a array
   */
  void shuffle(double[] a);
}
