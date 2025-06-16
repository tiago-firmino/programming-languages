
# LPro L1++ Interpreter - Project Phase 1

## Description

A Java interpreter for the L1++ language developed for the Programming Languages course.

## Usage

### Hands-on Mode

```bash
./x++.sh
```

- Write the L1++ expressions after the # prompt

- End programs with ;;

- Exit interpreter with Ctrl+C

### Execute tests from file

Choose a file to run from the *tests* directory. Results are shown after each test ran.

- Files to run:
  - tests.md
  - testsL1.md
  - testsL1++.md

```bash
./x++.sh <filename>
```

Example tests should be ran in Hands-on mode by copying them to the terminal after ./x++.sh execution.

## Limitations

- It is a requirement of the interpreter for functions to declare at least one parameter:

```rust
// Not supported (syntax error):
let getTestVal = fn => { 3 }; getTestVal();;

// Workaround - use dummy parameter:
let getTestVal = fn dummy => { 3 }; getTestVal(nil);;  // Returns 3
```

- Only functionalities required from the statement were implemented. This means:

  - No implementations of comments.

  - No implementations of string values.

  - *Other undocumented edge cases may exist.*
