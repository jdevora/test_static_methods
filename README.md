When a class gets a collaborator  from a static factory and it is not feasible to
inject the collaborator in normal circumstances you could uses a few different techniques 
to test or mock the collaborator:

Add a setter to the Factory, this could be called before running a test. This way we could inject a mocked collaborator


Add custom constructor that is only called at test time for inject a mock collaborator


Add a custom Collaborator setter, this setter is never called at run time because the collaborator is created the "normal way"
but at test time can be used to inject a mock collaborator.