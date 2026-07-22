public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 0, 9, 7, 2, -9, 3, -2, 0, -1};

        MergeSort sort = new MergeSort(nums);
        sort.sort();
        sort.printArray();
    }
}