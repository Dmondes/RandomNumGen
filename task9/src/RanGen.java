package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RanGen {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter quit to quit, type anything else to continue");
        while (!scan.nextLine().toLowerCase().trim().equals("quit")) {
            int sum = 0;
            String store = "";
            for (int i = 0; i < 6; i++) {
                int num = rand.nextInt(10);
                store = store + String.valueOf(num);
                System.out.println(store);
            }
            sum = Integer.valueOf(store);
            ArrayList<Integer> guesses = new ArrayList<>();
            while (true) {
                System.out.println("Enter guess: ");
                String input = scan.nextLine();
                if (input.length() != 6) {
                    System.out.println("Invalid length");
                    continue;
                }
                try {
                    int guess = Integer.valueOf(input);
                    if (guesses.contains(guess)) {
                        System.out.println("Already guessed this number");
                        continue;
                    } else {
                        guesses.add(guess);
                    }
                    if (guess > sum) {
                        System.out.println("Number is lower");
                    } else if (guess < sum) {
                        System.out.println("NUmber is higher");
                    } else {
                        System.out.println("Congrats! You win!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }
            System.out.println(sum);
            guesses.forEach((n) -> {
                System.out.println(n);
            });
        }
        scan.close();
    }
}