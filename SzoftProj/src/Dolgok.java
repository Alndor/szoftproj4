
public abstract class Dolgok {
	//Dolgok aktuális mezõjét számontartó változó
	protected Mezo current = new Mezo();
	
	//nem abstract, mert csak a dolgozonak és a ladanak kötelezõ megírni
	public void CollideWith(Dolgok d) {	}
	
	public abstract void HitByDolgozo(Dolgozo d, Iranyok i);
	
	public abstract void HitByLada(Lada l, Iranyok i);
	
	//"Mezo current" lekérdezése
	
	public Mezo GetCurrent() {
		return current;
	}
		
	//"Mezo current" beállítása
		
	public void SetCurrent(Mezo tmp) {
		current = tmp;
	}
}
