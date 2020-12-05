/*
 * 
 * 
 * 
 */
package vendingmachine;

/**
 *
 * @author GEPERSON.PH
 */
public class CashRegister {
    private int cashOnHand;
    
    
    public CashRegister(){
        cashOnHand = 500;
    }
    
    public CashRegister(int cashIn){
        if(cashIn >= 0){
            cashOnHand = cashIn;
        }else{
            cashOnHand = 500;
        }
        
        cashOnHand = 500;
    }
    public int currentBalance(){
        System.out.println("Current Amount: "+ cashOnHand);
        return cashOnHand;
    }
    
    public void acceptAmount(int amountIn){
        cashOnHand = cashOnHand + amountIn;
    }
    
    
    
}
