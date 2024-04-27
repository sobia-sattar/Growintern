import java.util.*;
public class ElectricityBillingSystem {
	private int previousReading;
    private int currentReading;
    private int costPerUnit;

    public ElectricityBillingSystem(int previousReading, int currentReading, int costPerUnit) {
        this.previousReading = previousReading;
        this.currentReading = currentReading;
        this.costPerUnit = costPerUnit;
    }

    public int calculateUnitsConsumed() {
        return currentReading - previousReading;
    }

    public int calculateTotalCost() {
        return calculateUnitsConsumed() * costPerUnit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the previous meter reading:");
        int previousReading = scanner.nextInt();

        System.out.println("Enter the current meter reading:");
        int currentReading = scanner.nextInt();

        System.out.println("Enter the cost per unit:");
        int costPerUnit = scanner.nextInt();

        ElectricityBillingSystem bill = new ElectricityBillingSystem(previousReading, currentReading, costPerUnit);

        System.out.println("Units consumed: " + bill.calculateUnitsConsumed());
        System.out.println("Total cost: $" + bill.calculateTotalCost());

        scanner.close();
    }
}
