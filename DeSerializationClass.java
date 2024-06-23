import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;



public class DeSerializationClass {
    private  static DeSerializationClass instance;
    FileInputStream fis;
    ObjectInputStream ois;
    public ProductDB pdb;

    private DeSerializationClass(){
    }

   

    public static DeSerializationClass getInstance(){
        if(instance==null){
            instance=new DeSerializationClass();
        }
        
        return instance;
    }

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
