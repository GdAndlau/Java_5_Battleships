package Battleship;

import static java.sql.Types.NULL;

public class FogOfWar {

    char[][] fogOfWar;

    public FogOfWar(char[][] fogOfWar){
        this.fogOfWar = fogOfWar;
    }

    public void displayFogOfWar(){
        char alphabet = 'A';
        System.out.println("");
        System.out.println(" " + " 1 2 3 4 5 6 7 8 9 10");
        for (char[] x: fogOfWar) {
            System.out.print(alphabet + " ");
            alphabet++;
            for (char y: x) {
                if(y == 'X' || y == 'M'){
                    System.out.print(y + " ");
                } else{
                    System.out.print('~' + " ");
                }
            }
            System.out.println();
        }
    }

}
