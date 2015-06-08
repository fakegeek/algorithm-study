package com.github.ruinshe.collect.common;

/**
 * An interface indicting A object has {@code size} attribute.
 */
public interface HasSize {

  /**
   * @return the size of the collection.
   */
  int size();

  /**
   * @return whether the collection is empty or not.
   */
  default boolean isEmpty() {
    return size() == 0;
  }
}

