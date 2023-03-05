//1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void),
// который вернет “перевернутый” список.

import java.util.LinkedList;
import java.util.Random;

public class DZ4_Tsk_1 {
    public static void main(String[] args) {
        System.out.print(mirrorLinkedList(random_Lst()));  // Вывод обратного списка
    }
    public static LinkedList<Integer> random_Lst(){  // Ф-ция генерации случайного списка цифр
        Random rand = new Random();
        LinkedList<Integer> my_list = new LinkedList<Integer>();
        for (int i = 0; i < 16; i++) {                        // Задаем кол-во эл-тов
            int num = rand.nextInt(0, 1000);   // Задаем интервал значений эл-тов
            my_list.add(num);
        }
        System.out.println("Исходный список"); // Вывод сгенерированого списка
        System.out.println(my_list); // Вывод сгенерированого списка
        System.out.println("Список обратный исходному"); 
        return my_list;
    }
    public static LinkedList<Integer> mirrorLinkedList(LinkedList<Integer> my_list){   // Ф-ция поворота списка
        LinkedList<Integer> my_list2 = new LinkedList<Integer>();
        int stpeps = my_list.size();               // Выделяем переменную для определения к-ва итераций в цикле 
        for (int i = 0 ; i < stpeps; i++) {
            my_list2.add(my_list.getLast());     // Получаем последний эл-т и добавляем в новый список
            my_list.removeLast();              //  Удаляем последний эл-т
        }
        return my_list2;   // Возввращаем обратный список                
    }
}
            