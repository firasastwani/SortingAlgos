import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortDriver {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java SortDriver <filename>");
            return;
        }

        String filename = args[0];
        int[] numbers = readNumbersFromFile(filename);

        if (numbers == null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");
        String choice = scanner.nextLine();

        Sorting sorting = new Sorting();

        long comparisons = 0;

        switch (choice) {
            case "s":
                comparisons = sorting.selectionSort(numbers);
                break;
            case "m":
                comparisons = sorting.mergeSort(numbers);
                break;
            case "h":
                comparisons = sorting.heapSort(numbers);
                break;
            case "q":
                comparisons = sorting.quickSort(numbers);
                break;
            case "r":
                comparisons = sorting.randomQuickSort(numbers);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("#" + choice + "-sort comparisons: " + comparisons);
        scanner.close(); 
    }

    private static int[] readNumbersFromFile(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            // Assuming the file contains a single line of space-separated integers
            String[] numberStrings = fileScanner.nextLine().split(" ");
            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }
            fileScanner.close();
            return numbers;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("File contains non-integer values.");
        }
        return null;
    }
}

