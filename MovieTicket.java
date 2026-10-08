import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;

    // Parameterized constructor to initialize the attributes
    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Calculates the total ticket amount
    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Provides a 10% discount if the number of tickets is 5 or more
    public double calculateDiscount() {
        double total = calculateTotal();
        if (numberOfTickets >= 5) {
            return total * 0.10;
        }
        return 0.0;
    }

    // Calculates the final amount after deducting the discount
    public double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    // Displays the complete booking bill with values formatted to two decimal places
    public void displayBill() {
        System.out.println("\n--- Booking Bill ---");
        System.out.println("Movie Name      : " + movieName);
        System.out.printf("Ticket Price    : $%.2f\n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.printf("Total Amount    : $%.2f\n", calculateTotal());
        System.out.printf("Discount        : $%.2f\n", calculateDiscount());
        System.out.printf("Final Amount    : $%.2f\n", calculateFinalAmount());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input values
        System.out.print("Enter movie name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter number of tickets: ");
        int count = scanner.nextInt();

        // Creating MovieTicket object using the parameterized constructor
        MovieTicket ticket = new MovieTicket(name, price, count);

        // Displaying the final booking bill
        ticket.displayBill();

        scanner.close();
    }
}