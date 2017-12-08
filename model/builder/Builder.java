package model.builder;
/**
 * 建造者模式
 * 
 * @author kui
 *
 */
abstract class Builder {
	public abstract void builderA();

	public abstract void builderB();

	public abstract Product getResult();
}
