package ChainOfR;

import java.util.ArrayList;

public abstract class AbstractHandler {
	protected AbstractHandler nextHandler;

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	public abstract void handle(shapeSettings settings);
	
	

}
