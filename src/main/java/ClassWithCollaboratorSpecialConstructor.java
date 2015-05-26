
/**
 * In this method, you can use a special constructor to inject a mocked
 * collaborator when you are testing the class.
 *
 * @author JDEvora
 */
public class ClassWithCollaboratorSpecialConstructor implements ClassWithCollaboratorInterface {

    public ClassWithCollaboratorSpecialConstructor() {
        //Default constructor
        collaborator = CollaboratorFactory.getColaboratorInstance();
    }

    public ClassWithCollaboratorSpecialConstructor(CollaboratorInterface collaboratorForTesting) {
        //Those the normal construction
        this();
        this.collaborator = collaboratorForTesting;
    }

    private CollaboratorInterface collaborator;
    private StringBuffer result = new StringBuffer();

    public void doSomething() {

        result.append("About to call the collaborator.");
        result.append(collaborator.method1());
        result.append(collaborator.method2());
        result.append("Colaborator called.");
    }

    public String getResult() {
        return result.toString();
    }
}
