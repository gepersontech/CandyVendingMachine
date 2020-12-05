
package vendingmachine;


import javax.swing.JOptionPane;

/**
 *
 * @author GEPERSON.PH
 */
public class Main {
               
    public static int coinsInserted;
    
    public static void main(String[] args) {
        CashRegister cRegister = new CashRegister();//creating the Cash Register 
        
        Dispenser candy = new Dispenser(100, 50);//Creating the four Dispenser
        Dispenser chips = new Dispenser(100,20);
        Dispenser gums = new Dispenser(500, 30);
        Dispenser cookies = new Dispenser(500, 25);
        
        
        int soldcandy=0,soldchips=0,soldgums=0,soldcookies=0, totalSales=0;//Declaring additional variables
        int change;
        String a;
        boolean s= true;
        
        do{
            showSelection(); //Showing the showSelection method
            
            a=JOptionPane.showInputDialog("Enter Selection: ");//Get the Selection
            switch(a){
                case "1":
                    JOptionPane.showMessageDialog(null, 
                            "Available Items: \t"+ candy.getCount());
                                    
                    sellProduct(candy,cRegister); //Call the sellPRoduct Method
                    if(coinsInserted>candy.getProductCost()){
                        change= coinsInserted - candy.getProductCost();
                        cRegister.acceptAmount(-change);
                        JOptionPane.showMessageDialog(null, "Please take your candy and your " + change + " pesos change!");
                    }
                    soldcandy++;
                    s=true;
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, 
                            "Available Items: \t"+ chips.getCount());
                    
                    sellProduct(chips,cRegister); //Call the sellPRoduct Method
                    
                    if(coinsInserted>chips.getProductCost()){
                        change= coinsInserted - chips.getProductCost();
                        cRegister.acceptAmount(-change);
                        JOptionPane.showMessageDialog(null, "Please take your candy and your " + change + " pesos change!");
                    }
                    soldchips++;
                    s=true;
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, 
                            "Available Items: \t"+ gums.getCount());
                    sellProduct(gums,cRegister); //Call the sellPRoduct Method
                     if(coinsInserted>gums.getProductCost()){
                        change= coinsInserted - gums.getProductCost();
                        cRegister.acceptAmount(-change);
                        JOptionPane.showMessageDialog(null, "Please take your candy and your " + change + " pesos change!");
                    }
                    soldgums++;
                    s=true;
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, 
                            "Available Items: \t"+ cookies.getCount());
                    sellProduct(cookies,cRegister); //Call the sellPRoduct Method
                     if(coinsInserted>gums.getProductCost()){
                        change= coinsInserted - gums.getProductCost();
                        cRegister.acceptAmount(-change);
                        JOptionPane.showMessageDialog(null, "Please take your candy and your " + change + " pesos change!");
                    }
                    soldcookies++;
                    s=true;
                    break;
                case "0":
                    //Exit the Program
                    s=false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid Input "
                                    + "\nType number only. Range [1-4]" );
                    s=false;
                    break;
            }
            
        }while(s);
        
        
        System.out.println("============= Sales Report File =============");//Additional Functionalities
        System.out.println("List of item sold.....\nItems\tQty\tPrice\tAmount");
        System.out.println("Candy\t"+soldcandy+"\t"+candy.getProductCost()+"\t"+soldcandy * candy.getProductCost());
        
        System.out.println("Chips\t"+soldchips+"\t"+chips.getProductCost()+"\t"+soldchips * chips.getProductCost());
        
        System.out.println("Gums\t"+soldgums+"\t"+gums.getProductCost()+"\t"+soldgums * gums.getProductCost());
        
        System.out.println("Cookies\t"+soldcookies+"\t"+cookies.getProductCost()+"\t"+soldcookies * cookies.getProductCost());
        
        totalSales=((soldcandy * candy.getProductCost())+(soldchips * chips.getProductCost())+
        (soldgums * gums.getProductCost())+(soldcookies * cookies.getProductCost()));
        System.out.println("Total Sales:\t"+totalSales);
        cRegister.currentBalance();//Current Balance plus Sales
        
        System.out.println("======== Item Inventory Report File ========");
        System.out.println("Items\tRemaining\tSold");
        System.out.println("Candy\t"+candy.getCount()+"\t\t"+soldcandy);
        System.out.println("Chips\t"+chips.getCount()+"\t\t"+soldchips);
        System.out.println("Gums\t"+gums.getCount()+"\t\t"+soldgums);
        System.out.println("Cookies\t"+cookies.getCount()+"\t\t"+soldcookies);
        
        System.out.println("\nThanks for purchasing candy through us.");
    }
    
    public static void showSelection(){
        
                JOptionPane.showMessageDialog(null, "*Enter Number to Buy Product.\nSelection: "
                + "\n   [1] Candy" 
                + "\n   [2] Chips "
                + "\n   [3] Gums"
                + "\n   [4] Cookies "
                + "\n \nEnter \"0\" to Exit the Program ");
    }
    
    public static void sellProduct(Dispenser product, CashRegister cRegister){
        int price;
        //coinsInserted;
        int coinsRequired;
        
        if (product.getCount()>0){
            price = product.getProductCost();
            coinsRequired = price;
            coinsInserted = 0;
            
            while(coinsRequired > 0){
                JOptionPane.showMessageDialog(null, "Please deposit "+ coinsRequired + " pesos");
                
                coinsInserted = coinsInserted + (Integer.parseInt(JOptionPane.showInputDialog( "Insert Coin: " ))); //The program error is append if the coinsInserted is Empty or input String is Empty.
                
                coinsRequired = price - coinsInserted;               
                                                            //missing statement to check if the amount entered is more than the cost of the item
                                                             //then, if posible, it returns the change.
            }                                                //posible that the machine could not accept more than or less than the cost of the item
            cRegister.acceptAmount(coinsInserted);
            product.makeSale();
            
            JOptionPane.showMessageDialog(null, "Collect your item at the bottom and enjoy.");
        }else{
            JOptionPane.showMessageDialog(null, "Sorry this item is sold out.");
        }
    }
    
}
