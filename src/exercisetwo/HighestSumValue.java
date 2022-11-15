package exercisetwo;

import java.util.ArrayList;
import java.util.List;

public class HighestSumValue {

    public static void highestValueSum(long[] numbers) {
        List<Long> sumNumbers = new ArrayList();
        long highestSumValue = 0;
        for (int i = 0; i <= numbers.length; i+=2) {
            sumNumbers.add(numbers[i]);
            highestSumValue += numbers[i];
        }

        int counter = 1;
        System.out.println("soma possível " + counter + ": " + sumNumbers + " => " + highestSumValue);

        long currentSumValue;
        List<Long> currentSumNumbers ;

        for(int i = 0; i < numbers.length-1; i++ ) {
            for (int j = i+2; j < numbers.length; j++) {
                counter++;
                currentSumNumbers = new ArrayList<>();
                currentSumNumbers.add(numbers[i]);
                currentSumValue = numbers[i];
                currentSumNumbers.add(numbers[j]);
                currentSumValue += numbers[j];
                System.out.println("soma possível "+ counter +": " + currentSumNumbers + " => " + numbers[i] + " + " + numbers[j] + " = " + currentSumValue);
                if (currentSumValue > highestSumValue) {
                    highestSumValue = currentSumValue;
                    sumNumbers = currentSumNumbers;
                }
            }
        }
        System.out.println("\n" + sumNumbers + " => " + highestSumValue);
    }
}
