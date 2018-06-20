package fworks.algorithms.problems.std;

/**
 * Version of the StdRandom from the book.<br/>
 * Described as: apI for our library of static methods for data analysis.
 * 
 * @author flaviolcastro
 *
 */
public interface StdStats {

  /**
   * largest value.
   * 
   * @param array to verify
   * @return
   */
  double max(double[] array);

  /**
   * smallest value.
   * 
   * @param array to verify
   * @return
   */
  double min(double[] array);

  /**
   * average.
   * 
   * @param array to verify
   * @return
   */
  double mean(double[] array);

  /**
   * sample variance.
   * 
   * @param array to verify
   * @return
   */
  double var(double[] array);

  /**
   * sample standard deviation.
   * 
   * @param array to verify
   * @return
   */
  double stddev(double[] array);

  /**
   * median.
   * 
   * @param array to verify
   * @return
   */
  double median(double[] array);
}
