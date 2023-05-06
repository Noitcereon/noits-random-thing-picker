package me.noitcereon;

import me.noitcereon.consoleui.InputTaker;
import me.noitcereon.functionality.GiftDelegator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("java:S106") // java:S106 = Warns against System.out.println
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Noit's Random Thing Picker has started!");
        System.out.println("Welcome to Noit's Random Thing Picker v" + ProjectInfo.VERSION);

        try (Scanner scanner = new Scanner(System.in)) {

            applicationLoop(scanner);

        } catch (Exception e) {
            LOGGER.error("Application crashed.", e.getCause());
            System.exit(1);
        }
        LOGGER.info("Exiting " + ProjectInfo.NAME + ProjectInfo.VERSION);
    }

    @SuppressWarnings("java:S2189") // Infinite loop detected, but there is System.exit, which the linter can't handle.
    private static void applicationLoop(Scanner scanner) {
        while (true) {
            System.out.println("Enter a command. Available commands: 'quit', 'generateGiftPairs'");
            String command = InputTaker.getInput(scanner);
            System.out.println("You entered: '" + command + "'");
            switch (command) {
                case "quit" -> System.exit(0);
                case "generateGiftPairs" -> generateGiftPairs(scanner);

                default -> System.out.println("Unknown command. Available commands are: 'quit', 'generateGiftPairs'");
            }
        }
    }

    private static void generateGiftPairs(Scanner scanner) {
        LOGGER.info("Starting 'generateGiftPairs'");
        System.out.println("To generate gift pairs you need to enter the names of the available gifters/receivers");
        System.out.println("You will now be asked to enter a name to be added to the list of available gifters/receivers");

        List<String> names = getNames(scanner);
        GiftDelegator giftDelegator = new GiftDelegator(names);
        Map<String, String> pairs = giftDelegator.selectGiftPairings();

        String pairsToString = pairs.toString();
        LOGGER.info("Pairs: {}", pairsToString);
    }

    private static List<String> getNames(Scanner scanner) {
        ArrayList<String> names = new ArrayList<>();
        while(true){
            System.out.println("Once you are done write 'done' and press enter.");
            String input = InputTaker.getInput(scanner);
            if(input.equals("done")) break;
            names.add(input);
            System.out.println("Current list: " + names);
        }
        return names;
    }

}