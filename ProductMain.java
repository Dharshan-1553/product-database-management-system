import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ProductMain - it is a main class where the Program begins
 */
public class ProductMain {
    static Scanner sc=new Scanner(System.in);
    /**
     * productDBObject - is an objext reference of ProductDB type,  
     * it is a static member variable
     */
    static ProductDB productDBObject;
    /**
     * dbSize - is an member variable of int type,  
     * it is a static member variable
     */
    static int dbSize;

    public static void main(String[] args) {
       char ch=' ';
        while(true){
            try {
                System.out.print("Do you want to open the existing product list (y/n) : ");
                ch=sc.next().toLowerCase().charAt(0);
                if(ch!='y'&& ch!='n'){
                    throw new InputMismatchException();
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("please enter Either \'y\' or \'n\' ");
            } 
        }
        

        switch (ch) {
            case 'y':
                deSerialization();
                break;
            case 'n':
                while(true){
                    try {
                        System.out.print("Enter DATABASE size : ");
                        String dbsizeString =sc.next();

                        dbSize=Integer.parseInt(dbsizeString);
                        if(dbSize>0){
                           break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter Number type value...");
                    }
                }
                productDBObject=new ProductDB(dbSize);
                operations();
                break;  
        }  
        // sc.close();
    } 

    /**
     * operations() - operations to perform in the ProductDB 
     */
    public static void operations(){
        do{
            if(dbSize<=0){
                System.out.println("OOPS.. your database size is 0\ncant do any operation in the database");
            }
            System.out.println("\nOPERATIONS...");
            System.out.println("=====================");
            System.out.println("1.Add products");
            System.out.println("2.update product details");
            System.out.println("3.display particular record  ");
            System.out.println("4.display All records  ");
            System.out.println("5.display price according to lowest to highest ");
            System.out.println("6.display price according to highest to lowest ");
            System.out.println("7.Delete record  ");
            System.out.println("8.Save the product list");
            System.out.println("9.Exit ");
            int choice=0;
            while(true){
                try {
                    System.out.print("\nENTER YOUR CHOICE :");
                    String choiceString=sc.next();
                    choice=Integer.parseInt(choiceString);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\n!!!! INVALID TYPE INPUT !!!!\n please enter value from 1-9" );
                }
            }
            if((choice<1 || choice>9)){
                System.out.println("\n!!!! INVALID TYPE INPUT !!!!\n please enter value from 1-9" );
                continue;
            }
            System.out.println();

            switch (choice) {
                case 1 :
                addingProducts();
                break;
                case 2:
                updateProductDetails();
                break;
                case 3:
                displayParticularRecord();
                break;
                case 4:
                displayAllRecord();
                break;
                case 5:
                displaypriceInAscending();
                break;
                case 6:
                displaypriceInDescending();
                break;
                case 7:
                deleterecord();
                break;
                case 8:
                serialization();
                break;
                case 9 :
                 System.exit(0);
            }
        }while(true);

    }

    /**
     * addingProducts() - to add products into the DataBase
     */
    public static void addingProducts(){
        if(productDBObject.checkDataBaseSize())
        {
        System.out.print("Enter product name  (eg. pen,book) :");
        String pName=sc.next(); 
        int pQuantity =0;
        while(true){
            try {
                System.out.print("Enter product quantity      (No.s) :");
                String pQuantityString=sc.next();
                pQuantity=Integer.parseInt(pQuantityString);
                break;
               } catch (NumberFormatException e) {
                 System.err.println("please enter number type...!!!");
               }
        }
        
        double pPrice=0.0;
        while(true){
            try {
                System.out.print("Enter product price        (rupees) :");
                String pPriceString=sc.next();
                pPrice=Double.parseDouble(pPriceString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("please enter number type...!!!");
            }
        }
        
        int pFitnessPeriod=0;
        while(true){
            try {
                System.out.print("Enter product fitness    (DDMMYYYY) :");
                String pFitnessPeriodString=sc.next();
                pFitnessPeriod=Integer.parseInt(pFitnessPeriodString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("please enter number type...!!!");
            }
        }
        System.out.print("Enter product type  (eg. stationery) :");
        String pType=sc.next();

        
        productDBObject.addProducts(new Product(pName,pType , pPrice, pQuantity, pFitnessPeriod ));
        }
        else{
            System.out.println("Your DataBase is Full...!!");
        }
        
        
    }

    /**
     * updateProductDetails() - used for any updation in the product details
     */
    public static void updateProductDetails(){
        if(productDBObject.getIndex()>0){
            System.out.println("1. To update product price");
            System.out.println("2. To update product quantity");
    
            int opt=sc.nextInt();
    
            switch (opt) {
                case 1:
                    updateproductPrice();
                    break;
                case 2:
                    updateProductQuantity();
                    break;
            }
        }
        else{
            System.out.println("There is no records in the data base.....");
        }
        
    }

    /**
     * updateproductPrice() - used to update the product price
     */
    public static void updateproductPrice(){
        int pid=0;
        while (true) {
            try {
                System.out.print("\nEnter product Id :");
                String pidString=sc.next();
                pid=Integer.parseInt(pidString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("please enter number type...!!!");
            }
        }
        
        double pPrice=0.0;
        while (true) {
            try {
                System.out.print("\nEnter price of the product :");
                String pPriceString=sc.next();
                pPrice=Integer.parseInt(pPriceString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("please enter number type...!!!");
            }
        }

        productDBObject.updatePrice(pid,pPrice);

    }

    /**
     * updateProductQuantity() - used to update the product quantities
     */
    public static void updateProductQuantity(){
        System.out.print("\nEnter product Id :");
        int pid=sc.nextInt();
        System.out.println("\nEnter quantity of the product :");
        int pQnt=sc.nextInt();

        productDBObject.updateQuantity(pid,pQnt);
    }

    /**
     * displayParticularRecord() - used to display the particular product details by taking product name
     */
    public static void displayParticularRecord(){
        if(productDBObject.getIndex()>0){
            System.out.print("\nEnter product name :");
            String pName=sc.next();
            productDBObject.showProducts(pName);
        }
        else{
            System.out.println("There is no records in the data base.....");
        }
        
    }

    /**
     * displayAllRecord() - used to display all the product details
     */
    public static void displayAllRecord(){
        if(productDBObject.getIndex()>0){
            productDBObject.viewAllProducts();
        }
        else{
            System.out.println("There is no records in the data base.....");
        }
    }

    /**
     *  displaypriceInAscending() - used to display the products in Ascending order according to the price
     */
    public static void displaypriceInAscending(){
        if(productDBObject.getIndex()>0){
            productDBObject.sortPriceInAscending();
        }
        else{
            System.out.println("There is no records in the data base.....");
        }
        
    }

    /**
     *  displaypriceInDescending() - used to display the products in descending order according to the price
     */
    public static void displaypriceInDescending(){
        if(productDBObject.getIndex()>0){
            productDBObject.sortPriceInDescending();
        }
        else{
            System.out.println("There is no records in the data base.....");
        }
        
    }

    /**
     * deleterecord() - used to delete the product from the DataBase 
     */
    public static  void deleterecord(){
        if(productDBObject.getIndex()>0){
            System.out.print("\nEnter product Id :");
            int pid=sc.nextInt();
            productDBObject.deleteProduct(pid);
        }
        else{
            System.out.println("There is no records in the data base.....");
        } 
    }

    /**
     * serialization() - used to serialization operation with the help of SerializationClass
     */
    public static void serialization(){
        SerializationClass ref=SerializationClass.getInstance();
        ref.pdb=productDBObject;
        ref.createSerializationFile();
        System.out.println("product list was saved successfully...");
    }

    /**
     * deSerialization() - used to deSerialization operation with the help of DeSerializationClass
     */
    public static void deSerialization(){
        SerializationClass sRef=SerializationClass.getInstance();
        if(sRef.isSerialized()){
            DeSerializationClass dRef=DeSerializationClass.getInstance();
            productDBObject=dRef.getproductDbObject();
            dbSize=productDBObject.productArr.length; 
            System.out.println("====================================================\nYour saved product details.............\n");
            dRef.showDb();
            
            System.out.println("====================================================");
            operations();
        }
        else{
            System.out.println("\nthere is no records saved yet... please create a new product list\n");
        }   
    }
}