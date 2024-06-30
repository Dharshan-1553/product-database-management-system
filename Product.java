import java.io.Serializable;

/**
 * Product is an Entity class used to define the product details
 */
class Product implements Serializable{
    static int autoId=100;
    int pId;
    String pName;
    String pType;
    double pPrice;
    int pQuantity;
    int pFitnessPeriod;

/**
 * parameterized construtor 
 * 
 * 
 * @param pName
 * @param pType
 * @param pPrice
 * @param pQuantity
 * @param pFitnessPeriod
 */
    public Product(String pName, String pType, double pPrice, int pQuantity, int pFitnessPeriod) {
        this.pId = ++autoId;
        this.pName = pName;
        this.pType = pType;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
        this.pFitnessPeriod = pFitnessPeriod;
    }

    
/**
 * to get the current Product ID
 * @return Product ID
 */
    public int getpId() {
        return pId;
    }

/**
 * to get the Product Name
 * @return Product Name
 */
    public String getpName() {
        return pName;
    }

/**
 * to assign Product Name
 * @param pName
 */
    public void setpName(String pName) {
        this.pName = pName;
    }

    /**
     * to get the product Name
     * @return Product Name
     */
    public String getpType() {
        return pType;
    }

    /**
     * to assign the Product Type 
     * (i.e) category of the product 
     * @param pType
     */
    public void setpType(String pType) {
        this.pType = pType;
    }

    /**
     * to get the  price of the Product
     * @return Product price
     */
    public double getpPrice() {
        return pPrice;
    }

    /**
     * to assign the Product Price
     * @param pPrice
     */
    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    /**
     * to get the Product Quantities
     * @return Quantity of the Product
     */
    public int getpQuantity() {
        return pQuantity;
    }

/**
 * to assign the Product Quantities
 * @param pQuantity
 */
    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    /**
     * to get the Product Fitness Period
     * @return Product Fitness Period (Expiry Date)
     */
    public int getpFitnessPeriod() {
        return pFitnessPeriod;
    }

    /**
     * to assign the product Fitness period
     * @param pFitnessPeriod
     */
    public void setpFitnessPeriod(int pFitnessPeriod) {
        this.pFitnessPeriod = pFitnessPeriod;
    }
        
}