package models;
import java.util.Arrays;
import java.util.Random;

public class ClothingStore{
    
    private Seller[] listSeller;
    private Seller[] listBestSellers;
    private Customer[] listCustomer;
    private Sale[] listSale;
    public static final int MAX_SELLERS = 5;
    public static final int MAX_CUSTOMERS = 15;
    public static final int MAX_SALES = 20;
    Random aleatorio = new Random();
    
    public ClothingStore(){     
        listCustomer = new Customer [MAX_CUSTOMERS];
        listSale = new Sale[MAX_SALES];
        listSeller= new Seller[MAX_SELLERS];
        listBestSellers= new Seller[MAX_SELLERS];
    }

    public Customer createCustomer (int id, String name){
       return new Customer(id, name);
    }
    
    public boolean VerifyIdCustomerIsNotInUse (Customer customer){
        boolean IdIsInUse = false;      
        for (int i = 0; i < listCustomer.length; i++){
           if ( listCustomer[i] != null ){
                if (customer.getId() == (listCustomer[i].getId())){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }

    public boolean VerifyIdSellerIsNotInUse (Seller seller){
        boolean IdIsInUse = false;      
        for (int i = 0; i < listSeller.length; i++){
           if ( listSeller[i]!= null ){
                if (seller.getId() == listSeller[i].getId()){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }

    public boolean VerifyIdSaleIsNotInUse (Sale sale){
        boolean IdIsInUse = false;      
        for (int i = 0; i < listSale.length; i++){
           if ( listSale[i]!= null ){
                if (sale.getId() == (listSale[i].getId())){
                    IdIsInUse = true;
                }
            }
        }
        return IdIsInUse;
    }
    
    public void addCustomer(Customer customer) throws ErroridNotFound, ErrorTheBaseDataIsFull{ 
        boolean IdIsInUse = VerifyIdCustomerIsNotInUse(customer);
        if (IdIsInUse == true){
             throw new ErroridNotFound();      
        }
        for (int i = 0; i < listCustomer.length; i++){
            if (listCustomer[i]== null ){
                listCustomer[i]= customer;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFull(); 
    }  
    
    public Seller createSeller (int id, String name){
        return new Seller (id, name);
    }
    
    public void addSeller (Seller seller )throws ErrorTheBaseDataIsFull{ 
        boolean IdIsInUse = VerifyIdSellerIsNotInUse(seller);
        if (IdIsInUse == true){
             throw new ErrorTheBaseDataIsFull(); 
             
        }    
        for (int i = 0; i < listSeller .length; i++){
            if (listSeller[i]== null ){
                listSeller[i]= seller ;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFull();    
    } 
    
    public Sale createSale (int id, Seller seller ,Customer customer, Brands brand,int earning){
         return new Sale (id, seller,customer,brand,earning);
    }
   
    public void addSale(Sale  sale )throws ErrorTheBaseDataIsFull,ErroridNotFound{
        boolean IdIsInUse = VerifyIdSaleIsNotInUse(sale);
        if (IdIsInUse == true){
             throw new ErroridNotFound();      
        }        
        for (int i = 0; i < listSale.length; i++){
            if (listSale[i] == null ){
                listSale[i] = sale;
                return;
            }
        }
        throw new ErrorTheBaseDataIsFull();    
    }  

    public  Customer FindCustomerById (int id)throws ErroridNotFound{     
        for (int i = 0; i < listCustomer.length; i++){
            if (listCustomer[i] != null) {
                 if (listCustomer[i].getId()==(id)){ 
                    return listCustomer[i];
                }
            }
        }          
        throw new ErroridNotFound();     
    }

    public  Seller FindSellerById (int id)throws ErroridNotFound{     
        for (int i = 0; i < listSeller.length; i++){
            if (listSeller[i] != null) {
                 if (listSeller[i].getId()==(id)){ 
                    return listSeller[i];
                }
            }
        }          
        throw new ErroridNotFound();     
    }   

    public int  getSalary (Seller seller ){
        int salary = 400000;
        for (int i = 0; i < listSale.length; i++){
             if (listSale[i] != null ){
                if (listSale[i].getSeller().equals(seller) ){
                    salary += 6000;
                }
            }
        }
        for (int i = 0; i < listBestSellers.length; i++){
             if (listBestSellers[i] != null ){
                if (listBestSellers[i].equals(seller) ){
                    salary += 100000;
                }
            }
        }    
        return salary;
    }

    public String  ShowSalaryOfAllSellers (){
       
    return "No disponible ";
    }
 
    public int  tellSales() { 
        int sales = 0;
        for (int i = 0; i < listSale.length; i++){
            if (listSale[i]!= null ){
                sales ++;
            }
        }
        return sales; 
    } 
    public int  tellEarnings() { 
        int earnings = 0;
        for (int i = 0; i < listSale.length; i++){
            if (listSale[i]!= null ){
                earnings += listSale[i].getEarning() ;
            }
        }
        return earnings; 
    } 
    public String  ShowSalesAndEarnings(){
        String SalesAndEarnings ="";    
        SalesAndEarnings += (("Sales: ")+tellSales() + "\n" + ("Earnings: ")+tellEarnings());        
        return SalesAndEarnings;
    }
    public int CalculateTotalSalesOfSeller (Seller seller){
        int numberSales = 0;
        for (int i = 0; i < listSale.length; i++){
             if (listSale[i] != null ){
                if (listSale[i].getSeller().equals(seller) ){
                numberSales ++;
                
                }
            }
        }   
    return numberSales;
    }
 
    public String RewardingBestSeller (){  
        Seller bestSeller = listSeller[0];
        for (int i = 1; i < listSeller.length; i++) {
            if (listSeller[i] != null ) {
                if (CalculateTotalSalesOfSeller(bestSeller)<CalculateTotalSalesOfSeller(listSeller[i])){
                   bestSeller = listSeller[i];                  
               }
            }   
        }
        for (int i = 0; i < listBestSellers.length; i++){
            if (listBestSellers[i]== null ){
                listBestSellers[i]= bestSeller;
                break;
            }
        }
        return bestSeller.getName();
    }
    public void deleteBadSeller(Seller seller){
        for (int i = 0 ; i < listSeller.length;i++){
            if (listSeller[i] != null) {  
                if (listSeller[i].equals(seller) ){
                    listSeller[i]= null;               
                }
            }
        }  
    }
    public String fireBadSeller(){
        String badSeller ="";
        for (int i = 0 ; i < listSeller.length;i++){
            if (listSeller[i] != null) {  
                if (CalculateTotalSalesOfSeller(listSeller[i]) < 3 ){
                    System.out.println(listSeller[i].getName());
                    badSeller += (listSeller[i].getName()+" fired"+ "\n" );
                    deleteBadSeller(listSeller[i]);   
                }
            }
        }  
       return badSeller; 
    }
     public int CalculateTotalSalesOfCustomer (Customer customer){
        int numberSales = 0;
        for (int i = 0; i < listSale.length; i++){
             if (listSale[i] != null ){
                if (listSale[i].getCustomer().equals(customer) ){
                numberSales ++;
                
                }
            }
        }   
    return numberSales;
    }
    public String CouponToTheBestCustomer(){
        String bestCustomer ="";
        for (int i = 0 ; i < listCustomer.length;i++){
            if (listCustomer[i] != null) {  
                if (CalculateTotalSalesOfCustomer(listCustomer[i]) > 4 ){
                    bestCustomer += (listCustomer[i].getName()+" win a coupon"+ "\n" );   
                }
            }
        }  
       return bestCustomer; 
    }
    public void deleteCustomer(Customer customer){
        for (int i = 0 ; i < listCustomer.length;i++){
            if (listCustomer[i] != null) {  
                if (listCustomer[i].equals(customer) ){
                    listCustomer[i]= null;               
                }
            }
        }  
    }
    public String deleteBadCustomers(){
        String badCustomers ="";
        for (int i = 0 ; i < listCustomer.length;i++){
            if (listCustomer[i] != null) {  
                if (CalculateTotalSalesOfCustomer(listCustomer[i]) == 0 ){
                    badCustomers += (listCustomer[i].getName()+" delete"+ "\n" );
                    deleteCustomer(listCustomer[i]);   
                }
            }
        }  
       return badCustomers; 
    }
    
    public String randomDrawingOfCustomers (){
        String win="";
        int number; 
        boolean add = false;
            while (add == false){
               number = (aleatorio.nextInt(MAX_CUSTOMERS));
                   if (listSale[number] != null ){
                       win = (listSale[number].getCustomer().getName()+" WIN !");
                    add = true;
                   }
               }
        return win;
    }   
}