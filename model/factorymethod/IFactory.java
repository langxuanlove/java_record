package model.factorymethod;
/**
 * 工厂方法模式：规避了简单工厂无法扩展的弊端
 * 工厂方法(Factory Method)模式的意义是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类当中。
 * 核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，仅负责具体工厂子类必须实现的接口，
 * 这样进一步抽象化的好处是使得工厂方法模式可以使系统在不修改具体工厂角色的情况下引进新的产品。
 * 工厂方法模式是简单工厂模式的衍生，解决了许多简单工厂模式的问题。首先完全实现‘开－闭 原则’，
 * 实现了可扩展。其次更复杂的层次结构，可以应用于产品结果复杂的场合。[2] 
 * 工厂方法模式对简单工厂模式进行了抽象。有一个抽象的Factory类（可以是抽象类和接口），
 * 这个类将不再负责具体的产品生产，而是只制定一些规范，具体的生产工作由其子类去完成。在这个模式中，
 * 工厂类和产品类往往可以依次对应。即一个抽象工厂对应一个抽象产品，一个具体工厂对应一个具体产品，
 * 这个具体的工厂就负责生产对应的产品。
 * 工厂方法模式(Factory Method pattern)是最典型的模板方法模式(Template Method pattern)应用。
 * 工厂方法抽象类
 * @author kui
 *
 */
public interface IFactory {
	GoodPerson createGoodPerson();
}
