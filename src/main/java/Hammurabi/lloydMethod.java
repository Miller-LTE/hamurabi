package Hammurabi;

import java.util.Random;
import java.util.Scanner;

public class lloydMethod {

    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    private int askHowManyAcresToBuy(int price, int bushels){
        System.out.print("How many acres of land would you like to buy? ");
        bushels = scanner.nextInt();
        return price;
    }
    private int askHowManyAcresToSell(int acres){
        System.out.print("How many acres of land would you like to sell? ");
        acres = scanner.nextInt();
        return acres;
    }
    private int askHowMuchGrainToFeedPeople(int bushels){
        System.out.print("How much grain to feed people? ");
        bushels = scanner.nextInt();
        return bushels;
    }
    private int askHowManyAcresToPlant(int acres, int population, int bushels){
        System.out.print("How much acres of seed do you want to plant? ");
//        int canPlant = population * acres;
        acres = scanner.nextInt();
        if (acres > (population * 10) && bushels * acres >= acresOwned){
            System.out.print("Not enough people to plant the fields... Try again.");
        }

        else return acres;
        return acres;
    }
}
