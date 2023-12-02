// base code for student budget assessment
// Students do not need to use this code in their assessment, fine to junk it and do something different!
//
// Your submission must be a maven project, and must be submitted via Codio, and run in Codio
//
// user can enter in wages and loans and calculate total income
//
// run in Codio 
// To see GUI, run with java and select Box Url from Codio top line menu
//
// Layout - Uses GridBag layout in a straightforward way, every component has a (column, row) position in the UI grid
// Not the prettiest layout, but relatively straightforward
// Students who use IntelliJ or Eclipse may want to use the UI designers in these IDEs , instead of GridBagLayout
package Budget;

// Swing imports
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// class definition
public class BudgetBase extends JPanel {    // based on Swing JPanel

    // high level UI stuff
    JFrame topLevelFrame;  // top-level JFrame
    GridBagConstraints layoutConstraints = new GridBagConstraints(); // used to control layout

    // widgets which may have listeners and/or values
    private JButton calculateButton;   // Calculate button
    private JButton exitButton;        // Exit button

    public JTextField wagesField;     // Wages text field
    public JTextField loansField;     // Loans text field
    public JTextField savingsField; //Savings text field
    public JTextField familyField; //Family text field
    public JTextField otherIncomeField; //Other text fields
    public JTextField totalIncomeField; // Total Income field

    public JTextField foodField; //Food text field
    public JTextField rentField; //Rent text field
    public JTextField commutingField; //Commuting text field
    public JTextField billsField; //bills text field
    public JTextField entertainmentField; //Entertainment text field
    public JTextField otherSpendingField; //Other(spending) text field
    public JTextField totalSpendingField; //Total Speding field

    private JTextField totalBudgetField; //total budget text field (for the surplus/deficit)

    // constructor - create UI  (dont need to change this)
    public BudgetBase(JFrame frame) {
        topLevelFrame = frame; // keep track of top-level frame
        setLayout(new GridBagLayout());  // use GridBag layout
        initComponents();  // initalise components
    }

    // initialise componenents
    // Note that this method is quite long.  Can be shortened by putting Action Listener stuff in a separate method
    // will be generated automatically by IntelliJ, Eclipse, etc
    private void initComponents() { 

        // Top row (0) - "INCOME" label
        JLabel incomeLabel = new JLabel("INCOME");
        addComponent(incomeLabel, 0, 0);

        // Row 1 - Wages label followed by wages textbox
        JLabel wagesLabel = new JLabel("Wages");
        addComponent(wagesLabel, 1, 0);

        // set up text field for entering wages
        // Could create method to do below (since this is done several times)
        wagesField = new JTextField("", 10);   // blank initially, with 10 columns
        wagesField.setHorizontalAlignment(JTextField.RIGHT) ;    // number is at right end of field
        addComponent(wagesField, 1, 1);

        // Row 2 - Loans label followed by loans textbox
        JLabel loansLabel = new JLabel("Loans");
        addComponent(loansLabel, 2, 0);

        // set up text box for entering loans
        loansField = new JTextField("", 10);   // blank initially, with 10 columns
        loansField.setHorizontalAlignment(JTextField.RIGHT) ;    // number is at right end of field
        addComponent(loansField, 2, 1); 

        /*
        added other income labels:

        - savings
        - family and
        - other incomes
        */
        JLabel savingsLabel = new JLabel("Savings");
        addComponent(savingsLabel, 3, 0);

        savingsField = new JTextField("", 10);
        savingsField.setHorizontalAlignment(JTextField.RIGHT) ;
        addComponent(savingsField, 3, 1);

        JLabel familyLabel = new JLabel("Family");
        addComponent(familyLabel, 4, 0);

        familyField = new JTextField("", 10);
        familyField.setHorizontalAlignment(JTextField.RIGHT) ;
        addComponent(familyField, 4, 1);

        JLabel otherIncomeLabel = new JLabel("Other income");
        addComponent(otherIncomeLabel, 5, 0);

        otherIncomeField = new JTextField("", 10);
        otherIncomeField.setHorizontalAlignment(JTextField.RIGHT) ; 
        addComponent(otherIncomeField, 5, 1);

        // Row 3 - Total Income label followed by total income field
        JLabel totalIncomeLabel = new JLabel("Total Income");
        addComponent(totalIncomeLabel, 6, 0);

        // set up text box for displaying total income.  Users cam view, but cannot directly edit it
        totalIncomeField = new JTextField("0", 10);   // 0 initially, with 10 columns
        totalIncomeField.setHorizontalAlignment(JTextField.RIGHT) ;    // number is at right end of field
        totalIncomeField.setEditable(false);    // user cannot directly edit this field (ie, it is read-only)
        addComponent(totalIncomeField, 6, 1);  

        //SPENDING label

        /*also added relevant spending labels:
        - food
        - rent
        - commuting
        - bills
        - Entertainment
        - other spending
        */
        JLabel emptyLabel = new JLabel(" ");
        addComponent(emptyLabel, 7, 0);

        JLabel spendingLabel = new JLabel("SPENDING");
        addComponent(spendingLabel, 8, 0);

        JLabel foodLabel = new JLabel("Food");
        addComponent(foodLabel, 9, 0);

        foodField = new JTextField("", 10);
        foodField.setHorizontalAlignment(JTextField.RIGHT) ;
        addComponent(foodField, 9, 1);

        JLabel rentLabel = new JLabel("Rent");
        addComponent(rentLabel, 10, 0);
        rentField = new JTextField("", 10);
        rentField.setHorizontalAlignment(JTextField.RIGHT) ;
        addComponent(rentField, 10, 1);

        JLabel commutingLabel = new JLabel("Commuting");
        addComponent(commutingLabel, 11, 0);
        commutingField = new JTextField("", 10);
        commutingField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(commutingField, 11, 1);

        JLabel billsLabel = new JLabel("Bills");
        addComponent(billsLabel, 12, 0);
        billsField = new JTextField("", 10);
        billsField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(billsField, 12, 1);

        JLabel entertainmentLabel = new JLabel("Entertainment");
        addComponent(entertainmentLabel, 13, 0);
        entertainmentField = new JTextField("", 10);
        entertainmentField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(entertainmentField, 13, 1);

        JLabel otherSpendingLabel = new JLabel("Other spending");
        addComponent(otherSpendingLabel, 14, 0);
        otherSpendingField = new JTextField("", 10);
        otherSpendingField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(otherSpendingField, 14, 1);

        JLabel totalSpendingLabel = new JLabel("Total Spending");
        addComponent(totalSpendingLabel, 15, 0);
        // set up text box for displaying total spending.  Users can view, but cannot directly edit it
        totalSpendingField = new JTextField("0", 10);   // 0 initially, with 10 columns
        totalSpendingField.setHorizontalAlignment(JTextField.RIGHT) ;    // number is at right end of field
        totalSpendingField.setEditable(false);    // user cannot directly edit this field (ie, it is read-only)
        addComponent(totalSpendingField, 15, 1);  

        JLabel emptyLabel2 = new JLabel(" ");
        addComponent(emptyLabel2, 16, 0);

        //added a total budget label to calculate the surplus/deficit from the income and spending calculations
        JLabel totalBudgetLabel = new JLabel("Total Budget");
        addComponent(totalBudgetLabel, 17, 0);
        totalBudgetField = new JTextField("", 10);
        totalBudgetField.setHorizontalAlignment(JTextField.RIGHT);
        totalBudgetField.setEditable(false);
        addComponent(totalBudgetField, 17, 1);

        // Row 4 - Calculate Button
        calculateButton = new JButton("Calculate");
        addComponent(calculateButton, 18, 0);  

        // Row 5 - Exit Button
        exitButton = new JButton("Exit");
        addComponent(exitButton, 19, 0);  

        // set up  listeners (in a spearate method)
        initListeners();
    }

    // set up listeners
    // initially just for buttons, can add listeners for text fields
    private void initListeners() {

        // exitButton - exit program when pressed
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // calculateButton - call calculateTotalIncome() and calculateTotalSpending() when pressed
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalIncome();
                calculateTotalSpending();
                calculateTotalBudget();
            }
        });

    }

    // add a component at specified row and column in UI.  (0,0) is top-left corner
    private void addComponent(Component component, int gridrow, int gridcol) {
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;   // always use horixontsl filll
        layoutConstraints.gridx = gridcol;
        layoutConstraints.gridy = gridrow;

        add(component, layoutConstraints);

    }

    // update totalIncomeField (eg, when Calculate is pressed)
    // use double to hold numbers, so user can type fractional amounts such as 134.50
    public double calculateTotalIncome() {

        double[] incomeSources = {
        // get values from income text fields.  valie is NaN if an error occurs
        getTextFieldValue(wagesField),
        getTextFieldValue(loansField),
        getTextFieldValue(savingsField),
        getTextFieldValue(familyField),
        getTextFieldValue(otherIncomeField)
        };

        // clear total field and return if any value is NaN (error)
        for(double income : incomeSources){
            if (Double.isNaN(income)) {
                totalIncomeField.setText("");  // clear total income field
                return 0.0; //exit method and do nothing
            }
        }

        // otherwise calculate total income and update text field
        double totalIncome = 0.0;
        for(double income : incomeSources){
            totalIncome += income;
        }
        
        totalIncomeField.setText(String.format("%.2f",totalIncome));  // format with 2 digits after the .
        return totalIncome;
    }

    public double calculateTotalSpending(){
        double [] spendingSources = {
            getTextFieldValue(foodField),
            getTextFieldValue(rentField),
            getTextFieldValue(commutingField),
            getTextFieldValue(billsField),
            getTextFieldValue(entertainmentField),
            getTextFieldValue(otherSpendingField)
        };

        //clear total field if any value is NaN 
        for(double spending : spendingSources){
            if(Double.isNaN(spending)){
                totalSpendingField.setText("");
                return 0.0;
            }
        }

        //otherwise calculate the total spending abd update the text field
        double totalSpending = 0.0;
        for(double spending : spendingSources){
            totalSpending += spending;
        }
        
        totalSpendingField.setText(String.format("%.2f",totalSpending));
        return totalSpending;
        }


        public double calculateTotalBudget(){
            double Income = calculateTotalIncome();
            double Spending = calculateTotalSpending();

            double Budget = Income - Spending;
            if(Budget < 0){
                totalBudgetField.setForeground(Color.red);
            } else {
                totalBudgetField.setForeground(Color.black);
            }

            totalBudgetField.setText(String.format("%.2f", Budget));

            return Budget;
        }

    // return the value if a text field as a double
    // --return 0 if field is blank
    // --return NaN if field is not a number
    private double getTextFieldValue(JTextField field) {

        // get value as String from field
        String fieldString = field.getText();  // get text from text field

        if (fieldString.isBlank()) {   // if text field is blank, return 0
            return 0;
        }

        else {  // if text field is not blank, parse it into a double
            try {
                return Double.parseDouble(fieldString);  // parse field number into a double
             } catch (java.lang.NumberFormatException ex) {  // catch invalid number exception
                JOptionPane.showMessageDialog(topLevelFrame, "Please enter a valid number");  // show error message
                return Double.NaN;  // return NaN to show that field is not a number
            }
        }
    }


// below is standard code to set up Swing, which students shouldnt need to edit much
    // standard mathod to show UI
    private static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("Budget Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        BudgetBase newContentPane = new BudgetBase(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    // standard main class to set up Swing UI
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }


}