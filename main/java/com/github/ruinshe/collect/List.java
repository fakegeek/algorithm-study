package com.github.ruinshe.collect;

import com.github.ruinshe.collect.common.HasSize;

/**
 * An ADT of list.
 */
public interface List<T> extends HasSize {

  /**
   * Adds an {@code element} at the end of the list.
   *
   * @param element the element to be added.
   * @return appends successfully or not.
   */
  boolean append(T element);

  /**
   * Adds an {@code element} at the front of the list.
   *
   * @param element the element to be added.
   * @return pushes successfully or not.
   */
  boolean push(T element);

  /**
   * @return the front element of the list.
   */
  T peekFront();

  /**
   * @return the end element of the list.
   */
  T peekBack();

  /**
   * @return the front element of the list, and remove the element.
   */
  T pollFront();
  
  /**
   * @return the end element of the list, and remove the element.
   */
  T pollBack();
}
