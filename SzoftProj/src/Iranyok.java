//az irányok nyilvántartására szolgáló enum
public enum  Iranyok {
	UP('w'), DOWN('s'), LEFT('a'), RIGHT('d'), NOTHING('x');
	private final char dir;
	//irányokhoz rendeli a karaktereket
	Iranyok(char c){
		dir=c;
		}
	
	public char getDir() {
		return dir;
	}
}
