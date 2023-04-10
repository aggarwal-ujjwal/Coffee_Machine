package machine;

import java.util.Scanner;
import java.lang.*;

public class CoffeeMachine {
    
    static int water = 400, milk = 540, coffee = 120, cups = 9, money = 550;
    public static void main(String[] args) {

        currentCoffeeMachineStats();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take): ");
        String action = input(scanner);
        
        performAction(action);
        
        currentCoffeeMachineStats();
    }

    private static void performAction(String action) {
        if (action.equals("buy")) {
            buy();
        } else if (action.equals("fill")) {
            fill();
        } else if (action.equals("take")) {
            take();
        }
    }

    private static void take() {
        System.out.printf("I gave you $%d", money);
        money = 0;
    }

    private static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scanner = new Scanner(System.in);
        int coffeeOption = scanner.nextInt();
        if (coffeeOption == 1) {
            water -= 250;
            coffee -= 16;
            money +=4;
        } else if (coffeeOption == 2) {
            water -= 350;
            milk -= 75;
            coffee -= 20;
            money += 7;
        } else {
            water -= 200;
            milk -= 100;
            coffee -= 12;
            money += 6;
        }
        cups--;
    }

    private static void currentCoffeeMachineStats() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", water, milk, coffee, cups, money);
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

    public static String input(Scanner scanner) {
        return scanner.nextLine();
    }
}
