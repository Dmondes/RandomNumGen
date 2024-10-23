package task10.src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class TenGen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(1, 101);
            numList.add(num);
        }
        Collections.shuffle(numList);
        int first = numList.get(0);
        System.out.println(first);
        ArrayList<Integer> guesses = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int upperBound = 100;
            int lowerBound = 0;
            while (true) {
                int next = numList.get(i);
                System.out.println("Enter guess");
                int guess = Integer.valueOf(scan.nextLine());
                if (next == guess) {
                    System.out.println("You are right! Next");
                    break;
                }

                if (next > guess) {
                    System.out.println("Number is higher");
                    guesses.add(guess);
                    if (guess > lowerBound){
                        lowerBound = guess;
                    }
                } else if (next < guess) {
                    System.out.println("Number is lower");
                    guesses.add(guess);
                    if (guess < upperBound || upperBound == 0){
                        upperBound = guess;
                    }
                }
                int upCount = 0;
                int lowCount = 0;
                for (int j = guess + 1; j <= upperBound; j++) {

                    upCount++;
                }
                for (int k = guess; k > lowerBound; k--) {
                    lowCount++;
                }
                if (guesses.size() > 1) {
                    System.out.println(
                            "Last guess: " + guesses.get(guesses.size() - 1) + " Upper: " + upCount + ", Lower: "
                                    + lowCount);
                } else {
                    System.out.println("Upper: " + upperBound + ", Lower: " + lowerBound);
                }
            }

        }
        System.out.println("Number list:");
        numList.forEach((n) -> {
            System.out.print(n + " ");
        });
        System.out.println("Guesses list");
        guesses.forEach((n) -> {
            System.out.print(n + " ");
        });
        scan.close();
    }

}
