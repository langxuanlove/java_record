package model.builder;

public class ConcreteBuilder1 extends Builder {

	private Product product = new Product();

	@Override
	public void builderA() {
		// TODO Auto-generated method stub
		product.add("部件A");
	}

	@Override
	public void builderB() {
		// TODO Auto-generated method stub
		product.add("部件B");
	}

	@Override
	public Product getResult() {
		// TODO Auto-generated method stub
		return product;
	}

}
