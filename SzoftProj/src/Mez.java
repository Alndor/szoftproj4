
public class Mez extends Item{
	
	//A m�z mezej�nek m�dos�t�j�nak be�ll�t�sa a m�z m�dos�t�j�nak f�ggv�ny�ben
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}

}
