package examen;

import java.util.Scanner;

public class Main_examen {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws CustomizedException {
		Scanner input = new Scanner(System.in); 
		int menu = 0; 
		int numeroFactura = 0; 
		String client = ""; 
		String direccio = ""; 
		String telefon = "";
		int numeroLinia = 0;
		String nomProducte = ""; 
		String descripcio = ""; 
		int quantitat = 0; 
		double preuProducte = 0.0d; 
		
		do {
			System.out.println("Escull quina opció vols realitzar del menú següent:\r\n"
					+ "1. Crear factura.\r\n"
					+ "2. Crear una línia de factura a una ja existent.\r\n" 
					+ "3. Calcular l'import total d'una factura.\r\n"
					+ "4. Calcular l'import totat de totes les factures.\r\n"
					+ "5. Saber el número de factures d'un client.\r\n"
					+ "6. Recórrer totes les factures d'un client.\r\n"
					+ "7. Mostrar les factures que tenen un determinat producte.\r\n"
					+ "8. Eliminar una factura.\r\n"
					+ "9. Exportar les factures en un fitxer csv.\r\n"
					+ "10. Exportar les línies de les factures en un fitxer csv.\r\n"
					+ "0. Sortir de l'aplicació.\r\n"
					+ "Tria un número del 0 al 10:");
			menu = input.nextInt(); 
			
			switch (menu) {
			case 0: 
				System.out.println("Gràcies i fins la propera!");
				break; 
			case 1: 
				numeroFactura = Metodes.inputInt("Introdueix el número de la factura:"); 
				client = Metodes.inputString("Introdueix el nom del client:");
				direccio = Metodes.inputString("Introdueix la direcció postal del client:"); 
				telefon = Metodes.inputString("Introdueix el telèfon del client:"); 
				Metodes.crearFactura(numeroFactura, client, direccio, telefon);
				break; 
			case 2: 
				numeroFactura = Metodes.inputInt("Introdueix el número de la factura que vols omplir:"); 
				numeroLinia = Metodes.inputInt("Introdueix el número de línia de factura:");
				nomProducte = Metodes.inputString("Introdueix el nom del producte:"); 
				descripcio = Metodes.inputString("Introdueix la descripció del producte:");
				quantitat = Metodes.inputInt("Introdueix la quantitat de productes:"); 
				preuProducte = Metodes.inputDouble("Introdueix el preu del producte:"); 
				Metodes.crearLiniaFactura(numeroFactura, numeroLinia, nomProducte, descripcio, quantitat, preuProducte);
				break; 
			case 3: 
				numeroFactura = Metodes.inputInt("Introdueix el número de la factura:"); 
				Metodes.totalimportFactura(numeroFactura);
				break; 
			case 4:    
				Metodes.totalFactures();
				break; 
			case 5: 
				client = Metodes.inputString("Introdueix el nom del client:");
				Metodes.numeroFacturesClient(client);
				break; 
			case 6: 
				client = Metodes.inputString("Introdueix el nom del client:");
				Metodes.forEach(client);
				break; 
			case 7: 
				nomProducte = Metodes.inputString("Introdueix el nom del producte:"); 
				Metodes.mostrarFacturesProducte(nomProducte);
				break; 
			case 8: 
				numeroFactura = Metodes.inputInt("Introdueix el número de la factura:"); 
				Metodes.eliminarFactura(numeroFactura);
				break; 
			case 9: 
				Metodes.crearFitxerFactura(); 
				break;   
			case 10: 
				Metodes.crearFitxerLiniesFactura();
				break; 
			default: 
				System.out.println("Error. Introdueix un número del 0 al 10.");
			}
			
		} while (menu != 0); 
		
		input.close();
	}

		
}