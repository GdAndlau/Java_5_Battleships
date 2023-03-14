package Ships;

public class AircraftCarrier extends Ship {

    private String name = "Aircraft Carrier";
    private int size = 5;


    public AircraftCarrier(){
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
