
public class Lada extends Dolgok {
	//v�ltoz�, ami sz�mon tartja, hogy a dobozt meg kell-e semmis�teni
	protected boolean smashed = false;
	//v�ltoz�, ami sz�mon tartja, hogy siker�lt-e a mozg�s
	protected boolean refused = false;
	protected Iranyok irany = null;
	
	//a param�ter�l kapott Dologhoz hozz��ti a l�d�t
	@Override
	public void CollideWith(Dolgok d) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lada].CollideWith(d)");
		
		d.HitByLada(this, irany);
		
		//System.out.println("<\t<-[lada].CollideWith(d)");
	}

	//a param�ter�l kapott dolgoz� egy megfelel� ir�nyba l�ki
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lada].HitByDolgozo(d, i)");
		
		irany = i;
		Mezo nextMezo = current.GetNeighbor(i);
		nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a mozg�s sikertelen a l�da marad jelenlegi hely�n
			d.Refuse();
			current.Accept(this);
			refused=false;
		}
		//amennyiben a l�da megsemmis�l, nem helyez�dik fel egyetlen mez�re sem
		if(smashed)
			return;
		else 
			nextMezo.Accept(this);
		
		
		//System.out.println("<\t<-[lada].HitByDolgozo(d, i)");
	}
	
	//a param�ter�l kapott l�da egy megfelel� ir�nyba l�ki
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lada].HitByLada(d, i)");
		
		irany = i;
		Mezo nextMezo = current.GetNeighbor(i);
		nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a mozg�s sikertelen a l�da marad jelenlegi hely�n
			l.Refuse();
			current.Accept(this);
			refused=false;
		}
		//amennyiben a l�da megsemmis�l, nem helyez�dik fel egyetlen mez�re sem
		if(smashed)
			return;
		
		else 
			nextMezo.Accept(this);
		
			
		//System.out.println("<\t<-[lada].HitByLada(d, i)");
	}
	
	//a mozg�s sikertelens�g�nek nyilv�ntart�sa
	public void Refuse() {
		//System.out.println(">\t->[lada].Refuse()");	
		
		refused = true;
		
		//System.out.println("<\t<-[lada].Refuse()");
	}
	
	//a l�da megsemmis�l�s�nek nyilv�ntart�sa
	public void Smashed() {
		//System.out.println(">\t->[lada].Smashed()");
		
		smashed = true;
		
		//System.out.println("<\t<-[lada].Smashed()");
	}
	
	//"Iranyok irany" lek�rdez�se
	
	public Iranyok GetIrany() {
		return irany;
	}
		
	//"Iranyok irany" be�ll�t�sa
		
	public void SetIrany(Iranyok tmp) {
		irany = tmp;
	}
	
}
