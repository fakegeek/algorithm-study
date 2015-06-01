package com.github.ruinshe.collect;

/**
 * A ADT of stack data structure.
 */
public interface Stack<T> {

  /**
   * Pushes an {@code element} into the stack.
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

  /**
   * @return the size of the stack.
   */
  int size();

  /**
   * @return whether the stack is empty or not.
   */
  boolean isEmpty();
}

