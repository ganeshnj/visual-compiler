package calculator;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.*;

import javax.swing.*;

import org.apache.batik.swing.*;
import org.apache.batik.svggen.*;
import org.apache.batik.apps.svgbrowser.JSVGViewerFrame.NewWindowAction;
import org.apache.batik.dom.svg.SVGDOMImplementation;

import org.w3c.dom.*;
import org.w3c.dom.svg.*;

public class MyClass {
	private static final int OFFSET = 15;
	private static final int GAP = 15;
	private String name;
	private String accessLevel;
	private Point position;
	private int width;
	private MyClass parent;
	private Connector connector;

	private SVGGraphics2D graphics;

	private ArrayList<MyDataMember> datas;
	private ArrayList<MyMethod> methods;
	private HashMap<MyClass, RelationshipType> relationships;

	public MyClass() {
		datas = new ArrayList<>();
		methods = new ArrayList<>();

		this.position = new Point(100, 100);
	}

	public MyClass(String classname) {
		datas = new ArrayList<>();
		methods = new ArrayList<>();

		this.name = classname;
		this.position = new Point(100, 100);
	}

	public MyClass(String classname, SVGGraphics2D g) {
		datas = new ArrayList<>();
		methods = new ArrayList<>();

		this.name = classname;
		this.graphics = g;
		this.position = new Point(100, 100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
		System.out.println("Class: " + this.name + " is set " + accessLevel);
	}

	public ArrayList<MyDataMember> getDatas() {

		if (datas == null)
			datas = new ArrayList<>();

		return datas;
	}

	public void setDatas(ArrayList<MyDataMember> dataMembers) {
		this.datas = dataMembers;
	}

	public void addData(MyDataMember dataMember) {
		this.getDatas().add(dataMember);
		System.out.println("Datamember: " + dataMember.getName() + " added to Class: " + this.name);
	}

	public ArrayList<MyMethod> getMethods() {
		if (methods == null)
			methods = new ArrayList<>();

		return methods;
	}

	public void setMethods(ArrayList<MyMethod> methods) {
		this.methods = methods;
	}

	public void addMethod(MyMethod method) {
		this.getMethods().add(method);
		System.out.println("Method: " + method.getName() + " added to Class: " + this.name);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
		System.out.println("Class: " + this.name + " position is set to " + this.position.toString());
	}

	public void draw() {

		int y = getPosition().y;
		y = y + GAP;

		if (!name.isEmpty()) {
			System.out.println("Drawing class: " + getName());
			graphics.drawString(getName(), getPosition().x + OFFSET, y);
			y = y + GAP;
		}

		graphics.drawLine(getPosition().x, y, getPosition().x + width, y);

		y = y + GAP;

		for (MyDataMember dataMember : getDatas()) {
			StringBuilder builder = new StringBuilder();
			builder.append(dataMember.getAccessLevel());
			builder.append("\t");
			builder.append(dataMember.getName().toString());
			builder.append(" : ");
			builder.append(dataMember.getType());

			System.out.println(builder.toString());
			graphics.drawString(builder.toString(), getPosition().x + OFFSET, y);
			y = y + GAP;
		}

		graphics.drawLine(getPosition().x, y, getPosition().x + width, y);

		y = y + GAP;

		for (MyMethod method : getMethods()) {
			StringBuilder builder = new StringBuilder();
			builder.append(method.getAccessLevel());
			builder.append("\t");
			builder.append(method.getName().toString());
			builder.append("(");

			for (MyDataMember arg : method.getArguments()) {
				builder.append(arg.getName());
				builder.append(" : ");
				builder.append(arg.getType());
				builder.append(",");
			}

			if (method.getArguments().size() > 0)
				builder.deleteCharAt(builder.length() - 1);

			builder.append(")");
			builder.append(" : ");
			builder.append(method.getReturnType().toString());

			System.out.println(builder.toString());
			graphics.drawString(builder.toString(), getPosition().x + OFFSET, y);
			y = y + GAP;
		}

		graphics.drawRect(getPosition().x, getPosition().y, getWidth(), getHeight());

		if (getParent() != null) {

			Rectangle2D start = new Rectangle2D.Double(getPosition().x, getPosition().y, getWidth(), getHeight());
			Rectangle2D end = new Rectangle2D.Double(getParent().getPosition().x, getParent().getPosition().y,
					getParent().getWidth(), getParent().getHeight());

			// because arrow is attached at parent which is end part
			Liner liner = new Liner(start, end);
			Line2D line = liner.getLine();

			graphics.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());

			// draw arrowhead at end
			Polygon p = getArrowPolygon(line, 5, 5);
			graphics.drawPolygon(p);
			
		}

		for (Entry<MyClass, RelationshipType> relationship : getRelationships().entrySet()) {
			Rectangle2D start = new Rectangle2D.Double(getPosition().x, getPosition().y, getWidth(), getHeight());

			Rectangle2D end = new Rectangle2D.Double(relationship.getKey().getPosition().x,
					relationship.getKey().getPosition().y, relationship.getKey().getWidth(),
					relationship.getKey().getHeight());

			Liner liner = new Liner(end, start);
			Line2D line = liner.getLine();
			Line2D xAxis = new Line2D.Double(100, 0, 0, 0);
			double theta = angleBetween2Lines(line, xAxis);
			graphics.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());

			// draw rectangle at itself		
			Polygon p = getSquarePolygon(line, 5, 5);
			graphics.fillPolygon(p);
		}

	}

	public SVGGraphics2D getGraphics() {
		return graphics;
	}

	public void setGraphics(SVGGraphics2D graphics) {
		this.graphics = graphics;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		System.out.println("Class: " + this.name + " : width is set to " + width);
	}

	public int getHeight() {
		int lines = getDatas().size() + getMethods().size() + 4;
		return lines * GAP;
	}

	public MyClass getParent() {
		return parent;
	}

	public void setParent(MyClass parent) {
		this.parent = parent;
		System.out.println("Class: " + this.name + " : inherits " + parent.getName());
	}

	public Connector getConnector() {
		if (connector == null)
			connector = new Connector(getPosition().x, getPosition().y, getWidth(), getHeight());
		return connector;
	}

	public void setConnector(Connector connector) {
		this.connector = connector;
	}

	public HashMap<MyClass, RelationshipType> getRelationships() {
		if (relationships == null)
			relationships = new HashMap<MyClass, RelationshipType>();

		return relationships;
	}

	public void setRelationships(HashMap<MyClass, RelationshipType> relationships) {
		this.relationships = relationships;
	}

	public void addRelationship(MyClass myClass, int qty) {
		getRelationships().put(myClass, qty == 1 ? RelationshipType.One : RelationshipType.Many);
		System.out.println("Class :" + getName() + " has " + qty + " " + myClass.getName());
	}

	// point A coordinates a,b
	// point B coordinates c,d
	// distance to point C D
	// calculate distance between the two points
	public Point interpolationByDistance(Line2D line, double D) {
		double a = line.getX1();
		double b = line.getY1();
		double c = line.getX2();
		double d = line.getY2();

		double DT = Math.sqrt(Math.pow((c - a), 2) + Math.pow((d - b), 2));

		double x;
		double y;
		double T = D / DT;

		// finding point C coordinate from a
		x = (1 - T) * a + T * c;
		y = (1 - T) * b + T * d;

		Point p = new Point((int) x, (int) y);
		return p;
	}
	
	public double angleBetween2Lines(Line2D line1, Line2D line2)
	{
	    double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
	                               line1.getX1() - line1.getX2());
	    double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
	                               line2.getX1() - line2.getX2());
	    return angle1-angle2;
	}
	
	private Polygon getArrowPolygon(Line2D line, int d, int h){
		int x1 = (int) line.getX1();
		int x2 = (int) line.getX2();
		int y1 = (int) line.getY1();
		int y2 = (int) line.getY2();
		
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;
        
        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};
        return new Polygon(xpoints, ypoints, 3);
     }
	
	private Polygon getSquarePolygon(Line2D line, int d, int h){
		int x1 = (int) line.getX1();
		int x2 = (int) line.getX2();
		int y1 = (int) line.getY1();
		int y2 = (int) line.getY2();
		
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;
        
        Point p = interpolationByDistance(new Line2D.Double(line.getP2(), line.getP1()), 10);
        
        int[] xpoints = {x2, (int) xm, p.x, (int) xn};
        int[] ypoints = {y2, (int) ym, p.y, (int) yn};
        return new Polygon(xpoints, ypoints, 4);
	}

}
