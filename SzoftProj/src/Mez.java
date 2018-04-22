
public class Mez extends Item{
	
	//A méz mezejének módosítójának beállítása a méz módosítójának függvényében
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}

}
