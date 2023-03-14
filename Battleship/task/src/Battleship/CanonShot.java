package Battleship;
import java.util.Scanner;

public class CanonShot {

    public int[] getLastShot() {
        return lastShot;
    }

    public int[] lastShot;


    public int[] getShotCoordinates() {
        Scanner scanner = new Scanner(System.in);

        int coordinate1 = 10;
        int coordinate2 = 10; /// check this

            //get the user's shot
            String[] shot = scanner.nextLine().split("", 2);

            switch (shot[0]) {
                case "A":
                    coordinate1 = 0;
                    break;
                case "B":
                    coordinate1 = 1;
                    break;
                case "C":
                    coordinate1 = 2;
                    break;
                case "D":
                    coordinate1 = 3;
                    break;
                case "E":
                    coordinate1 = 4;
                    break;
                case "F":
                    coordinate1 = 5;
                    break;
                case "G":
                    coordinate1 = 6;
                    break;
                case "H":
                    coordinate1 = 7;
                    break;
                case "I":
                    coordinate1 = 8;
                    break;
                case "J":
                    coordinate1 = 9;
                    break;
            }

            coordinate2 = Integer.parseInt(shot[1]); // issue
            coordinate2--;

            lastShot = new int[]{coordinate1, coordinate2};

        return new int[]{coordinate1, coordinate2};
    }

    public int fireCanon(BattleField battleField){
        boolean shotFired = false;
        int shotSuccess = 0;
        int coordinate1;
        int coordinate2; /// check this

        System.out.println("Take a shot!");

        while (!shotFired) {
            int[] shotCoordinates = getShotCoordinates();
            coordinate1 = shotCoordinates[0];
            coordinate2 = shotCoordinates[1];

            //check the battlefield
            if (coordinate1 < 10 && coordinate2 < 10) {
                char[][] twoD_arr = battleField.getTwoD_arr();

                if (twoD_arr[coordinate1][coordinate2] == 'O') {
                    shotFired = true;
                    shotSuccess = 1;
                    twoD_arr[coordinate1][coordinate2] = 'X';
                    battleField.setTwoD_arr(twoD_arr);
                } else if (twoD_arr[coordinate1][coordinate2] == 'X') {
                    shotFired = true;
                    twoD_arr[coordinate1][coordinate2] = 'X';
                    battleField.setTwoD_arr(twoD_arr);
                } else {
                    shotFired = true;
                    twoD_arr[coordinate1][coordinate2] = 'M';
                    battleField.setTwoD_arr(twoD_arr);
                }
            } else {
                System.out.println("Error! You entered the wrong coordinates! \n Try again:");
            }
        }

    return shotSuccess;
    }
}
