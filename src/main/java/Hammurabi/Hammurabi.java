package Hammurabi;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    //        Counter
    private int population;
    private int immigrants;
    private int starved;
    private int grainsDestroyedByRats;
    private int bushels; //2800 bushels of grain in storage
    private int acresOwned;// acres of land
    private int price;  //Land value is 19 bushels/acre
    private int years;
    private int harvest;

    public Hammurabi() {
        this.population = 100;
        this.immigrants = 5;
        this.starved = 0;
        this.grainsDestroyedByRats = 200;
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
        this.immigrants = 0;
        this.starved = 0;
        this.grainsDestroyedByRats = 200;
        this.bushels = 2800;
        this.acresOwned = 1000;
        this.price = rand.nextInt(26 - 17 + 1) + 17;
        this.harvest = rand.nextInt(6 - 1 + 1) + 1;
        this.years = 1;

        while (years <= 10) {
            printSummary();
            years++;

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

            //System.out.println("How much grain do you want to feed your people?");
//            askHowMuchGrainToFeedPeople(bushels);

            //System.out.println("How many acres of land do you want to plant?");
            askHowManyAcresToPlant(acresOwned, population, bushels);

            starvationDeaths(population);

//            uprising( population, starved);
            if (uprising(population, starved) == true) {
                System.out.println("You lose, trash!");
                break;
            }

            plagueDeaths(population);

            immigrants(population, acresOwned, bushels);

            grainEatenByRats(bushels);

            if(years==10){
                System.out.println("You win!");
                break;
            }
        }
    }

    private void printSummary() {
        System.out.println("O great Harambe!\n" +
                "You are in year " + years + " of your ten year rule.\n" +
                "In the previous year " + starved + " people starved to death.\n" +
                "In the previous year " + immigrants + " people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "Harvesting was done at " + harvest + " bushels per acre.\n" +
                "Rats destroyed " +  grainsDestroyedByRats + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.\n");
    }


    private int askHowManyAcresToBuy(int price, int bushels) {
//        System.out.print("How many acres of land would you like to buy? ");
//        int input = askForInput();
//        if (enoughBushels(input) == true) {
//            this.bushels -= this.price * input;
//            this.acresOwned += input;
//        }
//        System.out.println(this.bushels);

        String message = "How many acres of land would you like to buy?";
        int maxAcres = bushels / price;
        int input = getNumber(message);
        while (input > maxAcres) {
            String newMessage = "Not enough bushals. You only have " + bushels + " bushels.";
            System.out.println(newMessage);
            input = getNumber(message);

        }

        return input;
    }

    private int askHowManyAcresToSell(int acres) {

        //System.out.print("How many acres of land would you like to sell? ");
        String message = "How many acres of land would you like to sell?";
        int input = getNumber(message);
        //int input = askForInput(); //Input number how much acres to sell
        while (input > acresOwned) {
            String newMessage = "You do not have enough acres to sell";
            System.out.println(newMessage);
            input = getNumber(message);
        }
        this.bushels += this.price * input;
        this.acresOwned -= input;
        System.out.println(this.bushels);
        return input;
//        if (input <= 0 || this.acresOwned <= input) {
//            System.out.println("Does not work!"); //If you input # that is less than 0, it shall not work
//        } else {
//            this.bushels += this.price * input;
//        }
//        this.acresOwned -= input;
//        System.out.println(this.bushels);
//        return input;
    }

    private int askHowMuchGrainToFeedPeople(int bushels) {
        String message = "How much grain do you want to feed your people?";
        int input = getNumber(message);
        while (input > population * 20) {
            String newMessage = "You do not have enough bushels to feed everyone";
            System.out.println(newMessage);
            input = getNumber(message);
        }
        this.bushels -= input;
        System.out.println(this.bushels);
        return input;
//        int input = askForInput();
//        this.bushels -= input;
//        System.out.println(this.bushels);
//        return input;
    }

    private int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        String message = "How many acres of land do you want to plant?";
        int input = getNumber(message);
        while (input < 0 || input > 10 * population) { //each person can only plant 10 acres
            String newMessage = "Try again";
            System.out.println(newMessage);
            input = getNumber(message);
        }
        this.bushels += this.harvest * input;
        this.bushels -= input;
        System.out.println(this.bushels);
        return input;
//        int input = askForInput();
//        if (input <= 0) {
//            System.out.println("Try again");
//        } else if (input > 10 * this.population) {
//            System.out.println("You only have " + this.population + " to work.");
//        } else {
//            this.bushels += this.harvest * this.acresOwned;
//            this.bushels -= input;
//        }
//        System.out.println(this.bushels);
//        return input;
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

//    private boolean enoughBushels(int input) {
//        boolean isNotEnoughBushels = true;
//        while (input > this.bushels) {
//            System.out.println("Not enough bushels! Go lower!");
//            isNotEnoughBushels = false;
//            scanner.next();
//        }
//        return isNotEnoughBushels;
//    }

//    int getNumber(String message) {
//        while (true) {
//            System.out.print(message);
//            try {
//                return scanner.nextInt();
//            }
//            catch (InputMismatchException e) {
//                System.out.println("\"" + scanner.next() + "\" isn't a number!");
//            }
//        }
//    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                int input = scanner.nextInt();
                if (input >= 0) {
                    return input;
                }
                throw new IllegalArgumentException("number is negative");
            } catch (IllegalArgumentException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a positive number!");
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

    private int plagueDeaths(int population) {
//        boolean value = rand.nextInt((100 / 15)) == 0;
        if (new Random().nextDouble() <= 0.15) {
//            population = population / 2; //Plague occurs and half the population dies
            System.out.print("A horrible plague has occur! " + (population / 2) + " people died...\n");
            this.population = population / 2;
            return this.population;
        } else {
            System.out.print("No plague this year!\n");
            return 0; //Plague does not happen; population stays the same
        }
    }

    public int starvationDeaths(int population) {
//        int maxFeed = bushels / 20;
//        while (population > askHowMuchGrainToFeedPeople(maxFeed)){
//            population = population - ((bushels * 20) * (askHowMuchGrainToFeedPeople(bushelsFedToPeople)));
//        }
//        return population;
        int x = askHowMuchGrainToFeedPeople(bushels);

        int numberOfPeopleFed = (x / 20);
        if (numberOfPeopleFed > 0) {
            this.starved = population - numberOfPeopleFed;
            System.out.print("This year, we have " + this.starved + " People Starved...\n");
            this.population = numberOfPeopleFed;
            return this.starved;
        } else {
            System.out.print("No people starved this year!\n");
            return 0;

        }
    }

    private boolean uprising(int population, int starved) {
//        if (population == population / 0.45){
//            System.out.println("The population has started an uprising");
//            }
//        return true;

        if (starved > 0.45 * population) {
            System.out.print("You have made " + starved + " starved this year and that is more than 45% of the population!" +
                    " You are dismissed as the ruler.");
            return true;
        }
        return false;
    }

    private int immigrants(int population, int acresOwned, int bushels) {
////        Nobody will come to the city if people are starving (so don't call this method).
////        If everyone is well-fed,
////        compute how many people come to the city as:
////        `(20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1`.
//            population = ((20 * acresOwned) + (bushels)) / (100 * population) + 1;
//        return population;
        int numOfStarved = population - (bushels / 20);
        if (numOfStarved == 0) {
            System.out.print("Nobody starved this year!\n");
            return 0;
        } else {
            int numOfImmigrants = (20 * acresOwned + bushels) / (100 * population) + 1;
            System.out.print("This year " + numOfImmigrants + " came to our kingdom.\n");
            this.population += numOfImmigrants;
            return numOfImmigrants;
        }
    }

    private int grainEatenByRats(int bushels) {
//        > There is a 40% chance that you will have a rat infestation.
//        When this happens, rats will eat somewhere between 10% and 30% of your grain.
//        Return the amount of grain eaten by rats (possibly zero).

        if (new Random().nextDouble() <= 0.40) {
            System.out.print("You got a rat infestation\n");
            this.grainsDestroyedByRats = rand.nextInt((30-10)*100);
            this.bushels -= this.grainsDestroyedByRats;

            } else {
            grainsDestroyedByRats = 0;
            return this.bushels;
        }
        return this.bushels;
    }

}
