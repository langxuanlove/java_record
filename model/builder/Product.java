package model.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
   List<String> ls=new ArrayList<String>();
   public void add(String part){
	   ls.add(part);
   }
   public void show(){
	   for (int i = 0; i < ls.size(); i++) {
		System.out.println(ls.get(i));
	}
   }
}
