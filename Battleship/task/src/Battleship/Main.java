package Battleship;

import Ships.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean playing = true;
        int count1 = 17;
        int count2 = 17;

        // Create the battlefield 1
        char[][] twoD_arr1 = new char[10][10];
        // create the battlefleet 1

        BattleFleet BattleFleet1 = new BattleFleet();

        //set-up
        BattleField BattleField1 = playersSetUp(1, twoD_arr1, BattleFleet1);

        //prepare the guns
        CanonShot CanonShot1 = new CanonShot();

        // swap turn ---------
        swapTurns();

        // Create the battlefield 2
        char[][] twoD_arr2 = new char[10][10];

        // create the battlefleet 2
        BattleFleet BattleFleet2 = new BattleFleet();

        // create the battlefleet 2
        BattleField BattleField2 = playersSetUp(2, twoD_arr2, BattleFleet2);

        //prepare the guns
        CanonShot CanonShot2 = new CanonShot();

        while (playing) {

            //check for lives --------
            if(count1 == 0) {
                playing = false;
                System.out.println("Player 2 sank the last ship. You won. Congratulations!");
                break;
            }

            if(count2 == 0) {
                playing = false;
                System.out.println("Player 1 sank the last ship. You won. Congratulations!");
                break;
            }

            //next to play --------
            swapTurns();

            //Take a shot 1! --------
            gameSenario(twoD_arr2, BattleField1);

            count2 = fireCanon(BattleField2, CanonShot1, BattleFleet2, count2);
            //count1 = displayResult(result1, count1);

            //next to play --------
            swapTurns();

            //Take a shot 2! -------
            gameSenario(twoD_arr1, BattleField2);

            count1 = fireCanon(BattleField1, CanonShot2, BattleFleet1, count1);
            //count2 = displayResult(result2, count2);


        }
    }

    public static void gameSenario(char[][] two_dim_array, BattleField BattleField) {
        //Take a shot  --------
        displayFog(two_dim_array);
        System.out.println("---------------------");
        BattleField.printGrid();
    }

    public static void swapTurns(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter and pass the move to another player\n...");
        Boolean done = false;

        while (!done) {
            String input = scanner.nextLine();
            if (Objects.equals(input, "")) done = true;
        }
    }

    public static BattleField playersSetUp(int player, char[][] twoD_arr, BattleFleet BattleFleet){
        System.out.printf("Player %d, place your ships to the game field", player);
        System.out.println();

        BattleField BattleField = new BattleField(twoD_arr);
        BattleField.printGrid();
        placeShips(BattleField, BattleFleet);

        return BattleField;
    }

    public static BattleField placeShips(BattleField BattleField, BattleFleet BattleFleet){

        // Create the Aircraft Carrier
        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        int[][] locationA = addShip(BattleField, aircraftCarrier);

        //add it to the fleet
        BattleFleet.addShipToFleet(aircraftCarrier.getName(), locationA);

        // Create the Battleship
        Battleship battleship = new Battleship();
        int[][] locationB = addShip(BattleField, battleship);

        //add it to the fleet
        BattleFleet.addShipToFleet(battleship.getName(), locationB);

        // Create the Submarine
        Submarine submarine = new Submarine();
        int[][] locationC = addShip(BattleField, submarine);

        //add it to the fleet
        BattleFleet.addShipToFleet(submarine.getName(), locationC);

        // Create the Cruiser
        Cruiser cruiser = new Cruiser();
        int[][] locationD = addShip(BattleField, cruiser);

        //add it to the fleet
        BattleFleet.addShipToFleet(cruiser.getName(), locationD);

        // Create the Destroyer
        Destroyer destroyer = new Destroyer();
        int[][] locationE = addShip(BattleField, destroyer);

        //add it to the fleet
        BattleFleet.addShipToFleet(destroyer.getName(), locationE);

        return BattleField;
    }

    public static int[][] addShip(BattleField b, Ship ship){
        boolean shipAdded = false;
        int[][] coordinates = new int[0][];

        while(!shipAdded){
            ship.nameShipToAddToBattleField(ship.getName(), ship.getSize());
            String[] shipCordinates = ship.getShipCoordinate();

            int inputedShipSize = ship.inputedShipSize(shipCordinates);

            boolean isRightSize = ship.shipSizeValidation(inputedShipSize, ship.getSize(), ship.getName());
            if(isRightSize){
                coordinates = ship.convertShipCoordinatesToAddThemToBattlefield(shipCordinates);
                shipAdded = b.updateBattleField(coordinates);
            }
        }
        return coordinates;
    }

    public static int fireCanon(BattleField BattleField, CanonShot CanonShot, BattleFleet BattleFleet, int count){
        int result = CanonShot.fireCanon(BattleField);
        int[] shot = CanonShot.getLastShot(); //doesn't work
        BattleFleet.updateFleet(shot);
        result += BattleFleet.checkFleet();
        return displayResult(result, count);
    }

    public static void displayFog(char[][] twoD_arr) {
        FogOfWar FogOfWar = new FogOfWar(twoD_arr);
        FogOfWar.displayFogOfWar();
    }

    public static int displayResult(int result, int count){
        if(result == 1) {
            System.out.println("You hit a ship!");
            count--;
        } else if (result == 2) {
            System.out.println("You sank a ship!");
            count--;
        } else {
            System.out.println("You missed!");
        }
       return count;
    }

}
