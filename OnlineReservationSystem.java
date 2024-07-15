import java.util.*;

public class OnlineReservationSystem {
    private Map<String, String> users; // For storing username and passwords
    private Map<String, String> reservations; // For storing reservation data
    
    public OnlineReservationSystem() {
        users = new HashMap<>();
        reservations = new HashMap<>();
    }
    
    public void Run() {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print (" Please Enter your choice: ");
            
            int choice = input.nextInt();
            input.nextLine(); 
            
            switch (choice) {
                case 1:
                    login(input);
                    break;
                case 2:
                    signup(input);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Please Enter a valid option. ");
                    break;
            }
            
            System.out.println();
        }
    }

    private void login(Scanner input) {
    	System.out.println();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful.");
        	System.out.println();
            System.out.println("Logged in successfully...");
            System.out.println();
            reservationMenu(input, username);
        } else {
            System.out.println("Invalid username or password....\nPlease Try Again.");
        	System.out.println();
           
        }
    }

    private void signup(Scanner input) {
    	System.out.println();
        System.out.print("Enter username: ");
        String username = input.nextLine();

        if (users.containsKey(username)) {
        	System.out.println();
            System.out.println("Username already exists. Try again.");
            return;
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();
        users.put(username, password);
        System.out.println();
        System.out.println("Registration successful... \nYou can now log in to the system...");
    }

    private void reservationMenu(Scanner input, String username) {
        while (true) {
            System.out.println("1. Reserve a seat.");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Logout");
            System.out.print("Please Enter your choice: ");
            
            int choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    ReserveSeat(input, username);
                    break;
                case 2:
                    cancelReservation(input, username);
                    break;
                case 3:
                	System.out.println();
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
            
            System.out.println();
        }
    }

    private void ReserveSeat(Scanner input, String username) {
    	System.out.println();
        System.out.print("Enter reservation details: ");
        String reservationDetails = input.nextLine();

        if (reservations.containsKey(username)) {
            System.out.println("You already have a reservation. Cancel it first to make a new one.");
            return;
        }

        reservations.put(username, reservationDetails);
        System.out.println("Reservation created successfully.");
        System.out.println("Reservation created successfully...");
    }

    private void cancelReservation(Scanner scanner, String username) {
        if (reservations.containsKey(username)) {
        	System.out.println();
            System.out.println("Your current reservation: " + reservations.get(username));
            System.out.print("Do you want to cancel this reservation? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                reservations.remove(username);
                System.out.println("Reservation canceled successfully...");
                System.out.println();
               
            } else {
                System.out.println("Reservation not canceled.");
            }
        } else {
            System.out.println("You don't have any reservations.");
        }
    }
    
    public static void main(String[] args) {
    	OnlineReservationSystem reservationSystem = new OnlineReservationSystem();
    	reservationSystem.Run();
    }
}

