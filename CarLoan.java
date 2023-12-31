//Imports
import java.util.Scanner;
import java.util.*;

/**
 * PROGRAM TITLE: Car Loan Calculator
 * 
 * ELEMENT LIST: functions, if else statements, do while loop, system.out.printf, continue, break, double, arithmetic operators
 * 
 * PROGRAM DESCRIPTION: This program will caluclate a car loan for a user
 * 
 */
public class CarLoan
{
    /**
     * Constructor for objects of class CarLoan
     */
    public CarLoan()
    {
        
    } //END of CarLoan()
    
    
    
    /**
     * Intro function displays user welcome text
     * 
     * @param none
     * @returns nothing
     */
    public static void intro() {
        
        System.out.println("-----------------------------------------------------");
        System.out.println("CAR LOAN CALCULATOR\n");
        System.out.println("Welcome to BlueShore Financial's car loan calculator");
        System.out.println("This program will take in your loan, loan length, interest rate and down payment."); //program explanation
        System.out.println("It will then calculate your monthly cost\n");
        System.out.println("-----------------------------------------------------");
        
    } //END of intro()
    
    
    
    /**
     * Outro function displays goodbye text
     * 
     * @param none
     * @returns nothing
     */
    public static void outro() {
    
        System.out.println("-----------------------------------------------------");
        System.out.println("Thanks for using this program."); //thank u msg
        System.out.println("Have a nice day and be sure to come back!");
        System.out.println("-----------------------------------------------------");
        
    } //END of outro()
    
    
    
    /**
     * Input function lets user input a double value
     * 
     * @params none
     * @returns a double value
     * 
     */
    public static double inputPrompt(){
        
        double input;
        Scanner userInput = new Scanner(System.in); //new scanner object
        
        while (true) {
            if (userInput.hasNextDouble()){
                
                input = userInput.nextDouble(); //sets input to the double value in scanner
                break;
                
            } else if (userInput.hasNext()){
                
                System.out.println("You entered " + userInput.next()); //takes whatever the value of the data in the scanner
                System.out.println("Please enter a numerical value");
                    
            }
        }
        
        return input;
    
    } //END of inputPrompt()
    
    

    /**
     * Main method
     * 
     * 
     */
    public static void main(String[] args) {
        //Variable declarations
        double carLoan;
        double loanLength;
        double interestRate;
        double downPayment;
        double remainingBalance;
        double months; 
        double monthlyBalance; //Stores monthly cost of loan
        double interest;
        double monthlyPayment; 
        double roundAnswer; 
        double anotherLoan;
        double biweekly;
        double weekly;
        String line = "-----------------------------------------------------";
        LoanFrame runGui = new LoanFrame(); //runs gui program
        
        
        
        do {
            //USER INTERFACE
            intro(); //calls intro function           
            
            
            //PRIMARY INPUTS
            System.out.println("Enter the loan amount you would like");
            System.out.print("You entered: $"); //REITERATES user input
            
            carLoan = inputPrompt(); //input for carLoan
            
            System.out.println("\nEnter the loan length (in months)");
            System.out.print("You entered: ");
            
            loanLength = inputPrompt(); //input for loanLength
            
            System.out.println("\nEnter the interest rate");
            System.out.print("You entered: ");
            
            interestRate = inputPrompt(); //input for interestRate
            
            System.out.println("\nEnter the down payment");
            System.out.print("You entered: $");
            
            downPayment = inputPrompt(); //input for downPayment
    
            
            
            //MAIN
            if ((loanLength <= 0) || (interestRate <= 0)) {
                
                System.out.println("Error! You must take out a valid car loan"); //error message
            
            } else if ((downPayment) >= (carLoan)) {
            
                System.out.println("The car can be paid in full. Why are you even here???"); //if the down payment already covers car loan
            
            } else {
                //PRIMARY CALCULATIONS
                remainingBalance = (carLoan - downPayment);
                monthlyBalance = (remainingBalance / loanLength);
                interest = ((monthlyBalance * interestRate) / 100);
                monthlyPayment = (monthlyBalance + interest);
                biweekly = (monthlyBalance + interest) / 2;
                weekly = (monthlyBalance + interest) / 4; //divides monthly balance by 4 for weekly cost
                
                //PRIMARY OUTPUT
                System.out.println("\f");
                System.out.println(line);
                System.out.printf("Loan: $%.2f %n", carLoan);
                System.out.printf("Down Payment: $%.2f %n", downPayment);
                System.out.printf("Principle: $%.2f %n", remainingBalance);
                System.out.println("Loan term: " + loanLength + " months\n");
                System.out.println("Interest Rate: " + interestRate + "%");
                System.out.printf("Interest: $%.2f %n", interest);
                System.out.printf("Monthly without interest: $%.2f %n", monthlyBalance);
                System.out.println("\nCost with interest: "); //outputs cost with interest included
                System.out.printf("Monthly: $%.2f %n", monthlyPayment);
                System.out.printf("Biweekly: $%.2f %n", biweekly);
                System.out.printf("Weekly: $%.2f %n", weekly);
                System.out.println(line);
            
            } //END of if ((loanLength <= 0) || (interestRate <= 0)) 
        
            
            System.out.println("\nWould you like to calculate another loan?\n\nYes: 0\nNo: 1"); //ask if user wants to redo program
            anotherLoan = inputPrompt();
            
            
            if (anotherLoan == 1) {
                
                System.out.println("\f");
                outro();
                break; //breaks out of loop
                
            } else if (anotherLoan == 0) {
                
                System.out.println("\f");
                continue; //continues loop
                
            } //END of if (anotherLoan == 1)
            //END of MAIN
            
            
            
        } while (true); //END of do while(true)

        
        
        
    } //END of main
    
    

    
} //END of CarLoan class



/*
 * 
 * 
 * 
 * 
 * NOTES:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * TEST CODE:
 * 
 * 
 * 
 * 
 */



