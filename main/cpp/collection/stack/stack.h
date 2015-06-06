#ifndef COLLECTION_STACK_H
#define COLLECTION_STACK_H

namespace algorithms {
  template <typename T>
  class stack {
  private:
    unsigned init_size;
    T *storage;
    unsigned current_size;
    unsigned size_limit;
    bool increaseSize();

  public:
    stack();
    bool push(T _el);
    T peek();
    T poll();
    unsigned size();
    bool isEmpty();
  };
};

#endif
