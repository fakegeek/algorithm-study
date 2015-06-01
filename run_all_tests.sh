#! /usr/bin/env bash
#
# Runs all tests.
#

BAZEL="build-tools/bazel/output/bazel"
${BAZEL} fetch //main/... //test/... || exit $?
${BAZEL} test //main/... //test/... || exit $?
