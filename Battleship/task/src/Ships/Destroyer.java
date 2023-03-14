package Ships;

public class Destroyer extends Ship {
    private String name = "Destroyer";
    private int size = 2;

    public Destroyer(){
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
