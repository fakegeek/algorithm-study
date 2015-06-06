#include "stack.h"
#include <new>

using namespace algorithms;

template <typename T>

stack<T>::stack() {
  init_size = 10;
  current_size = 0;
  storage = new T[init_size];
  size_limit = init_size;
}

template <typename T>
bool stack<T>::push(T _el) {
  if(current_size == init_size) {
    if(!increaseSize()) return false;
  } else {
    storage[current_size++] = _el;
    return true;
  }
}

template <typename T>
T stack<T>::peek() {
  return current_size == 0 ? NULL : storage[current_size - 1];
}

template <typename T>
T stack<T>::poll() {
  return current_size == 0 ? NULL : storage[--current_size];
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
  for(unsigned i; i < current_size; i++) {
    cp_to[i] = storage[i];
  }
  free(storage);
  storage = cp_to;
  return true;
}
