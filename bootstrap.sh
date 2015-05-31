set -eux

cd build-tools/bazel/
sudo apt-get update -qq
sudo apt-get install -y protobuf-compiler libarchive-dev netcat-traditional
sudo update-alternatives --set nc /bin/nc.traditional
export JAVA_HOME=/usr/lib/jvm/java-8-oracle
export JAVA_OPTS="-Xmx3000m"
./compile.sh || return $?

BAZEL=build-tools/bazel/output/bazel
cd ../..
ln -s build-tools/bazel/tools .
ln -s build-tools/bazel/third_party .
$BAZEL fetch //java/... || return $?
