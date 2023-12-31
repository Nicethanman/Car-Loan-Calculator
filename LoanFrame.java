//Imports
import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The class Images is used to demo a basic GUI (Graphical user Interface) or empty JFrame, 
 * The following code is desigend to show students the keywords and sytax needed to gernerate an empty JFrame (no buttons, no text boxes, no window listeners).
 *
 * @author (John Vatougios)
 * @version (Version #1)
 */
public class LoanFrame implements ActionListener
{
    // Define Frame Objects
        
    JFrame myFrame; // By defining the objects here they become global variables, meaning they are accessible by any method wihtin this class / file
    JPanel myPanel0;
    JPanel myPanel1;
    JPanel myPanel2;
    JPanel myPanel3;
    JPanel myPanel4;
    JLabel title;
    JLabel carAge;
    JTextField amountLoan;
    JTextField lengthLoan;
    JTextField loanInterest;
    JTextField paymentDown;
    JRadioButton badScore;
    JRadioButton okScore;
    JRadioButton goodScore;
    JButton submit;
    JLabel userOutput;
    JLabel creditScore;
    
        
    
    /**
     * Constructor for objects of class JFrameExemplar
     */
    public LoanFrame()
    {
        // Building Frame Objects
        myFrame = new JFrame(); 
        myPanel0 = new JPanel();
        myPanel1 = new JPanel();
        myPanel2 = new JPanel();
        myPanel3 = new JPanel();
        myPanel4 = new JPanel();
        title = new JLabel("CAR LOAN CALCULATOR");
        carAge = new JLabel("What's your credit score");
        badScore = new JRadioButton("0-350");
        okScore = new JRadioButton("351-650");
        goodScore = new JRadioButton("651+");
        amountLoan = new JTextField("Enter loan amount");
        lengthLoan = new JTextField("Enter loan length (months)");
        loanInterest = new JTextField("Enter loan interest (%)");
        paymentDown = new JTextField("Enter down payment");
        submit = new JButton("SUBMIT");
        userOutput = new JLabel("");
        creditScore = new JLabel("");
        
        
        myFrame.setLayout(new GridLayout (5,1));
        
        
        myFrame.add(myPanel0);
        myFrame.add(myPanel1);
        myFrame.add(myPanel2);
        myFrame.add(myPanel3);
        myFrame.add(myPanel4);   
    
        
        myPanel0.setLayout(new GridLayout(1,1,20,20));
        myPanel1.setLayout(new GridLayout(4,1,40,0));
        myPanel2.setLayout(new GridLayout(4,1,0,0));
        myPanel3.setLayout(new GridLayout(1,1,0,0));
        myPanel4.setLayout(new GridLayout(1,2,0,0));
        
        
        myPanel0.add(title);
        
        
        myPanel1.add(amountLoan);
        myPanel1.add(lengthLoan);
        myPanel1.add(loanInterest);
        myPanel1.add(paymentDown);
        
        
        ButtonGroup score = new ButtonGroup();
        score.add(badScore);
        score.add(goodScore);
        score.add(okScore);
        
        
        myPanel2.add(carAge);
        myPanel2.add(badScore);
        myPanel2.add(okScore);
        myPanel2.add(goodScore);
        
        
        myPanel3.add(submit);
        myPanel3.setSize(10,10);
        
        
        myPanel4.add(userOutput);
        myPanel4.add(creditScore);
        
        
        submit.addActionListener(this);

        carAge.setFont(new Font("Serif", Font.BOLD, 22));
        
        
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        
        
        userOutput.setFont(new Font("Serif", Font.BOLD, 18));
        userOutput.setHorizontalAlignment(JLabel.CENTER);
        userOutput.setVerticalAlignment(JLabel.CENTER);
        
        
        creditScore.setFont(new Font("Serif", Font.BOLD, 16));
        creditScore.setHorizontalAlignment(JLabel.CENTER);
        creditScore.setVerticalAlignment(JLabel.CENTER);
        
        
        // Position and Size the Frame
        myFrame.setSize(800,800);
        
        
        //set the title of the GUI being created
        myFrame.setTitle("Car Loan Calculator");
        
        
        //Must make the Frame Visible
        myFrame.setVisible(true);
        
        
        // This will end the program when the JFrame is closed, otherwise it will run in the background FOREVER!!!!!!
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        double loan = Double.parseDouble(amountLoan.getText());
        double length = Double.parseDouble(lengthLoan.getText());
        double findInterest = Double.parseDouble(loanInterest.getText());
        double down = Double.parseDouble(paymentDown.getText());
        double balanceRemaining;
        double interest;
        double balanceMonthly;
        double paymentMonthly;
        double roundMonthly;
        double loanRemaining;
        
        
        if (e.getSource() == submit) {
            
            
            if(badScore.isSelected()){
                
                loan = (Double.parseDouble(amountLoan.getText())) / 2;
                creditScore.setText("$" + Double.toString(loan) + " could not be loaned because of your credit score");
            
            } else if (okScore.isSelected()) {
                loanRemaining = loan * 0.25;
                loan = Double.parseDouble(amountLoan.getText()) * 0.75;
                creditScore.setText("$" + Double.toString(loanRemaining) + " could not be loaned because of your credit score");
                
            } else if (goodScore.isSelected()) {
            
                loan = Double.parseDouble(amountLoan.getText());
                creditScore.setText("Your full loan can be taken out. WOOHOO!!!");
            
            } else {
                
                creditScore.setText("Error! Please select a proper credit score");
            
            }
            
            
            balanceRemaining = (loan - down);
            balanceMonthly = (balanceRemaining / length);
            interest = ((balanceMonthly * findInterest) / 100);
            paymentMonthly = (balanceMonthly + interest);
            roundMonthly = Math.round(paymentMonthly * 100 / 100);
            
            
            if (roundMonthly <= 0) {
            
                userOutput.setText("Invalid loan. Please check entered data");
                
            } else {
                
                userOutput.setText("Monthly Payment: $" + Double.toString(roundMonthly));
                
            }
            
            
        }
       
        
    }    

    
    /*    
    public static void main (String[] args) 
    {
        LoanFrame runGui = new LoanFrame();
    }
    */

}