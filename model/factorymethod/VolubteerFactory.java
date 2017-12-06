package model.factorymethod;

public class VolubteerFactory implements IFactory {

	@Override
	public GoodPerson createGoodPerson() {
		// TODO Auto-generated method stub
		return new Volubteer();
	}
}
