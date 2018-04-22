
public abstract class Item extends Dolgok{
	
	//Az Item m�dos�t� �rt�ke
	protected double modifier;
	
	//A m�dos�t� met�dus
	public abstract void Modify();
	
	public void HitByDolgozo(Dolgozo d, Iranyok i) { }
	
	public void HitByLada(Lada l, Iranyok i) { }
	
	//"int modifier" lek�rdez�se
	
	public double GetModifier(){
		return modifier;
	}
	
	//"int modifier" be�ll�t�sa
	
	public void SetModifier(int m){
		modifier = m;
	}
}
