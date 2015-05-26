
/**
 * This method consits of a collaborator setter that is ONLY used when you are
 * testing the class, in normal circunstances the collaborator gets popullated at
 * construction time
 *
 *
 * @author JDEvora
 */
public class ClassWithCollaboratorSpecialSetter implements ClassWithCollaboratorInterface {

    public ClassWithCollaboratorSpecialSetter() {
        //Default constructor
        collaborator = CollaboratorFactory.getColaboratorInstance();
    }

    private CollaboratorInterface collaborator;
    private StringBuffer result = new StringBuffer();

    public void setColaborator(CollaboratorInterface testingColaborator) {
        //This setter is only called unter testing
        this.collaborator = testingColaborator;
    }

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
