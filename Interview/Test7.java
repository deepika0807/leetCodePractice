package Interview;

import java.util.ArrayList;
import java.util.List;

//33. Search in Rotated Sorted Array
public class Test7 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(7);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(0);
        nums.add(1);

        System.out.println(search(nums, 0));  // should print correct index
    }

    public static int search(List<Integer> nums, int target) {
        int k = findMin(nums);    // rotation count
        rotateArray(nums, k);     // restore sorted array
        return searchingHelper(nums, target, 0, nums.size() - 1);
    }

    // ------------------ FIND MIN (your structure, fixed) ------------------
    static int findMin(List<Integer> nums) {
        int min = nums.get(0);
        int index = 0;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < min) {
                min = nums.get(i);
                index = i;
            }
        }
        return index;   // fixed
    }

    // ------------------ ROTATE ARRAY (your structure, fixed) ------------------
    static void rotateArray(List<Integer> nums, int k) {
        if (k == 0) return;

        // correct 3-step rotation
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    static void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

    // ------------------ BINARY SEARCH (your structure, fixed) ------------------
    static int searchingHelper(List<Integer> nums, int target, int start, int end) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (nums.get(mid) == target) {
            return mid;
        }

        if (nums.get(mid) > target) {
            return searchingHelper(nums, target, start, mid - 1);
        } else {
            return searchingHelper(nums, target, mid + 1, end);
        }
    }
}
