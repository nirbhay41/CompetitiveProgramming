package com.RocketScience.DSA.Array_ADT;

public class Array {
    private int[] arr;
    public int size, length = 0;

    public Array(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void add(int x) {
        if (length < size)
            arr[length++] = x;
    }

    public void show() {
        System.out.println("Displaying all the Elements of Array: ");
        for (int i = 0; i < length; i++)
            System.out.println(arr[i]);
    }

    public void insert(int index, int x) {
        if (index >= 0 && index <= length) {
            for (int i = length; i > index; i--)
                arr[i] = arr[i - 1];
            arr[index] = x;
            length++;
        }
    }

    public int delete(int index) {
        if (index >= 0 && index <= length) {
            int pop = arr[index];
            for (int i = index; i < length - 1; i++)
                arr[i] = arr[i + 1];
            length--;
            return pop;
        }
        return 0;
    }

    public int binarySearch(int x) {
        /*
           Best Case : O(1)
           Average Case : O(log2 n)
           Worst Case : O(log2 n)
         */

        int l = 0, h = length - 1, mid;
        while (l <= h) {
            mid = l + (h-l)/2;
            if (arr[mid] == x) return mid;
            else if (x < arr[mid]) h = mid - 1;
            else if (x > arr[mid]) l = mid + 1;
        }
        return -1;
    }

    public int get(int index) {
        if (index >= 0 && index <= length)
            return arr[index];
        return -1;
    }

    public void set(int index, int x) {
        if (index >= 0 && index <= length)
            arr[index] = x;
    }

    public int max() {
        int max = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int min() {
        int min = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public int sum() {
        int s = 0;
        for (int i = 0; i < length; i++) {
            s += arr[i];
        }
        return s;
    }

    public boolean isSorted() {
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public void SortedInsertion(int x) {
        int i;
        if (length == size) return;
        for (i = length - 1; i >= 0 && arr[i] > x; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = x;
        length++;
    }

    public static Array merge(Array a, Array b) {
        int i, j;
        i = j = 0;
        Array c = new Array(a.length + b.length);
        while (i < a.length && j < b.length) {
            if (a.get(i) < b.get(j)) {
                c.add(a.get(i++));
            } else c.add(b.get(j++));
        }
        for (; i < a.length; i++)
            c.add(a.get(i));
        for (; j < b.length; j++)
            c.add(b.get(j));
        return c;
    }

    public static Array union(Array a, Array b) {
        int i, j;
        i = j = 0;
        Array c = new Array(a.length + b.length);
        while (i < a.length && j < b.length) {
            if (a.get(i) < b.get(j))
                c.add(a.get(i++));
            else if (a.get(i) > b.get(j))
                c.add(b.get(j++));
            else {
                c.add(a.get(i++));
                j++;
            }
        }
        for (; i < a.length; i++)
            c.add(a.get(i));
        for (; j < b.length; j++)
            c.add(b.get(j));
        return c;
    }

    public static Array intersection(Array a, Array b) {
        int i, j;
        i = j = 0;
        Array c = new Array(a.length + b.length);
        while (i < a.length && j < b.length) {
            if (a.get(i) < b.get(j))
                i++;
            else if (a.get(i) > b.get(j))
                j++;
            else {
                c.add(a.get(i++));
                j++;
            }
        }
        return c;
    }

    public static Array difference(Array a, Array b) {
        int i, j;
        i = j = 0;
        Array c = new Array(a.length + b.length);
        while (i < a.length && j < b.length) {
            if (a.get(i) < b.get(j))
                c.add(a.get(i++));
            else if (a.get(i) > b.get(j))
                j++;
            else if (a.get(i) == b.get(j)) {
                i++;
                j++;
            }
        }
        for (; i < a.length; i++)
            c.add(a.get(i));
        return c;
    }

    /*
      Implementing Bubble Sort
        Best Case: O(n)
        Average Case : O(n^2)
        Worst Case : O(n^2)
     */
    public static void bubbleSort(Array a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) { // for passes
            int flag = 0;
            for (int j = 0; j < a.length - 1 - i; j++) { // for iteration
                if (a.get(j) > a.get(j + 1)) {
                    temp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temp);
                    flag = 1;
                }
            }
            if (flag == 0) break; // if the list is already sorted
        }
    }

    public static void insertionSort(Array a) {
        int j, x;
        for (int i = 1; i < a.length; i++) {
            j = i - 1;
            x = a.get(i);
            while (j > -1 && a.get(j) > x) {
                a.set(j + 1, a.get(j));
                j--;
            }
            a.set(j + 1, x);
        }
    }
}
