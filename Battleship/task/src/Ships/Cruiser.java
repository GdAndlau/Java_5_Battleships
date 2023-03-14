package Ships;

public class Cruiser extends Ship {
    private String name = "Cruiser";
    private int size = 3;

    public Cruiser(){
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
