
/**
 * В классе Converter осуществляется конвертация суммарного числа пройденных шагов в пройденную дистанцию (км) и
   в сожженные килокалории.
 * В классе StepTracker создан объект conv, который обращается к методам класса Converter при выводе статистики методом stat.
 * @see StepTracker
 */

public class Converter {
    static final double DISTANCE = 0.75d;
    static final double CALS = 0.05d; // перевод калорий в килокалории выполнен сразу здесь

    /**
     * Метод для определения пройденной дистанции в км
     * @param sum
     * @return пройденная дистанция в км
     */
    double convertDist (int sum) {
        return (sum*DISTANCE/1000);
    }

    /**
     * Метод для определения числа сожженных ккал
     * @param sum
     * @return число сожженных ккал
     */
    double convertCals (int sum) {
        return (sum*CALS);
    }
}
