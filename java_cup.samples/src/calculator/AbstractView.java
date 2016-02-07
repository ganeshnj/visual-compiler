package calculator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.svg.SVGDocument;

public abstract class AbstractView extends javax.swing.JFrame {
	
	private JMenuBar jMenuBar = null;
	private JMenu jMenuFile = null;
	private JMenuItem jMenuItemNew = null;
	
	private SVGGraphics2D svgGraphics = null;
	private SVGDocument svgDocument = null;
	
	private String filename = null;
	
	public AbstractView() {
		super();
		this.initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		this.setName("JFrame");
		this.setPreferredSize(new Dimension(800, 600));
		this.setSize(800, 600);
		this.setJMenuBar(getjMenuBar());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("My Interpreter");
	}

	public JMenuBar getjMenuBar() {
		if(jMenuBar == null){
			jMenuBar = new JMenuBar();
			jMenuBar.add(getjMenuFile());
		}
		return jMenuBar;
	}

	public void setjMenuBar(JMenuBar jMenuBar) {
		this.jMenuBar = jMenuBar;
	}

	public JMenu getjMenuFile() {
		if (jMenuFile == null){
			jMenuFile = new JMenu();
			jMenuFile.setText("File");
			jMenuFile.add(getjMenuItemNew());
		}
		return jMenuFile;
	}

	public void setjMenuFile(JMenu jMenu) {
		this.jMenuFile = jMenu;
	}

	public JMenuItem getjMenuItemNew() {
		if(jMenuItemNew == null) {
			jMenuItemNew = new JMenuItem("New");
			jMenuItemNew.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return jMenuItemNew;
	}

	public void setjMenuItemNew(JMenuItem jMenuItemNew) {
		this.jMenuItemNew = jMenuItemNew;
	}
	
	protected abstract void onPaint(SVGGraphics2D g);

	public String getFilename() {
		if(filename == null) {
			filename = new String();
		}
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	public SVGGraphics2D getSvgGraphics() {
		if(svgGraphics == null){
			svgGraphics = new SVGGraphics2D(getSvgDocument());
		}
		return svgGraphics;
	}

	
	public void setSvgGraphics(SVGGraphics2D svgGraphics) {
		this.svgGraphics = svgGraphics;
	}

	
	public SVGDocument getSvgDocument() {
		if(svgDocument == null) {
			 DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
			 String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
			 svgDocument = (SVGDocument) impl.createDocument(svgNS, "svg", null);
		}
		return svgDocument;
	}

	public void setSvgDocument(SVGDocument svgDocument) {
		this.svgDocument = svgDocument;
	}
}
