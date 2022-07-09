package Hammurabi;

import java.util.Random;
import java.util.Scanner;



public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    //        Counter
    private int population;
    private int immigrants;
    private int starved;
    private int grainEatenByRats;
    private int bushels; //2800 bushels of grain in storage
    private int acresOwned;// acres of land
    private int price;  //Land value is 19 bushels/acre
    private int years;
    private int harvest;

    public Hammurabi() {
        this.population = 100;
        this.immigrants = 5;
        this.starved = 0;
        this.grainEatenByRats = 200;
        this.bushels = 2800;
        this.acresOwned = 1000;
        this.price = rand.nextInt(26 - 17 + 1) + 17;
        this.harvest = rand.nextInt(6 - 1 + 1) + 1;
        this.years = 1;
    }


    public static void main(String[] args) {
        new Hammurabi().playGame();
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

    }

    void playGame() {

        this.population = 100;
        this.immigrants = 5;
        this.starved = 0;
        this.grainEatenByRats = 200;
        this.bushels = 2800;
        this.acresOwned = 1000;
        this.price = rand.nextInt(26 - 17 + 1) + 17;
        this.harvest = rand.nextInt(6 - 1 + 1) + 1;
        this.years = 1;

        while (years <= 10) {
            printSummary();
            years++;
            int temp = 0;
//            askHowManyAcresToBuy(price, bushels);
//            askHowManyAcresToSell(acresOwned);


            boolean isIncorrectInput = true;
            while (isIncorrectInput) {
                System.out.println("Would you like to buy or sell acres? Press 1 to buy. Press 2 to sell.\n");
                int input = askForInput();
                if (input == 1) {
                    askHowManyAcresToBuy(price, bushels);
                    isIncorrectInput = false;
                } else if (input == 2) {
                    askHowManyAcresToSell(acresOwned);
                    isIncorrectInput = false;
                } else {
                    System.out.println("Pick 1 or 2.");
                }
            }

            System.out.println("How much grain do you want to feed your people?");
            askHowMuchGrainToFeedPeople(bushels);

            System.out.println("How many acres of land do you want to plant?");
            askHowManyAcresToPlant(acresOwned, population, bushels);
        }
    }

    private void printSummary(){
        System.out.println("O great Harambe!\n" +
                "You are in year " + years + " of your ten year rule.\n" +
                "In the previous year " + starved + " people starved to death.\n" +
                "In the previous year " + immigrants + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushels + " bushels at " + harvest + " bushels per acre.\n" +
                "Rats destroyed " + grainEatenByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.\n");
    }


    private int askHowManyAcresToBuy(int price, int bushels) {
        System.out.print("How many acres of land would you like to buy? ");
        int input = askForInput();
        if (enoughBushels(input) == true) {
            this.bushels -= this.price * input;
            this.acresOwned += input;
        }
        System.out.println(this.bushels);
        return input;
    }

    private int askHowManyAcresToSell(int acres) {

        System.out.print("How many acres of land would you like to sell? ");
        int input = askForInput(); //Input number how much acres to sell
        if (input <= 0 || this.acresOwned <= input) {
            System.out.println("Does not work!"); //If you input # that is less than 0, it shall not work
        } else {
            this.bushels += this.price * input;
        }
        this.acresOwned -= input;
        System.out.println(this.bushels);
        return input;

    }

    private int askHowMuchGrainToFeedPeople(int bushels) {
        int input = askForInput();
        this.bushels -= input;
        System.out.println(this.bushels);
        return input;
    }

    private int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int input = askForInput();
        if (input <= 0) {
            System.out.println("Try again");
        } else if (input > 10 * this.population) {
            System.out.println("You only have " + this.population + " to work.");
        } else {
            this.bushels += this.harvest * this.acresOwned;
            this.bushels -= input;
        }
        System.out.println(this.bushels);
        return input;
    }

    private int askForInput() {
        int input;
        do {
            System.out.println("Enter a positive number.");
            while (!scanner.hasNextInt()) {
                System.out.println("Not a number.");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input <= 0);
        return input;
    }

    private boolean enoughBushels(int input) {
        boolean isNotEnoughBushels = true;
        while (input > this.bushels) {
            System.out.println("Not enough bushels! Go lower!");
            isNotEnoughBushels = false;
            scanner.next();
        }
        return isNotEnoughBushels;
    }
}
