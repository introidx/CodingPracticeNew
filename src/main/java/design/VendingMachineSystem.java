package design;

/**
 * Created by PRAKASH RANJAN on 13-02-2023
 */
import java.util.HashMap;
import java.util.Map;

interface VendingMachine {
    void displayProducts();
    boolean acceptPayment(double amount);
    boolean dispenseProduct(int productId);
}

interface ProductInventory {
    boolean checkAvailability(int productId);
    void updateQuantity(int productId);
}

class VendingMachineImpl implements VendingMachine {
    private ProductInventory productInventory;
    private Map<Integer, Double> products;

    public VendingMachineImpl(ProductInventory productInventory) {
        this.productInventory = productInventory;
        this.products = new HashMap<>();
        this.products.put(1, 2.0);
        this.products.put(2, 3.0);
        this.products.put(3, 1.5);
        this.products.put(4, 5.0);
    }

    @Override
    public void displayProducts() {
        System.out.println("Products available in the vending machine:");
        products.forEach((id, price) -> System.out.println("Product ID: " + id + ", Price: $" + price));
    }

    @Override
    public boolean acceptPayment(double amount) {
        // Payment processing logic
        System.out.println("Payment accepted: $" + amount);
        return true;
    }

    @Override
    public boolean dispenseProduct(int productId) {
        if (productInventory.checkAvailability(productId)) {
            // Dispense product logic
            System.out.println("Product with ID " + productId + " dispensed");
            productInventory.updateQuantity(productId);
            return true;
        }
        System.out.println("Product with ID " + productId + " not available");
        return false;
    }
}

class ProductInventoryImpl implements ProductInventory {
    private Map<Integer, Integer> productQuantities;

    public ProductInventoryImpl() {
        this.productQuantities = new HashMap<>();
        this.productQuantities.put(1, 10);
        this.productQuantities.put(2, 5);
        this.productQuantities.put(3, 20);
        this.productQuantities.put(4, 15);
    }

    @Override
    public boolean checkAvailability(int productId) {
        int quantity = productQuantities.getOrDefault(productId, 0);
        return quantity > 0;
    }

    @Override
    public void updateQuantity(int productId) {
        int quantity = productQuantities.getOrDefault(productId, 0);
        productQuantities.put(productId, quantity - 1);
    }
}

public class VendingMachineSystem {
    public static void main(String[] args) {
        ProductInventory productInventory = new ProductInventoryImpl();
        VendingMachine vendingMachine = new VendingMachineImpl(productInventory);
        vendingMachine.displayProducts();
        vendingMachine.acceptPayment(2.0);
        vendingMachine.dispenseProduct(1);
        vendingMachine.dispenseProduct(2);
    }
}

