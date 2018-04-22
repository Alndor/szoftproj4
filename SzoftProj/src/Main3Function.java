import java.io.IOException;
import java.util.Scanner;

public class Main3Function {
	
	public static void main(String args[]) throws IOException {
								
		Commands comm = new Commands();
		
		//Alapmenü, amibõl választhat a felhasználó.
		
		System.out.println("1 Lépés lyukra");
		System.out.println("2 Lépés falra");
		System.out.println("3 Lépés dolgozóra");
		System.out.println("4 Lépés kapcsolóra");
		System.out.println("5 Lépés ládára");
		System.out.println("6 Lépés célmezõre");
		System.out.println("7 Tolható láda tolása");
		System.out.println("8 Nem tolható láda tolása");
		System.out.println("9 Láda lyukra tolása");
		System.out.println("10 Láda kapcsolóra tolása");
		System.out.println("11 Láda célmezõre tolása");
		System.out.println("12 Láda falhoz tolása");
		System.out.println("13 Tolható láda lánc tolása");
		System.out.println("14 Nem tolható láda lánc tolása");		
		System.out.println("15 Láda-dolgozó lánc tolása");
		System.out.println("16 Láda-dolgozó-fal lánc tolása");
		System.out.println("17 Ládák tolása mézzel");
		System.out.println("18 Ládák tolása olajjal");
		System.out.println("19 Láda-láda-célmezõ tolása");
		System.out.println("20 FEladás");
		System.out.println("21 Kilépés");
		System.out.println("22 Méz lerakása");
		System.out.println("23 Olaj lerakása");
		System.out.println("\nÍrja be a választott teszteset számát!");
		
		Scanner scanner = new Scanner(System.in);		
		int szam = scanner.nextInt();		
		scanner.close();
		
		switch (szam) {
		case 1:
				comm.loadMap("Test1");
				comm.listDolgozo();
				comm.listLyuk();
				comm.moveDolgozo("d");
				comm.listDolgozo();
				break;
		case 2:
				comm.loadMap("Test1");
				comm.listAkadaly();
				comm.listDolgozo();
				comm.moveDolgozo("w");
				comm.listDolgozo();
				break;
		case 3:
				comm.loadMap("Test1");
				comm.listDolgozo();
				comm.moveDolgozo("a");
				comm.listDolgozo();
				break;
		case 4:
				comm.loadMap("Test1");
				comm.listDolgozo();
				comm.listKapcsolo();
				comm.listLyuk();
				comm.moveDolgozo("s");
				comm.listDolgozo();
				comm.listLyuk();
				break;
		case 5:
				comm.loadMap("Test2");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("d");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 6:
				comm.loadMap("Test2");
				comm.listDolgozo();
				comm.ListCelmezo();
				comm.moveDolgozo("w");
				comm.listDolgozo();
				comm.ListCelmezo();
				break;
		case 7:
				comm.loadMap("Test2");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("a");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 8:
				comm.loadMap("Test2");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("s");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 9:
				comm.loadMap("Test3");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("d");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 10:
				comm.loadMap("Test3");
				comm.listDolgozo();
				comm.listLada();
				comm.listLyuk();
				comm.moveDolgozo("a");
				comm.listDolgozo();
				comm.listLada();
				comm.listLyuk();
				break;
		case 11:
				comm.loadMap("Test3");
				comm.listDolgozo();
				comm.listLada();
				comm.ListCelmezo();
				comm.listAkadaly();
				comm.moveDolgozo("s");
				comm.listDolgozo();
				comm.listLada();
				comm.ListCelmezo();
				comm.listAkadaly();
				break;
		case 12:
				comm.loadMap("Test3");
				comm.listDolgozo();
				comm.listLada();				
				comm.listAkadaly();
				comm.moveDolgozo("w");
				comm.listDolgozo();
				comm.listLada();				
				comm.listAkadaly();
				break;
		case 13:
				comm.loadMap("Test4");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("d");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 14:
				comm.loadMap("Test4");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("a");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 15:
				comm.loadMap("Test4");
				comm.listDolgozo();
				comm.listLada();
				comm.moveDolgozo("s");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 16:
				comm.loadMap("Test4");
				comm.listDolgozo();
				comm.listLada();
				comm.listAkadaly();
				comm.moveDolgozo("s");
				comm.moveDolgozo("s");
				comm.listDolgozo();
				comm.listLada();
				break;
		case 17:
				comm.loadMap("Test5");
				comm.listMez();				
				comm.listLada();	
				comm.listDolgozo();
				comm.moveDolgozo("a");							
				comm.listLada();
				comm.listMez();
				comm.listDolgozo();
				break;
		case 18:
				comm.loadMap("Test5");
				comm.listOlaj();	
				comm.listDolgozo();
				comm.listLada();					
				comm.moveDolgozo("s");											
				comm.listOlaj();
				comm.listDolgozo();
				comm.listLada();
				break;
		case 19:
				comm.loadMap("Test6");				
				comm.listDolgozo();
				comm.ListCelmezo();
				comm.listAkadaly();
				comm.listLada();					
				comm.moveDolgozo("s");											
				comm.listDolgozo();
				comm.listAkadaly();							
				comm.listLada();	
				comm.ListCelmezo();
				break;
		case 20:
				comm.loadMap("Test6");				
				comm.listDolgozo();		
				comm.GiveUp(1);
				comm.moveDolgozo("s");															
				comm.listDolgozo();				
				break;
		case 21:
				comm.loadMap("Test6");
				comm.EndGame();
				break;
		case 22:
				comm.loadMap("Test6");
				comm.listDolgozo();
				comm.listMez();
				comm.placeMez();
				comm.listDolgozo();
				comm.listMez();
				break;
		case 23:
				comm.loadMap("Test6");
				comm.listDolgozo();
				comm.listOlaj();
				comm.placeOlaj();
				comm.listDolgozo();
				comm.listOlaj();
				break;		
		default:
				break;
		}		
	}
}
