
public abstract class Item extends Dolgok{
	
	//Az Item m�dos�t� �rt�ke
	private int modifier;
	
	//A m�dos�t� met�dus
	public abstract void Modify();
	
	public void HitByDolgozo(Dolgozo d, Iranyok i) { }
	
	public void HitByLada(Lada l, Iranyok i) { }
}
