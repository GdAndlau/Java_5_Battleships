package Ships;

public class Battleship extends Ship {
    private String name = "Battleship";
    private int size = 4;

    public Battleship(){
        super();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }


}
