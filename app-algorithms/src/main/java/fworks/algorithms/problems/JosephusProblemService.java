package fworks.algorithms.problems;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
@Service
@Log4j2
public class JosephusProblemService {

  /**
   * Solve Josephus Problem.
   * @param m eliminator position
   * @param n number of persons
   */
  public void solve(Integer m, Integer n) {

    Queue<Integer> queue = new QueueArrayImpl<>();

    // add the n items
    for (int i = 0; i < n; i++) {
      queue.enqueue(i);
    }

    // get with the position m
    while (!queue.isEmpty()) {
      // dequeue
      for (int i = 0; i < m - 1; i++) {
        Integer item = queue.dequeue();
        // add again because it is not at m position
        queue.enqueue(item);
      }
      Integer removed = queue.dequeue();
      log.info(removed);
    }
  }
}
