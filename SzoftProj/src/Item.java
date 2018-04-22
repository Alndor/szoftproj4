
public abstract class Item extends Dolgok{
	
	//Az Item módosító értéke
	protected int modifier;
	
	//A módosító metódus
	public abstract void Modify();
	
	public void HitByDolgozo(Dolgozo d, Iranyok i) { }
	
	public void HitByLada(Lada l, Iranyok i) { }
	
	//"int modifier" lekérdezése
	
	public int GetModifier(){
		return modifier;
	}
	
	//"int modifier" beállítása
	
	public void SetModifier(int m){
		modifier = m;
	}
}
