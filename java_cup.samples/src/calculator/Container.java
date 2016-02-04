package calculator;

import java.util.ArrayList;

import org.apache.batik.svggen.SVGGraphics2D;

public class Container {

	private SVGGraphics2D graphics;

	private ArrayList<MyClass> classes;
	private ArrayList<MyDataMember> datas;
	private ArrayList<MyMethod> methods;

	public Container(SVGGraphics2D g) {
		this.graphics = g;
	}

	public ArrayList<MyClass> getClasses() {
		if (classes == null)
			classes = new ArrayList<>();

		return classes;
	}

	public void setClasses(ArrayList<MyClass> classes) {
		this.classes = classes;
	}

	public void addClass(String classname) {
		MyClass myClass = new MyClass(classname, graphics);
		getClasses().add(myClass);

		System.out.println("Class: " + myClass.getName() + " added");
	}

	public MyClass getClass(String classname) throws Exception {
		for (MyClass myClass : getClasses()) {
			if (myClass.getName().equals(classname))
				return myClass;
		}

		throw new Exception("Class: " + classname + " doesn't exist");
	}

	public ArrayList<MyDataMember> getDatas() {
		if (datas == null)
			datas = new ArrayList<>();

		return datas;
	}

	public void setDatas(ArrayList<MyDataMember> data) {
		this.datas = data;
	}

	public void addData(String name) {
		MyDataMember dataMember = new MyDataMember(name);
		getDatas().add(dataMember);

		System.out.println("Datamember: " + dataMember.getName() + " added");
	}

	public MyDataMember getData(String dataname) throws Exception {
		for (MyDataMember dataMember : getDatas()) {
			if (dataMember.getName().equals(dataname))
				return dataMember;
		}

		throw new Exception("Datamember: " + dataname + " doesn't exist");
	}

	public ArrayList<MyMethod> getMethods() {

		if (methods == null)
			methods = new ArrayList<>();

		return methods;
	}

	public void setMethods(ArrayList<MyMethod> methods) {
		this.methods = methods;
	}

	public void addMethod(String methodname) {
		MyMethod method = new MyMethod(methodname);
		getMethods().add(method);

		System.out.println("Method: " + method.getName() + " added");
	}

	public MyMethod getMethod(String methodname) throws Exception {
		for (MyMethod method : getMethods()) {
			if (method.getName().equals(methodname))
				return method;
		}

		throw new Exception("Datamember: " + methodname + " doesn't exist");
	}

}
