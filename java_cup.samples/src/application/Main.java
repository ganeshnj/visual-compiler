package application;

import java.io.FileReader;
import java_cup.runtime.ComplexSymbolFactory;

public class Main {
	
	private AbstractView view;
	
	public Main(String argv[]) {
		this.view = new InterpreterView();
		
		if (argv.length == 1) {
			this.view.setFilename(argv[0]);
    	} else {
    		this.view.setFilename("test.txt");
    	}
		
		this.view.onPaint(view.getSvgGraphics());
	}

	static public void main(String argv[]) {    
		Main mainApp = new Main(argv);
		mainApp.show();
	}
	
	public void show() {
		view.setVisible(true);
	}
}


