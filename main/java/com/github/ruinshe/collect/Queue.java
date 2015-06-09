package com.github.ruinshe.collect;

import com.github.ruinshe.collect.common.HasSize;

/**
 * A ADT of <b>FIFO</b> queue data structure.
 */
public interface Queue<T> extends HasSize {

  /**
   * Pushes an {@code element} into the queue.
   *
   * @return pushes successfully or not.
   */
  boolean push(T element);

  /**
   * @return the front element of the queue and remove the element from the queue.
   */
  T take();
}

