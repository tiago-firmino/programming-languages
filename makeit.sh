#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

find . -name '*.class' -type f -delete

javacc ParserL1.jj

javac -d . ASTNodes/*.java *.java

echo ">>> running L1int"
java -cp . L1int
