package bookstoreDatabaseManager;

import java.util.Scanner;

/**
 * This is the main class, contains the menu and a few methods to navigate
 * through the program Some of the major methods in the Bookstore class include:
 * adding a product(Book, CD, or DVD), adding a member(Premium or Regular),
 * removing products, removing members, calculating discounts, purchasing any of
 * the three products, adding/removing premium status and more.
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class Start {

    /**
     * the main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean loopMainMenu = true, validInput = true;
        int choice;

        Bookstore bookstore = new Bookstore();  //constructs a bookstore object
        welcomeMessage();   //displays welcome message

        while (loopMainMenu) {  //will loop until user exits program
            boolean loopProductMenu = true;
            boolean loopMemberMenu = true;
            boolean loopPurchaseMenu = true;

            try {   //loops until user enters a correct input for the main menu
                Scanner input = new Scanner(System.in); //new scanner to prevent infinite looping
                displayMainMenu();  //main menu
                System.out.println("Enter your choice here:");
                choice = input.nextInt();   //user enters choice here   //clears enter

                switch (choice) {   //following switch is for the main menu
                    case 0:
                        System.out.println("Goodbye!"); //exits program
                        loopMainMenu = false;
                        break;
                    case 1:
                        while (loopProductMenu) {   //loops until user exits back to main menu
                            try {   //loops until user enters correct input
                                input = new Scanner(System.in);
                                displayProductMenu();   //product menu
                                System.out.println("Enter your choice here:");
                                choice = input.nextInt();   //user enters choice here
                                input.nextLine();

                                switch (choice) {
                                    case 0:
                                        System.out.println("Returning to the main menu...\n");  //returns to the man menu
                                        loopProductMenu = false;
                                        break;
                                    case 1:
                                        while (true) {  //will loop until user has entered the following fields correctly
                                            try {
                                                bookstore.addBook();    //see addBook in Bookstore for more info
                                                break;  //breaks loop if user enters correct info
                                            } catch (Exception error) { //catches any error in the method
                                                System.out.println("Your input was incorrect. Please try again.\n");    //error message
                                            }
                                        }
                                        break;
                                    case 2:
                                        while (true) {  //will loop until user has entered the following fields correctly
                                            try {
                                                bookstore.addCD();  //see addCD in Bookstore for more info
                                                break;
                                            } catch (Exception error) { //catches any error in the method
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (true) {  //will loop until user has entered the following fields correctly
                                            try {
                                                bookstore.addDVD(); //see addDVD in Bookstore for more info
                                                break;
                                            } catch (Exception error) { //catches any error in the method
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (true) {  //will loop until user has entered the following fields correctly
                                            try {
                                                bookstore.removeProduct();  //see removeProduct in Bookstore for more info
                                                break;
                                            } catch (Exception error) { //catches any error in method
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 5:
                                        bookstore.printProducts();  //see printProducts in Bookstore
                                        break;
                                    case 6:
                                        while (true) {  //loops until user input does not cause any errors
                                            try {
                                                bookstore.searchProductInformation();   //see searchProductInformation for more info
                                                break;
                                            } catch (Exception error) { //catches any user input error
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Please enter 0, 1, 2, 3, 4, 5, or 6\n");    //error message if user entered an integer other than the ones listed
                                        break;
                                }
                            } catch (Exception error) { //catches any input that isn't an integer and displays following error message
                                System.out.println("Please enter 0, 1, 2, 3, 4, 5, or 6\n");
                            }
                        }
                        break;
                    case 2:
                        while (loopMemberMenu) {    //loops until user enters proper input
                            try {
                                input = new Scanner(System.in);
                                displayMemberMenu();    //displays member menu, see method below
                                System.out.println("Enter your choice here:");
                                choice = input.nextInt();   //user enters choice here
                                input.nextLine();

                                switch (choice) {
                                    case 0:
                                        System.out.println("Returning to the main menu...\n");  //returns to main menu
                                        loopMemberMenu = false;
                                        break;
                                    case 1:
                                        while (true) {  //loops unitl user info is correct
                                            try {
                                                bookstore.addRegularMember();   //see addRegularMember in Bookstore
                                                break;
                                            } catch (Exception error) { //catches any error that user may have caused
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 2:
                                        while (true) {  //loops until user enters proper input
                                            try {
                                                bookstore.addPremiumMember();   //see addPremiumMember in Bookstore
                                                break;
                                            } catch (Exception error) { //catches any user error
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (true) {  //loops until user inputs info properly
                                            try {
                                                bookstore.addPremiumStatus();   //see addPremiumStatus in Bookstore
                                                break;
                                            } catch (Exception error) { //catches any error user may have caused
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (true) {  //loops until user input is correct
                                            try {
                                                bookstore.removePremiumStatus();    //see removePremiumStatus in Bookstore
                                                break;
                                            } catch (Exception error) { //catches any error user may have caused
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 5:
                                        while (true) {  //loops until user input is correct
                                            try {
                                                bookstore.removeMember();   //see removeMember in Bookstore
                                                break;
                                            } catch (Exception error) { //catches any error user may have caused
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    case 6:
                                        bookstore.printMembers();   //see printMembers in Bookstore
                                        break;
                                    case 7:
                                        while (true) {  //loops until user input is correct
                                            try {
                                                bookstore.searchMemberInformation();    //see searchMemberInformation in Bookstore
                                                break;
                                            } catch (Exception error) { //catches any error user may have caused
                                                System.out.println("Your input was incorrect. Please try again.\n");
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Please enter 0, 1, 2, 3, 4, 5, 6, or 7.\n");    //displays if user enters an integer not listed`
                                        break;
                                }
                            } catch (Exception error) {
                                System.out.println("Please enter 0, 1, 2, 3, 4, 5, 6, or 7.\n");    //displays if user does not enter an integer for choice
                            }
                        }
                        break;
                    case 3:
                        while (loopPurchaseMenu) {  //loops until user enters legit choice
                            try {
                                input = new Scanner(System.in);
                                displayPurchaseMenu();  //displays the purchase menu
                                System.out.println("Enter your choice here:");
                                choice = input.nextInt();   //user enters choice here
                                input.nextLine();

                                switch (choice) {
                                    case 0:
                                        System.out.println("Returning to the main menu...\n");  //exits to main menu
                                        loopPurchaseMenu = false;
                                        break;
                                    case 1:
                                        bookstore.buyBook();    //see buyBook in bookstore
                                        break;
                                    case 2:
                                        bookstore.buyCD();  //see buyCD in bookstore
                                        break;
                                    case 3:
                                        bookstore.buyDVD(); //see buyDVD in bookstore
                                        break;
                                    default:
                                        System.out.println("Please enter 0, 1, 2, or 3\n"); //displays if user input is not an integer listed
                                        break;
                                }
                            } catch (Exception error) {
                                System.out.println("Please enter 0, 1, 2, or 3\n"); //displays if user enters a non-integer
                            }
                        }
                        break;
                    default:
                        System.out.println("Please enter 0, 1, 2, or 3\n"); //displays if user entered a non-integer in main menu
                        break;
                }
            } catch (Exception error) {
                System.out.println("Please enter 0, 1, 2, or 3\n"); //displays if user entered a non-integer in main menu
            }
        }
    }

    /**
     * This method displays the Main Menu
     */
    public static void displayMainMenu() {  //prints following statements for main menu
        System.out.println("Welcome to the Main Menu, please choose from the following options...\n");
        System.out.println("1. View Product Menu");
        System.out.println("2. View Member Menu");
        System.out.println("3. View Purchase Menu");
        System.out.println("0. Exit Program\n");
    }

    /**
     * This method displays the Product Menu
     */
    public static void displayProductMenu() {   //displays following statements for product menu
        System.out.println("Welcome to the Product Menu, please choose from the following options...\n");
        System.out.println("1. Add Book");
        System.out.println("2. Add CD");
        System.out.println("3. Add DVD");
        System.out.println("4. Remove product");
        System.out.println("5. Print list of all products");
        System.out.println("6. Search for a product's information");
        System.out.println("0. Return to the Main Menu\n");
    }

    /**
     * This method displays the Member Menu
     */
    public static void displayMemberMenu() {    //displays following statements for member menu
        System.out.println("Welcome to the Member Menu, please choose from the following options...\n");
        System.out.println("1. Add a new Regular Member");
        System.out.println("2. Add a new Premium Member");
        System.out.println("3. Add Premium status to a Regular Member");
        System.out.println("4. Remove Premium status");
        System.out.println("5. Remove a Member");
        System.out.println("6. Print list of all members");
        System.out.println("7. Search for a member's information");
        System.out.println("0. Return to the Main Menu\n");
    }

    /**
     * This method displays the Purchase Menu
     */
    public static void displayPurchaseMenu() {  //displays following is statements for purchase menu
        System.out.println("Welcome to the Purchase Menu, please choose from the following options...\n");
        System.out.println("1. Purchase a Book");
        System.out.println("2. Purchase a CD");
        System.out.println("3. Purchase a DVD");
        System.out.println("0. Return to the Main Menu\n");
    }

    /**
     * This method displays a welcome message
     */
    public static void welcomeMessage() {   //following statements are the welcome message
        System.out.println("Welcome to my bookstore project!\nThis program keeps track of products and members.\nThe store offers three products: books, CDs, and DVDs.");
        System.out.println("It also offers memberships, regular and premium, to customers. It keeps track of how much each customer spends and applies a discount to anyone that's a premium member based on their amount spent.");
        System.out.println("The program also tracks inventories, prices, ID numbers, and other details about the products.\n");
    }
}
