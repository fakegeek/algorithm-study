cc_library(
  name = "linked_list_test_source",
  srcs = ["linked_list_test.cpp"],
  hdrs = ["//main/cpp/collection/list:linked_list"],
  deps = ["@gtest//:main"],
)

cc_test(
    name = "linked_list_test",
    deps = [":linked_list_test_source"],
)
