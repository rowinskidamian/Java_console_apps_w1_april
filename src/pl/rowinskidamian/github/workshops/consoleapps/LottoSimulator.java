package pl.rowinskidamian.github.workshops.consoleapps;

// w tym zadaniu podzielić na metody plus try catche zrobić jeszcze oraz zrobić, żeby numery użytkonika były mniejsze niż 49

import java.util.Random;
import java.util.Scanner;

public class LottoSimulator {

    public static void startApp() {

        // pytam użytkownika o 6 liczb

        System.out.println("Podaj 6 liczb, a sprawdzę, czy trafiłeś szóstkę, albo przynajmniej 1 w lotto :)");

        int[] numbersPuttedByUser = userNumberInputs();

        // generuję 6 liczb losowych

        int[] lottoSixNumbers = generateSixDiffNumbers();

        // sprawdzam liczby użytkownika i liczby wygenerowane, wyświetlam wyniki

        printResultsOfLotto(numbersPuttedByUser, lottoSixNumbers);

    }

    private static int[] userNumberInputs() {

        Scanner scanner = new Scanner(System.in);
        int[] numbersPuttedByUser = new int[6];
        int userNumbersCounter = 0;
        String inputFromUser;
        int numberFromUser;

        while (true) {

            System.out.println("Podaj liczbę w zakresie od 1 do 49:");
            inputFromUser = scanner.next();


            try {
                numberFromUser = Integer.parseInt(inputFromUser);

                if (numberFromUser!= 0 && checkIfNumberWasAlreadyDrawed(numberFromUser, numbersPuttedByUser)) {
                    System.out.println("Tą liczbę już podałeś, podaj kolejną, inną.");
                }

                for (int i = 0; i < numbersPuttedByUser.length; i++) {

                    if (numberFromUser > 0 && numberFromUser < 49
                            && !checkIfNumberWasAlreadyDrawed(numberFromUser, numbersPuttedByUser)) {
                        numbersPuttedByUser[userNumbersCounter] = numberFromUser;
                        userNumbersCounter++;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Błąd, wprowadź poprawną liczbę.");
            }

            if (userNumbersCounter == 6) {
                System.out.println("Podałeś 6 różnych liczb, super!");
                break;
            }

        }
        return numbersPuttedByUser;
    }

    private static void printResultsOfLotto(int[] numbersPuttedByUser, int [] lottoSixNumbers) {

        int[] luckyNumbers = new int[6];
        int counterLuckyNumbers = 0;

        for (int i = 0; i < numbersPuttedByUser.length; i++) {
            for (int i1 = 0; i1 < lottoSixNumbers.length; i1++) {
                if (numbersPuttedByUser[i] == lottoSixNumbers[i1]) {
                    luckyNumbers[counterLuckyNumbers] = numbersPuttedByUser[i];
                    counterLuckyNumbers++;
                }
            }
        }

        System.out.println();
        System.out.println("Twoje liczby to:");
        for (int i = 0; i < numbersPuttedByUser.length; i++) {
            System.out.print(numbersPuttedByUser[i] + " ");
            if (i == numbersPuttedByUser.length - 1) {
                System.out.println();
            }
        }

        System.out.println("Liczby lotto to:");
        for (int i = 0; i < lottoSixNumbers.length; i++) {
            System.out.print(lottoSixNumbers[i] + " ");
            if (i == lottoSixNumbers.length - 1) {
                System.out.println();
            }
        }

        System.out.println("Trafiłeś liczb: " + counterLuckyNumbers);
        for (int i = 0; i < luckyNumbers.length; i++) {
            if (luckyNumbers[i] > 0) {
                System.out.println(luckyNumbers[i]);
            }
        }
    }

    private static int[] generateSixDiffNumbers() {
        Random randomNumberGenerated = new Random();
        int[] lottoNumbers = new int[6];

        for (int i = 0; i < lottoNumbers.length; i++) {
            int currentRandomNumber;

            while (true) {
                currentRandomNumber = randomNumberGenerated.nextInt(49);

                if (currentRandomNumber > 0 && !checkIfNumberWasAlreadyDrawed(currentRandomNumber, lottoNumbers)) {
                    lottoNumbers[i] = currentRandomNumber;
                    break;
                }
            }

        }

        return lottoNumbers;

    }

    private static boolean checkIfNumberWasAlreadyDrawed(int currentNumber, int[] tableOfNumbers) {
        boolean result = false;
        for (int i1 = 0; i1 < tableOfNumbers.length; i1++) {
            if (currentNumber == tableOfNumbers[i1]) {
                return true;
            }
        }
        return result;
    }


}
