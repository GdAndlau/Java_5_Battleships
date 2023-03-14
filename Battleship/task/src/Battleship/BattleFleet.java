package Battleship;

import java.util.*;


public class BattleFleet {

    public HashMap<String, ArrayList<int[]>> fleet = new HashMap<>();

    public void addShipToFleet(String name, int[][] position){
        ArrayList<int[]> positionFinal = null;

        int[] position1 = position[0]; //a 10
        int[] position2 = position[1]; //b 10

        if(position1[0] == position2[0]){
            if(position1[1] > position2[1]){
                positionFinal = createPositionArrayV(position2[1], position1[1], position2[0]);
                fleet.put(name, positionFinal);

            } else if(position1[1] < position2[1]){
                positionFinal = createPositionArrayV(position1[1], position2[1], position2[0]);
                fleet.put(name, positionFinal);

            }
        } else if (position1[1] == position2[1]){
            if(position1[0] < position2[0]){
                positionFinal = createPositionArrayH(position1[0], position2[0], position1[1]);
                fleet.put(name, positionFinal);

            } else if(position1[0] > position2[0]){
                positionFinal = createPositionArrayH(position2[0], position1[0], position1[1]);
                fleet.put(name, positionFinal);

            }
        } else {
            System.out.println("Error! something went wrong");
        }

    }

    public ArrayList<int[]> createPositionArrayH(int small, int big, int commun){
        ArrayList<int[]> position = new ArrayList<>();
        int j = 0;

        for(int i = small; i <= big; i++){
            position.add(j, new int[]{i, commun});
            j++;
        }
        return position;
    }

    public ArrayList<int[]> createPositionArrayV(int small, int big, int commun){
        ArrayList<int[]> position = new ArrayList<>();
        int j = 0;

        for(int i = small; i <= big; i++){
            position.add(j, new int[]{commun, i});
            j++;
        }
        return position;
    }

    public boolean updateFleet(int[] shot) {
        boolean remove = false;
        int[] removeMe = new int[2];
        String removeName = new String();

        for (Map.Entry<String, ArrayList<int[]>> mapElement : fleet.entrySet()) {
            for (int[] itemList : mapElement.getValue()) {
                for(int l = 0; l < itemList.length; l++){
                    if(itemList[0] == shot[0] && itemList[1] == shot[1]+1) {
                        removeName = mapElement.getKey();
                        removeMe = mapElement.getValue().get(l);
                        remove = true;
                        break;
                    }
                }

            }
        }
        if(remove) fleet.get(removeName).remove(removeMe);

    return remove;
    }

    public int checkFleet() {
        int count = 0;
        boolean shipDead = false;
        String shipName = new String();
        for (Map.Entry<String, ArrayList<int[]>> mapElement : fleet.entrySet()) {

            if (mapElement.getValue().isEmpty()) {
                shipDead = true;
                shipName = mapElement.getKey();
                count++;
            }
        }
        if(shipDead) fleet.remove(shipName);
        return count;
    }

}


