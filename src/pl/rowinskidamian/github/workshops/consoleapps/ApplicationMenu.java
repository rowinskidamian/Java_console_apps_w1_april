package pl.rowinskidamian.github.workshops.consoleapps;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ApplicationMenu {

    private static final int EXIT = 0;
    private static final int GUESS_IN_10 = 1;
    private static final int GUESS_NUMBER_GAME = 2;
    private static final int DICE_THROWER = 3;
    private static final int LOTTO_SIMULATOR = 4;
    private static final int PARSING_WEBSITE = 5;

    private static int[] menuActions = {EXIT, GUESS_IN_10, DICE_THROWER, GUESS_NUMBER_GAME, LOTTO_SIMULATOR,
            PARSING_WEBSITE};

    public static void main(String[] args) {
        printWelcomeMessage();
        while (true) {
            showMenu();
            int userInput = getDecision();
            if (validAction(userInput)) {
                if (userInput == EXIT) {
                    exitAction();
                    break;
                }
                executeAction(userInput);
            } else {
                printWrongMessage();
            }
        }
        printGoodbyeMessage();
    }

    private static void printWrongMessage() {
        System.out.println("\nCoś poszło nie tak, wprowadź poprawny numer z menu.");
    }

    private static void executeAction(int userInput) {

        switch (userInput) {
            case GUESS_IN_10:
                ComputerGuessIn10Moves.startApp();
                break;
            case DICE_THROWER:
                DiceThrower.startApp();
                break;
            case GUESS_NUMBER_GAME:
                GuessNumberGame.startApp();
                break;
            case LOTTO_SIMULATOR:
                LottoSimulator.startApp();
                break;
            case PARSING_WEBSITE:
                ParsingWebsite.startApp();
                break;

        }
    }

    private static void printGoodbyeMessage() {
        System.out.println("Miło było Cię obsługiwać... ;( ");
    }

    private static void exitAction() {
        System.out.println("Kończę działanie...");
    }

    private static boolean validAction(int userInput) {
        int[] validAction = menuActions;
        Arrays.sort(validAction);
        int index = Arrays.binarySearch(validAction, userInput);
        return index >= 0;
    }

    private static int getDecision() {
        System.out.print("\nTwój wybór wpisz tutaj: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Nie wprowadziłeś liczby, spróbuj ponownie.");
        }
        int decision = scanner.nextInt();
        scanner.nextLine();
        return decision;
    }

    private static void showMenu() {
        System.out.println("\nCo mogę dla Ciebie zrobić? Wpisz liczbę z menu:\n");
        System.out.println(EXIT + ") Wyłącz się");
        System.out.println(GUESS_IN_10 + ") Zgadnę Twoją liczbę w 10 ruchów");
        System.out.println(GUESS_NUMBER_GAME + ") Zgadnij moją liczbę");
        System.out.println(DICE_THROWER + ") Rzucajmy kośćmi");
        System.out.println(LOTTO_SIMULATOR + ") Pograjmy w lotto");
        System.out.println(PARSING_WEBSITE + ") Na koniec na poważnie - zobaczmy newsy z BusinessInsider.com.pl");

    }

    private static void printWelcomeMessage() {
        System.out.println();
        System.out.println("    ******************************************************");
        System.out.println("**************************************************************");
        System.out.println("        Jestem APLIKATOR2020 mam dla Ciebie kilka gier!");
        System.out.println("**************************************************************");
        System.out.println("    ******************************************************");
        System.out.println();
    }
}