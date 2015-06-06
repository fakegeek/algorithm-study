#include "gtest/gtest.h"
#include "main/cpp/collection/stack/stack.h"

using namespace algorithms;

TEST(StackTest, TEST) {


  stack<int> test_stack;

  EXPECT_EQ(test_stack.isEmpty(), true);
  EXPECT_EQ(test_stack.size(), 0);
  test_stack.push(3);
  test_stack.push(4);
  test_stack.push(5);
  EXPECT_EQ(test_stack.isEmpty(), false);
  EXPECT_EQ(test_stack.size(), 3);

  EXPECT_EQ(test_stack.peek(), 5);
  EXPECT_EQ(test_stack.poll(), 5);
  EXPECT_EQ(test_stack.size(), 2);
  EXPECT_EQ(test_stack.poll(), 5);
  EXPECT_EQ(test_stack.poll(), 5);


  for(int i = 0; i < 15; i++) {
    test_stack.push(i);
  }

  EXPECT_EQ(test_stack.size(), 15);

}
