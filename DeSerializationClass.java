import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/** 
 * DeSerializationClass is a class used for DeSerialization  i.e converting back the Byte Code text file of Product Database into  object
 */
public class DeSerializationClass {

    /**
     * instance - is an objext reference of DeSerializationClass type,  
     * it is private and static member variable
     */
    private  static DeSerializationClass instance;
     /**
     * pdb - is an objext reference of ProductDB type, 
     * it is public member variable
     */
    public ProductDB pdb;

     /**
     * fis - is an objext reference of FileInputStream type, 
     * it is default member variable
     */
    FileInputStream fis;
    /**
     * ois - is an objext reference of ObjectInputStream type, 
     * it is default member variable
     */
    ObjectInputStream ois;

    /**
     * DeSerializationClass() - is a private constructor, to achieve Singleton class
     */
    private DeSerializationClass(){
    }

   
    /**
     * getInstance() - used to get the object of the DeSerializationClass, which is responsible for the only one instance for this class to achieve Singleton
     * @return instance - object of the DeSerializationClass
     */
    public static DeSerializationClass getInstance(){
        if(instance==null){
            instance=new DeSerializationClass();
        }
        
        return instance;
    }

    /**
     * showDb() - used to display size of Products and Product details present in the DataBase.   
     */
    public void showDb(){
        int size=pdb.productArr.length;

        if(pdb==null){
            System.out.println("No Saved Records");
        }
        else{
            System.out.println("\nSize of the data base is "+size +"\n");
            pdb.viewAllProducts();
        }
        
    }

    /**
     * getproductDbObject() - used to perform Deserialization 
     * @return
     */
    public ProductDB getproductDbObject(){
        try {
            fis=new FileInputStream("F:/jspiders/core java/VS/collections/MyAssignments/productDetails.txt");
            ois=new ObjectInputStream(fis);
            pdb=(ProductDB)ois.readObject();
        }
        catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Product.autoId=pdb.lastId;
        return pdb;
    }
}
