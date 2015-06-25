#include "gtest/gtest.h"
#include "main/cpp/collection/stack/stack.h"
#include <iostream>
#include <string>
#include <stdexcept>


TEST(StackTest, TEST) {
  stack<int> test_stack;

  EXPECT_EQ(test_stack.isEmpty(), true);

  int exc_count = 0;

  std::string s = std::string("stack empty");
  try {
    test_stack.peek();
  } catch (std::runtime_error e) {
    EXPECT_EQ(std::string(e.what()), s);
    ++exc_count;
  }

  try {
    test_stack.poll();
  } catch (std::runtime_error e) {
    EXPECT_EQ(std::string(e.what()), s);
    ++exc_count;
  }

  EXPECT_EQ(exc_count, 2);

  EXPECT_EQ(test_stack.size(), 0);
  test_stack.push(3);
  test_stack.push(4);
  test_stack.push(5);
  EXPECT_EQ(test_stack.isEmpty(), false);
  EXPECT_EQ(test_stack.size(), 3);

  EXPECT_EQ(test_stack.peek(), 5);
  EXPECT_EQ(test_stack.poll(), 5);
  EXPECT_EQ(test_stack.size(), 2);
  EXPECT_EQ(test_stack.poll(), 4);
  EXPECT_EQ(test_stack.poll(), 3);

  for(int i = 0; i < 15; i++) {
    test_stack.push(i);
  }

  EXPECT_EQ(test_stack.size(), 15);
}


