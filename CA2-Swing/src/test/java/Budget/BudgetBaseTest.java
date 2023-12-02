package Budget;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Swing imports
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Unit test for swing application.
 * We can't test the GUI so we have to test methods that do the work.
 * Add more tests for any manipulations of values in your application.
 * Rewrite methods so that they are not void, but return values, and can be tested.
 */
public class BudgetBaseTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldTotal()
    {
        JFrame frame = new JFrame();
        BudgetBase bb = new BudgetBase(frame);
        double value = 0.0;

        assertEquals(value, bb.calculateTotalIncome() );
    }

    @Test
    public void shouldTotalUserInput(){
        JFrame frame = new JFrame();
        BudgetBase bb = new BudgetBase(frame);

        bb.wagesField.setText("10000");
        bb.loansField.setText("5000");
        bb.savingsField.setText("234.34");
        bb.familyField.setText("893.21");
        bb.otherIncomeField.setText("432.53");

        double result = bb.calculateTotalIncome();

        double expectedIncome = 10000 + 5000 + 234.34 + 893.21 + 432.53;
        assertEquals(expectedIncome, result, 0.01, "The total income should be correct based on user input");
    }
    
    @Test
    public void shouldTotalBudget()
    {
        JFrame frame = new JFrame();
        BudgetBase bb = new BudgetBase(frame);
        double value = 0.0;

        assertEquals(value, bb.calculateTotalBudget() );
    }

    @Test
    public void shouldTotalBudgetUserOutput(){
        JFrame frame = new JFrame();
        BudgetBase bb = new BudgetBase(frame);

        bb.wagesField.setText("10000");
        bb.loansField.setText("5000");
        bb.savingsField.setText("234.34");

        bb.billsField.setText("893.21");
        bb.entertainmentField.setText("432.53");
        bb.otherSpendingField.setText("543.12");

        double result = bb.calculateTotalBudget();
        double expectedBudget = (10000 + 5000 + 234.34) - (893.21 + 432.53 + 543.12); 
        assertEquals(expectedBudget, result, 0.01, "The budget should be correct based on user input for income and spending");

    }

    @Test
    public void shouldTotalSpending()
    {
        JFrame frame = new JFrame();
        BudgetBase bb = new BudgetBase(frame);
        double value = 0.0;

        assertEquals(value, bb.calculateTotalSpending());
    }

    @Test
    public void shouldTotalSpendingUserInput(){
        JFrame frame = new JFrame();
        BudgetBase bb = new BudgetBase(frame);

        bb.foodField.setText("10000");
        bb.rentField.setText("5000");
        bb.commutingField.setText("234.34");
        bb.billsField.setText("893.21");
        bb.entertainmentField.setText("432.53");
        bb.otherSpendingField.setText("543.12");

        double result = bb.calculateTotalSpending();

        double expectedSpending = 10000 + 5000 + 234.34 + 893.21 + 432.53 + 543.12;
        assertEquals(expectedSpending, result, 0.01, "The total spending should be correct based on user input");
    }

}
