package design_pattern.p7_adapter_design_pattern.client;


import design_pattern.p7_adapter_design_pattern.adaptee.WeightMachineForBabies;
import design_pattern.p7_adapter_design_pattern.adepter.WeightMachineAdapter;
import design_pattern.p7_adapter_design_pattern.adepter.WeightMachineAdapterImpl;

public class Client {

    public static void main(String args[]) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }

}
