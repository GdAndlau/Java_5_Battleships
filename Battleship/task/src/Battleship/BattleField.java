package Battleship;

import java.util.HashMap;

import static java.sql.Types.NULL;

public class BattleField {

    //the Battlefield
    char[][] twoD_arr;

    public char[][] getTwoD_arr() {
        return twoD_arr;
    }

    public void setTwoD_arr(char[][] twoD_arr) {
        this.twoD_arr = twoD_arr;
    }

    public BattleField(char[][] twoD_arr){
        this.twoD_arr = twoD_arr;
    }

    public Boolean updateBattleField(int[][] position){
        int[] position1 = position[0]; //a 10
        int[] position2 = position[1];

        boolean shipAdded = true;
        if(position1[0] == position2[0]){
           if(position1[1] > position2[1]){
               shipAdded = checkBoatPlacementHorizontal(twoD_arr, position1[0], position2[1], position1[1] - position2[1]);
               //shipAdded = fieldUpdate(position1[1], position2[1], position2[0], shipAdded);
               if(shipAdded) {
                   for (int m = position1[1]; m >= position2[1]; m--) {
                       twoD_arr[position1[0]][m - 1] = isSpaceTaken(twoD_arr[position1[0]][m - 1]);
                       shipAdded = true;
                   }
               }
           } else if(position1[1] < position2[1]){
               shipAdded = checkBoatPlacementHorizontal(twoD_arr, position1[0], position1[1],position2[1] - position1[1]);
               shipAdded = fieldUpdateV(position2[1], position1[1], position1[0], shipAdded);
           }
        } else if (position1[1] == position2[1]){
            if(position1[0] < position2[0]){
                shipAdded = checkBoatPlacementVertical(twoD_arr, position1[0], position1[1], position2[0] - position1[0]);
                shipAdded = fieldUpdateH(position2[0], position1[0], position2[1], shipAdded);
            } else if(position1[0] > position2[0]){
                shipAdded = checkBoatPlacementVertical(twoD_arr,position2[0], position1[1], position1[0] - position2[0]);
                shipAdded = fieldUpdateH(position1[0], position2[0], position2[1], shipAdded);
            }
        } else{
            System.out.println("Error! Wrong ship location! Try again:");
            shipAdded = false;
        }
        if(shipAdded) printGrid();
        return shipAdded;
    }

    public boolean fieldUpdateV(int big, int small, int identical, boolean shipAdded){
        if(shipAdded) {
            for (int m = small; m <= big; m++) {
                twoD_arr[identical][m - 1] = isSpaceTaken(twoD_arr[identical][m -1]);
                shipAdded = true;

            }
        }
        return shipAdded;
    }

    public boolean fieldUpdateH(int big, int small, int identical, boolean shipAdded){
        if(shipAdded) {
            for (int m = small; m <= big; m++) {
                twoD_arr[m][identical - 1] = isSpaceTaken(twoD_arr[m][identical - 1]);
                shipAdded = true;

            }
        }
        return shipAdded;
    }

    public void printGrid(){
        char alphabet = 'A';
        System.out.println(" " + " 1 2 3 4 5 6 7 8 9 10");
        for (char[] a: twoD_arr) {
            System.out.print(alphabet + " ");
            alphabet++;
            for (char b: a) {
                if (b != NULL) {
                    System.out.print(b + " ");
                } else {
                    System.out.print('~' + " ");
                }
            }
            System.out.println();
        }
    }

    public char isSpaceTaken(char space){
        if(space == 'O'){
            System.out.println("Error! You placed it too close to another one. Try again:");
        } else {
            space = 'O';
        }
        return space;
    }

    public boolean checkBoatPlacementVertical(char[][] twoD_arr, int row, int col, int boatLength) {
        boatLength++;

        for (int i = row - 1; i <= row + boatLength; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < twoD_arr.length && j >= 0 && j < twoD_arr[0].length && twoD_arr[i][j] == 'O') {
                    System.out.println("Error! You placed it too close to another one. " +
                            "Try again:");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBoatPlacementHorizontal(char[][] twoD_arr, int row, int col, int boatLength) {
        // Check if the boat is touching any other boats
        boatLength++;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + boatLength; j++) {
                if (i >= 0 && i < twoD_arr[0].length && j >= 0 && j < twoD_arr.length && twoD_arr[i][j] == 'O') {
                    System.out.println("Error! You placed it too close to another one. " +
                            "Try again:");
                    return false;
                }
            }
        }
        // If all checks pass, return true
        return true;
    }
}
