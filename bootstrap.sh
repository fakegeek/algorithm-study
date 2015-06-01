#! /usr/bin/env bash
#
# bootstrap script for Travis CI.

set -eux

cd build-tools/bazel/
if [[ "$(uname -s)" == "Darwin" ]]; then
  brew install protobuf libarchive
else
  sudo apt-get update -qq
  sudo apt-get install -y protobuf-compiler libarchive-dev netcat-traditional
  sudo update-alternatives --set nc /bin/nc.traditional
fi
./compile.sh || return $?
cd ../..
ln -s build-tools/bazel/tools .
ln -s build-tools/bazel/third_party .
