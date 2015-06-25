#ifndef COLLECTION_LINKED_LIST_H
#define COLLECTION_LINKED_LIST_H

#include <new>
#include <cstdlib>
#include <stdexcept>

namespace algorithms {
  template <typename T>
  struct node {
    T value;
    node<T> *next;
    node<T> *prev;
  };

  template <typename T>
  class linked_list {
  private:
    node<T> *head_ptr;
    node<T> *tail_ptr;
    unsigned counter;

  public:
    linked_list();
    ~linked_list();
    T &front() const;
    T &back() const;
    unsigned size();
    void remove_front();
    void remove_back();
    bool push_back(const T &_v);
    bool push_front(const T &_v);
  };

  template <typename T>
  linked_list<T>::linked_list() {
    head_ptr = NULL;
    tail_ptr = NULL;
    counter = 0;
  }

  template <typename T>
  linked_list<T>::~linked_list() {
    if(counter == 0) return;
    tail_ptr = NULL;
    node<T> *tmp = head_ptr;
    while(head_ptr->next != NULL) {
      tmp = head_ptr;
      head_ptr = head_ptr->next;
      delete(tmp);
    }
  }

  template <typename T>
  T &linked_list<T>::front() const {
    if(head_ptr == NULL) {
      throw std::runtime_error("empty_list");
    }

    return head_ptr->value;
  }

  template <typename T>
  T &linked_list<T>::back() const {
    if(tail_ptr == NULL) {
      throw std::runtime_error("empty_list");
    }

    return tail_ptr->value;
  }

  template <typename T>
  unsigned linked_list<T>::size() {
    return counter;
  }

  template <typename T>
  void linked_list<T>::remove_front() {
    if(head_ptr == NULL) {
      throw std::runtime_error("empty_list");
    }

    node<T> *tmp = head_ptr->next;

    delete(head_ptr);

    if(counter > 1) {
      tmp->prev = NULL;
    } else {
      tail_ptr = NULL;
    }

    head_ptr = tmp;

    counter --;
  }

  template <typename T>
  void linked_list<T>::remove_back() {
    if(tail_ptr == NULL) {
      throw std::runtime_error("empty_list");
    }

    node<T> *tmp = tail_ptr->prev;

    delete(tail_ptr);
    if(counter > 1) {
      tmp->next = NULL;
    } else {
      head_ptr = NULL;
    }

    tail_ptr = tmp;

    counter --;
  }

  template <typename T>
  bool linked_list<T>::push_back(const T &_v) {
    node<T> *i_node = new (std::nothrow) node<T>;
    if(i_node == NULL) return false;

    i_node->value = _v;
    i_node->next = NULL;
    i_node->prev = tail_ptr;

    if(counter > 0) {
      tail_ptr->next = i_node;
    } else {
      head_ptr = i_node;
    }

    tail_ptr = i_node;
    counter ++;
    return true;
  }

  template <typename T>
  bool linked_list<T>::push_front(const T &_v) {
    node<T> *i_node = new (std::nothrow) node<T>;
    if(i_node == NULL) return false;

    i_node->value = _v;
    i_node->next = head_ptr;
    i_node->prev = NULL;

    if(counter > 0) {
      head_ptr->prev = i_node;
    } else {
      tail_ptr = i_node;
    }

    head_ptr = i_node;
    counter ++;
    return true;
  }
};

#endif
