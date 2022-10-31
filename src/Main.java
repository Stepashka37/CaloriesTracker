
/**
 * В классе Main реализован вывод меню, ввод команд и взаимодействие пользователя с интерфейсом приложения.
   Взаимодействие с методами класса StepTracker происходит с помощью объекта step, класса StepTracker.
   Хотя по заданию требовалось реализовать ввод месяцев в формате 0-11, я решил, что для удобства пользователей лучше сделать это
   в формате 1-12, то же самое и с вводом дней.
   Поэтому все значения месяцев и дней передаются в методы класса StepTracker уменьшенные на 1.
 * @author Dmitry Maksimov "dimax40rus@yandex.ru"
 * @version 1.1
 * @see StepTracker
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker step = new StepTracker();
        while (true) {
            printMenu();
            int command = sc.nextInt();
            if (command == 1) {
                System.out.println ("Укажите месяц (1-12): 1-ЯНВ, 2-ФЕВ, 3-МАРТ, 4-АПР, 5-МАЙ, 6-ИЮНЬ, 7-ИЮЛЬ, 8-АВГ, 9-СЕНТ, 10-ОКТ, 11-НОЯБ, 12-ДЕК: ");
                step.symbolCheck(sc);
                int monthNumber = sc.nextInt();
                System.out.println ("Укажите день (1-30): ");
                step.symbolCheck(sc);
                int dayNumber = sc.nextInt();
                System.out.println ("Введите количество шагов: ");
                step.symbolCheck(sc);
                int daySteps = sc.nextInt();
                step.saveSteps(monthNumber-1, dayNumber-1, daySteps);
                System.out.println();
            } else if (command == 2) {
                System.out.println ("Укажите номер месяца, за который вывести статистику: ");
                step.symbolCheck(sc);
                int monthNumber = sc.nextInt();
                step.stat(monthNumber-1);
                System.out.println();
            } else if (command == 3) {
                System.out.println ("Укажите новое целевое количество шагов за день: ");
                int goalSteps = sc.nextInt();
                step.newStepsGoal(goalSteps);
                System.out.println();
            } else if (command == 4) {
                System.out.println ("Выход.");
                break;
            } else {
                System.out.println ("Неизвестная команда, пожалуйста, повторите ввод команды.");
                System.out.println();
            }
        }
    }

    /** Метод для печати меню */
    public static void printMenu () {
        System.out.println ("Добро пожаловать в приложение \"Твой Фитнес-трекер\". Выберите необходимое действие: ");
        System.out.println ("1. Ввести количество шагов за определенный день (1-30).");
        System.out.println ("2. Напечатать статистику за определённый месяц (1-12).");
        System.out.println ("3. Изменить цель по количеству шагов за день.");
        System.out.println ("4. Выйти из приложения.");
    }
}

