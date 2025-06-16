#!/usr/bin/env bash
set -euo pipefail

echo ">>> cleaning up"
rm -f run/*.class
rm -f src/Parser/*.java

echo ">>> compiling ParserL1"
cd src/Parser
javacc ParserXpp.jj
cd ../..
javac -d run -cp src $(find src -name "*.java")

cd tests

if [[ $# -eq 0 ]]; then
    echo ">>> No test file provided; launching REPL"
    java -cp ../run Xppint
    exit 0
fi

if [[ $# -ne 1 ]]; then
    echo "Usage: $0 [<tests.md> | <tests.xpp>]"
    exit 1
fi

test_file="$1"
echo ">>> running tests from $test_file"

# collect only lines ending in ';;'
mapfile -t tests < <(
  grep -E ';;\s*$' "$test_file" \
    | grep -v '^\s*#' \
    | grep -v '^\s*/\*' \
    | grep -v '\*/'
)

if [[ ${#tests[@]} -eq 0 ]]; then
  echo "No tests found in $test_file (no lines ending with ';;')."
  exit 1
fi

for expr in "${tests[@]}"; do
  echo
  echo ">>> Test: $expr"
  echo "$expr" \
    | java -cp ../run Xppint \
    | sed -e '/^X++ interpreter PL MEIC/d' \
          -e '/^# $/d' \
          -e 's/^# //'
done
