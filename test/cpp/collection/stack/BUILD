cc_library(
  name = "stack_test_source",
  srcs = ["stack_test.cpp"],
  hdrs = ["//main/cpp/collection/stack:stack"],
  deps = ["@gtest//:main"],
)

cc_test(
    name = "stack_test",
    deps = [":stack_test_source"],
)
