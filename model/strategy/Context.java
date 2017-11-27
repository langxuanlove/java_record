package model.strategy;

public class Context {
	public StrategySuper strategySuper = null;
	public Context(String type){
		switch(type){
		case "1":
			this.strategySuper=new StrategyImpl1();
			break;
			
		case "2":
			this.strategySuper=new StrategyImpl2();
			break;
		default:
			this.strategySuper=new StrategyImpl();
			break;
		}
	}
	public double price(double money){
		return this.strategySuper.price(money);
	}
}
