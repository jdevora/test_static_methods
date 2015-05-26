/**
 * The magic is done at the Factory level
 * 
 * @author JDEvora
 */
public class ClassWithCollaborator implements ClassWithCollaboratorInterface{
     private CollaboratorInterface collaborator =CollaboratorFactory.getColaboratorInstance();
     private StringBuffer result = new StringBuffer();
    
    public void doSomething(){
        
        result.append("About to call the collaborator.");
        result.append(collaborator.method1());
        result.append(collaborator.method2());
        result.append("Colaborator called.");
    }
    
    public String getResult(){
        return result.toString();
    }
}
