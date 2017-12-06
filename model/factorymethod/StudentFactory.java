package model.factorymethod;

public class StudentFactory implements IFactory {

	@Override
	public GoodPerson createGoodPerson() {
		return new Student();
	}

}
