package controllers;
import views.Window;
import models.ClothingStore;
import models.Brands;
import models.ErroridNotFound;
import models.ErrorTheBaseDataIsFull;

public class Controller {
    private Window window;
    private ClothingStore clothingStore;
    private boolean running;
    
    public Controller() throws ErroridNotFound{
        window = new Window();
        clothingStore = new ClothingStore();
        running = true;
        controlActions();
    }
    public void controlActions() throws ErroridNotFound{
        while (running){ 
            
            switch (window.getOption()){  
                case ADD_TO_THE_DATABASE:
                    switch (window.getActionOfAdd()){  
                        case ADD_CUSTOMER:
                        addCustomer();
                        break; 
                        case ADD_SALE:
                            addSale();
                            break;
                        case ADD_SELLER:
                            addSeller();
                            break;
                    }        
                break;    
                case PERFORM_AN_OPERATION:
                    switch (window.getActionOfOoeration()){
                        case SHOW_SALARYS:
                            showSalary();
                            break;
                        case SHOW_SALES_AND_EARNINGS:
                            showSalesAndEarnigs();
                            break;
                        case REWARDING_BEST_SELLER:
                            rewardingBestSeller();
                            break;    
                        case FIRE_BAD_SELLER:
                            fireBadSeller();
                            break;   
                        case COUPON_TO_THE_BEST_COUSTOMERS:
                            couponToTheBestCoustomers();
                            break;
                        case DELETE_BAD_CUSTOMERS:
                            deleteBadCustomers();
                            break;
                        case RANDOM_DRAWING_OF_CUSTOMERS:
                            randomDrawingOfCustomers();
                            break;    
                            
                    }
                break;
                case INFORMATION:
                    showInformation();
                    break;
            }
        }
    }
    private void addCustomer(){
        int id = window.askForId("Customer");
        String name = window.askForName();
        try {
            clothingStore.addCustomer(clothingStore.createCustomer(id, name));
        } catch (ErrorTheBaseDataIsFull ex) {
             window.showMessage("¡Error!: The memory space this full." );
           return;
        }catch (ErroridNotFound ex) {
             window.showMessage("¡Error!: The id already in use, please check and try again." );
           return;
        }
        window.showMessage(" client " + name + " added to the system with the id: " +id);    
    }
   
    private void addSeller(){
        int id = window.askForId("Seller");
        String name = window.askForName();
        try {
            clothingStore.addSeller(clothingStore.createSeller(id, name));
        } catch (ErrorTheBaseDataIsFull ex) {
          window.showMessage("¡Error!: The memory space this full or the id already in use, please check and try again." );
           return;
        }
        window.showMessage(" Seller " + name + " added to the system with the id: " +id);    
    }
    private void addSale() throws ErroridNotFound {
        int idsale = window.askForId("Sale");
        int idSeller= window.askForId("Seller");
        int idcustomer = window.askForId("Customer"); 
        Brands brand = window.getBrand();
        int earning = window.askForNumber("earning"); 
        
        try {
            clothingStore.addSale(clothingStore.createSale(idsale, clothingStore.FindSellerById(idSeller), clothingStore.FindCustomerById(idcustomer), brand, earning));
        } catch (ErrorTheBaseDataIsFull ex) {
           window.showMessage("¡Error!: The memory space this full, please check and try again." );
           return;
        }catch (ErroridNotFound ex) {
           window.showMessage("¡Error!: id of sale in use or id of customer/seller not found, please check and try again." );
           return;
        }
        window.showMessage("Sale number: " +idsale + " added to the database" );
    }
    private void showSalary(){
        String salary = clothingStore.ShowSalaryOfAllSellers();
        window.showMessage(salary);
    }
    private void showSalesAndEarnigs(){
        String salesAndEarnigs = clothingStore.ShowSalesAndEarnings();
        window.showMessage(salesAndEarnigs);
    }
    private void rewardingBestSeller(){
        window.showMessage(clothingStore.RewardingBestSeller()+" was rewarded with 100000 in salary");    
    }
    private void fireBadSeller(){
        window.showMessage(clothingStore.fireBadSeller());        
    }
    private void couponToTheBestCoustomers(){
        String BestCoustomers = clothingStore.CouponToTheBestCustomer();
        window.showMessage(BestCoustomers);
    }
     private void showInformation(){
        window.showInformation();
    } 
    private void deleteBadCustomers(){
        String BadCustomers = clothingStore.deleteBadCustomers();
        window.showMessage(BadCustomers);
    } 
    private void randomDrawingOfCustomers(){
        String win = clothingStore.randomDrawingOfCustomers();
        window.showMessage(win);
    }
   
}
