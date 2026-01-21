package collections;

import java.util.List;

public class  NumberUtils {

    public static double sum(List<? extends Number> listNumbers){
        double sum = 0.0;
        for (Number number : listNumbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void addToIntList(List<? super Integer> listNumbers, Integer element){
        listNumbers.add(element);
    }


}
