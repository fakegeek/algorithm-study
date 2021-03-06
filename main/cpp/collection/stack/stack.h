#ifndef COLLECTION_STACK_H
#define COLLECTION_STACK_H

#include <new>
#include <cstdlib>
#include <stdexcept>

namespace algorithms {
  template <typename T>
  class stack {
  private:
    unsigned init_size;
    T *storage;
    unsigned current_size;
    unsigned size_limit;
    bool increaseSize();
    void init(unsigned _size);

  public:
    stack();
    ~stack();
    stack(unsigned _init);
    bool push(T _el);
    T peek();
    T poll();
    unsigned size();
    bool isEmpty();
  };
}

using namespace algorithms;

template <typename T>
stack<T>::stack() {
  init(10);
}

template <typename T>
stack<T>::stack(unsigned _init) {
  init(_init);
}

template <typename T>
void stack<T>::init(unsigned _size) {
  init_size = _size;
  current_size = 0;
  storage = new T[init_size];
  size_limit = init_size;
}

template <typename T>
stack<T>::~stack() {
  delete(storage);
}

template <typename T>
bool stack<T>::push(T _el) {
  if(current_size == init_size) {
    if(!increaseSize()) return false;
  }
  storage[current_size++] = _el;
  return true;
}

template <typename T>
T stack<T>::peek() {
  if(current_size == 0) {
    throw std::runtime_error("stack empty");
  } else {
    return storage[current_size - 1];
  }
}

template <typename T>
T stack<T>::poll() {
  if(current_size == 0) {
    throw std::runtime_error("stack empty");
  } else {
    return storage[--current_size];
  }
}

template <typename T>
unsigned stack<T>::size() {
  return current_size;
}

template <typename T>
bool stack<T>::isEmpty() {
  return current_size == 0;
}

template <typename T>
bool stack<T>::increaseSize() {
  T *cp_to = new (std::nothrow) T[size_limit << 1];
  if(cp_to == NULL) return false;
  std::copy(storage, storage + current_size, cp_to);
  delete(storage);
  storage = cp_to;
  return true;
}

#endif
