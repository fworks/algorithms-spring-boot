package fworks.algorithms.problems.basics;

import java.util.Comparator;
import org.springframework.stereotype.Service;

@Service
public class ArrayServiceImpl implements ArrayService {

  @Override
  public <T> T getMax(T[] array, Comparator<T> comparator) {
    T max = array[0];
    for (int i = 0; i < array.length; i++) {
      if (comparator.compare(array[i], max) > 0) {
        max = array[i];
      }
    }
    return max;
  }

  @Override
  public double getMax(double[] array) {
    double max = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }

  @Override
  public double getMin(double[] array) {
    double min = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }

  @Override
  public double getSum(double[] array) {
    double sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }

  @Override
  public double getAvg(double[] array) {
    return getSum(array) / array.length;
  }

  @Override
  public double[] reverse(double[] array) {
    double[] reversed = new double[array.length];
    for (int i = 0; i < array.length; i++) {
      reversed[i] = array[array.length - 1 - i];
    }
    return reversed;
  }

  @Override
  public double[] copy(double[] array) {
    double[] copied = new double[array.length];
    for (int i = 0; i < array.length; i++) {
      copied[i] = array[i];
    }
    return copied;
  }

  @Override
  public boolean isSorted(double[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        // if before value is bigger than actual value - not sorted
        return false;
      }
    }
    return true;
  }
}
