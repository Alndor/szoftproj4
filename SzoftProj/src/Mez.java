
public class Mez extends Item{
	
	private String name="Mez";
	public String getName() {
		return name;
	}
	
	public Mez() {
		modifier=2;
	}
	
	//A m�z mezej�nek m�dos�t�j�nak be�ll�t�sa a m�z m�dos�t�j�nak f�ggv�ny�ben
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}

}
