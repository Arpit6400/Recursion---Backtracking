# 🎯 Recursion & Backtracking Revision Guide

This repository contains key problems from **Striver's Recursion and Backtracking Series (L1 to L23)**. It is organized into a clean folder structure to serve as a reference for future revisions.

## 📂 Repository Structure
- [problems/](problems/) - Contains all implementation files, renamed descriptively with lesson prefixes.
- [README.md](README.md) - This revision reference guide explaining each pattern.

---

## 📌 Recursion Patterns

Here is a collective summary of the key recursion and backtracking patterns utilized throughout these problems:

1.  **Basic Recursion**: Direct function self-invocation with a base case to prevent stack overflow.
2.  **Backtracking**: Performing operations on the way down the recursive call stack, and explicitly undoing them on the way up (reverting state) to explore alternative paths.
3.  **Parameterized Recursion**: Carrying the state/accumulated value inside the function parameters down the call tree.
4.  **Functional Recursion**: Returning the result of a subproblem up the call stack to construct the final return value.
5.  **Multiple Recursion Calls**: Invoking more than one recursive call in a single execution frame (creates a branching call tree, e.g., Fibonacci).
6.  **Subsequences / Pick & Not-Pick Pattern**: A binary branching decision at each index to either include the current element in a subsequence or exclude it.
7.  **Index Loop-Based Recursion**: Iterating through remaining elements using a loop inside the recursive function (common for generating unique combinations/subsets by skipping adjacent duplicates).
8.  **Divide and Conquer**: Splitting the problem into independent subproblems, solving them recursively, and combining their results (e.g., Merge Sort, Quick Sort).
9.  **Grid Pathfinding / Backtracking**: Moving in cardinal/diagonal directions on a 2D grid, tracking visits to avoid cycles, and resetting visited state upon backtracking.
10. **State-Space Constraint Backtracking**: Systematically searching configurations (like chessboards, sudoku grids, or coloring maps) by placing a value, verifying constraints in $O(1)$ or $O(N)$, recursing, and removing it on failure.

---

## 📌 Problem Index (L1 - L23)

### 💡 L1 & L2: Basic Recursion & Backtracking
*   **Concept**:
    *   **Recursion**: A function calls itself to solve a smaller subproblem until it hits the *base condition*.
    *   **Backtracking (Print/Process on Return)**: Postpones printing or state changes until the recursive call returns. This naturally reverses the call order.
*   **Problems**:
    1.  Print $1$ to $N$ (Recursion & Backtracking)
    2.  Print $N$ to $1$ (Recursion & Backtracking)
*   **File Link**: [rec1_Print_1_To_N_And_N_To_1.java](problems/rec1_Print_1_To_N_And_N_To_1.java)

---

### 💡 L3: Parameterized & Functional Recursion
*   **Concept**:
    *   **Parameterized**: Carries the accumulated value (e.g., sum) down the recursive tree inside the function parameters.
    *   **Functional**: Returns the result of the subproblem up the call stack (e.g., $f(n) = n + f(n-1)$).
*   **Problems**:
    1.  Sum of first $N$ numbers
    2.  Factorial of $N$
*   **File Link**: [rec3_Sum_1_To_N_And_Factorial.java](problems/rec3_Sum_1_To_N_And_Factorial.java)

---

### 💡 L4: Functional Recursion (Array Reversal & Palindrome)
*   **Concept**:
    *   Reversing an array using two-pointer index swapping ($L$ and $R$) or mathematical mapping with a single pointer ($i$ and $n - i - 1$).
*   **Problems**:
    1.  Reverse an Array (Two-pointer & One-pointer versions)
*   **File Link**: [rec4_Reverse_Array.java](problems/rec4_Reverse_Array.java)

---

### 💡 L5: Multiple Recursion Calls (Fibonacci)
*   **Concept**:
    *   A single stack frame invokes more than one recursive call (e.g., $f(n-1) + f(n-2)$).
    *   This creates an exponential tree of calls ($O(2^n)$ time complexity), demonstrating the need for memoization or dynamic programming.
*   **Problems**:
    1.  Calculate $N$-th Fibonacci Number
*   **File Link**: [rec5_Fibonacci_Number.java](problems/rec5_Fibonacci_Number.java)

---

### 💡 L6: Subsequences / Power Set Pattern
*   **Concept**:
    *   **Pick / Not Pick Pattern**: At each index, you make two choices:
        1.  *Pick*: Add the element at the current index to the list and recurse.
        2.  *Not Pick*: Remove/exclude the element and recurse.
*   **Problems**:
    1.  Generate all subsequences of an array
*   **File Link**: [rec6_Subsequences_Of_Array.java](problems/rec6_Subsequences_Of_Array.java)

---

### 💡 L7: Subsequences with Sum equal to K
*   **Concept**:
    *   A extension of the pick/not pick pattern where the base case checks if the running sum matches $K$.
    *   **Techniques**:
        1.  *Print All*: Standard traversal.
        2.  *Print First Only*: Return `true` when a match is found and immediately exit child calls to avoid further recursion.
        3.  *Count All*: Accumulate results by returning `leftCall + rightCall`.
*   **Problems**:
    1.  Subsequences with sum $K$ (all, first, and count variants)
*   **File Link**: [rec7_Subsequences_With_Sum_K.java](problems/rec7_Subsequences_With_Sum_K.java)

---

### 💡 L8 & L9: Divide and Conquer (Merge Sort & Quick Sort)
*   **Concept**:
    *   **Merge Sort (L8)**: Divides the array into two halves recursively, sorts them, and merges them using a two-pointer merge algorithm ($O(N \log N)$ time, $O(N)$ space).
    *   **Quick Sort (L9)**: Chooses a pivot element, partitions the array around it (smaller elements on left, larger on right), and recursively sorts the partition boundaries ($O(N \log N)$ average time, $O(1)$ auxiliary space).
*   **Problems**:
    1.  Merge Sort
    2.  Quick Sort
*   **File Links**:
    *   [rec8_Merge_Sort.java](problems/rec8_Merge_Sort.java)
    *   [rec9_Quick_Sort.java](problems/rec9_Quick_Sort.java)

---

### 💡 L10: Combination Sum I (LeetCode 39)
*   **Concept**:
    *   Pick/Not-pick choice where elements can be reused an unlimited number of times.
    *   If you pick the element, you remain at the same index ($idx$), reducing the target value. You only advance the index ($idx + 1$) when you choose not to pick the element.
*   **Problems**:
    1.  Combination Sum (Unlimited element reuse)
*   **File Link**: [rec10_Combination_Sum_I.java](problems/rec10_Combination_Sum_I.java)

---

### 💡 L11: Combination Sum II (LeetCode 40)
*   **Concept**:
    *   Find all unique combinations where each element can be used once. Duplicates must not be present in the output.
    *   **Loop-based Recursion**: Sort the array first. At each recursion level, use a loop starting from the current index. If $candidates[i] == candidates[i - 1]$ and $i > idx$, skip it to prevent duplicate combinations.
*   **Problems**:
    1.  Combination Sum II
*   **File Link**: [rec11_Combination_Sum_II_And_Subsets_II.java](problems/rec11_Combination_Sum_II_And_Subsets_II.java)

---

### 💡 L12: Subset Sum I
*   **Concept**:
    *   Calculate the sums of all possible subsets.
    *   Traverse the array using a pick/not-pick mechanism. In the base case, add the accumulated sum to the result list.
*   **Problems**:
    1.  Subset Sums
*   **File Link**: [rec12_Subset_Sums.java](problems/rec12_Subset_Sums.java)

---

### 💡 L13: Subset Sum II / Subsets II (LeetCode 90)
*   **Concept**:
    *   Generate all unique subsets of a set that contains duplicate numbers.
    *   Sort the array and use the index-loop recursion pattern. Skip duplicate numbers on the same level of the recursion tree to avoid duplicates.
*   **Problems**:
    1.  Subsets II
*   **File Link**: [rec11_Combination_Sum_II_And_Subsets_II.java](problems/rec11_Combination_Sum_II_And_Subsets_II.java) *(implemented inside the `subsetsWithDup` method)*

---

### 💡 L14: Permutations of Array / String (LeetCode 46)
*   **Concept**:
    *   Generate all orderings of a given array/string.
    *   **Approach 1**: Use a boolean frequency array to mark visited indices, picking unvisited elements at each step ($O(N)$ space).
    *   **Approach 2 (In-Place Swap)**: Loop through indices from the current marker, swapping elements to position them, recursing, and then swapping back (backtracking) ($O(1)$ extra space).
*   **Problems**:
    1.  Permutations of an Array
*   **File Link**: [rec14_Permutations_Of_Array.java](problems/rec14_Permutations_Of_Array.java)

---

### 💡 L15 & L16: N-Queens Problem (LeetCode 51)
*   **Concept**:
    *   Place $N$ queens on an $N \times N$ chessboard such that no two queens attack each other.
    *   **Safety Optimization**: Instead of scanning diagonals in $O(N)$ on every placement, maintain boolean arrays/hash tables:
        *   `leftRow`: checks horizontal threats.
        *   `lowerDiagonal`: checks diagonal threats matching $row + col$.
        *   `upperDiagonal`: checks diagonal threats matching $(N-1) + col - row$.
*   **Problems**:
    1.  N-Queens
*   **File Link**: [rec16_N_Queens.java](problems/rec16_N_Queens.java)

---

### 💡 L17: Sudoku Solver (LeetCode 37)
*   **Concept**:
    *   Fill an incomplete Sudoku board using backtracking.
    *   Iterate through each cell. When an empty cell `.` is found, try placing characters `'1'` to `'9'`. Validate standard row, column, and $3 \times 3$ grid safety. If valid, recurse. If the board becomes invalid later, backtrack.
*   **Problems**:
    1.  Sudoku Solver
*   **File Link**: [rec17_Sudoku_Solver.java](problems/rec17_Sudoku_Solver.java)

---

### 💡 L18: M-Coloring Problem
*   **Concept**:
    *   Determine if a graph can be colored with at most $M$ colors such that no adjacent vertices share the same color.
    *   Recursively try coloring each vertex from $1$ to $M$, checking adjacency safety, and backtracking if a color assignment blocks completion.
*   **Problems**:
    1.  M-Coloring Graph
*   **File Link**: [rec18_M_Coloring_Graph.java](problems/rec18_M_Coloring_Graph.java)

---

### 💡 L19: Palindrome Partitioning (LeetCode 131)
*   **Concept**:
    *   Partition a string such that every substring in the partition is a palindrome.
    *   At the current index, loop forward to find any prefix substring that is a palindrome. Add it to the path, recurse on the remainder of the string, and backtrack.
*   **Problems**:
    1.  Palindrome Partitioning
*   **File Link**: [rec19_Palindrome_Partitioning.java](problems/rec19_Palindrome_Partitioning.java)

---

### 💡 L20: Rat in a Maze
*   **Concept**:
    *   Find all possible paths a rat can take from $(0, 0)$ to $(N-1, N-1)$ in a maze.
    *   **Backtracking Walk**: Maintain a `visited` board. Attempt movements in sorted alphabetical direction (D, L, R, U) to produce lexicographically sorted paths. Backtrack by marking the cell unvisited.
*   **Problems**:
    1.  Rat in a Maze Pathfinding
*   **File Link**: [rec20_Rat_In_A_Maze.java](problems/rec20_Rat_In_A_Maze.java)

---

### 💡 L21: K-th Permutation Sequence (LeetCode 60)
*   **Concept**:
    *   Find the $K$-th permutation sequence of numbers from $1$ to $N$.
    *   **Mathematical Block Skipping**: Instead of generating all permutations recursively ($O(N!)$), calculate block sizes using factorials. Determine the exact digit to select, remove it from a list, reduce $K$, and repeat for the remaining numbers. Runs in $O(N^2)$ time.
*   **Problems**:
    1.  K-th Permutation
*   **File Link**: [rec21_Kth_Permutation_Sequence.java](problems/rec21_Kth_Permutation_Sequence.java)

---

### 💡 L22: Letter Combinations of a Phone Number (LeetCode 17)
*   **Concept**:
    *   Recursion on phone keypad layout configurations.
    *   Map digits to their respective character lists. Traverse the input string digit-by-digit, looping through the corresponding characters, appending, recursing, and backtracking.
*   **Problems**:
    1.  Letter Combinations of a Phone Number
*   **File Link**: [rec22_Letter_Combinations_Phone_Number.java](problems/rec22_Letter_Combinations_Phone_Number.java)

---

### 💡 L23: Generate Parentheses (LeetCode 22)
*   **Concept**:
    *   Generate all combinations of well-formed parentheses.
    *   Maintain counts of open `(` and close `)` parentheses.
        *   Place a `(` if `open < N`.
        *   Place a `)` if `close < open`.
*   **Problems**:
    1.  Generate Parentheses
*   **File Link**: [rec23_Generate_Parentheses.java](problems/rec23_Generate_Parentheses.java)
