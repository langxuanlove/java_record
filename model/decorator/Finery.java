package model.decorator;
/**
 * 
 * @author kui
 *
 */
public class Finery extends Person {
	protected Person component;

	public void decorator(Person component) {
		this.component = component;
	}

	@Override
	public void show() {
		if (component != null) {
			System.out.println("FineryµÄshow·½·¨.");
			component.show();
		}
	}

}
