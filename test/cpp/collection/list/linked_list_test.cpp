#include "gtest/gtest.h"
#include "main/cpp/collection/list/linked_list.h"

#include <iostream>
using namespace algorithms;

TEST(LINKED_LIST, TEST) {

  linked_list<int> test_list;
  EXPECT_EQ(test_list.size(), 0);

  test_list.push_back(3);
  EXPECT_EQ(test_list.size(), 1);
  EXPECT_EQ(test_list.front(), 3);
  EXPECT_EQ(test_list.back(), 3);

  test_list.push_back(4);
  EXPECT_EQ(test_list.size(), 2);
  EXPECT_EQ(test_list.front(), 3);
  EXPECT_EQ(test_list.back(), 4);

  test_list.push_front(2);
  EXPECT_EQ(test_list.size(), 3);
  EXPECT_EQ(test_list.front(), 2);
  EXPECT_EQ(test_list.back(), 4);

  test_list.remove_front();
  test_list.remove_back();
  EXPECT_EQ(test_list.front(), 3);
  EXPECT_EQ(test_list.back(), 3);
  test_list.remove_front();
  EXPECT_EQ(test_list.size(), 0);
  test_list.push_back(3);
  test_list.remove_back();
  EXPECT_EQ(test_list.size(), 0);
}
