
public abstract class Item extends Dolgok{
	
	//Az Item m�dos�t� �rt�ke
	protected int modifier;
	
	//A m�dos�t� met�dus
	public abstract void Modify();
	
	public void HitByDolgozo(Dolgozo d, Iranyok i) { }
	
	public void HitByLada(Lada l, Iranyok i) { }
	
	//"int modifier" lek�rdez�se
	
	public int GetModifier(){
		return modifier;
	}
	
	//"int modifier" be�ll�t�sa
	
	public void SetModifier(int m){
		modifier = m;
	}
}
