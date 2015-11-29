package calculator;


import java.util.ArrayList;

import org.apache.batik.svggen.*;

public class MyContainer {
	
	private SVGGraphics2D graphics;
	
	private ArrayList<MyClass> classes;
	
	public MyContainer(){
		this.classes = new ArrayList<>();
	}
	
	public MyContainer(SVGGraphics2D g){
		this.classes = new ArrayList<>();
		this.graphics = g;
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
		MyClass myClass = new MyClass(classname, graphics);
		this.addClass(myClass);
	}

	public void draw(){
		if(classes != null){
			for (MyClass myClass : classes) {
			
			}
		}
	}

	public SVGGraphics2D getGraphics() {
		return graphics;
	}

	public void setGraphics(SVGGraphics2D graphics) {
		this.graphics = graphics;
	}
}