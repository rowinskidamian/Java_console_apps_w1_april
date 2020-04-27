package pl.rowinskidamian.github.workshops.consoleapps;

import java.util.Scanner;

public class ComputerGuessIn10Moves {

    public static void startApp() {

        int min = 0;
        int max = 1000;
        int userAnswer;
        final int ANSWER_TOO_MUCH = 1;
        final int ANSWER_TOO_LESS = 2;
        final int ANSWER_GUESSED = 3;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pomyśl o liczbie całkowitej od 0 do 1000, a zgadnę ją do 10 ruchów");

        while (true) {

            int guess = (max - min) / 2 + min;

            System.out.println("Zgaduję: " + guess);

            System.out.println("Wybierz odpowiedź:");
            System.out.println("1 - za dużo");
            System.out.println("2 - za mało");
            System.out.println("3 - zgadłeś!");

            userAnswer = scanner.nextInt();

            if (userAnswer == ANSWER_GUESSED) {
                System.out.println("Wygrałem! Dzięki za zabawę!");
                break;
            } else if (userAnswer == ANSWER_TOO_MUCH) {
                max = guess;
            } else if (userAnswer == ANSWER_TOO_LESS) {
                min = guess;
            }

        }




    }

}
