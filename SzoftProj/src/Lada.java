import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Lada extends Dolgok {
	//v�ltoz�, ami sz�mon tartja, hogy a dobozt meg kell-e semmis�teni
	protected boolean smashed = false;
	//v�ltoz�, ami sz�mon tartja, hogy siker�lt-e a mozg�s
	protected boolean refused = false;
	protected Iranyok irany = null;
	
	private boolean mozgathato = true;
	
	public void Mozgathato() {
		int akadalyszam = 0;
		int i;
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.DOWN).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.DOWN).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.UP).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.UP).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.RIGHT).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.RIGHT).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.LEFT).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.LEFT).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		if (akadalyszam > 1) {
			mozgathato = false;
		}
		
	}
	
	public boolean GetMozgathato() {
		return mozgathato;
	}
	
	private String name="Lada";
	
	public Lada() {
		this.SetWeight(10);
	}
	public String getName() {
		return name;
	}
	
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
		if(nextMezo == null)
			return;
		nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a mozg�s sikertelen a l�da marad jelenlegi hely�n
			d.Refuse();
			current.Accept(this);
			refused=false;
		}
		//amennyiben a l�da megsemmis�l, nem helyez�dik fel egyetlen mez�re sem
		else if(smashed)
			return;
		else {
			nextMezo.Accept(this);
			this.Mozgathato();
		}							
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
	
	public JsonObject Save() {
		JsonObject out = Json.createObjectBuilder()
				.add("type", "lada")
				.add("weight", weight)
				.build();

		return out;
	}

	@Override
	public void SetWeight(int x) {
		// TODO Auto-generated method stub
		if (x>0)
			super.SetWeight(x);
	}
	
	@Override
	public void Load(JsonObject ob, Map map) {
		SetWeight(ob.getInt("weight"));
	}
	
	
	
	
}
