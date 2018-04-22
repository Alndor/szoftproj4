
public class Mez extends Item{
	
	private String name="Mez";
	public String getName() {
		return name;
	}
	
	public Mez() {
		modifier=2;
	}
	
	//A méz mezejének módosítójának beállítása a méz módosítójának függvényében
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}

}
