package Ships;

import java.util.Scanner;

public class Ship {

    int size;
    String name;

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void nameShipToAddToBattleField(String name, int size){
        System.out.printf("Enter the coordinates of the %s (%d cells):", name, size);
        System.out.println();

    }

    public String[] getShipCoordinate(){
        Scanner scanner = new Scanner(System.in);
        String[] shipCordinates = new String[2];
        shipCordinates[0] = scanner.next();
        shipCordinates[1] = scanner.next();

        return shipCordinates;
    }

    public int[][] convertShipCoordinatesToAddThemToBattlefield(String[] shipCordinates){
        int[][] boatCoordinates = new int[2][2];
        boatCoordinates[0] = convertCoordinate(shipCordinates[0]);
        boatCoordinates[1] = convertCoordinate(shipCordinates[1]);
        return boatCoordinates;
    }

    public int[] convertCoordinate(String coordinates){
        int[] finalArray = new int[2];
        char alphabet = 'A';

        String[] coordinateArr= coordinates.split("", 2);
        char[] coordinatesArray = coordinateArr[0].toCharArray();

        char value = coordinatesArray[0];
        for(int i = 0; i <= 10; i++){
            if(value == alphabet){
                finalArray[0] = i;
            }
            alphabet++;
        }

        int value2 = Integer.parseInt(coordinateArr[1]);

        for(int l = 0; l <= 10; l++){
            if(value2 == l){
                finalArray[1] = l;
            }
        }
        return finalArray;
    }

    public int inputedShipSize(String[] shipCordinates){
        int size = 0;
        // Am array of Strings

        String[] coo1 = shipCordinates[0].split("", 2); // A1
        String[] coo2 = shipCordinates[1].split("", 2); // A5

        char[] firstItemCoo1 = coo1[0].toCharArray(); // A
        char[] firstItemCoo2 = coo2[0].toCharArray(); // A

        int secondItemCoo1 = Integer.parseInt(coo1[1]); // 1
        int secondItemCoo2 = Integer.parseInt(coo2[1]); // 5

        if(firstItemCoo1[0] == firstItemCoo2[0]){
            if(secondItemCoo1 > secondItemCoo2){
                size = secondItemCoo1 - secondItemCoo2;
            } else {
                size = secondItemCoo2 - secondItemCoo1;
            }
        } else if (secondItemCoo1 == secondItemCoo2) {
            if(firstItemCoo1[0] > firstItemCoo2[0]){
                size = firstItemCoo1[0] - firstItemCoo2[0];
            } else {
                size = firstItemCoo2[0] - firstItemCoo1[0];
            }
        }
        size++;
        return size;

    }

    public boolean shipSizeValidation(int inputedShipSize, int allowedSize, String name){
        boolean validShip;
        if(inputedShipSize > allowedSize || inputedShipSize < allowedSize){
            System.out.printf("Error! Wrong length of the %s! Try again:", name);
            System.out.println("");
            validShip = false;
        } else {
            validShip = true;
        }
        return validShip;
    }

}
