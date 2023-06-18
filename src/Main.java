import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Recursion

        // Task 1
        // Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
        // Используйте перебор и двоичный поиск для решения этой задачи.
        // Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).

        // test();

        // Task 2
        // Реализация бинарного дерева поиска



    }

    public static boolean useEnumeration(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int left, int right, int element) {
        if(right >= left && left <= array.length - 1) {
            int middle = (left + right) / 2;

            if (array[middle] == element)
                return true;

            if (array[middle] > element)
                return binarySearch(array, left, middle - 1, element);

            return binarySearch(array, middle + 1, right, element);
        }

        return false;
    }

    public static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor(Math.random() * 1000000000);
        }
        return array;
    }

    public static void test() {
        int[] array = generateRandomArray(10000000);
        Arrays.sort(array);

        System.out.println(useEnumeration(array, 47));
        System.out.println(binarySearch(array, 0, array.length - 1, 47));

        double time1 = System.currentTimeMillis();
        useEnumeration(array, 47);
        System.out.println(System.currentTimeMillis() - time1);

        double time2 = System.currentTimeMillis();
        binarySearch(array, 0, array.length - 1, 289);
        System.out.println(System.currentTimeMillis() - time2);
    }
}
