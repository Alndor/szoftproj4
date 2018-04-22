
public class Olaj extends Item {

	//Az olaj mezejének módosítójának beállítása az olaj módosítójának függvényében
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}
	
}
