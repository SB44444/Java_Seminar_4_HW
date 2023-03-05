// 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class DZ4_Tsk_2 {
    public static void main(String[] args) {        

        try (Scanner scanner = new Scanner(System.in)) {  // Создаём сканер
            System.out.print("Введите целое число для добавлния в список: ");
            if (scanner.hasNextInt()) {     // Если введенное число целое, считываются данные
                int number = scanner.nextInt();  
                enqueue(random_Lst(), number); //  Добавляем элемент в конец списка                
            } else {
                System.out.println("Вы ввели не целое число");  // Иначе выводится сообщение
            }        
        }
        catch (Exception e) {   // Если что-то введено совсем не так
            System.out.println(e.getMessage());
        }

        System.out.println("Первое число будет удалено из нижеследующего списка ");
        System.out.println(dequeue(random_Lst()));        //  Удаляем первый элемент из списка и его же возвращаем
        
        System.out.println("Выведен первый элемент из нижеследующего списка ");
        System.out.println(first(random_Lst()));         // Возвращаем первый элемент списка без его удаления

    }
    public static LinkedList<Integer> random_Lst(){  // Ф-ция генерации случайного списка цифр
        Random rand = new Random();
        LinkedList<Integer> my_list = new LinkedList<Integer>();
        for (int i = 0; i < 8; i++) {                        // Задаем кол-во эл-тов
            int num = rand.nextInt(0, 1000);   // Задаем интервал значений эл-тов
            my_list.add(num);
        }
        System.out.println("Исходный список"); 
        System.out.println(my_list); // Вывод сгенерированого списка
        return my_list;        
    }    

    public static void enqueue(LinkedList<Integer> my_List, int number) {    // Ф-ция добавления элемента в конец очереди
        my_List.addLast(number);
        System.out.println("Итоговый список с добавленным элементом");
        System.out.println(my_List);    // Вывод  списка
    }

    public static int dequeue(LinkedList<Integer> my_List) { //Ф-ция удаляет первый элемент из списка и его возвращает
        int number = my_List.get(0);
        my_List.remove(0);
        return number;
    }

    public static int first(LinkedList<Integer> my_List) { // Ф-ция вернет первый элемент списка без его удаления
        int number = my_List.get(0);
        return number;
    }    
}