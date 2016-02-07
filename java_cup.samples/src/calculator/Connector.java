package calculator;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Connector {
	public static final int GAP = 10;

	public Connector(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	int x, y, width, height;
	int leftCount, rightCount, topCount, bottomCount;

	public Point getNextLeft() {
		leftCount++;
		return new Point(x, y + (leftCount * GAP));
	}

	public Point getNextRight() {
		rightCount++;
		return new Point(x + width, y + (rightCount * GAP));
	}

	public Point getNextTop() {
		topCount++;
		return new Point(x, y + (topCount * GAP));
	}

	public Point getNextBottom() {
		bottomCount++;
		return new Point(x + height, y + (bottomCount * GAP));
	}

	public Point getCurrentLeft() {
		return new Point(x, y + (leftCount * GAP));
	}

	public Point getCurrentRight() {
		return new Point(x + width, y + (rightCount * GAP));
	}

	public Point getCurrentTop() {
		return new Point(x, y + (topCount * GAP));
	}

	public Point getCurrentBottom() {
		return new Point(x + height, y + (bottomCount * GAP));
	}

	public Connector(Rectangle2D onRectangle, Rectangle2D forRectangle) {
		super();
		this.onRectangle = onRectangle;
		this.forRectangle = forRectangle;
	}

	private Rectangle2D onRectangle;
	private Rectangle2D forRectangle;
	private PositionType position = PositionType.Others;

	public Point getPoint(Rectangle2D onR, Rectangle2D forR) {

		int onX1 = (int) onR.getX();
		int onY1 = (int) onR.getY();
		int onX2 = (int) (onX1 + onR.getWidth());
		int onY2 = (int) (onY1 + onR.getHeight());

		int forX1 = (int) forR.getX();
		int forY1 = (int) forR.getY();
		int forX2 = (int) (forX1 + forR.getWidth());
		int forY2 = (int) (forY1 + forR.getHeight());

		// Check where the forR lies
		boolean left = onX1 > forX2;
		boolean right = onX2 < forX1;
		boolean top = onY1 > forY2;
		boolean bottom = onY2 < forY1;

		Random random = new Random();

		if (top && left) {
			int temp = random.nextInt(10);
			if (temp % 2 == 0) {
				// top selected
				int x = getRandomInteger(onX1, onX2, random);
				int y = onY1;
				return new Point(x, y);
			} else {
				// left selected
				int x = onX1;
				int y = getRandomInteger(onY1, onY2, random);
				return new Point(x, y);
			}
		} else if (left && bottom) {
			int temp = random.nextInt(10);
			if (temp % 2 == 0) {
				// left selected
				int x = onX1;
				int y = getRandomInteger(onY1, onY2, random);
				return new Point(x, y);
			} else {
				// bottom selected
				int x = getRandomInteger(onX1, onX2, random);
				int y = onY1;
				return new Point(x, y);
			}
		} else if (bottom && right) {
			int temp = random.nextInt(10);
			if (temp % 2 == 0) {
				// bottom selected
				int x = getRandomInteger(onX1, onX2, random);
				int y = onY1;
				return new Point(x, y);
			} else {
				// right selected
				int x = onX2;
				int y = getRandomInteger(onY1, onY2, random);
				return new Point(x, y);
			}
		} else if (right && top) {
			int temp = random.nextInt(10);
			// right selected
			if (temp % 2 == 0) {
				int x = onX2;
				int y = getRandomInteger(onY1, onY2, random);
				return new Point(x, y);
			} else {
				// top selected
				int x = getRandomInteger(onX1, onX2, random);
				int y = onY1;
				return new Point(x, y);
			}
		} else if (left) {
			// left selected
			int x = onX1;
			int y = getRandomInteger(onY1, onY2, random);
			setPosition(PositionType.Left);
			return new Point(x, y);
		} else if (right) {
			int x = onX2;
			int y = getRandomInteger(onY1, onY2, random);
			setPosition(PositionType.Right);
			return new Point(x, y);
		} else if (bottom) {
			int x = getRandomInteger(onX1, onX2, random);
			int y = onY2;
			setPosition(PositionType.Bottom);
			return new Point(x, y);
		} else if (top) {
			int x = getRandomInteger(onX1, onX2, random);
			int y = onY1;
			setPosition(PositionType.Top);
			return new Point(x, y);
		}

		// Overlapping to each other
		return null;

	}



	private int getRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());

		return (int) (fraction + aStart);
	}

	public Rectangle2D getOnRectangle() {
		return onRectangle;
	}

	public void setOnRectangle(Rectangle2D onRectangle) {
		this.onRectangle = onRectangle;
	}

	public Rectangle2D getForRectangle() {
		return forRectangle;
	}

	public void setForRectangle(Rectangle2D forRectangle) {
		this.forRectangle = forRectangle;
	}

	public PositionType getPosition() {
		return position;
	}

	public void setPosition(PositionType position) {
		this.position = position;
	}

}
