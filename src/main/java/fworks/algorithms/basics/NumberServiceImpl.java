package fworks.algorithms.basics;

import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.bag.BagLinkedListImpl;
import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueLinkedListImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Number service class.<br/>
 * Implements few number related operations.
 * 
 * @author flaviolcastro
 *
 */
@Service
@Log4j2
public class NumberServiceImpl implements NumberService {

  @Override
  public long getAbs(long number) {
    return (number < 0 ? -number : number);
  }

  @Override
  public double getAbs(double number) {
    return (number < 0.0 ? -number : number);
  }

  @Override
  public boolean isPrime(long number) {
    // number has to be bigger than 1
    if (number < 2) {
      log.debug("Prime number need to be bigger than 1. Number was: {}", number);
      return false;
    }
    // try to see if number is prime
    // loop from 2 till the
    for (int i = 2; i <= number / i; i++) {
      log.debug("i:{} - number:{}", i, number);
      // number can't be divisible by another number
      long rest = number % i;
      if (rest == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public Bag<Integer> findAllPrimes(long number) {
    Bag<Integer> bag = new BagLinkedListImpl<>();
    for (int i = 2; i < number; i++) {
      if (isPrime(i)) {
        bag.add(i);
      }
    }
    return bag;
  }

  @Override
  public long countAllPrimes(long number) {
    long count = 0;
    for (int i = 2; i < number; i++) {
      if (isPrime(i)) {
        count++;
      }
    }
    return count;
  }

  @Override
  public Queue<Long> factor(long number) {
    long calc = number;
    Queue<Long> bag = new QueueLinkedListImpl<>();
    for (long i = 2; i <= calc; i++) {
      while (calc % i == 0) {
        long factor = calc / i;
        bag.enqueue(i);
        calc = factor;
      }
    }
    return bag;
  }

  @Override
  public double perfectSquareRoot(long number) {
    if (number <= 0) {
      // there is no square root for negative number or zero
      return Double.NaN;
    }

    if (number == 1) {
      // for 1 it is 1
      return number;
    }

    // calculate factors
    Queue<Long> queue = factor(number);
    log.info("Factor: {}", queue);

    if (queue.size() % 2 != 0) {
      // if not an even number - it will not be perfect
      log.info("Not a perfect square: {} - Factor: {}", number, queue);
      return Double.NaN;
    }

    // go through the factors and calculate the value
    double value = 0;
    Long old = null;
    while (!queue.isEmpty()) {
      Long dequeue = queue.dequeue();
      if (!dequeue.equals(old)) {
        if (old != null) {
          // not a perfect square
          log.info("Not a perfect square: {}", number);
          return Double.NaN;
        }
        // keep the old value to match up
        old = dequeue;
      } else {
        // calculate
        if (value == 0) {
          value = 1;
        }
        value *= dequeue;
        // clean the old value
        old = null;
      }
    }
    log.info("Perfect square: {}", value);
    return value;
  }

  @Override
  public double squareRootNewtons(double number) {
    if (number < 0.0) {
      // there is no square root for negative number or zero
      return Double.NaN;
    }
    // crazy error constant :)
    double err = 1e-15;

    double value = number;
    //
    while (Math.abs(value - (number / value)) > (err * value)) {
      value = ((number / value) + value) / 2.0;
    }
    // return the calculated value
    return value;
  }

  @Override
  public double getRightTrianguleHypotenuse(double sideA, double sideB) {
    double sideA2 = sideA * sideA;
    double sideB2 = sideB * sideB;
    log.info("Calculating hypotenuse from {} by {} -> sqrt({}+{})", sideA, sideB, sideA2, sideB2);
    return squareRootNewtons(sideA2 + sideB2);
  }

  @Override
  public double getRightTrianguleArea(double sideA, double sideB) {
    double area = sideA * sideB / 2;
    log.info("Calculating area from {} by {} -> {}", sideA, sideB, area);
    return area;
  }

  @Override
  public double getRightTriangulePerimeter(double sideA, double sideB) {
    double hypotenuse = getRightTrianguleHypotenuse(sideA, sideB);
    double perimeter = sideA + sideB + hypotenuse;
    log.info("Calculating perimeter from {} by {} by {} -> {})", sideA, sideB, hypotenuse,
        perimeter);
    return perimeter;
  }

}
