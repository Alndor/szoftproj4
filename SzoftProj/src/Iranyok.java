//az ir�nyok nyilv�ntart�s�ra szolg�l� enum
public enum  Iranyok {
	UP('w'), DOWN('s'), LEFT('a'), RIGHT('d'), NOTHING('x');
	private final char dir;
	//ir�nyokhoz rendeli a karaktereket
	Iranyok(char c){
		dir=c;
		}
	
	public char getDir() {
		return dir;
	}
}
