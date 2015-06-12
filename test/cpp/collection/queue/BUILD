cc_library(
  name = "queue_test_source",
  srcs = ["queue_test.cpp"],
  hdrs = ["//main/cpp/collection/queue:queue", "//main/cpp/collection/list:linked_list"],
  deps = ["@gtest//:main"],
)

cc_test(
    name = "queue_test",
    deps = [":queue_test_source"],
)
