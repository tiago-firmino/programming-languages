#!/usr/bin/env bash
set -euo pipefail
echo ">>> cleaning up"
rm -f run/*.class
rm -f src/Parser/*.java

echo ">>> compiling ParserL1"
cd src/Parser
javacc ParserL1.jj
cd ../..
javac -d run -cp src $(find src -name "*.java")

echo ">>> running L1int"
java -cp run L1int