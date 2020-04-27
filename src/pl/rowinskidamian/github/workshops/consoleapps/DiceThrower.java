package pl.rowinskidamian.github.workshops.consoleapps;

import java.util.Random;
import java.util.Scanner;

public class DiceThrower {

    public static void startApp() {

        int[] diceOptions = new int[]{3, 4, 6, 8, 10, 12, 20, 100};
        int diceChoosenByUser;
        int multiplier;
        int modifier;
        int resultOfDiceThrowing;
        int resultOfDiceThrowingPlusModifier;

        System.out.println("Wprowadź jaki chcesz wykonać rzut kostką, wg wzoru xDy+z .");
        System.out.println("Dla przykładu 2x rzut kostką 10 ścienną +3 to: 2D10+3");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        System.out.println(userInput);

        diceChoosenByUser = checkDice(diceOptions, userInput);

        multiplier = checkMultiplier(userInput);

        resultOfDiceThrowing = throwDice(diceChoosenByUser, multiplier);

        modifier = checkModifier(userInput);

        resultOfDiceThrowingPlusModifier = resultOfDiceThrowing + modifier;

        System.out.println("Wynik rzutu Twojej kostki to:");
        System.out.println(resultOfDiceThrowingPlusModifier);

    }

    private static int throwDice(int diceChoosenByUser, int multiplier) {
        Random random = new Random();
        int diceThrowingResult = 0;
        int counterResults = 0;
        int randomNumber;

        do {
            randomNumber = random.nextInt(diceChoosenByUser);
            if (randomNumber > 0) {
                diceThrowingResult += randomNumber;
                counterResults++;
            }
        } while (counterResults < multiplier);


        return diceThrowingResult;

    }

    private static int checkMultiplier(String userInput) {
        char[] userInputInChar = userInput.toCharArray();
        if (Character.isDigit(userInputInChar[0])) {
            return Character.getNumericValue(userInputInChar[0]);
        } else return 1;

    }

    private static int checkModifier(String userInput) {

        if (userInput.contains("+")) {
            String[] userInputSplitted = userInput.split("\\+");
            return +Integer.parseInt(userInputSplitted[1]);
        } else if (userInput.contains("-")) {
            String[] userInputSplitted = userInput.split("\\-");
            int outcome = -Integer.parseInt(userInputSplitted[1]);
            System.out.println(outcome);
            return outcome;
        } else {
            return 0;
        }
    }

    public static int checkDice(int[] diceOptions, String userInput) {
        String currentDice = "";
        for (int i = 0; i < diceOptions.length; i++) {
            currentDice = "D" + diceOptions[i];
            if (userInput.contains(currentDice)) {
                return diceOptions[i];
            }
        }
        return 0;
    }


}
