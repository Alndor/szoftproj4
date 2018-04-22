
public class Olaj extends Item {

	
	private String name="Olaj";
	public String getName() {
		return name;
	}
	
	public Olaj() {
		modifier=0.5;
	}
	//Az olaj mezejének módosítójának beállítása az olaj módosítójának függvényében
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}
	
}
