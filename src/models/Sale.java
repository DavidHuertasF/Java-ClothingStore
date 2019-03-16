package models;

public class Sale {
    private Brands brand;
    private Customer customer;  
    private Seller seller;
    private int id;
    private int earning;
 
    public Sale (int id, Seller seller ,Customer customer, Brands brand, int earning){
    this.seller = seller;
    this.customer = customer;   
    this.id = id;
    this.brand = brand;
    this.earning = earning;
    }    
    public Brands getBrand() {
        return brand;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Seller getSeller() {
        return seller;
    }
    public int getId() {
        return id;
    }

    public int getEarning() {
        return earning;
    }
}
