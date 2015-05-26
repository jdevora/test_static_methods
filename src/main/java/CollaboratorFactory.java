/**
 * The factory could have a special setter 
 * @author jdevora
 */
public class CollaboratorFactory {
    private CollaboratorFactory(){
        // Totally static class
    }
    private static CollaboratorInterface collaboratorInstance = null;

    /**
     *
     * @return
     */
    public static synchronized CollaboratorInterface getColaboratorInstance(){ 
        if (collaboratorInstance==null){
            collaboratorInstance = new CollaboratorImplementation();
        }
        
        return collaboratorInstance;
    }
    
    public static synchronized void setColaboratorInstance(CollaboratorInterface testColaborator){
        collaboratorInstance=testColaborator;
    }
}
