import java.util.ArrayList;

public class SortedList {
    private final ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    // Add a string to the list while maintaining sorted order
    public void add(String str) {
        int position = binarySearchForInsert(str);
        list.add(position, str);
    }

    // Search for a string in the list and return its index or -1 if not found
    public int search(String str) {
        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = str.compareTo(list.get(mid));

            if (comparison == 0) {
                return mid; // Found the element
            } else if (comparison < 0) {
                high = mid - 1; // Search the left half
            } else {
                low = mid + 1; // Search the right half
            }
        }

        return -(low + 1); // Element not found, return insertion point as negative
    }

    // Find the correct insertion point using binary search
    private int binarySearchForInsert(String str) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (str.compareTo(list.get(mid)) > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // Correct insertion position
    }

    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return String.join(", ", list);
    }
}
