#! /usr/bin/env bash
#
# Runs all tests.
#

BAZEL="build-tools/bazel/output/bazel"
${BAZEL} fetch //java/... || return $?
