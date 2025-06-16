
# LPro L1++ Interpreter - Project Phase 1

## Description

A Java interpreter for the X++ language developed for the Programming Languages course.

## Usage

### Hands-on Mode

```bash
./x++.sh
```

- Write the X++ expressions after the # prompt

- End programs with ;;

- Exit interpreter with Ctrl+C

### Execute tests from file

Choose a file to run from the *tests* directory. Results are shown after each test ran.

- Files to run:
  - tests.md
  - testsL1.md
  - testsL1++.md
  - testetype3+unions.md
  - any readable file that resides in *tests* directory (can be something like test.xpp)

```bash
./x++.sh <filename>
```

Example tests should be ran in Hands-on mode by copying them to the terminal after ./x++.sh execution.

## Limitations

- Explicit typings on parameters and return are needed, all parameters and the return type of a function must be explicitly annotated.

```rust
// Valid example with one parameter and explicit typing:
let k = -1;
let om: (int -> int) -> int = fn f: int -> int => { f(k) };
om(fn x: int => { x * x });;  // Returns: int 1
```

- Not all functionalities required from the statement were implemented. This means:

  - No implementations of subtyping.

  - No implementations of recursive typing and recursive functions.

  - Not working Unions and Structs types.

  - Type definition and unfold logic was tried as well as typechecking of more complex ASTNodes.
