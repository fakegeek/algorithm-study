#include "gtest/gtest.h"
#include "main/cpp/collection/queue/queue.h"

#include <iostream>

using namespace algorithms;

TEST(QUEUE, TEST) {
  queue<int> test_queue;
  EXPECT_EQ(test_queue.size(), 0);
  test_queue.enqueue(1);
  EXPECT_EQ(test_queue.dequeue(), 1);
}
