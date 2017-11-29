package model.decorator;

public class Test {
public static void main(String[] args) {
	Person person=new Person("¥Ó≈‰∑Ω∞∏°£");
	BigTrouser bigTrouser=new BigTrouser();
	Tshirts tshirts=new Tshirts();
	
	bigTrouser.decorator(person);
	tshirts.decorator(bigTrouser);
	tshirts.show();
}
}
