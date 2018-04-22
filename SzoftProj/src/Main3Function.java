import java.io.IOException;
import java.util.Scanner;

public class Main3Function {
	
	public static void main(String args[]) throws IOException {
								
		Commands comm = new Commands();
		
		//Alapmen�, amib�l v�laszthat a felhaszn�l�.
		
		System.out.println("1 L�p�s lyukra");
		System.out.println("2 L�p�s falra");
		System.out.println("3 L�p�s dolgoz�ra");
		System.out.println("4 L�p�s kapcsol�ra");
		System.out.println("5 L�p�s l�d�ra");
		System.out.println("6 L�p�s c�lmez�re");
		System.out.println("7 Tolhat� l�da tol�sa");
		System.out.println("8 Nem tolhat� l�da tol�sa");
		System.out.println("9 L�da lyukra tol�sa");
		System.out.println("10 L�da kapcsol�ra tol�sa");
		System.out.println("11 L�da c�lmez�re tol�sa");
		System.out.println("12 L�da falhoz tol�sa");
		System.out.println("13 Tolhat� l�da l�nc tol�sa");
		System.out.println("14 Nem tolhat� l�da l�nc tol�sa");		
		System.out.println("15 L�da-dolgoz� l�nc tol�sa");
		System.out.println("16 L�da-dolgoz�-fal l�nc tol�sa");
		System.out.println("17 L�d�k tol�sa m�zzel");
		System.out.println("18 L�d�k tol�sa olajjal");
		System.out.println("19 L�da-l�da-c�lmez� tol�sa");
		System.out.println("20 FElad�s");
		System.out.println("21 Kil�p�s");
		System.out.println("22 M�z lerak�sa");
		System.out.println("23 Olaj lerak�sa");
		System.out.println("\n�rja be a v�lasztott teszteset sz�m�t!");
		
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
