import java.util.Scanner;
import java.util.Arrays; 

public class SortDriverEX2 {


    // Experiment 2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of random values to generate: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        // Generates random array (length n) of numbers
        for (int i = 0; i < n; i++) {
            numbers[i] = (int) (Math.random() * 10000); 
        }

        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");

        String choice = scanner.next();
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
                scanner.close();
                return;
        }

        // Testing the sorted array
        //System.out.println("Sorted array: " + Arrays.toString(numbers));

        System.out.println("#" + choice + "-sort comparisons: " + comparisons);
        scanner.close();
    }

    
}

