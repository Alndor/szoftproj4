
public class Coord implements Comparable{
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
	    public boolean equals(Coord c) {
	    	return isEqual(c);
	    }
	    
	    @Override
		public int compareTo(Object arg0) {
			Coord c = (Coord) arg0;
			
			if(this.isEqual(c))
			return 0;
			
			int cx = c.getX();
			int cy = c.getY();
			
			if(x > cx)
				return 1;
			
			else if(x < cx)
				return -1;
			
			if(y < cy)
				return -1;
			
			return 1;
		}
	}
