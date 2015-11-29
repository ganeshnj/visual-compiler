package calculator;


import java.util.ArrayList;

public class MyContainer {
	private ArrayList<MyClass> classes;
	
	public MyContainer(){
		classes = new ArrayList<>();
	}

	public ArrayList<MyClass> getClasses() {
		
		if(classes == null)
			classes = new ArrayList<>();
		
		return classes;
	}

	public void setClasses(ArrayList<MyClass> classes) {
		
		if(classes == null)
			classes = new ArrayList<>();
		
		this.classes = classes;
	}
	
	public void addClass(MyClass c) {
		
		if(classes == null)
			classes = new ArrayList<>();
		
		this.classes.add(c);
	}
	
	public MyClass getClass(String name){
		if(classes != null){
			for (MyClass myClass : classes) {
				if(myClass.getName().equals(name))
					return myClass;
			}
		}
		System.out.println("Class doesn't exist");
		return null;
	}
	
	public void createClass(String classname) {
		MyClass myClass = new MyClass(classname);
		this.addClass(myClass);
	}

	public void draw(){
		if(classes != null){
			for (MyClass myClass : classes) {
			
			}
		}
	}
}
