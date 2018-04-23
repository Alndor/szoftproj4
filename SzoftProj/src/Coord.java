
public class Coord {
		int x; int y;
	    public Coord(int x, int y) {
	       this.x = x;
	       this.y = y;
	    }
	    public String getCoord() {
	    	return new String("("+String.valueOf(x)+","+String.valueOf(y)+")");
	    }
	    public int getX() {
	    	return x;
	    }
	    public int getY() {
	    	return y;
	    }
	    public void setX(int i) {
	    	x = i;
	    }
	    public void setY(int i) {
	    	y = i;
	    }
	    public boolean isEqual(Coord c) {
	    	return x == c.getX() && y == c.getY();
	    }
	}
