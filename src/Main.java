import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Basics

        // Task 1
        // Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
        //
        // Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].

        //findMaxMinAverageValue();

        // Task 2
        // Реализуйте алгоритм сортировки пузырьком, вставкой, выбором, слиянием для сортировки массива

        //sort();

        // Сравнение скорости выполнения
        //testSpeed();

        // Task 3
        // Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
        // Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.

        //printPrimeNumbers();

        // Task 4
        // Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива (пропусков быть не должно).

        //deleteAllAppearances(new int[]{1,2,3,4,5,3,2,2}, 3);



    }

    public static Scanner scan(){
        return new Scanner(System.in);
    }
    public static void findMaxMinAverageValue() {
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++){
            array[i] = (int) Math.floor(Math.random() * 10);
        }

        int min = array[0];
        int max = array[0];
        double sum = 0;

        for(int i = 0; i < array.length - 1; i++){
            if(array[i + 1] < min) min = array[i + 1];
            if(array[i + 1] > max) max = array[i + 1];
            sum += array[i];
        }

        System.out.println(Arrays.toString(array));
        System.out.println("Min value : " + min);
        System.out.println("Max value : " + max);
        System.out.println("Average value : " + sum / array.length);
    }

    public static void sort() {
        int[] array = new int[20];
        for(int i = 0; i < array.length; i++){
            array[i] = (int) Math.floor(Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));

        System.out.println("1) Bubble sort ");
        System.out.println("2) Insertion sort ");
        System.out.println("3) Selection sort ");
        System.out.println("4) Merge sort ");
//        System.out.println("5) Pyramidal sort ");
//        System.out.println("6) Quick sort ");
        System.out.print("Sort using... ");
        int decision = scan().nextInt();

        switch (decision){
            case 1:
                System.out.println(Arrays.toString(bubbleSort(array)));
                break;
            case 2:
                System.out.println(Arrays.toString(insertionSort(array)));
                break;
            case 3:
                System.out.println(Arrays.toString(selectionSort(array)));
                break;
            case 4:
                System.out.println(Arrays.toString(mergeSort(array)));
                break;
        }
    }

    private static int[] bubbleSort(int[] array) {

        boolean isSort = false;
        while(!isSort){
            isSort = true;
            for(int i = 1; i < array.length; i++){
                if(array[i] < array[i - 1]){
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    isSort = false;
                }
            }
        }
        return array;
    }

    private static int[] insertionSort(int[] array) {

        for(int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i;
            while(j > 0 && array[j - 1] > current){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }

        return array;
    }

    private static int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++){
            int min = array[i];
            int minId = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < min){
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        return array;
    }

    private static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];
        int size = 1;
        while(size < array.length) {
            for(int i = 0; i < array.length; i += 2* size){
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;
        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);
        int iterationCount = src1End - src1Start + src2End - src2Start;
        for(int i = destStart; i < destStart + iterationCount; i++){
            if(index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])){
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static  void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }

    private static void testSpeed() {
        int testLen = 10000;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];
        int[] arr3 = new int[testLen];
        int[] arr4 = new int[testLen];

        System.out.println("\n-----Случайный массив------");
        for(int i = 0; i < testLen; i++){
            arr1[i] = arr2[i] = arr3[i] = arr4[i] = (int) Math.floor(Math.random() * 10000);
        }

        System.out.println("Пузырьковая сортировка: ");
        measureTime(() -> bubbleSort(arr1));

        System.out.println("Сортировка вставками: ");
        measureTime(() -> insertionSort(arr2));

        System.out.println("Сортировка выбором: ");
        measureTime(() -> selectionSort(arr3));

        System.out.println("Сортировка слиянием: ");
        measureTime(() -> mergeSort(arr4));
    }

    public static void printPrimeNumbers() {
        for(int i = 2; i <= 100; i++){
            boolean isPrime = true;

            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) System.out.print(i + " ");
        }
    }

    public static void deleteAllAppearances(int[] array, int element){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == element) counter++;
        }

        int[] resultArray = new int[array.length - counter];

        for(int i = 0, j = 0; i < array.length; i++){
            if(array[i] != element){
                resultArray[j] = array[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(resultArray));
    }
}
