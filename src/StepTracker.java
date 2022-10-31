
/**
 * В классе StepTracker реализована основная логика приложения. Внутри класса создан класс MonthData, объектом которого
   является массив из 30 дней. Далее в основном классе создан объект monthToData в формате массива. ¬ конструкторе StepTracker
   массив инициализирован.
 * @see Main
 * @see Converter
 */

import java.util.Scanner;

public class StepTracker {
    Converter conv = new Converter();
    int stepsGoal = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    /**
     * Метод для ввода и сохранения количества шагов.
     * Содержит логику на случай ввода некорректного значения месяца, дня и кол-ва шагов.
     * @param month месяц
     * @param day день
     * @param steps количество шагов
     */
    void saveSteps (int month, int day, int steps) {
        if (steps < 0) {
            System.out.println ("Число шагов не может быть меньше 0. Повторие ввод.");
            System.out.println();
            return;
        }
        if (month < 0 || month >= monthToData.length) {
            System.out.println ("Некорректный ввод месяца. ѕовторите ввод.");
            System.out.println();
            return;
        }
        if (day < 0 || day >= monthToData[month].days.length) {
            System.out.println ("Некорректный ввод дня. Повторите ввод.");
            System.out.println();
            return;
        }
        monthToData[month].days[day] = steps;
        System.out.println ("Значение сохранено.");
    }

    /**
     * Метод выводящий статистику за определенный месяц.
     * Содержит логику на случай ввода некорректного значения месяца.
     * @param month мес€ц
     */
    void stat (int month) {
        int sum = 0;
        int max = 0;

        if (month < 0 || month >= monthToData.length) {
            System.out.println ("Некорректный ввод месяца. Повторите ввод.");
            System.out.println();
            return;
        }

        for (int j = 0; j < monthToData[month].days.length; j++) {
            sum += monthToData[month].days[j];
            max = Math.max(max, monthToData[month].days[j]);
        }

        System.out.println("Пройденные шаги по дням:");
        for (int j = 0; j < monthToData[month].days.length-1; j++) {
            System.out.print( (j+1) + " день: "  + monthToData[month].days[j] + ", ");
        }
        System.out.print( (monthToData[month].days.length) + " день: "  + monthToData[month].days[monthToData[month].days.length-1]);
        System.out.println();
        System.out.println ("Суммарное число шагов пройденных за месяц " + (month+1) + " равно: " + sum);
        System.out.println ("Максимальное число шагов пройденных за один день: " + max);
        System.out.println ("Среднее число шагов в день: " + sum/monthToData[month].days.length);
        System.out.println ("Суммарная дистанция, пройденная за месяц, км: " + conv.convertDist(sum) + ".");
        System.out.println ("Суммарное количество сожженых килокалорий за месяц, ккал: " + conv.convertCals(sum) + ".");
        System.out.println ("Лучшая серия за месяц (число дней, в течение которых вы превышали дневную норму шагов): " + bestSeries(month));
    }

    /**
     * Метод для определения лучшей серии за месяц
     * @param month месяц
     * @return лучшая серия за месяц
     */
    int bestSeries (int month) {
        int count = 0;
        int best = 0;
        for (int j = 0; j < monthToData[month].days.length; j++) {
            if (monthToData[month].days[j] >= stepsGoal) {
                count++;
                best = Math.max(best, count);
            } else {
                count = 0;
            }
        }
        return best;
    }

    /**
     * Метод для задания нового целевого количества шагов
     * @param newStepsGoal новое целевое кооличество шагов
     */
    void newStepsGoal(int newStepsGoal) {
        if (newStepsGoal >= 0) {
            stepsGoal = newStepsGoal;
            System.out.println("Новая цель по количеству шагов в день: " + stepsGoal + ". Так держать!");
        } else {
            System.out.println("Число шагов не может быть меньше 0.");
        }
    }

    /**
     * Метод для проверки, что введено именно число, а не символы
     * @param n ввод с консоли
     */
    void symbolCheck (Scanner n) {
         if (!n.hasNextInt()) {
             System.out.println("Некорректный ввод. Пожалуйста, введите число.");
             return;
         }
     }

    class MonthData {
        int[] days;
        public MonthData() {
            days = new int[30];
        }
    }

}



