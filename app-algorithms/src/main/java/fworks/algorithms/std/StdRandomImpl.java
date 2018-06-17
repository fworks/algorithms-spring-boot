package fworks.algorithms.std;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class StdRandomImpl implements StdRandom {
  
  /**
   * Random object.
   */
  private Random random = new Random(System.currentTimeMillis());
  
  @Override
  public void setSeed(long seed) {
    random = new Random(seed);
  }

  @Override
  public double random() {
    return random.nextDouble();
  }

  @Override
  public int uniform(int n) {
    return random.nextInt(n);
  }

  @Override
  public int uniform(int lo, int hi) {
    return random.ints(lo, hi).findAny().getAsInt();
  }

  @Override
  public double uniform(double lo, double hi) {
    return random.doubles(lo, hi).findAny().getAsDouble();
  }

  @Override
  public boolean bernoulli(double p) {
    return random.nextDouble() < p;
  }

  @Override
  public double gaussian() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double gaussian(double m, double s) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int discrete(double[] a) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void shuffle(double[] a) {
    // TODO Auto-generated method stub

  }

}
