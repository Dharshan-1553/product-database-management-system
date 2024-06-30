import java.io.Serializable;

/**
 * Product DataBase class for CRUD operation
 */
public class ProductDB implements Serializable {
    public Product[] productArr;
    private int  index =0;
    int lastId;


/**
 * declare the size of the database 
 * @param size
 */
    public ProductDB(int size) {
        this.productArr = new Product[size];
        maxId();
    }

    /**
     * To check whether the DataBase have sufficient Space to insert Product
     * @return boolean value - true / false
     */
    public boolean checkDataBaseSize(){
        return productArr!=null &&  index<productArr.length;
    }


    /**
     * addProducts(Product product) - is used to add the product objects to the Product dataBase
     * 
     * @param product - product record (i.e object of product)
     */

     public void addProducts(Product product){
        if(index<productArr.length){
            productArr[index++]=product;
            maxId();
            System.out.println("\nProduct was added sucessfully.... ");
        }
        
    }

    /**
     * deleteProduct( int pId) - used to delete the product object from the Product DataBase
     * @param pId - Id of the product
     */
    public void deleteProduct(int pId){
        int i=0;
        boolean flag=false;
        for( i=0;i<productArr.length;i++){
            if(productArr[i]!=null && productArr[i].getpId()==pId){
                productArr[i]=null;
                flag=true;
            }
            
        }
        
        autoSortDatabase();
        maxId();
        System.out.println(flag?"\nProduct was deleted sucessfully...!":"no such product present in the database");
    }

    /**
     * this method is used to  view all the products stored in the product database
     */
    public void viewAllProducts(){
        int count =0;
        for (Product prdEle : productArr) {
            if(prdEle!=null){
                System.out.println("PRODUCT ID            :"+prdEle.getpId());
                System.out.println("PRODUCT NAME          :"+prdEle.getpName());
                System.out.println("PRODUCT TYPE          :"+prdEle.getpType());
                System.out.println("PRODUCT PRICE         :"+prdEle.getpPrice());
                System.out.println("TOTAL QUANTITIES      :"+prdEle.getpQuantity());
                System.out.println("PRODUCT FITNESS UPTO  :"+prdEle.getpFitnessPeriod());
                System.out.println();
                count++;
            }
        }
        System.out.println("\nTotal products available in the product list is "+count);
        System.out.println("You can add upto "+(productArr.length-count) +" products\n");
    }

    /**
     * showProducts(String pNameString)  - used to show the list of particular product Id
     * @param pNameString - Product name
     */

    public void showProducts(String pNameString){
        boolean found=false;
        for(int i=0;i<productArr.length;i++){
            
            if( productArr[i]!=null  && productArr[i].getpName().equalsIgnoreCase(pNameString) ){
                found=true;
                System.out.println("PRODUCT ID            :"+productArr[i].getpId());
                System.out.println("PRODUCT NAME          :"+productArr[i].getpName());
                System.out.println("PRODUCT TYPE          :"+productArr[i].getpType());
                System.out.println("PRODUCT PRICE         :"+productArr[i].getpPrice());
                System.out.println("TOTAL QUANTITIES      :"+productArr[i].getpQuantity());
                System.out.println();
            }
        }
        System.out.println(found?"":"No such product present in the Database..");
    }

    /**
     *  updateQuantity(int pId,int pQuantity) - to update the quantity of the particular product 
     * based on the product id
     * @param pId   - id of the product
     * @param pQuantity -  no of quantities to updated either positive or negative value. 
     *                    positive value to increse the quantity, 
     *                    negative value to decrease the quantity
     */
    public void updateQuantity(int pId,int pQuantity){
        for(Product product:productArr){
            if(product != null && product.getpId() == pId){
                product.setpQuantity(product.getpQuantity()+pQuantity);
                System.out.println("Quantity was updated : "+product.getpQuantity() +"\n");
            }
        }
    }


    /**
     * updatePrice(int pId,int newPrice) -  to update the price  of the particular product 
     * based on the product id 
     * @param pId  - id of the product
     * @param newPrice - new price of the product
     */
    public void updatePrice(int pId,double newPrice){
        for(Product product:productArr){
            if(product != null && product.getpId() == pId){
                product.setpPrice(newPrice);
                System.out.println("Price  was updated : "+product.getpPrice() +"\n");
            }
        }
    }

    /**
     * sortPriceInAscending() - to sort the product according to the Price in low to high (i.e Ascending order)
     */
    public void sortPriceInAscending(){
        for(int i=0;i<index-1 && productArr[i]!=null;i++){
            for(int j=i+1;j<index;j++){
                if(productArr[i].getpPrice()>productArr[j].getpPrice()){
                    Product temp=productArr[i];
                    productArr[i]=productArr[j];
                    productArr[j]=temp;
                }
            }
        }
        viewAllProducts();
    } 

    /**
     * sortPriceInDescending() -  to sort the product according to the Price in high to low(i.e Descending order)
     */
    public void sortPriceInDescending(){
        for(int i=index-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(productArr[i].getpPrice()>productArr[j].getpPrice()){
                    Product temp=productArr[i];
                    productArr[i]=productArr[j];
                    productArr[j]=temp; 
                }
            }
        }
        viewAllProducts();
    }

    /**
     * autoSortDatabase() - used to Sort automatically in the product DataBase array
     *                    - it does left Shifting to make database efficient to store product 
     */
    private  void autoSortDatabase(){
        int i=0;
        for(i=0;i<productArr.length;i++){
            if(productArr[i]==null){
                 for(int j=i;j<productArr.length-1;j++){
                    productArr[j]=productArr[j+1];
                }
            }
        }
        productArr[productArr.length-1]=null;
        i=0;
        while(i<productArr.length){
            if(productArr[i]==null){
                index =i;
                break;
            }
            i++;
        }
    }

    /**
     *  maxId() - it returns lastly assigned value to the Product
     */
    public void maxId(){
        for(Product p: productArr){
            if(p!=null && lastId<p.getpId()){
                lastId=p.getpId();
            }
        }
        return;
    }

    /**
     * used to get the Index of Product array 
     * @return the current index of the productDb Array
     */
    public int getIndex(){
        return this.index;
    }

}
