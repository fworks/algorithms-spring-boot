package fworks.algorithms.std;

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
   * @param array
   * @return
   */
  double max(double[] array);

  /**
   * smallest value.
   * 
   * @param array
   * @return
   */
  double min(double[] array);

  /**
   * average.
   * 
   * @param array
   * @return
   */
  double mean(double[] array);

  /**
   * sample variance.
   * 
   * @param array
   * @return
   */
  double var(double[] array);

  /**
   * sample standard deviation.
   * 
   * @param array
   * @return
   */
  double stddev(double[] array);

  /**
   * median.
   * 
   * @param array
   * @return
   */
  double median(double[] array);
}
