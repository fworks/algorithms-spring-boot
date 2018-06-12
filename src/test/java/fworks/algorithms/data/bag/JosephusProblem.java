package fworks.algorithms.data.bag;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import org.junit.Test;

public class JosephusProblem {

  @Test
  public void test() {
    this.josephus(2, 7);
  }

  private void josephus(Integer m, Integer n) {

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
      System.out.println(removed);
    }
  }
}
