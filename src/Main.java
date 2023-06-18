import java.util.Arrays;
import List.*;

public class Main {
    public static void main(String[] args) {

        // OOP BASICS

        // Task 1
        // Проектирование и создание класса, описывающего вектор

        /*
        Vector[] vectors = Vector.getArrayOfVectors(2);
        System.out.println(Arrays.toString(vectors));
        System.out.println();

        System.out.println("Длина вектора: " + vectors[0].getLength());
        System.out.println("Длина вектора: " + vectors[1].getLength());
        System.out.println();

        System.out.println("Скалярное произведение векторов: " + vectors[0].multiplyScalar(vectors[1]));
        System.out.println("Векторное произведение: " + vectors[0].multiplyVector(vectors[1]));
        System.out.println();

        vectors[0].getAngle(vectors[1]);
        System.out.println();

        System.out.println("Сумма векторов: " + vectors[0].addVector(vectors[1]));
        System.out.println("Разность векторов: " + vectors[0].minusVector(vectors[1]));
        */

        // Task 2
        // Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
        // Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
        // Пример:
        // Дан массив [1, 2, 3], и массив весов [1, 2, 10].
        // В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».

        /*
        WeightElements weightElements = new WeightElements(new int[]{2,3,4}, new int[]{1,2,10});
        System.out.println(weightElements.getRandom());
        */

        // Task 3
        // Реализация связного списка.
        
        List list = new List();
        
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addByIndex(4,2);
        list.print();

        System.out.println();
        list.removeAt(1);
        list.print();
    }


}
