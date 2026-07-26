import java.util.Scanner;

public class binary {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = arr.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                foundIndex = mid;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found.");
        }

        sc.close();
    }
}