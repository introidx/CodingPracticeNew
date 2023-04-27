package design_pattern.p1_strategy_design_pattern.drive;

public class DriveExample {

    /**
     * When two or more child at the same level have same implementation
     * it results in to duplicate code, which is not ideal
     */

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.setDriveStrategy(new NormalDriveStrategy());
        v.drive();
    }

}

class Vehicle{
    private DriveStrategy strategy;

    public void setDriveStrategy(DriveStrategy strategy){
        this.strategy = strategy;
    }

    public void drive(){
        strategy.drive();
    }
}

class SportsDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Sports Drive Strategy");
    }
}

class NormalDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}

interface DriveStrategy{
    public void drive();
}
