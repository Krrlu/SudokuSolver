# SudokuSolver

This is a simple sudoku solver uses [Z3](https://github.com/Z3Prover/z3) library. It reads input from a file with the name `input.txt` in the same directory as the program, and outputs the result to a file with the name `output.txt` in the same directory as `input.txt`. 

Example:
Suppose `input.txt` contains following 9 lines 
$$3 \ 8  \ 0\ 0\ 0\ 0\ 0\ 0\ 0 $$
$$0\ 0\ 0\ 4\ 0\ 0\ 7\ 8\ 5 $$
$$0\ 0\ 9\ 0\ 2\ 0\ 3\ 0\ 0 $$
$$0\ 6\ 0\ 0\ 9\ 0\ 0\ 0\ 0 $$
$$8\ 0\ 0\ 3\ 0\ 2\ 0\ 0\ 9 $$
$$0\ 0\ 0\ 0\ 4\ 0\ 0\ 7\ 0 $$
$$0\ 0\ 1\ 0\ 7\ 0\ 5\ 0\ 0 $$
$$4\ 9\ 5\ 0\ 0\ 6\ 0\ 0\ 0\ $$
$$0\ 0\ 0\ 0\ 0\ 0\ 0\ 9 \ 2 $$
After program executing,After the program executing, there is a `output.txt` contains the result
$$3\ 8\ 4\  5\ 6\ 7 \ 9\ 2\ 1  $$
$$1\ 2\ 6\  4\ 3\ 9\  7\ 8\ 5  $$
$$7\ 5\ 9\  8\ 2\ 1\  3\ 4\ 6  $$
$$5\ 6\ 3\  7\ 9\ 8\  2\ 1\ 4  $$
$$8\ 4\ 7\  3\ 1\ 2\  6\ 5\ 9  $$
$$9\ 1\ 2\  6\ 4\ 5\ 8\ 7\ 3  $$
$$2\ 3\ 1\ 9\ 7\ 4\  5\ 6\ 8  $$
$$4\ 9\ 5\ 2\ 8\ 6\ 1\ 3\ 7  $$
$$6\ 7\ 8\  1\ 5\ 3\  4\ 9\  2$$
