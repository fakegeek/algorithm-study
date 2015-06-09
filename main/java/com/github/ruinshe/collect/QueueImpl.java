package com.github.ruinshe.collect;

/**
 * A simple implementation of {@link Queue}.
 */
public class QueueImpl<T> implements Queue<T> {

  private static final int INIT_SIZE = 16;
  private static final int DEFAULT_MAX_SIZE = 1024;

  private final int maxSize;
  private Object[] elements;
  private int front;
  private int back;

  public QueueImpl() {
    this(DEFAULT_MAX_SIZE);
  }

  public QueueImpl(int maxSize) {
    this.maxSize = maxSize;
    elements = new Object[INIT_SIZE];
    front = 0;
    back = 0;
  }

  @Override
  public boolean push(T element) {
    if (!adjustSize(front, back + 1)) {
      return false;
    }
    elements[back++] = element;
    return true;
  }

  @Override
  public T take() {
    if (isEmpty()) {
      return null;
    } else {
      T element = (T) elements[front++];
      adjustSize(front, back);
      return element;
    }
  }

  @Override
  public int size() {
    return back - front;
  }

  /**
   * Adjusts the size to fit ({@code newFront}, {@code newBack}),
   * and <b>set new {@code front} and {@code back}</b>.
   *
   * @param newFront new front index of the queue
   * @param newBack  new back index of the queue
   * @returnss the memory allocation is successful or not.
   */
  private boolean adjustSize(int newFront, int newBack) {
    int newSize = newBack - newFront;
    if (newSize > maxSize) {
      return false;
    }

    if (elements.length > INIT_SIZE && newSize < elements.length / 3) {
      Object[] newElements = new Object[Math.max(INIT_SIZE, elements.length >> 1)];
      System.arraycopy(elements, newFront, newElements, 0, newSize);
      elements = newElements;
      front = 0;
      back = newSize;
    } else if (newBack > elements.length) {
      // only for push case
      if (elements.length < maxSize || newSize > (elements.length << 1) / 3) {
        Object[] newElements = new Object[Math.min(maxSize, elements.length << 1)];
        System.arraycopy(elements, front, newElements, 0, size());
        elements = newElements;
        front = 0;
        back = newSize - 1;
      } else {
        Object[] newElements = new Object[Math.min(maxSize, elements.length << 1)];
        newSize = 0;
        for (int i = newFront; i < newBack - 1; i++) {
          newElements[newSize++] = elements[i];
        }
        elements = newElements;
        front = 0;
        back = newSize - 1;
      }
    }
    return true;
  }
}
