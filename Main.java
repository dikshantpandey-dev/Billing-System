import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type 'quit' or 'QUIT' to exit.");
            System.out.print("User ID: ");
            String userId = scanner.nextLine();
            if (userId.equalsIgnoreCase("quit"))
                break;

            System.out.print("Password: ");
            String password = scanner.nextLine();
            if (password.equalsIgnoreCase("quit"))
                break;

            if (!userId.equals("admin") || !password.equals("password")) {
                System.out.println("Invalid login. Try again.");
                continue;
            }

            System.out.print("Enter the number of items: ");
            int numberOfItems = Integer.parseInt(scanner.nextLine());
            double[] itemPrices = new double[numberOfItems];
            double total = 0;

            for (int i = 0; i < numberOfItems; i++) {
                System.out.print("Enter price for item " + (i + 1) + ": ");
                itemPrices[i] = Double.parseDouble(scanner.nextLine());
                total += itemPrices[i];
            }

            System.out.print("Apply VAT? (yes/no): ");
            String vatResponse = scanner.nextLine();
            if (vatResponse.equalsIgnoreCase("yes")) {
                total += total * 0.13;
            }

            System.out.print("Enter discount percentage: ");
            double discount = Double.parseDouble(scanner.nextLine());
            total -= total * (discount / 100);

            System.out.println("Total amount to be paid: " + total);

            System.out.print("Enter payment amount: ");
            double paymentAmount = Double.parseDouble(scanner.nextLine());

            double change = paymentAmount - total;
            System.out.println("Change: " + change);

            double[] denominations = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
            for (double denomination : denominations) {
                if (change >= denomination) {
                    System.out.println("Highest denomination of the change: " + denomination);
                    break;
                }
            }
        }

        scanner.close();
    }
}
