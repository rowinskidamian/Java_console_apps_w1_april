package pl.rowinskidamian.github.workshops.consoleapps;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void startApp() {
        System.out.println("\n yes yes yes... działamy!\n");
        StartProgram();
    }

    public static void StartProgram() {
        int computerRandomNumber = drawRandomNumber();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz liczbę, a powiem Ci, czy to jest liczba, którą wylosowałem:");

        while (true) {

            String inputFromUser = scanner.next();
            int numberFromUser;

            try {
                numberFromUser = Integer.parseInt(inputFromUser);

                if (numberFromUser == computerRandomNumber) {
                    System.out.println("\nZgadłeś liczbę: " + computerRandomNumber + ". Gratulacje!");
                    break;
                } else if (numberFromUser > computerRandomNumber) {
                    System.out.println("Podałeś liczbę większą od wylosowanej, zgaduj dalej");
                } else {
                    System.out.println("Podałeś liczbę mniejszą od wylosowanej, zgaduj dalej");
                }

            } catch (NumberFormatException e) {
                System.out.println("Niepoprawna liczba podaj jeszcze raz.");
            }

        }


    }

    private static int drawRandomNumber() {
        Random drawedRandomNumber = new Random();
        int random = drawedRandomNumber.nextInt(100);
        return random;
    }


}
