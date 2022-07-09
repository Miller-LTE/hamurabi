
package Hamurabi;
import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Random;
import java.util.Scanner;


public class Hammurabi {
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
    }

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
        new Hammurabi().playGame();
    }

    void playGame(){
        System.out.println("O great Harambe!\n" +
                "You are in year " + years + " of your ten year rule.\n" +
                "In the previous year " + starved + " people starved to death.\n" +
                "In the previous year " + immigrants + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushels + " bushels at " + harvest + " bushels per acre.\n" +
                "Rats destroyed " + grainEatenByRats + " bushels, leaving 2800 bushels in storage.\n" +
                "The city owns 1000 acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.\n");

        while (years <= 10){
            years++;
            askHowManyAcresToBuy(price, bushels);

        }
    }

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

    public int plagueDeaths(int population){
        int death = 0;

        return death;
    }


}
}

