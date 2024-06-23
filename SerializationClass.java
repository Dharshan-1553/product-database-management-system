import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializationClass {

    private static SerializationClass instance =null;
    public ProductDB pdb;

    FileOutputStream fos=null;
    ObjectOutputStream oos =null;

    static File fileObj= new File("F:/jspiders/core java/VS/collections/MyAssignments/productDetails.txt");
    static boolean hasSerialised=false;

    private SerializationClass(){
    }

    public static SerializationClass getInstance(){
        if(instance==null){
            instance=new SerializationClass();
        }
        return instance;
    }

    public  void createFile(){

        if(fileObj.exists()==false){
            try {
                fileObj.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    
    }

    public boolean isSerialized(){
        if(fileObj!=null&& fileObj.exists()==true){
            hasSerialised=true;
        }
        return hasSerialised;
    }

    public void createSerializationFile(){
        createFile();
        try {
            fos=new FileOutputStream("F:/jspiders/core java/VS/collections/MyAssignments/productDetails.txt");
            oos=new ObjectOutputStream(fos);

            oos.writeObject(pdb);
            hasSerialised=true;
    
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                oos.close();
            fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }  
}
