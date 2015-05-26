
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author JDEvora
 */
public class ClassWithCollaboratorTest {

    public ClassWithCollaboratorTest() {
    }

    
    private static String normalResult = "About to call the collaborator.Very important method 1Very important method 2Colaborator called.";
    private static String stubResult = "About to call the collaborator.Very important method stub 1Very important method stub 2Colaborator called.";
    private static String beforeCalling ="About to call the collaborator.";
    private static String afterCalling ="Colaborator called.";
    private static String method1Result ="This method1 is a strub";
    private static String method2Result ="This method2 is a strub";
         
    
     @Test
    public void checks_normal_result() {

        ClassWithCollaborator instance = new ClassWithCollaborator();
        instance.doSomething();

        assertEquals(normalResult, instance.getResult());

    }

    @Test
    public void injects_collaborator_using_the_factory() {

        CollaboratorInterface collaboratorInstance = new ColaboratorStub();

        CollaboratorFactory.setColaboratorInstance(collaboratorInstance);

        ClassWithCollaborator instance = new ClassWithCollaborator();
        instance.doSomething();
        
        //Sets it to null, the next time a normal Collaborator will be created
        CollaboratorFactory.setColaboratorInstance(null);

        assertEquals(stubResult, instance.getResult());
        
        // Checks that the Factory is serving the correct collaborator again
        assertEquals(CollaboratorFactory.getColaboratorInstance().getClass(), (new CollaboratorImplementation()).getClass());

    }

   

    @Test
    public void check_the_contract_using_mockito_and_special_constructor() {

        CollaboratorInterface mockedColaboratorInstance = mock(CollaboratorInterface.class);

        ClassWithCollaboratorInterface instance = new ClassWithCollaboratorSpecialConstructor(mockedColaboratorInstance);
        instance.doSomething();

        verify(mockedColaboratorInstance).method1();
        verify(mockedColaboratorInstance).method2();

    }
    
     @Test
    public void mocks_the_collaborator_using_mockito_and_special_setter() {
        CollaboratorInterface mockedColaboratorInstance = mock(CollaboratorInterface.class);
        
        when(mockedColaboratorInstance.method1()).thenReturn(method1Result);
        when(mockedColaboratorInstance.method2()).thenReturn(method2Result);

        ClassWithCollaboratorSpecialSetter instance = new ClassWithCollaboratorSpecialSetter();
        instance.setColaborator(mockedColaboratorInstance);
        instance.doSomething();
        
        assertEquals(beforeCalling+method1Result+method2Result+afterCalling, instance.getResult());
    }

}
