package bookstoreDatabaseManager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the heart and soul of the program, contains majority methods required
 * to carry out logic, display, and error catching. Some of the major methods
 * include: adding a product(Book, CD, or DVD), adding a member(Premium or
 * Regular), removing products, removing members, calculating discounts,
 * purchasing any of the three products, adding/removing premium status and
 * more.
 *
 * @author Chase Scallion
 * @version 11/15/2019
 */
public class Bookstore {

    private ArrayList<Product> products = new ArrayList<>();    //products array list
    private ArrayList<Member> members = new ArrayList<>();  //members array list
    private boolean hasPaid, loopConfirm = true, confirmId, checkPremium;   //following are all variables used in the methods below
    private double price, movieLength, amountSpent, subtotal, total, discount;
    private int id, amountInStock, numPages, numTracks, memberId, amount, availableAmount, counter, keyId, productType, memberType;
    private String title, author, publisher, artist, director, actor, search, name;
    private String[] tracks;
    private static DecimalFormat twoDecimals = new DecimalFormat("#.##");   //makes it look nice "10.99"

    private Scanner input = new Scanner(System.in); //scanner

    /**
     * The constructor for Bookstore
     */
    public Bookstore() {
    }

    /**
     * This method adds a book to the products array list
     *
     * @param price price of the product
     * @param id id number of the product
     * @param title title of the product
     * @param amountInStock number in stock
     * @param author author of book
     * @param publisher publisher of book
     * @param numPages number of pages in book
     */
    public void addBook(double price, int id, String title, int amountInStock, String author, String publisher, int numPages) {
        products.add(new Book(price, id, title, amountInStock, author, publisher, numPages));   //adds new book to products array list
    }

    /**
     * This method adds a CD to the products array list
     *
     * @param price price of the product
     * @param id id number of the product
     * @param title title of the product
     * @param amountInStock number in stock
     * @param artist artist of the cd
     * @param numTracks number of tracks on the cd
     * @param tracks the tracks on cd
     */
    public void addCD(double price, int id, String title, int amountInStock, String artist, int numTracks, String[] tracks) {
        products.add(new CD(price, id, title, amountInStock, artist, numTracks, tracks));   //adds new cd to products array list
    }

    /**
     * This method adds a DVD to the products list
     *
     * @param price price of the product
     * @param id id number of the product
     * @param title title of the product
     * @param amountInStock number in stock
     * @param director director of the dvd
     * @param actor main actor of the dvd
     * @param movieLength length of the dvd
     */
    public void addDVD(double price, int id, String title, int amountInStock, String director, String actor, double movieLength) {
        products.add(new DVD(price, id, title, amountInStock, director, actor, movieLength));   //adds new dvd to products array list
    }

    /**
     * This method adds a Regular Member to the members array list
     *
     * @param name name of the member
     * @param memberId id number of the member
     * @param amountSpent amount member has spent
     */
    public void addRegularMember(String name, int memberId, double amountSpent) {
        members.add(new Member(name, memberId, amountSpent));   //adds new regular member to members array list
    }

    /**
     * This method adds a Premium Member to the members array list
     *
     * @param name name of the member
     * @param memberId id number of the member
     * @param amountSpent amount member has spent
     * @param hasPaid tracks if premium member has paid their fee
     * @param discount tracks discount percentage of a premium member
     */
    public void addPremiumMember(String name, int memberId, double amountSpent, boolean hasPaid, double discount) {
        members.add(new Premium(name, memberId, amountSpent, hasPaid, discount));   //adds a new premium member to members array list
    }

    /**
     * This method adds a new book to the products array list
     */
    public void addBook() {
        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the price of the book:"); //user enters price of book here
        price = input.nextDouble();
        input.nextLine();

        System.out.println("Enter the ID of the book:");    //user enters id book here
        idChecker();    //see idChecker, makes sure id already isnt being used

        System.out.println("Enter the title of the book:"); //user enters title of book here
        title = input.nextLine();

        System.out.println("Enter how many books you are adding to stock:");    //user enters number of book adding to stock
        amountInStock = input.nextInt();
        input.nextLine();

        System.out.println("Enter the author of the book:");    //user enter author of book here
        author = input.nextLine();

        System.out.println("Enter the publisher of the book:"); //user enters publisher of book here
        publisher = input.nextLine();

        System.out.println("Enter the number of pages in the book:");   //user enter number of pages here
        numPages = input.nextInt();
        input.nextLine();

        products.add(new Book(price, id, title, amountInStock, author, publisher, numPages));   //adds book to the array list
        System.out.println(amountInStock + " of \"" + title + "\" has been added to the bookstore's inventory.\n"); //success statement
    }

    /**
     * This method adds a new CD to the products array list
     */
    public void addCD() {
        input = new Scanner(System.in); //new scanner to avoid input error

        System.out.println("Enter the price of the CD:");   //enter price here
        price = input.nextDouble();
        input.nextLine();

        System.out.println("Enter the ID of the CD:");  //enter id number here
        idChecker();    //checks if id number is already taken

        System.out.println("Enter the title of the CD:");   //enter title here
        title = input.nextLine();

        System.out.println("Enter how many CDs you are adding to stock:");  //enter number adding to stock here
        amountInStock = input.nextInt();
        input.nextLine();

        System.out.println("Enter the artist of the CD:");  //enter artist of cd here
        artist = input.nextLine();

        System.out.println("Enter the number of tracks on the CD:");    //enter the number of tracks here
        numTracks = input.nextInt();
        input.nextLine();

        System.out.println("Enter the titles of the tracks:");  //enter titles of tracks here
        tracks = new String[numTracks];

        for (int i = 0; i < tracks.length; i++) {   //user enters track titles until array is filled
            System.out.println("Track " + (i + 1) + ":");   //shows which track number user is on
            tracks[i] = input.nextLine();
        }

        products.add(new CD(price, id, title, amountInStock, artist, numTracks, tracks));   //adds new cd to products array list
        System.out.println(amountInStock + " of \"" + title + "\" has been added to the bookstore's inventory.\n");
    }

    /**
     * This method adds a new DVD to the products array list
     */
    public void addDVD() {
        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the price of the DVD:");  //enter price here
        price = input.nextDouble();
        input.nextLine();

        System.out.println("Enter the ID of the DVD:"); //enter id number here
        idChecker();    //checks if id number is already taken

        System.out.println("Enter the title of the DVD:");  //enter title here
        title = input.nextLine();

        System.out.println("Enter how many DVDs you are adding to stock:"); //enter number adding to stock here
        amountInStock = input.nextInt();
        input.nextLine();

        System.out.println("Enter the name of the director of the DVD:");   //enter director here
        director = input.nextLine();

        System.out.println("Enter the name of the main actor:");    //enter main actor here
        actor = input.nextLine();

        System.out.println("Enter the length(in hours) of the of the DVD:");    //enter length of dvd here
        movieLength = input.nextDouble();
        input.nextLine();

        products.add(new DVD(price, id, title, amountInStock, director, actor, movieLength));   //adds new dvd to products array list
        System.out.println(amountInStock + " of \"" + title + "\" has been added to the bookstore's inventory.\n");
    }

    /**
     * This method adds a new regular member to the members array list
     */
    public void addRegularMember() {
        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the name of the member:");    //user enters name here
        name = input.nextLine();

        System.out.println("Enter the member's ID:");   //user enters member ID here
        memIdChecker(); //checks if member id is already taken

        System.out.println("Enter the amount this person has spent:");  //enter amount member has spent here
        amountSpent = input.nextDouble();
        input.nextLine();

        addRegularMember(name, memberId, amountSpent);  //adds new regular member to members array list
        System.out.println(name + " with ID: " + memberId + " has been successfully added.\n"); //success message
    }

    /**
     * This method adds a new premium member to the members array list
     */
    public void addPremiumMember() {
        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the name of the member:");    //enter member name here
        name = input.nextLine();

        System.out.println("Enter the member's ID:");   //enter member id here
        memIdChecker(); //checks if member id is already taken

        System.out.println("Enter the amount this person has spent:");  //enter amount member has spent here
        amountSpent = input.nextDouble();
        input.nextLine();

        hasPaid = true; //premium member has paid for membership

        addPremiumMember(name, memberId, amountSpent, hasPaid, 0.0);    //adds new premium member to the members array list
        calculatePremiumDiscount(); //calculates discount that premium member gets on purchases
        System.out.println(name + " with ID: " + memberId + " has been successfully added.\n"); //success message
    }

    /**
     * This method will add premium status to a regular member. Regular member
     * turns into a premium member
     */
    public void addPremiumStatus() {
        counter = members.size();   //method will not run if members array list is empty
        if (counter == 0) {
            System.out.println("There are no members in the system!");
            return; //breaks method if there are no members in the array list
        }

        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the Member ID of the member to add Premium status to: "); //enter id of regular member here
        memberId = input.nextInt();
        int checkId = 0;

        for (int i = 0; i < members.size(); i++) {  //checks if member already has premium status
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof Premium) {    //will not give premium status to member that already has it
                checkId = 2;
            } else if (memberId == members.get(i).getMemberId() && members.get(i) instanceof Member) {  //gives premium status to regular member, removes member from members array list
                checkId = 1;
                name = members.get(i).getName();   //get name
                memberId = members.get(i).getMemberId();    //get id
                amountSpent = members.get(i).getAmountSpent();  //get amount spent
                members.remove(i);  //removes member from members array list
            }
        }
        if (checkId == 0) { //prints if no member has the id
            System.out.println("No member has that ID.");
        } else if (checkId == 1) {  //adds new premium member to members array list
            members.add(new Premium(name, memberId, amountSpent, true, 0.00));
            calculatePremiumDiscount(); //calculates premium discount
            System.out.println(name + " now has Premium status!\n");
        } else {    //prints if member is already premium
            System.out.println("That member already has Premium status!\n");
        }
    }

    /**
     * This method removes a product via ID number from the products array list
     */
    public void removeProduct() {
        counter = products.size();  //method will break if products array list is empty
        if (counter == 0) {
            System.out.println("There are no products in the system!\n");
            return; //returns to product menu
        }

        input = new Scanner(System.in); //new scanner to avoid input errors

        printProducts();    //prints list of available products
        boolean validId = false;
        System.out.println("Enter the ID of the product you want to remove:");  //enter id here
        id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < products.size(); i++) { //checks if id is valid
            if (id == products.get(i).getId()) {    //if valid, product will be removed
                validId = true;
                System.out.println(products.get(i).getTitle() + " has been removed.\n");
                products.remove(i);
            }
        }
        if (validId == false) { //if not valid, following statement is printed
            System.out.println("That is not a valid product ID.\n");
        }
    }

    /**
     * This method removes a member via member ID number from the members array
     * list
     */
    public void removeMember() {
        counter = members.size();   //method will break if members array list is empty
        if (counter == 0) {
            System.out.println("There are no members in the system!\n");
            return; //returns to member menu
        }

        input = new Scanner(System.in); //new scanner to avoid input errors

        printMembers(); //prints list of members
        boolean validMemberId = false; //resets variable
        System.out.println("Enter the ID of the member you want to remove:");   //user enters member id here
        memberId = input.nextInt();
        input.nextLine();

        for (int i = 0; i < members.size(); i++) {  //checks if member id is valid
            if (memberId == members.get(i).getMemberId()) { //if valid, member is removed from members array list
                validMemberId = true;   //confirms id
                System.out.println(members.get(i).getName() + " has been removed.\n");
                members.remove(i);  //removes member
            }
        }
        if (validMemberId == false) {   //prints if member id is not valid
            System.out.println("That is not a valid member ID.\n");
        }
    }

    /**
     * This method removes premium status from a member
     */
    public void removePremiumStatus() {
        counter = 0;
        for (int i = 0; i < members.size(); i++) {  //method will break if there are no members or no premium members
            if (members.get(i) instanceof Premium) {
                counter++;  //counts number of premium members found
            }
        }
        if (counter == 0) {  //prints if there are no premium members in members array list
            System.out.println("There are no Premium Members in the system!\n");
            return; //returns to member menu
        }

        input = new Scanner(System.in); //new scanner to avoid input error

        System.out.println("Enter the Member ID of the member you want to remove Premium status from: ");   //user enters member id here
        keyId = input.nextInt();
        input.nextLine();
        int checkId = 0; //resets variable

        for (int i = 0; i < members.size(); i++) {  //checks if id belongs to a premium member
            if ((members.get(i) instanceof Premium) && (members.get(i).getMemberId() == keyId)) {   //if confirmed premium member, premium status is removed
                checkId = 1;
                name = members.get(i).getName();    //get name
                memberId = members.get(i).getMemberId();    //get id
                amountSpent = members.get(i).getAmountSpent();  //get amount spent
                members.remove(i);  //removes premium member from array list
            } else {
                checkId = 0;
            }
        }
        if (checkId == 0) { //prints if no premium member has the ID
            System.out.println("No Premium Member has that ID.\n");
        } else {    //prints if member has premium stripped
            members.add(new Member(name, memberId, amountSpent));   //adds member back as regular member
            System.out.println(name + " no longer has Premium status.\n");
        }
    }

    /**
     * This method calculates the discount that a premium member has
     */
    public void calculatePremiumDiscount() {
        Premium m;  //premium object
        for (int i = 0; i < members.size(); i++) {  //goes through members array list searching for premium members
            if (members.get(i) instanceof Premium) {    //if premium is found, discount rules are applied
                m = (Premium) members.get(i);   //gets premium member
                if (m.getAmountSpent() < 20) {  //discount of 5% if premium member has spent less than 20 dollars
                    m.setDiscount(.05);
                } else if (m.getAmountSpent() > 20 && m.getAmountSpent() < 50) {    //discount of 10% if premium member has spent between 20 and 50 dollars
                    m.setDiscount(.10);
                } else if (m.getAmountSpent() > 50 && m.getAmountSpent() < 100) {   //discount of 15% if premium member has spent between 50 and 100 dollars
                    m.setDiscount(.15);
                } else {    //discount of 20% if premium member has spent more than 100 dollars
                    m.setDiscount(.20);
                }
            }
        }
    }

    /**
     * This method allows a user to purchase a book
     */
    public void buyBook() {
        counter = 0;
        for (int i = 0; i < products.size(); i++) { //method will not run if there are no books to purchase
            if (products.get(i) instanceof Book) {
                counter++;  //counts number of books found
            }
        }
        if (counter == 0) { //prints if no books are available to purchase
            System.out.println("There are no books available to purchase!\n");
            return; //returns to the purchase menu
        }

        loopConfirm = true;
        System.out.println("Here are the following available books to purchase:\n");    //formats prints statements to make them look tabular
        System.out.printf("%-10s%-45s%-10s%-20s", "ID", "Title", "Price", "Amount in Stock");
        System.out.println();

        for (int i = 0; i < products.size(); i++) { //prints a list of available books in tabular format
            if (products.get(i) instanceof Book) {  //prints if book is found
                System.out.printf("%-10s%-45s%-10s%-20d", products.get(i).getId(), products.get(i).getTitle(), products.get(i).getPrice(), products.get(i).getAmountInStock());
                System.out.println();
            }
        }

        System.out.println("\nEnter the ID of the book you would like to purchase:");

        while (loopConfirm) {   //loops until user enters a valid book id
            availableAmount = 0;
            try {
                input = new Scanner(System.in); //user enters id here
                id = input.nextInt();
                confirmId = false;

                for (int i = 0; i < products.size(); i++) { //checks if id is valid
                    if (products.get(i) instanceof Book && id == products.get(i).getId()) { //if valid, gets product information
                        confirmId = true;
                        loopConfirm = false;
                        availableAmount = products.get(i).getAmountInStock();
                        price = products.get(i).getPrice();
                    }
                }
                if (confirmId == false) {   //throws exception if id is not valid
                    throw new Exception("Please enter a valid ID from the list above:");
                }
            } catch (Exception error) { //throws exception if user does not enter an int
                System.out.println("Please enter a valid ID from the list above:");
            }
        }
        loopConfirm = true; //resets variable
        System.out.println("Enter the number of copies you would like to purchase:");

        while (loopConfirm) {   //loops until user enters an available amount to purchase
            try {
                input = new Scanner(System.in); //enters amount to purchase here
                amount = input.nextInt();
                input.nextLine();
                if (amount <= availableAmount && amount > 0) {    //if amount is available, code proceeds
                    loopConfirm = false;
                    for (int i = 0; i < products.size(); i++) { //if valid amount, purchase amount is subtracted from amount in stock
                        if (id == products.get(i).getId()) {
                            products.get(i).setAmountInStock(products.get(i).getAmountInStock() - amount);  //sets amount in stock
                        }
                    }
                } else {    //throws exception of amount is too many
                    throw new Exception("Please enter a valid amount of copies:");
                }
            } catch (Exception error) { //throws exception if user does not enter an int
                System.out.println("Please enter a valid amount of copies:");
            }
        }

        System.out.println("Enter your Membership ID:");
        subtotal = price * amount; //calculates subtotal of purchase
        loopConfirm = true; //resets variable
        confirmId = false;

        while (loopConfirm) {  //loop until a valid member id is entered
            try {
                input = new Scanner(System.in); //enter member id here
                memberId = input.nextInt();
                input.nextLine();

                for (int i = 0; i < members.size(); i++) {  //checks if member id is valid
                    if (memberId == members.get(i).getMemberId()) { //id is confirmed
                        confirmId = true;   //confirms id
                        loopConfirm = false;    //breaks while loop
                    }
                }
                if (confirmId == false) {   //throws exception if member id is invalid
                    throw new Exception("Please enter a valid Membership ID:");
                }
            } catch (Exception error) { //throws exception if user enters a non int
                System.out.println("Please enter a valid Membership ID:");
            }
        }

        checkPremium = false; //resets variable
        for (int i = 0; i < members.size(); i++) {  //this loop checks if member is premium or regular
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof Premium) {    //if premium, discount is applied to subtotal
                calculatePremiumDiscount(); //calculates premium discount
                Premium m = (Premium) members.get(i);   //gets premium member
                discount = m.getDiscount(); //gets discount
                total = subtotal - (subtotal * discount);   //discout is applied to purchase
                checkPremium = true;    //confirms premium
                members.get(i).setAmountSpent(members.get(i).getAmountSpent() + total); //sets total amount spent
            } else {
                total = subtotal;   //not premium, no discount
                members.get(i).setAmountSpent(members.get(i).getAmountSpent() + total); //sets total amount spent
            }
        }

        if (checkPremium == true) { //prints following statements if member is confirmed premium
            System.out.println("Your subtotal is: $" + subtotal);
            System.out.println("You're a Premium Member! Your discount of " + discount * 100 + "% was applied!");
            System.out.println("Your total is: $" + twoDecimals.format(total));
            System.out.println("You saved: $" + twoDecimals.format(subtotal * discount));
        } else {    //prints following statements if member is not premium
            System.out.println("You are not a Premium Member! Please consider upgrading to save up to 20%!");
            System.out.println("Your total is: $" + twoDecimals.format(total));
        }
        checkInventory();   //checks if any inventory stocks have fallen to 0
    }

    /**
     * This method allows a user to purchase a CD
     */
    public void buyCD() {
        counter = 0;
        for (int i = 0; i < products.size(); i++) { //method will break if there are no cds to purchase
            if (products.get(i) instanceof CD) {
                counter++;  //counts number of CDs
            }
        }
        if (counter == 0) { //breaks if no cds are available
            System.out.println("There are no CDs available to purchase!");
            return; //returns to purchase menu
        }

        loopConfirm = true; //resets variable
        System.out.println("Here are the following available CDs to purchase:\n");  //prints following statement in tabular format
        System.out.printf("%-10s%-45s%-10s%-20s", "ID", "Title", "Price", "Amount in Stock");
        System.out.println();

        for (int i = 0; i < products.size(); i++) { //prints the list of cds available in tabular format
            if (products.get(i) instanceof CD) {    //prints if cd is found
                System.out.printf("%-10s%-45s%-10s%-20d", products.get(i).getId(), products.get(i).getTitle(), products.get(i).getPrice(), products.get(i).getAmountInStock());
                System.out.println();
            }
        }

        System.out.println("\nEnter the ID of the CD you would like to purchase:");

        while (loopConfirm) {   //loops until user enters a valid id
            availableAmount = 0;
            try {
                input = new Scanner(System.in); //user enters id here
                id = input.nextInt();
                confirmId = false;

                for (int i = 0; i < products.size(); i++) { //checks if id is valid
                    if (products.get(i) instanceof CD && id == products.get(i).getId()) {   //if valid, gets product information
                        confirmId = true;
                        loopConfirm = false;
                        availableAmount = products.get(i).getAmountInStock();
                        price = products.get(i).getPrice();
                    }
                }
                if (confirmId == false) {   //prints if is not valid
                    throw new Exception("Please enter a valid ID from the list above:");
                }
            } catch (Exception error) { //prints if input is not valid
                System.out.println("Please enter a valid ID from the list above:");
            }
        }
        loopConfirm = true; //resets variable
        System.out.println("Enter the number of copies you would like to purchase:");

        while (loopConfirm) {   //loops until user enters a valid amount to purchase
            try {
                input = new Scanner(System.in); //user enters amount here
                amount = input.nextInt();
                input.nextLine();
                if (amount <= availableAmount && amount > 0) {  //checks if amount is valid
                    loopConfirm = false;    //breaks loop if valid amount
                    for (int i = 0; i < products.size(); i++) { //loops to get product
                        if (id == products.get(i).getId()) {    //sets product amount in stock to new amount
                            products.get(i).setAmountInStock(products.get(i).getAmountInStock() - amount); //subtracts purchase amount from amount in stock
                        }
                    }
                } else {    //throws exception if amount isnt valid
                    throw new Exception("Please enter a valid amount of copies:");
                }
            } catch (Exception error) { //throws exception if user does not enter an int
                System.out.println("Please enter a valid amount of copies:");
            }
        }

        System.out.println("Enter your Membership ID:");
        subtotal = price * amount;  //calculates subtotal
        loopConfirm = true; //resets variable
        confirmId = false;  //resets variable

        while (loopConfirm) {   //loops until user enters a valid id
            try {
                input = new Scanner(System.in); //user enters id here
                memberId = input.nextInt();
                input.nextLine();

                for (int i = 0; i < members.size(); i++) {  //checks if id is valid
                    if (memberId == members.get(i).getMemberId()) { //if valid, confirms it
                        confirmId = true;   //confirms id
                        loopConfirm = false;    //breaks loop if id is valid
                    }
                }
                if (confirmId == false) {   //throws exception if id isnt valid
                    throw new Exception("Please enter a valid Membership ID:");
                }
            } catch (Exception error) { //throws exception if user doesnt enter an int
                System.out.println("Please enter a valid Membership ID:");
            }
        }

        checkPremium = false;   //resets variable
        for (int i = 0; i < members.size(); i++) {  //checks if member is premium or not
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof Premium) {    //if premium, gets info
                calculatePremiumDiscount(); //calculates discount
                Premium m = (Premium) members.get(i);   //premium object
                discount = m.getDiscount(); //sets discount
                total = subtotal - (subtotal * discount);   //calculates total with discount applied
                checkPremium = true;    //confirms premium
                members.get(i).setAmountSpent(members.get(i).getAmountSpent() + total); //sets new amount spent
            } else {    //if member is regular
                total = subtotal;   //no discount applied
                members.get(i).setAmountSpent(members.get(i).getAmountSpent() + total); //sets the new amount spent
            }
        }

        if (checkPremium == true) { //prints following if member is premium
            System.out.println("Your subtotal is: $" + twoDecimals.format(subtotal));
            System.out.println("You're a Premium Member! Your discount of " + discount * 100 + "% has been applied!");
            System.out.println("Your total is: $" + twoDecimals.format(total));
            System.out.println("You saved: $" + twoDecimals.format(subtotal * discount));
        } else {    //prints following if member is regular
            System.out.println("You are not a Premium Member! Please consider upgrading to save up to 20%!");
            System.out.println("Your total is: $" + twoDecimals.format(total));
        }
        checkInventory();   //checks if any inventories have hit 0
    }

    /**
     * This method allows a user to purchase a DVD
     */
    public void buyDVD() {
        counter = 0;
        for (int i = 0; i < products.size(); i++) { //method will not run if there are no dvds to purchase
            if (products.get(i) instanceof DVD) {
                counter++;
            }
        }
        if (counter == 0) { //prints if no dvds are available to purchase
            System.out.println("There are no DVDs available to purchase!\n");
            return; //returns to the purchase menu
        }

        loopConfirm = true;
        System.out.println("Here are the following available DVDs to purchase:\n");    //formats prints statements to make them look tabular
        System.out.printf("%-10s%-45s%-10s%-20s", "ID", "Title", "Price", "Amount in Stock");
        System.out.println();

        for (int i = 0; i < products.size(); i++) { //prints a list of available dvds in tabular format
            if (products.get(i) instanceof DVD) {   //prints if dvd is found
                System.out.printf("%-10s%-45s%-10s%-20d", products.get(i).getId(), products.get(i).getTitle(), products.get(i).getPrice(), products.get(i).getAmountInStock());
                System.out.println();
            }
        }

        System.out.println("\nEnter the ID of the DVD you would like to purchase:");

        while (loopConfirm) {   //loops until user enters a valid dvd id
            availableAmount = 0;
            try {
                input = new Scanner(System.in); //user enters id here
                id = input.nextInt();
                confirmId = false;  //resets variable

                for (int i = 0; i < products.size(); i++) { //checks if id is valid
                    if (products.get(i) instanceof DVD && id == products.get(i).getId()) { //if valid, gets product information
                        confirmId = true;   //confirms id
                        loopConfirm = false;    //breaks while loop
                        availableAmount = products.get(i).getAmountInStock(); //gets amount in stock
                        price = products.get(i).getPrice(); //gets price
                    }
                }
                if (confirmId == false) {   //throws exception if id is not valid
                    throw new Exception("Please enter a valid ID from the list above:");
                }
            } catch (Exception error) { //throws exception if user does not enter an int
                System.out.println("Please enter a valid ID from the list above:");
            }
        }
        loopConfirm = true; //resets variable
        System.out.println("Enter the number of copies you would like to purchase:");

        while (loopConfirm) {   //loops until user enters an available amount to purchase
            try {
                input = new Scanner(System.in); //enters amount to purchase here
                amount = input.nextInt();
                input.nextLine();
                if (amount <= availableAmount && amount > 0) {    //if amount is available, code proceeds
                    loopConfirm = false;
                    for (int i = 0; i < products.size(); i++) { //if valid amount, purchase amount is subtracted from amount in stock
                        if (id == products.get(i).getId()) {
                            products.get(i).setAmountInStock(products.get(i).getAmountInStock() - amount);  //sets amount in stock
                        }
                    }
                } else {    //throws exception of amount is too many
                    throw new Exception("Please enter a valid amount of copies:");
                }
            } catch (Exception error) { //throws exception if user does not enter an int
                System.out.println("Please enter a valid amount of copies:");
            }
        }

        System.out.println("Enter your Membership ID:");
        subtotal = price * amount; //calculates subtotal of purchase
        loopConfirm = true; //resets variable
        confirmId = false;  //resets variable

        while (loopConfirm) {  //loop until a valid member id is entered
            try {
                input = new Scanner(System.in); //enter member id here
                memberId = input.nextInt();
                input.nextLine();

                for (int i = 0; i < members.size(); i++) {  //checks if member id is valid
                    if (memberId == members.get(i).getMemberId()) { //id is confirmed
                        confirmId = true;   //confirms id
                        loopConfirm = false;    //breaks while loop
                    }
                }
                if (confirmId == false) {   //throws exception if member id is invalid
                    throw new Exception("Please enter a valid Membership ID:");
                }
            } catch (Exception error) { //throws exception if user enters a non int
                System.out.println("Please enter a valid Membership ID:");
            }
        }

        checkPremium = false; //resets variable
        for (int i = 0; i < members.size(); i++) {  //this loop checks if member is premium or regular
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof Premium) {    //if premium, discount is applied to subtotal
                calculatePremiumDiscount(); //calculates premium discount
                Premium m = (Premium) members.get(i);   //gets premium member
                discount = m.getDiscount(); //gets discount
                total = subtotal - (subtotal * discount);   //discout is applied to purchase
                checkPremium = true;    //confirms premium
                members.get(i).setAmountSpent(members.get(i).getAmountSpent() + total); //sets total amount spent
            } else {
                total = subtotal;   //not premium, no discount
                members.get(i).setAmountSpent(members.get(i).getAmountSpent() + total); //sets total amount spent
            }
        }

        if (checkPremium == true) { //prints following statements if member is confirmed premium
            System.out.println("Your subtotal is: $" + subtotal);
            System.out.println("You're a Premium Member! Your discount of " + discount * 100 + "% was applied!");
            System.out.println("Your total is: $" + twoDecimals.format(total));
            System.out.println("You saved: $" + twoDecimals.format(subtotal * discount));
        } else {    //prints following statements if member is not premium
            System.out.println("You are not a Premium Member! Please consider upgrading to save up to 20%!");
            System.out.println("Your total is: $" + twoDecimals.format(total));
        }
        checkInventory();   //checks if any inventory stocks have fallen to 0
    }

    /**
     * This method allows a user to search for a product information via title
     */
    public void searchProductInformation() {
        counter = products.size();
        if (counter == 0) { //method will break if there are no products available
            System.out.println("There are no products in inventory!");
            return; //returns to product menu
        }

        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the title of the product:");  //user enters title here
        search = input.nextLine();

        System.out.println("Searching...");
        int foundId = 0;    //resets variable

        for (int i = 0; i < products.size(); i++) { //the following makes an object of the extended class to allow access to extended methods
            if (products.get(i).getTitle().equalsIgnoreCase(search) && products.get(i) instanceof Book) {   //gets info if book
                foundId = products.get(i).getId();  //gets id
                Book product = (Book) products.get(i);  //creates book object
                productType = 0;    //sets product type to book
                basicProductInfo(i);    //gets basic product info
                author = product.getAuthor();   //gets author
                publisher = product.getPublisher(); //gets publisher
                numPages = product.getNumPages();   //gets number of pages
            } else if (products.get(i).getTitle().equalsIgnoreCase(search) && products.get(i) instanceof CD) {  //gets info if cd
                foundId = products.get(i).getId();  //gets id
                CD product = (CD) products.get(i);  //creates cd object
                productType = 1;    //sets product type to cd
                basicProductInfo(i);    //gets basic product info
                artist = product.getArtist();   //gets artist
                numTracks = product.getNumTracks(); //gets number of tracks
                tracks = product.getTracks();   //gets list of tracks
            } else if (products.get(i).getTitle().equalsIgnoreCase(search) && products.get(i) instanceof DVD) { //gets info if dvd
                foundId = products.get(i).getId();  //gets id
                DVD product = (DVD) products.get(i);    //creates dvd object
                productType = 2;    //sets product type to dvd
                basicProductInfo(i);    //gets basic product info
                director = product.getDirector();   //gets director
                actor = product.getActor(); //gets main actor
                movieLength = product.getMovieLength(); //get dvd length
            }
        }
        if (foundId == 0) { //prints if there are products with that title
            System.out.println("There is no product with that title in stock.\n");
        } else if (productType == 0) {  //prints all available information of book if found in tabular format
            System.out.printf("%-10s%-35s%-20s%-10s%-25s%-20s%-12s", "ID", "Title", "Amount in Stock", "Price", "Author", "Publisher", "Number of Pages");
            System.out.println();
            System.out.printf("%-10s%-35s%-20s%-10s%-25s%-20s%-12s", id, title, amountInStock, price, author, publisher, numPages);
            System.out.println();
        } else if (productType == 1) {  //prints all available information of cd if found in tabular format
            System.out.printf("%-10s%-35s%-20s%-10s%-15s%-20s%-12s", "ID", "Title", "Amount in Stock", "Price", "Artist", "Number of Tracks", "Tracks");
            System.out.println();
            System.out.printf("%-10s%-35s%-20s%-10s%-15s%-20s%-12s", id, title, amountInStock, price, artist, numTracks, Arrays.toString(tracks));
            System.out.println();
        } else if (productType == 2) {  //prints all available information of dvd if found in tabular format
            System.out.printf("%-10s%-35s%-20s%-10s%-15s%-20s%-12s", "ID", "Title", "Amount in Stock", "Price", "Director", "Main Actor", "Movie Length(in hours)");
            System.out.println();
            System.out.printf("%-10s%-35s%-20s%-10s%-15s%-20s%-12s", id, title, amountInStock, price, director, actor, movieLength);
            System.out.println();
        }
    }

    /**
     * This method checks if any products have reached 0 in stock and removes
     * them from the products array list
     */
    public void checkInventory() {
        for (int i = 0; i < products.size(); i++) {  //goes through full list
            if (products.get(i).getAmountInStock() == 0) {   //if product stock is 0, it is removed from list
                products.remove(i);
            }
        }
    }

    /**
     * This method allows a user to search for member information via name
     */
    public void searchMemberInformation() {
        counter = members.size();
        if (counter == 0) { //method will break if there are no members to search
            System.out.println("There are no members in the system!");
            return; //returns to member menu
        }

        input = new Scanner(System.in); //new scanner to avoid input errors

        System.out.println("Enter the name of the member"); //user enters name of member here
        search = input.nextLine();

        System.out.println("Searching...");
        int foundId = 0;    //resets variable

        for (int i = 0; i < members.size(); i++) {  //loops through full array list and determines if name belongs to premium member or regular
            if (members.get(i).getName().equalsIgnoreCase(search) && members.get(i) instanceof Premium) {   //if name matches premium member
                foundId = members.get(i).getMemberId(); //gets id
                Premium member = (Premium) members.get(i);  //creates premium object
                memberType = 1; //sets member type to premium
                basicMemberInfo(i); //gets basic member info
                hasPaid = member.isHasPaid();   //gets premium status
                discount = member.getDiscount();    //gets discount
            } else if (members.get(i).getName().equalsIgnoreCase(search) && members.get(i) instanceof Member) { //if name belongs to regular member
                foundId = members.get(i).getMemberId(); //gets id
                memberType = 0; //sets memeber type to regular
                basicMemberInfo(i); //gets basic member info
            }
        }
        if (foundId == 0) { //prints if no member has the name
            System.out.println("There is no member with that name.\n");
        } else if (memberType == 1) {   //prints premium member info in tabular format
            System.out.printf("%-10s%-25s%-15s%-10s%-15s", "ID", "Name", "Amount Spent", "Premium", "Discount");
            System.out.println();
            System.out.printf("%-10s%-25s%-15s%-10s%-15s", memberId, name, amountSpent, hasPaid, discount);
            System.out.println();
        } else if (memberType == 0) {   //prints regular member info in tabular format
            System.out.printf("%-10s%-25s%-15s", "ID", "Name", "Amount Spent");
            System.out.println();
            System.out.printf("%-10s%-25s%-15s", memberId, name, amountSpent);
            System.out.println();
        }
    }

    /**
     * This method gets basic product information at location i in the products
     * array list
     *
     * @param i This comes from the position in the products array list when the
     * method is called
     */
    public void basicProductInfo(int i) {
        id = products.get(i).getId();   //gets id
        title = products.get(i).getTitle(); //gets title
        amountInStock = products.get(i).getAmountInStock(); //gets amount in stock
        price = products.get(i).getPrice(); //gets price
    }

    /**
     * This method gets basic member information at location i in the members
     * array list
     *
     * @param i This comes from the position in the members array list when the
     * method is called
     */
    public void basicMemberInfo(int i) {
        name = members.get(i).getName();    //gets name
        memberId = members.get(i).getMemberId();    //gets id
        amountSpent = members.get(i).getAmountSpent();  //gets amount spent
    }

    /**
     * This method prints a list of all available products
     */
    public void printProducts() {
        counter = products.size();  //method will break if products array list is empty
        if (counter == 0) {
            System.out.println("There are no products in the system!\n");
            return; //returns to product menu
        }

        System.out.println("Printing products...\n");

        System.out.println("Books...\n");
        System.out.printf("%-10s%-30s%-15s", "ID", "Title", "Price");   //sets table
        System.out.println();
        for (int i = 0; i < products.size(); i++) { //prints all instances of books
            if (products.get(i) instanceof Book) {  //calls method if book is found
                basicPrintInfoProd(i);
            }
        }

        System.out.println("\nCDs...\n");
        System.out.printf("%-10s%-30s%-15s", "ID", "Title", "Price");   //sets table
        System.out.println();
        for (int i = 0; i < products.size(); i++) { //prints all instances of cds
            if (products.get(i) instanceof CD) {    //calls method if cd is found
                basicPrintInfoProd(i);
            }
        }

        System.out.println("\nDVDs...\n");
        System.out.printf("%-10s%-30s%-15s", "ID", "Title", "Price");   //sets table
        System.out.println();
        for (int i = 0; i < products.size(); i++) { //prints all instance of dvds
            if (products.get(i) instanceof DVD) {   //calls method if dvd is found
                basicPrintInfoProd(i);
            }
        }
        System.out.println();   //formatting line
    }

    /**
     * This method prints a list of members in the system
     */
    public void printMembers() {
        counter = members.size();  //method will break if products array list is empty
        if (counter == 0) {
            System.out.println("There are no members in the system!\n");
            return; //returns to product menu
        }

        System.out.println("Printing members...\n");
        System.out.printf("%-10s%-20s%-15s", "ID", "Name", "Amount Spent"); //sets table
        System.out.println();
        System.out.println("Premium Members...\n");
        for (int i = 0; i < members.size(); i++) {  //prints all instances of premium members
            if (members.get(i) instanceof Premium) {    //calls method if premium member is found
                basicPrintInfoMem(i);
            }
        }

        System.out.println("\nRegular Members...\n");
        System.out.printf("%-10s%-20s%-15s", "ID", "Name", "Amount Spent"); //sets table
        System.out.println();
        for (int i = 0; i < members.size(); i++) {  //prints all instances of regular members
            if (!(members.get(i) instanceof Premium)) { //calls method if regular member is found
                basicPrintInfoMem(i);
            }
        }
        System.out.println();   //formatting line
    }

    /**
     * This method prints a product's information in tabular format
     *
     * @param i This is the location of the object being called in the products
     * array list
     */
    public void basicPrintInfoProd(int i) {
        System.out.printf("%-10s%-30s%-15s", products.get(i).getId(), products.get(i).getTitle(), twoDecimals.format(products.get(i).getPrice()));  //prints all product fields
        System.out.println();
    }

    /**
     * This method prints a member's information in tabular format
     *
     * @param i This is the location of the object being called in the members
     * array list
     */
    public void basicPrintInfoMem(int i) {
        System.out.printf("%-10s%-20s%-15s", members.get(i).getMemberId(), members.get(i).getName(), twoDecimals.format(members.get(i).getAmountSpent()));  //gets basic member info and prints
        System.out.println();
    }

    /**
     * This method checks if an ID number is already taken by another product
     */
    public void idChecker() {
        while (true) {   //loops until user enters an id not taken
            id = input.nextInt();   //enters id here
            input.nextLine();
            counter = 0;

            for (int i = 0; i < products.size(); i++) { //loops through products array list checking for id
                if (id == products.get(i).getId()) {    //if id is found
                    System.out.println("That ID number is taken, please try another:"); //prints this statement
                    counter++;  //increments counter
                    break;  //breaks loop immediately
                }
            }
            if (counter == 0) {  //if coutner is 0, then id is valid, breaks while loop
                break;
            }
        }
    }

    /**
     * This method checks if an ID number is taken by another member
     */
    public void memIdChecker() {
        while (true) {   //loops until user enters an id not taken
            memberId = input.nextInt(); //enters id here
            input.nextLine();
            counter = 0;

            for (int i = 0; i < members.size(); i++) {  //loops through products array list checking for id
                if (memberId == members.get(i).getMemberId()) { //if id is found
                    System.out.println("That ID number is taken, please try another:"); //prints this statement
                    counter++;  //increments counter
                    break;  //breaks loop immediately
                }
            }
            if (counter == 0) {  //if counter is 0, then id is valid, breaks while loop
                break;
            }
        }
    }
}
