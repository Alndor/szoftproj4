//a mezõkön elhelyezhetõ akadályok osztálya
public class Akadaly extends Dolgok {
	
	private String name="Akadaly";
	//ha az akadályra dolgozó lépne
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[akadaly].HitByDolgozo(d, i)");
		
		d.Refuse();
		
		//System.out.println("<\t<-[akadaly].HitByDolgozo(d, i)");
		
	}

	//ha az akadályra láda lépne
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[akadaly].HitByLada(l, i)");
		
		l.Refuse();
		
		//System.out.println("<\t<-[akadaly].HitByLada(l, i)");
	}
	
	public String getName() {
		return name;
	}

	
}
