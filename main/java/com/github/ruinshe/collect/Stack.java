package com.github.ruinshe.collect;

import com.github.ruinshe.collect.common.HasSize;

/**
 * An ADT of stack data structure.
 */
public interface Stack<T> extends HasSize {

  /**
   * Pushes an {@code element} into the stack.
   *
   * @param element the element to be pushed.
   * @return pushes successfully or not.
   */
  boolean push(T element);

  /**
   * @return the top element of the stack.
   */
  T peek();

  /**
   * @return the top element of the stack and remove the element from the stack.
   */
  T poll();
}

