
public class Olaj extends Item {

	
	private String name="Olaj";
	public String getName() {
		return name;
	}
	
	public Olaj() {
		modifier=0.5;
	}
	//Az olaj mezej�nek m�dos�t�j�nak be�ll�t�sa az olaj m�dos�t�j�nak f�ggv�ny�ben
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}
	
}
