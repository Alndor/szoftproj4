import javax.json.JsonObject;

public abstract class Dolgok {
	//Dolgok aktu�lis mez�j�t sz�montart� v�ltoz�
	protected Mezo current;
	protected String name = "Dolgok";
	//Dolgok s�lya
	protected int weight;
	
	//nem abstract, mert csak a dolgozonak �s a ladanak k�telez� meg�rni
	public void CollideWith(Dolgok d) {	}
	
	public abstract void HitByDolgozo(Dolgozo d, Iranyok i);
	
	public abstract void HitByLada(Lada l, Iranyok i);
	
	//"Mezo current" lek�rdez�se
	
	public Mezo GetCurrent() {
		return current;
	}
		
	//"Mezo current" be�ll�t�sa
		
	public void SetCurrent(Mezo tmp) {
		current = tmp;
	}
	
	//"int weight" lek�rdez�se
	
	public int GetWeight(){
		
		return weight;
	}
	
	//"int weight" bea�ll�t�sa
	
	public void SetWeight(int x){
		weight = x;
	}
	
	public abstract JsonObject Save();
	public abstract void Load(JsonObject ob, Map map);
	public String getName() {
		return name;
	}

}
