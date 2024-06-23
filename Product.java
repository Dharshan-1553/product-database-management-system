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

    

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public int getpFitnessPeriod() {
        return pFitnessPeriod;
    }

    public void setpFitnessPeriod(int pFitnessPeriod) {
        this.pFitnessPeriod = pFitnessPeriod;
    }

    
    
}