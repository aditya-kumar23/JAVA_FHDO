class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class CombustionEngine extends Engine {
    public CombustionEngine() {
        super("Combustion Engine");
    }
}

class ElectricEngine extends Engine {
    public ElectricEngine() {
        super("Electric Engine");
    }
}

class HybridEngine extends Engine {
    public HybridEngine() {
        super("Hybrid Engine");
    }
}

class Manufacture{
    private String name;
    private String yearlyIncome;
    private int yearFounded;

    public String getName() {
        return name;
    }
    public String getYearlyIncome() {
        return yearlyIncome;
    }
    public int getYearFounded() {
        return yearFounded;
    }
    public Manufacture(String name, String yearlyIncome, int yearFounded) {
        this.name = name;
        this.yearlyIncome = yearlyIncome;
        this.yearFounded = yearFounded;
    }


}

abstract class Vehicle {
    private Manufacture manufacture;
    private Engine engine; 

    public Vehicle(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture; 
        this.engine = engine;
    }
    public Manufacture getManufacture() {
        return manufacture;
    }

    public Engine getEngine() {
        return engine;
    }
    public abstract void ShowCharacteristics();
}

class ICEV extends Vehicle {
    public ICEV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }
    @Override
    public void ShowCharacteristics() {
        System.out.println("Vehicle Type: ICEV");
        System.out.println("Manufacture: " + getManufacture().getName());
        System.out.println("Early income of manufacture: " + getManufacture().getYearlyIncome());
        System.out.println("Foundation year of manufacture: " + getManufacture().getYearFounded());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}
class BEV extends Vehicle {
    public BEV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Vehicle Type: BEV");
        System.out.println("Manufacture: " + getManufacture().getName());
        System.out.println("Early income of manufacture: " + getManufacture().getYearlyIncome());
        System.out.println("Foundation year of manufacture: " + getManufacture().getYearFounded());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

class HybridV extends Vehicle {
    public HybridV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Vehicle Type: HybridV");
        System.out.println("Manufacture: " + getManufacture().getName());
        System.out.println("Early income of manufacture: " + getManufacture().getYearlyIncome());
        System.out.println("Foundation year of manufacture: " + getManufacture().getYearFounded());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}
public class VehicleDetail {
    public static void main(String[] args) {
        Manufacture toyota = new Manufacture("Toyota", "$100 billion", 1937);
        Manufacture tesla = new Manufacture("Tesla", "$46 billion", 2003);

        Engine combustionEngine = new Engine("Combustion Engine");
        Engine electricEngine = new Engine("Electric Engine");
        Engine hybridEngine = new Engine("Hybrid Engine");

        Vehicle[] vehicles = {
            new ICEV(toyota, combustionEngine),
            new BEV(tesla, electricEngine),
            new HybridV(toyota, hybridEngine)
        };

        System.out.println("Vehicle Characteristics:");
        for (Vehicle vehicle : vehicles) {
            vehicle.ShowCharacteristics();
            System.out.println();
        }
    }
}