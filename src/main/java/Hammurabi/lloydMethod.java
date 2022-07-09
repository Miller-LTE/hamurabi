package Hammurabi;

import java.util.Random;
import java.util.Scanner;

public class lloydMethod {

    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);



    //        Counter
    int people = 100;
    int bushels = 2800; //2800 bushels of grain in storage
//    int acresOwned =  1000;// acres of land
//    int price = 20;  //Land value is 19 bushels/acre
//    int years = 1;
//
//        System.out.println("O great Harambe!\n" +
//                "You are in year 1 of your ten year rule.\n" +
//                " In the previous year 0 people starved to death.\n" +
//                "In the previous year 5 people entered the kingdom.\n" +
//                "The population is now 100.\n" +
//                "We harvested 3000 bushels at 3 bushels per acre." +
//                "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
//                "The city owns 1000 acres of land.\n" +
//                "Land is currently worth 19 bushels per acre.");
//
//        while (years <= 10){
//
//    }
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
