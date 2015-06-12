#ifndef COLLECTION_QUEUE_H
#define COLLECTION_QUEUE_H

#include <new>
#include "main/cpp/collection/list/linked_list.h"

namespace algorithms {
  template <typename T>
  class queue {
  private:
    linked_list<T> storage;
  public:
    void enqueue(const T &_v);
    T dequeue();
    unsigned size();
    bool is_empty();
  };

  template <typename T>
  void queue<T>::enqueue(const T &_v) {
    storage.push_back(_v);
  }

  template <typename T>
  T queue<T>::dequeue() {
    if(is_empty()) {
      throw "empty queue";
    } else {
      T val = storage.front();
      storage.remove_front();
      return val;
    }
  }

  template <typename T>
  unsigned queue<T>::size() {
    return storage.size();
  }

  template <typename T>
  bool queue<T>::is_empty() {
    return storage.size() == 0;
  }
}

#endif
