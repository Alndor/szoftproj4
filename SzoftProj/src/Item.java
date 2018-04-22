
public abstract class Item extends Dolgok{
	
	//Az Item módosító értéke
	private int modifier;
	
	//A módosító metódus
	public abstract void Modify();
	
	public void HitByDolgozo(Dolgozo d, Iranyok i) { }
	
	public void HitByLada(Lada l, Iranyok i) { }
}
