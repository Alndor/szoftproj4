//a mez�k�n elhelyezhet� akad�lyok oszt�lya
public class Akadaly extends Dolgok {
	
	private String name="Akadaly";
	//ha az akad�lyra dolgoz� l�pne
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[akadaly].HitByDolgozo(d, i)");
		
		d.Refuse();
		
		//System.out.println("<\t<-[akadaly].HitByDolgozo(d, i)");
		
	}

	//ha az akad�lyra l�da l�pne
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
