package machine;

import java.util.Scanner;
import java.lang.*;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);
    static int water = 400, milk = 540, coffee = 120, cups = 9, money = 550;
    public static void main(String[] args) {
        String action = "";
        while (!action.equals("exit")) {
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            if (action.equals("exit")) {
                break;
            } else {
                performAction(action);
            }
        }

    }

    private static void performAction(String action) {
        if (action.equals("buy")) {
            buy();
        } else if (action.equals("fill")) {
            fill();
        } else if (action.equals("take")) {
            take();
        } else if (action.equals("remaining")) {
            currentCoffeeMachineStats();
        }
    }

    private static void take() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    private static void fill() {

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
        String input = scanner.next();
        if(input.equals("back"))
            return;
        int coffeeOption = Integer.parseInt(input);
        if (coffeeOption == 1) {
            if (water < 250 ){
                System.out.println("Sorry, not enough water!");
            } else if (coffee < 16) {
                System.out.println("Sorry, not enough coffee beans!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 250;
                coffee -= 16;
                money += 4;
                cups--;
            }
        } else if (coffeeOption == 2) {
            if (water < 350 ){
                System.out.println("Sorry, not enough water!");
            } else if (coffee < 20) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (milk < 75) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 350;
                milk -= 75;
                coffee -= 20;
                money += 7;
                cups--;
            }
        } else {
            if (water < 200 ){
                System.out.println("Sorry, not enough water!");
            } else if (coffee < 12) {
                System.out.println("Sorry, not enough coffee beans!");
            } else if (milk < 100) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 200;
                milk -= 100;
                coffee -= 12;
                money += 6;
                cups--;
            }
        }

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
        return scanner.next();
    }
}
