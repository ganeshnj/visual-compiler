package calculator;

import java.awt.*;
import java.io.FileReader;

import org.apache.batik.swing.*;
import org.apache.batik.svggen.*;
import org.w3c.dom.*;
import java_cup.runtime.ComplexSymbolFactory;

public class InterpreterView extends AbstractView {
	
	public InterpreterView() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void onPaint(SVGGraphics2D g) {
		// TODO Auto-generated method stub
		try {    	
	    	ComplexSymbolFactory csf = new ComplexSymbolFactory ();
	    	Lexer l = new Lexer(new FileReader(this.getFilename()));
	    	l.setSymbolFactory(csf);
	    	Parser p = new Parser(l, csf);
	    	p.setContainer(new Container(getSvgGraphics()));
	    	p.parse();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
		getSvgGraphics().setSVGCanvasSize(new Dimension(640, 480));
		
		Element root = getSvgDocument().getDocumentElement();
		getSvgGraphics().getRoot(root);
		
		JSVGCanvas canvas = new JSVGCanvas();
	    this.getContentPane().add(canvas);
	    canvas.setSVGDocument(getSvgDocument());
	    this.pack();
	    this.setVisible(true);
	}

}
