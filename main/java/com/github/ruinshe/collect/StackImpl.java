package com.github.ruinshe.collect;

/**
 * A simple implementation of {@link Stack}.
 */
public class StackImpl<T> implements Stack<T> {

  private static final int INIT_SIZE = 10;

  private Object[] elements;
  private int size;

  public StackImpl() {
    elements = new Object[INIT_SIZE];
    size = 0;
  }

  @Override
  public boolean push(T element) {
    if (!adjustSize(size + 1)) {
      return false;
    }
    elements[size++] = element;
    return true;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      return null;
    } else {
      return (T) elements[size - 1];
    }
  }

  @Override
  public T poll() {
    if (isEmpty()) {
      return null;
    } else {
      T element = (T) elements[--size];
      adjustSize(size);
      return element;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private boolean adjustSize(int newSize) {
    if (newSize > elements.length) {
      Object[] newElements = new Object[elements.length << 1];
      System.arraycopy(elements, 0, newElements, 0, elements.length);
      elements = newElements;
    } else if (elements.length > INIT_SIZE && newSize < elements.length / 3) {
      Object[] newElements = new Object[Math.max(INIT_SIZE, elements.length >> 1)];
      System.arraycopy(elements, 0, newElements, 0, size);
      elements = newElements;
    }
    return true;
  }
}
