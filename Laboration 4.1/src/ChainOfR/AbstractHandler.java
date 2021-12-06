package ChainOfR;

public abstract class AbstractHandler {
	protected AbstractHandler nextHandler;

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	public void handle(String request) {
		if(nextHandler != null) {
			nextHandler.handle(request);
		}
		
	}
	
	

}
