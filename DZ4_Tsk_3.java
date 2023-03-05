
import java.util.Scanner;
import java.util.LinkedList;

public class DZ4_Tsk_3 {
    public static void main(String[] args) {
        LinkedList<Double> resList = new LinkedList<Double>();  // Создаем список
        try (Scanner sc = new Scanner(System.in)) {             // Создаем сканер
            System.out.print("Введите первое число и нажмите ENTER: ");
            resList.add(sc.nextDouble());  // Добавляем первое число в список
            sc.nextLine();

            while(true) {  //  Находимся в цикле, пока запущен калькулятор
                System.out.print("  Выберите действие ( +, -, *, / ) \nили клавишу [C] для отмены последнего действия нажмите ENTER: ");
                String math_char = sc.nextLine();     // Вводим действие     

                if ("C".equals(math_char) || "c".equals(math_char)) {  // Если введена клавиша отмены, удаляем из списка последний добавленный эл-т
                    resList.removeFirst();

                    if (resList.isEmpty()) resList.add(0.0);  // Если список пустой, в итого добавляем ноль
                    }
                else {
                    System.out.print("Введите следующее число и нажмите ENTER: ");  
                    double nextNum = sc.nextDouble();  //  Добавляем следующее число в список

                    calculate(resList, math_char, nextNum);  //  Проводим расчет
                    sc.nextLine();   //  Запрашиваем седующее действие
                    }

                System.out.println("Итого: " + resList.getFirst());  // Вводим итого              
            }
        }
    }

    public static void calculate(LinkedList<Double> resList, String math_char, double nextNum) {  // Ф-ция расчета
        double res = resList.getFirst();      //  Переменная для вывода промежуточного резултата
        switch (math_char) {                 // Получаем последний добавленный эл-т списка и проводим выбранное дйствие
            
            case "+":
                resList.add(0, resList.getFirst() + nextNum);
                System.out.printf(res + " " + math_char + " " + nextNum + " = " + resList.getFirst() + "\n");  // Вывод расчета              
                break;
            
            case "-":
                resList.add(0, resList.getFirst() - nextNum);
                System.out.printf(res + " " + math_char + " " + nextNum + " = " + resList.getFirst() + "\n");  // Вывод расчета 
                break;

            case "*":
                resList.add(0, resList.getFirst() * nextNum);
                System.out.printf(res + " " + math_char + " " + nextNum + " = " + resList.getFirst() + "\n");  // Вывод расчета 
                break;
            
            case "/":
                if (nextNum == 0) {       // Исключаем деление на ноль
                    System.out.println("Ошибка! На ноль делить нельзя");
                    break;
                }
                resList.add(0, resList.getFirst() / nextNum);
                System.out.printf(res + " " + math_char + " " + nextNum + " = " + resList.getFirst() + "\n");  // Вывод расчета 
                break;
            
            default:
                System.out.println("Ошибка при наборе данных! Повториете ввод");
        }
    }
}