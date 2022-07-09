
package Hammurabi;

import java.util.Random;
import java.util.Scanner;


//public class Hammurabi {
//    Random rand = new Random();  // this is an instance variable
//    Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) { // required in every Java program
//        new Hammurabi().playGame();
//    }
//
//    void playGame() {
//        // declare local variables here: grain, population, etc.
//        // statements go after the declations
//    }

    //other methods go here


public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    //        Counter
    int population = 100;
    int immigrants = 5;
    int starved = 0;
    int grainEatenByRats = 200;
    int bushels = 2800; //2800 bushels of grain in storage
    int acresOwned =  1000;// acres of land
    int price = rand.nextInt(26 - 17 + 1) + 17;  //Land value is 19 bushels/acre
    int years = 1;
    int harvest = rand.nextInt(6 - 1 + 1) + 1;





    public static void main(String[] args){
//        new Hammurabi().playGame();
//        Random rand = new Random();
//        Scanner scanner = new Scanner(System.in);
//
//        //        Counter
//        int population = 100;
//        int immigrants = 5;
//        int starved = 0;
//        int grainEatenByRats = 200;
//        int bushels = 2800; //2800 bushels of grain in storage
//        int acresOwned =  1000;// acres of land
//        int price = rand.nextInt(26 - 17 + 1) + 17;  //Land value is 19 bushels/acre
//        int years = 1;
//        int harvest = rand.nextInt(6 - 1 + 1) + 1;

    }

    void playGame(){
        while (years <= 10){
        System.out.println("O great Harambe!\n" +
                "You are in year " + years + " of your ten year rule.\n" +
                "In the previous year " + starved + " people starved to death.\n" +
                "In the previous year " + immigrants + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushels + " bushels at " + harvest + " bushels per acre.\n" +
                "Rats destroyed " + grainEatenByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.\n");
            years++;
            int temp = 0;
            askHowManyAcresToBuy(price, bushels);
            askHowManyAcresToSell(acresOwned);

            break;
        }
    }

    private int askHowManyAcresToBuy(int price, int bushels){
        System.out.print("How many acres of land would you like to buy? ");
        int input = scanner.nextInt();
        if(bushels<0){
            System.out.println("Does not work!");
        } else {
            bushels-=price*input;
        }
        acresOwned+= input;
        System.out.println(bushels);
        return input;
    }

    private int askHowManyAcresToSell(int acres){
        System.out.print("How many acres of land would you like to sell? ");
        int input = scanner.nextInt(); //Input number how much acres to sell
        if (bushels<0 || acres < -input){
            System.out.println("Does not work!"); //If you input # that is less than 0, it shall not work
        } else {
            bushels+=price*input;
        }
        acresOwned-=input;
        System.out.println(bushels);

        return input;
//        System.out.print("How many acres of land would you like to sell? ");
//        int input = scanner.nextInt(); //Input number how much acres to sell
//        input = acres;
//        bushels += price * input;
//        System.out.println(bushels);
//        return input;
    }

    public int plagueDeaths(int population){
        int death = 0;

        return death;
    }


}


