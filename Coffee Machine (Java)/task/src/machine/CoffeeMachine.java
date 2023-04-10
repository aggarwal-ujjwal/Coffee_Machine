package machine;

import java.util.Scanner;
import java.lang.*;

public class CoffeeMachine {
    public static void main(String[] args) {

//        System.out.println("Starting to make a coffee\n" +
//                "Grinding coffee beans\n" +
//                "Boiling water\n" +
//                "Mixing boiled water with crushed coffee beans\n" +
//                "Pouring coffee into the cup\n" +
//                "Pouring some milk into the cup\n" +
//                "Coffee is ready!");

//        System.out.println("Write how many cups of coffee you will need: ");
//        Scanner scanner = new Scanner(System.in);
//        int noOfCups = scanner.nextInt();
//        System.out.printf("For %d cups of coffee you will need:\n",noOfCups);
//        System.out.printf("%d ml of water\n", noOfCups*200);
//        System.out.printf("%d ml of milk\n", noOfCups*50);
//        System.out.printf("%d g of coffee beans\n", noOfCups*15);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = input(scanner);

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = input(scanner);

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = input(scanner);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = input(scanner);

        printCoffeeCups(water,milk,coffee,cups);


    }

    private static void printCoffeeCups(int water, int milk, int coffee, int cups) {
        int possibleCups = Math.min(water/200, Math.min(milk/50, coffee/15));
        if(possibleCups==cups){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCups > cups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)",possibleCups-cups);
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee" , possibleCups);
        }
    }

    public static int input(Scanner scanner) {k
        return scanner.nextInt();
    }
}
