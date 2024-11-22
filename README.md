# Sorting Algorithms Project

This project implements several sorting algorithms and provides a way to test their performance in terms of the number of comparisons made during sorting. The project consists of two main experiments:

- **Experiment 1**: Reads numbers from a file and sorts them using a chosen algorithm.
- **Experiment 2**: Generates random numbers and sorts them using a chosen algorithm.

## Files

- `SortDriverEX1.java`: Main class for Experiment 1, which reads numbers from a file and sorts them.
- `SortDriverEX2.java`: Main class for Experiment 2, which generates random numbers and sorts them.
- `Sorting.java`: Contains the implementation of various sorting algorithms.

## Sorting Algorithms

The following sorting algorithms are implemented in the `Sorting` class:

- **Selection Sort**: A simple comparison-based sorting algorithm.
- **Merge Sort**: A divide-and-conquer algorithm that divides the array into halves, sorts them, and merges them back.
- **Heap Sort**: A comparison-based sorting technique based on a binary heap data structure.
- **Quick Sort**: A divide-and-conquer algorithm that picks an element as a pivot and partitions the array around the pivot.
- **Randomized Quick Sort**: A variation of quick sort where the pivot is chosen randomly.

## How to Run

### Experiment 1

1. Compile the Java files:
   ```bash
   javac SortDriverEX1.java Sorting.java
   ```

2. Run the program with a file containing numbers:
   ```bash
   java SortDriverEX1 <filename>
   ```

   Replace `<filename>` with the path to your file containing space-separated integers.

3. Choose a sorting algorithm by entering one of the following options:
   - `s` for selection sort
   - `m` for merge sort
   - `h` for heap sort
   - `q` for quick sort
   - `r` for randomized quick sort

### Experiment 2

1. Compile the Java files:
   ```bash
   javac SortDriverEX2.java Sorting.java
   ```

2. Run the program:
   ```bash
   java SortDriverEX2
   ```

3. Enter the number of random values to generate and choose a sorting algorithm as described above.

## Notes

- The program outputs the number of comparisons made by the chosen sorting algorithm.
- Ensure that the input file for Experiment 1 contains a single line of space-separated integers.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
