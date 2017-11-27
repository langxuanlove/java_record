package model.strategy;
/**
 * 价格涨价一倍
 * @author kui
 *
 */
public class StrategyImpl2 extends StrategySuper {

	@Override
	public double price(double money) {
		// TODO Auto-generated method stub
		return 2*money;
	}
}
