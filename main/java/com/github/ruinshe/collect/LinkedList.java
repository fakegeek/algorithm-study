package com.github.ruinshe.collect;

/**
 * Linked list implementation for {@link List}.
 */
public class LinkedList<T> implements List<T> {

  /**
   * Internal linked list node implementation.
   */
  private final class ListNode<E> {

    private final E element;
    private ListNode<E> prev;
    private ListNode<E> next;

    ListNode() {
      element = null;
      prev = null;
      next = null;
    }

    ListNode(E element, ListNode<E> prev, ListNode<E> next) {
      this.element = element;
      this.prev = prev;
      this.next = next;
      prev.setNext(this);
      next.setPrev(this);
    }

    public E getElement() {
      return element;
    }

    public ListNode<E> getPrev() {
      return prev;
    }

    public void setPrev(ListNode<E> prev) {
      this.prev = prev;
    }

    public ListNode<E> getNext() {
      return next;
    }

    public void setNext(ListNode<E> next) {
      this.next = next;
    }

    public void revoke() {
      prev.setNext(next);
      next.setPrev(prev);
    }
  }

  private ListNode<T> head;
  private int size;

  public LinkedList() {
    head = new ListNode<>();
    head.setPrev(head);
    head.setNext(head);
    size = 0;
  }

  @Override
  public boolean append(T element) {
    new ListNode<T>(element, head.getPrev(), head);
    size++;
    return true;
  }

  @Override
  public boolean push(T element) {
    new ListNode<T>(element, head, head.getNext());
    size++;
    return true;
  }

  @Override
  public T peekFront() {
    return (head.getNext() == head) ? null : head.getNext().getElement();
  }

  @Override
  public T peekBack() {
    return (head.getPrev() == head) ? null : head.getPrev().getElement();
  }

  @Override
  public T pollFront() {
    if (isEmpty()) {
      return null;
    } else {
      T element = peekFront();
      head.getNext().revoke();
      size--;
      return element;
    }
  }
  
  @Override
  public T pollBack() {
    if (isEmpty()) {
      return null;
    } else {
      T element = peekBack();
      head.getPrev().revoke();
      size--;
      return element;
    }
  }

  @Override
  public int size() {
    return size;
  }
}
