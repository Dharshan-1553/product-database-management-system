import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/** 
 * Serializationclass is a class used for serialization i.e converting the object of Product Database into Byte Code text file
 */
public class SerializationClass {

    /**
     * instance - is an objext reference of SerializationClass type,  
     * it is private and static member variable
     */
    private static SerializationClass instance =null;
    /**
     * pdb - is an objext reference of ProductDB type, 
     * it is public member variable
     */
    public ProductDB pdb;

    /**
     * fos - is an objext reference of FileOutputStream type, 
     * it is default member variable
     */
    FileOutputStream fos=null;
    /**
     * oos - is an objext reference of ObjectOutputStream type, 
     * it is default member variable
     */
    ObjectOutputStream oos =null;

    /**
     * fileObj - is an objext reference of File type, 
     * it is static and default member variable
     */
    static File fileObj= new File("F:/jspiders/core java/VS/collections/MyAssignments/productDetails.txt");
    /**
     * hasSerialised - is a boolean static member variable, 
     */
    static boolean hasSerialised=false;

    /**
     * SerializationClass() - is a private constructor, to achieve Singleton class
     */
    private SerializationClass(){
    }

    /**
     * getInstance() - used to get the object of the SerializationClass, which is responsible for the only one instance for this class to achieve Singleton
     * @return instance - object of the SerializationClass
     */
    public static SerializationClass getInstance(){
        if(instance==null){
            instance=new SerializationClass();
        }
        return instance;
    }

    /**
     * createFile() - used to create new file to store Serialized byte code, 
     * if the file is already exists, it dosen't create new file
     */
    public  void createFile(){

        if(fileObj.exists()==false){
            try {
                fileObj.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }    
    }

    /**
     * isSerialized() - is used to check whether the file is serialized or not 
     * @return boolean value
     */
    public boolean isSerialized(){
        if(fileObj!=null&& fileObj.exists()==true){
            hasSerialised=true;
        }
        return hasSerialised;
    }

    /**
     * createSerializationFile() - used to perform serialization process
     */
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
