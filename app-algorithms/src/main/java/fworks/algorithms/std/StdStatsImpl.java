package fworks.algorithms.std;

import fworks.algorithms.basics.ArrayService;
import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.bag.BagLinkedListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StdStatsImpl implements StdStats {

  private ArrayService arrayService;

  @Autowired
  public StdStatsImpl(ArrayService arrayService) {
    this.arrayService = arrayService;
  }

  @Override
  public double max(double[] a) {
    return arrayService.getMax(a);
  }

  @Override
  public double min(double[] a) {
    return arrayService.getMin(a);
  }

  @Override
  public double mean(double[] a) {
    return arrayService.getAvg(a);
  }

  @Override
  public double var(double[] a) {
    double avg = arrayService.getAvg(a);
    double[] bag = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      double x = a[i] - avg;
      bag[i] = x * x;
    }
    return arrayService.getAvg(bag);
  }

  @Override
  public double stddev(double[] a) {
    return 0;
  }

  @Override
  public double median(double[] a) {
    return 0;
  }

}
