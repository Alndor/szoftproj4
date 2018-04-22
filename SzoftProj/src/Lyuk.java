
public class Lyuk extends Dolgok {
	protected Map m = new Map();
	private String name = "Lyuk";
	//amennyiben dolgozó lép a lyukra, meghívja az annak megölésére szolgáló függvényt
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lyuk].HitByDolgozo(d, i)");
		
		m.Kill(d);
		
		//System.out.println("<\t<-[lyuk].HitByDolgozo(d, i)");
	}

	//amennyiben láda lép a lyukra, meghívja az annak megsemmisítését elõidézõ függvényt
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lyuk].HitByLada(l, i)");
		
		l.Smashed();
		
		//System.out.println("<\t<-[lyuk].HitByLada(l, i)");
	}
	
	//"Map m" lekérdezése
	
	public Map GetMap() {
		return m;
	}
			
	//"Map m" beállítása
			
	public void SetMap(Map tmp) {
		m = tmp;
	}
	
	public String getName() {
		return name;
	}
}
