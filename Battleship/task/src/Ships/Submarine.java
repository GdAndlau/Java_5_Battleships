package Ships;

public class Submarine extends Ship {
    private String name = "Submarine";
    private int size = 3;

    public Submarine(){
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
