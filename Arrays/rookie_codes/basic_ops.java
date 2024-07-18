package Arrays.rookie_codes;

public class basic_ops {
    static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int insert(int[] arr, int index, int num, int cap) {
        // checking whether the size of the array is not exceeding
        if (arr.length == cap) {
            return cap;
        }
        // shifting the elements till insert index
        for (int i = cap; i > index; i--) { // i = arr.length because if the last index of array is 3 then the
                                            // array.length will be 4
            arr[i] = arr[i - 1];
        }

        arr[index] = num;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        return 0;
    }

    static int delete_num(int[] arr, int num) {
        int del_index = search(arr, num);
        for (int i = del_index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        return 0;
    }

    static int delete_index(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 99, 4, 5, 6, 4, 7, 3, 2, 6, 98 };

        System.out.printf("Index is %d\n", search(arr, 7));
        insert(arr, 3, 99, 6);
        delete_num(arr, 99);
        delete_index(arr, 3);
    }
}