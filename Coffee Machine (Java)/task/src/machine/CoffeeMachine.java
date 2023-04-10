package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

//        System.out.println("Starting to make a coffee\n" +
//                "Grinding coffee beans\n" +
//                "Boiling water\n" +
//                "Mixing boiled water with crushed coffee beans\n" +
//                "Pouring coffee into the cup\n" +
//                "Pouring some milk into the cup\n" +
//                "Coffee is ready!");

        System.out.println("Write how many cups of coffee you will need: ");
        Scanner scanner = new Scanner(System.in);
        int noOfCups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n",noOfCups);
        System.out.printf("%d ml of water\n", noOfCups*200);
        System.out.printf("%d ml of milk\n", noOfCups*50);
        System.out.printf("%d g of coffee beans\n", noOfCups*15);
    }
}
