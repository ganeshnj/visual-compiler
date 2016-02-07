package calculator;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Liner {
	private Rectangle2D startRectangle;
	private Rectangle2D endRectangle;

	public Liner(Rectangle2D startRectangle, Rectangle2D endRectangle) {
		super();
		this.startRectangle = startRectangle;
		this.endRectangle = endRectangle;
	}

	public Rectangle2D getStartRectangle() {
		return startRectangle;
	}

	public void setStartRectangle(Rectangle2D startRectangle) {
		this.startRectangle = startRectangle;
	}

	public Rectangle2D getEndRectangle() {
		return endRectangle;
	}

	public void setEndRectangle(Rectangle2D endRectangle) {
		this.endRectangle = endRectangle;
	}

	public Line2D getLine() {
		double startX1 = startRectangle.getX();
		double startY1 = startRectangle.getY();
		double startX2 = (startX1 + startRectangle.getWidth());
		double startY2 = (startY1 + startRectangle.getHeight());

		double endX1 = endRectangle.getX();
		double endY1 = endRectangle.getY();
		double endX2 = (endX1 + endRectangle.getWidth());
		double endY2 = (endY1 + endRectangle.getHeight());

		// Position of start with respect to end
		boolean left = startX1 > endX2;
		boolean right = startX2 < endX1;
		boolean top = startY1 > endY2;
		boolean bottom = startY2 < endY1;

		double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

		Random random = new Random();
		if (top && left) {
			// select start edge
			int r = random.nextInt(10);
			if (r % 2 == 0) {
				// select top
				x1 = getRandomInteger(startX1, startX2, random);
				y1 = startY1;
			} else {
				// select left
				x1 = startX1;
				y1 = getRandomInteger(startY1, startY2, random);
			}

			// select end edge
			r = random.nextInt(10);
			if (r % 2 == 0) {
				// select right
				x2 = endX2;
				y2 = getRandomInteger(endY1, endY2, random);
			} else {
				// select bottom
				x2 = getRandomInteger(endX1, endX2, random);
				y2 = endY2;
			}
		} else if (left && bottom) {

			// select start edge
			int r = random.nextInt(10);
			if (r % 2 == 0) {
				// select bottom of start
				x1 = getRandomInteger(startX1, startX2, random);
				y1 = startY2;
			} else {
				// select left of start
				x1 = startX1;
				y1 = getRandomInteger(startY1, startY2, random);
			}

			// select end edge
			r = random.nextInt(10);
			if (r % 2 == 0) {
				// select right of end
				x2 = endX2;
				y2 = getRandomInteger(endY1, endY2, random);
			} else {
				// select top of end
				x2 = getRandomInteger(endX1, endX2, random);
				y2 = endY1;
			}

		} else if (bottom && right) {

			// select start edge
			int r = random.nextInt(10);
			if (r % 2 == 0) {
				// select bottom of start
				x1 = getRandomInteger(startX1, startX2, random);
				y1 = startY2;
			} else {
				// select right of start
				x1 = startX2;
				y1 = getRandomInteger(startY1, startY2, random);
			}

			// select end edge
			r = random.nextInt(10);
			if (r % 2 == 0) {
				// select left of end
				x2 = endX1;
				y2 = getRandomInteger(endY1, endY2, random);
			} else {
				// select top of end
				x2 = getRandomInteger(endX1, endX2, random);
				y2 = endY1;
			}

		} else if (right && top) {

			// select start edge
			int r = random.nextInt(10);
			if (r % 2 == 0) {
				// select top of start
				x1 = getRandomInteger(startX1, startX2, random);
				y1 = startY1;
			} else {
				// select right of start
				x1 = startX2;
				y1 = getRandomInteger(startY1, startY2, random);
			}

			// select end edge
			r = random.nextInt(10);
			if (r % 2 == 0) {
				// select left of end
				x2 = endX1;
				y2 = getRandomInteger(endY1, endY2, random);
			} else {
				// select bottom of end
				x2 = getRandomInteger(endX1, endX2, random);
				y2 = endY2;
			}

		} else if (left) {
			double y = getRandomInteger(startY1 > endY1 ? startY1 : endY1, startY2 > endY2 ? startY2 : endY2, random);
			x1 = startX1;
			y1 = y;

			x2 = endX2;
			y2 = y;

		} else if (right) {
			// System.out.println("start " + startY1 + " " + startY2);
			// System.out.println("end " + endY1 + " " + endY2);
			double r1 = startY1 > endY1 ? startY1 : endY1;
			double r2 = startY2 > endY2 ? endY2 : startY2;
			// System.out.println(r1 + " " + r2);
			double y = getRandomInteger(r1, r2, random);
			x1 = startX2;
			y1 = y;

			x2 = endX1;
			y2 = y;

		} else if (bottom) {
			double x = getRandomInteger(startX1 > endX1 ? endX1 : startX1, startX2 < endX2 ? endX2 : startX2, random);
			x1 = x;
			y1 = startY2;

			x2 = x;
			y2 = endY1;

		} else if (top) {
			double x = getRandomInteger(startX1 > endX1 ? endX1 : startX1, startX2 < endX2 ? endX2 : startX2, random);
			x1 = x;
			y1 = startY1;

			x2 = x;
			y2 = endY2;
		}
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		return line;
	}

	private int getRandomInteger(double startX1, double startX2, Random aRandom) {
		if (startX1 > startX2) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) startX2 - (long) startX1 + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());

		return (int) (fraction + startX1);
	}

}
