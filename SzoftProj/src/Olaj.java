
public class Olaj extends Item {

	//Az olaj mezej�nek m�dos�t�j�nak be�ll�t�sa az olaj m�dos�t�j�nak f�ggv�ny�ben
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}
	
}
